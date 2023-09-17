package com.fudy.shop.infrastructure.captcha;

import com.fudy.shop.domain.captcha.Captcha;
import com.fudy.shop.domain.captcha.CaptchaSender;
import com.fudy.shop.domain.cache.CachePrefix;
import com.fudy.shop.domain.captcha.CaptchaType;
import com.fudy.shop.domain.user.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MockCaptchaSender implements CaptchaSender {
    @Override
    public void send(PhoneNumber phone, Captcha captcha) throws Exception {
        log.warn("send captcha mock, phone: {}, captcha: {}", phone.getValue(), captcha.getCode());
    }

    @Override
    public CachePrefix getCachePrefix() {
        return CachePrefix.MOCK;
    }

    @Override
    public CaptchaType getType() {
        return CaptchaType.MOCK;
    }
}
