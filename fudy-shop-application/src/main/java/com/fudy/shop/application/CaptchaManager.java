package com.fudy.shop.application;

import com.fudy.shop.application.dto.CaptchaDTO;
import com.fudy.shop.domain.captcha.*;
import com.fudy.shop.domain.user.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Service
public class CaptchaManager  {
    @Autowired
    private CaptchaService captchaService;

    public void send(@Valid CaptchaDTO dto) throws Exception{
        CaptchaType type = CaptchaType.of(dto.getType());
        captchaService.sendCaptcha(type, new PhoneNumber(dto.getPhone()));
    }

}
