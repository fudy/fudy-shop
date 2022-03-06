package com.fudy.shop.interfaces.http;

import com.alibaba.fastjson.JSON;
import com.fudy.shop.interfaces.dto.Result;
import com.fudy.shop.interfaces.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @PostMapping("/users")
    public @ResponseBody Result<UserDTO> register(@RequestBody UserDTO userDTO) {
        return Result.success(userDTO);
    }
}