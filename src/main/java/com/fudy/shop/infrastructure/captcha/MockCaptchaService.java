package com.fudy.shop.infrastructure.captcha;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("captcha-mock")
public class MockCaptchaService implements CaptchaService {
    @Override
    public void send(String phone, String captcha) throws Exception {
        log.warn("send captcha mock, phone: {}, captcha: {}", phone, captcha);
    }
}
