package com.fudy.shop.infrastructure.captcha;

import com.fudy.shop.infrastructure.cache.CachePrefix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("captcha-user-login")
@Slf4j
public class UserLoginCaptchaService implements CaptchaService {

    @Override
    public void send(String phone, String captcha) throws Exception {
        log.warn("send user login captcha, phone: {}, captcha: {}", phone, captcha);
    }

    @Override
    public CachePrefix getPrefix() {
        return CachePrefix.USER_LOGIN;
    }
}
