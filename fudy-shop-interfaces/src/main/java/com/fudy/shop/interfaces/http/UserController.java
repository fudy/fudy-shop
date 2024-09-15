package com.fudy.shop.interfaces.http;

import com.fudy.shop.application.UserManager;
import com.fudy.shop.application.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserManager userManager;
    @Autowired
    private HttpSession httpSession;

    @PostMapping("/api/users")
    public @ResponseBody
    Result<UserDTO> createUser(@RequestBody UserDTO userDTO) {
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
            SimpleUserDTO data = userManager.login(dto, httpSession);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/api/auth")
    public @ResponseBody Result<SimpleUserDTO> authSuccess(@RequestBody UserLoginDTO dto) {
        try {
            SimpleUserDTO data = userManager.login(dto, httpSession);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/api/user/logout")
    public @ResponseBody Result<Void> login() {
        try {
            userManager.logout(httpSession);
            return Result.success(null);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/api/user/sms-login")
    public @ResponseBody Result<SimpleUserDTO> smsLogin(@RequestBody SmsUserLoginDTO dto) {
        try {
            SimpleUserDTO data = userManager.smsLogin(dto, httpSession);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/api/user/password")
    public @ResponseBody Result<Void> modifyPassword(@RequestBody ForgetPasswordDTO dto) {
        try {
            userManager.forgetPassword(dto);
            return Result.success(null);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/api/user")
    public @ResponseBody Result<SimpleUserDTO> getUser() {
        try {
            SimpleUserDTO user = userManager.getUser(httpSession);
            return Result.success(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
}
