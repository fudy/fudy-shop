package com.fudy.shop.application;

import com.fudy.shop.application.assembler.UserAssembler;
import com.fudy.shop.application.dto.*;
import com.fudy.shop.domain.modal.cache.CachePrefix;
import com.fudy.shop.domain.service.CaptchaService;
import com.fudy.shop.domain.modal.user.*;
import com.fudy.shop.domain.repository.UserSessionRepository;
import com.fudy.shop.domain.repository.UserSessionRepositoryFactory;
import com.fudy.shop.domain.service.UserService;
import com.fudy.shop.domain.modal.user.session.UserSession;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@Validated
@Service
public class UserManager  {
    @Autowired
    private UserService userService;
    @Autowired
    private UserAssembler userAssembler;
    @Autowired
    private CaptchaService captchaService;
    @Autowired
    private ImageCaptchaManager imageCaptchaManager;
    @Autowired
    private UserSessionRepositoryFactory<HttpSession> userSessionRepositoryFactory;

    private void validateCreateUserParam(UserDTO userDTO) throws Exception {
        if (!StringUtils.equals(userDTO.getPassword(), userDTO.getConfirmPassword())) {
            throw new Exception("两次密码输入不一致！");
        }
        if (!captchaService.isValid(CachePrefix.USER_REGISTRY, userDTO.getPhone(), userDTO.getCaptcha())) {
            throw new Exception("验证码不正确或已过期");
        }
    }

    public UserDTO createUser(@Valid UserDTO userDTO) throws Exception {
        validateCreateUserParam(userDTO);
        User user = userAssembler.toUser(userDTO);
        user = userService.saveUser(user);
        return userAssembler.toUserDTO(user);
    }

    public SimpleUserDTO login(@Valid UserLoginDTO dto, HttpSession httpSession) throws Exception {
        if (!imageCaptchaManager.isValid(httpSession, dto.getImageCaptcha())) {
            throw new Exception("图片验证码不正确");
        }
        User user = userService.login(new UserName(dto.getUserName()), new Password(dto.getPassword()));
        //将用户相关信息存到session中
        this.getUserSessionRepository(httpSession).save(new UserSession(user));
        imageCaptchaManager.clearImageCaptcha(httpSession);
        return userAssembler.toSimpleUserDTO(user);
    }

    public void logout(HttpSession httpSession) {
        this.getUserSessionRepository(httpSession).invalidate();
    }

    public SimpleUserDTO smsLogin(@Valid SmsUserLoginDTO dto, HttpSession httpSession) throws Exception {
        boolean isValid = captchaService.isValid(CachePrefix.USER_LOGIN, dto.getPhone(), dto.getCaptcha());
        if (!isValid) {
            throw new Exception("手机号未注册或验证码不正确");
        }
        User user = userService.getUser(new PhoneNumber(dto.getPhone()));
        Objects.requireNonNull(user, "手机号未注册或验证码不正确");
        //将用户相关信息存到session中
        this.getUserSessionRepository(httpSession).save(new UserSession(user));
        return userAssembler.toSimpleUserDTO(user);
    }

    public void forgetPassword(@Valid ForgetPasswordDTO dto) throws Exception{
        if (!StringUtils.equals(dto.getPassword(), dto.getConfirmPassword())) {
            throw new Exception("两次密码输入不一致！");
        }
        boolean isValid = captchaService.isValid(CachePrefix.FORGET_PASSWORD, dto.getPhone(), dto.getCaptcha());
        if (!isValid) {
            throw new Exception("用户名不存在或验证码不正确");
        }
        User user = userService.getUser(new UserName(dto.getUserName()));
        Objects.requireNonNull(user, "用户名不存在或验证码不正确");
        if (!user.phoneNumberEquals(new PhoneNumber(dto.getPhone()))) {
            throw new Exception("用户名和手机号不匹配");
        }
        userService.saveUser(user);
    }

    private UserSessionRepository getUserSessionRepository(HttpSession httpSession) {
        return userSessionRepositoryFactory.newUserSessionRepository(httpSession);
    }

    public SimpleUserDTO getUser(HttpSession httpSession) {
        UserSession userSession = this.getUserSessionRepository(httpSession).getUserSession();
        return userAssembler.toSimpleUserDTO(userSession);
    }
}
