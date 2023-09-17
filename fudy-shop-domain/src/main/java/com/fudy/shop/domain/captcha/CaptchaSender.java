package com.fudy.shop.domain.captcha;


import com.fudy.shop.domain.cache.Cacheable;
import com.fudy.shop.domain.user.PhoneNumber;

public interface CaptchaSender extends Cacheable {
    void send(PhoneNumber phone, Captcha captcha) throws Exception;

    CaptchaType getType();
}
