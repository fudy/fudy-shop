package com.fudy.shop.infrastructure.captcha;

import com.fudy.shop.infrastructure.cache.CachePrefix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("captcha-mock")
public class MockCaptchaService implements CaptchaService {
    @Override
    public void send(String phone, String captcha) throws Exception {
        log.warn("send captcha mock, phone: {}, captcha: {}", phone, captcha);
    }

    @Override
    public CachePrefix getPrefix() {
        return CachePrefix.MOCK;
    }
}
