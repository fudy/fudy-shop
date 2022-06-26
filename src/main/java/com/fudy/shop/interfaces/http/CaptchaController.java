package com.fudy.shop.interfaces.http;

import com.fudy.shop.application.CaptchaManager;
import com.fudy.shop.application.ImageCaptchaManager;
import com.fudy.shop.interfaces.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class CaptchaController {
    @Autowired
    private CaptchaManager captchaManager;
    @Autowired
    private ImageCaptchaManager imageCaptchaManager;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

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

    @GetMapping("/api/image-captcha")
    public @ResponseBody
    void outputImageCaptcha() {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "No-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            imageCaptchaManager.outputImageCaptcha(request, response);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
