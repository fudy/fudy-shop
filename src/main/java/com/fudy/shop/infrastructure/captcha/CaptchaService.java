package com.fudy.shop.infrastructure.captcha;

public interface CaptchaService {
    void send(String phone, String captcha) throws Exception;
}
