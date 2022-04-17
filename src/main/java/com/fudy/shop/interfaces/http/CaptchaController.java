package com.fudy.shop.interfaces.http;

import com.fudy.shop.application.CaptchaManager;
import com.fudy.shop.interfaces.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class CaptchaController {
    @Autowired
    private CaptchaManager captchaManager;

    @CrossOrigin
    @PostMapping("/api/captcha")
    public @ResponseBody
    Result<UserDTO> sendCaptcha(@RequestBody CaptchaDTO captchaDTO) {
        try {
            captchaManager.send(captchaDTO);
            return Result.success(null);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
}
