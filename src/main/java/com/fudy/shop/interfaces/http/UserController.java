package com.fudy.shop.interfaces.http;

import com.fudy.shop.application.UserManager;
import com.fudy.shop.interfaces.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserManager userManager;

    @PostMapping("/api/users")
    public @ResponseBody Result<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        try {
            UserDTO data = userManager.createUser(userDTO);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/api/user/login")
    public @ResponseBody Result<SimpleUserDTO> login(@RequestBody UserLoginDTO dto) {
        try {
            SimpleUserDTO data = userManager.login(dto);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/api/user/sms-login")
    public @ResponseBody Result<SimpleUserDTO> smsLogin(@RequestBody SmsUserLoginDTO dto) {
        try {
            SimpleUserDTO data = userManager.smsLogin(dto);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
}
