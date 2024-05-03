package com.fudy.shop.domain.modal.captcha;


import com.fudy.shop.domain.modal.cache.Cacheable;
import com.fudy.shop.domain.modal.user.PhoneNumber;

public interface CaptchaSender extends Cacheable {
    void send(PhoneNumber phone, Captcha captcha) throws Exception;

    CaptchaType getType();
}
