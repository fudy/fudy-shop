package com.fudy.shop.infrastructure.captcha;

import com.fudy.shop.infrastructure.cache.CachePrefix;

public interface CaptchaService {
    void send(String phone, String captcha) throws Exception;
    //获取缓存前缀
    CachePrefix getPrefix();
}
