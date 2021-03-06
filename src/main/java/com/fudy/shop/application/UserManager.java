package com.fudy.shop.application;

import com.fudy.shop.application.assembler.UserAssembler;
import com.fudy.shop.application.repository.UserRepository;
import com.fudy.shop.application.repository.query.UserQuery;
import com.fudy.shop.domain.user.User;
import com.fudy.shop.domain.user.session.HttpUserSession;
import com.fudy.shop.domain.user.session.UserSession;
import com.fudy.shop.infrastructure.cache.CachePrefix;
import com.fudy.shop.interfaces.dto.*;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@Validated
@Service
public class UserManager {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAssembler userAssembler;
    @Autowired
    private CaptchaManager captchaManager;
    @Autowired
    private ImageCaptchaManager imageCaptchaManager;

    private void validateCreateUserParam(UserDTO userDTO) throws Exception {
        if (!StringUtils.equals(userDTO.getPassword(), userDTO.getConfirmPassword())) {
            throw new Exception("两次密码输入不一致！");
        }
        if (!captchaManager.isValid(CachePrefix.USER_REGISTRY, userDTO.getPhone(), userDTO.getCaptcha())) {
            throw new Exception("验证码不正确或已过期");
        }
    }

    public UserDTO createUser(@Valid UserDTO userDTO) throws Exception {
        validateCreateUserParam(userDTO);
        User user = userAssembler.toUser(userDTO);
        user.generateSalt();
        user.encryptPassword();
        user = userRepository.createUser(user);
        return userAssembler.toUserDTO(user);
    }

    public SimpleUserDTO login(@Valid UserLoginDTO dto, HttpSession httpSession) throws Exception {
        if (!imageCaptchaManager.isValid(httpSession, dto.getImageCaptcha())) {
            throw new Exception("图片验证码不正确");
        }
        UserQuery query = new UserQuery();
        query.setUsername(dto.getUserName());
        User user = userRepository.getUser(query);
        Objects.requireNonNull(user, "用户名和密码不正确");
        boolean isValid = user.authenticate(dto.getUserName(), dto.getPassword());
        if (!isValid) {
            throw new Exception("用户名和密码不正确");
        }
        //将用户相关信息存到session中
        this.getUserSession(httpSession).save(user);
        imageCaptchaManager.clearImageCaptcha(httpSession);
        return userAssembler.toSimpleUserDTO(user);
    }

    public void logout(HttpSession httpSession) {
        this.getUserSession(httpSession).invalidate();
    }

    public SimpleUserDTO smsLogin(@Valid SmsUserLoginDTO dto, HttpSession httpSession) throws Exception {
        boolean isValid = captchaManager.isValid(CachePrefix.USER_LOGIN, dto.getPhone(), dto.getCaptcha());
        if (!isValid) {
            throw new Exception("手机号未注册或验证码不正确");
        }
        UserQuery query = new UserQuery();
        query.setPhone(dto.getPhone());
        User user = userRepository.getUser(query);
        Objects.requireNonNull(user, "手机号未注册或验证码不正确");
        //将用户相关信息存到session中
        this.getUserSession(httpSession).save(user);
        return userAssembler.toSimpleUserDTO(user);
    }

    public void forgetPassword(@Valid ForgetPasswordDTO dto) throws Exception{
        if (!StringUtils.equals(dto.getPassword(), dto.getConfirmPassword())) {
            throw new Exception("两次密码输入不一致！");
        }
        boolean isValid = captchaManager.isValid(CachePrefix.FORGET_PASSWORD, dto.getPhone(), dto.getCaptcha());
        if (!isValid) {
            throw new Exception("用户名不存在或验证码不正确");
        }
        UserQuery query = new UserQuery();
        query.setUsername(dto.getUserName());
        User user = userRepository.getUser(query);
        Objects.requireNonNull(user, "用户名不存在或验证码不正确");
        if (!StringUtils.equals(user.getPhone(), dto.getPhone())) {
            throw new Exception("用户名和手机号不匹配");
        }
        user.encryptPassword(dto.getPassword());
        userRepository.updateUser(user);
    }

    private UserSession getUserSession(HttpSession httpSession) {
        return new HttpUserSession(httpSession);
    }

    public SimpleUserDTO getUser(HttpSession httpSession) {
        UserSession userSession = this.getUserSession(httpSession);
        return userAssembler.toSimpleUserDTO(userSession);
    }
}
