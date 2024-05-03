package com.fudy.shop.infrastructure.captcha;

import com.fudy.shop.domain.modal.captcha.Captcha;
import com.fudy.shop.domain.modal.captcha.CaptchaSender;
import com.fudy.shop.domain.modal.cache.CachePrefix;
import com.fudy.shop.domain.modal.captcha.CaptchaType;
import com.fudy.shop.domain.modal.user.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserLoginCaptchaSender implements CaptchaSender {

    @Override
    public void send(PhoneNumber phone, Captcha captcha) throws Exception {
        log.warn("send user login captcha, phone: {}, captcha: {}", phone.getValue(), captcha.getCode());
    }

    @Override
    public CachePrefix getCachePrefix() {
        return CachePrefix.USER_LOGIN;
    }

    @Override
    public CaptchaType getType() {
        return CaptchaType.USER_LOGIN;
    }
}
