package com.fudy.shop.application;

import com.fudy.shop.application.assembler.UserAssembler;
import com.fudy.shop.application.repository.UserRepository;
import com.fudy.shop.domain.user.User;
import com.fudy.shop.interfaces.dto.UserDTO;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Service
public class UserManager {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAssembler userAssembler;
    @Autowired
    private CaptchaManager captchaManager;

    private void validateCreateUserParam(UserDTO userDTO) throws Exception {
        if (!StringUtils.equals(userDTO.getPassword(), userDTO.getConfirmPassword())) {
            throw new Exception("两次密码输入不一致！");
        }
        if (!captchaManager.isValid(userDTO.getPhone(), userDTO.getCaptcha())) {
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
}
