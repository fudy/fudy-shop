package com.fudy.shop.infrastructure.captcha;

import com.fudy.shop.domain.captcha.Captcha;
import com.fudy.shop.domain.captcha.CaptchaSender;
import com.fudy.shop.domain.cache.CachePrefix;
import com.fudy.shop.domain.captcha.CaptchaType;
import com.fudy.shop.domain.user.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ForgetPasswordCaptchaSender implements CaptchaSender {
    @Override
    public void send(PhoneNumber phone, Captcha captcha) throws Exception {
        log.warn("send forget password captcha, phone: {}, captcha: {}", phone.getValue(), captcha.getCode());
    }

    @Override
    public CachePrefix getCachePrefix() {
        return CachePrefix.FORGET_PASSWORD;
    }

    @Override
    public CaptchaType getType() {
        return CaptchaType.FORGET_PASSWORD;
    }
}
