package com.fudy.shop.interfaces.manager;

import com.fudy.shop.interfaces.dto.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

public interface UserManagerInterface {
    UserDTO createUser(@Valid UserDTO userDTO) throws Exception;

    SimpleUserDTO login(@Valid UserLoginDTO dto, HttpSession httpSession) throws Exception;

    SimpleUserDTO smsLogin(@Valid SmsUserLoginDTO dto, HttpSession httpSession) throws Exception;

    void logout(HttpSession httpSession);

    void forgetPassword(@Valid ForgetPasswordDTO dto) throws Exception;

    SimpleUserDTO getUser(HttpSession httpSession);
}
