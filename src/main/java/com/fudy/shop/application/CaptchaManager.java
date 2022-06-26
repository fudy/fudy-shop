package com.fudy.shop.application;

import com.fudy.shop.domain.user.Captcha;
import com.fudy.shop.infrastructure.cache.CachePrefix;
import com.fudy.shop.infrastructure.cache.CacheService;
import com.fudy.shop.infrastructure.captcha.CaptchaFactory;
import com.fudy.shop.infrastructure.captcha.CaptchaService;
import com.fudy.shop.interfaces.dto.CaptchaDTO;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

@Validated
@Service
public class CaptchaManager {
    @Autowired
    private CaptchaFactory captchaFactory;
    @Autowired
    private CacheService cacheService;

    public void send(@Valid CaptchaDTO dto) throws Exception{
        CaptchaService captchaService = captchaFactory.getCaptchaService(dto.getType());
        Objects.requireNonNull(captchaService, "验证码服务未配置");
        Captcha captcha = new Captcha();
        captchaService.send(dto.getPhone(), captcha.getCode());
        cacheService.write(captchaService.getPrefix(), dto.getPhone(), captcha.getCode(), 3600);
    }

    public boolean isValid(CachePrefix prefix, String phone, String captcha) {
        String value = cacheService.read(prefix, phone, String.class);
        return StringUtils.equals(value, captcha);
    }


}
