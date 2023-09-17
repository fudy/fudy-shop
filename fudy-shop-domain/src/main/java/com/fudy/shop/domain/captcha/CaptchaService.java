package com.fudy.shop.domain.captcha;

import com.fudy.shop.domain.cache.CachePrefix;
import com.fudy.shop.domain.cache.CacheService;
import com.fudy.shop.domain.user.PhoneNumber;
import com.fudy.shop.domain.util.RandomUtil;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaptchaService {
    public static final int DEFAULT_SIZE = 4;
    private CaptchaSender captchaSender;
    private CacheService cacheService;
    private CaptchaFactory captchaFactory;

    @Autowired
    public CaptchaService(CaptchaSender captchaSender, CacheService cacheService,CaptchaFactory captchaFactory) {
        this.captchaSender = captchaSender;
        this.cacheService = cacheService;
        this.captchaFactory = captchaFactory;
    }

    public void sendCaptcha(CaptchaType type, PhoneNumber phoneNumber) throws Exception {
        CaptchaSender captchaSender = captchaFactory.getCaptchaService(type);
        Captcha captcha = new Captcha( RandomUtil.randomDigits(DEFAULT_SIZE));
        String phone = phoneNumber.getValue();
        //减少前端过于频繁地发送验证码
        Boolean exist = cacheService.read(CachePrefix.LOCK, phone, Boolean.class);
        if (Boolean.TRUE.equals(exist)) {
            throw new Exception("验证码发送过于频繁！");
        }
        cacheService.write(CachePrefix.LOCK, phone, true, 60);
        captchaSender.send(phoneNumber, captcha);
        cacheService.write(captchaSender.getCachePrefix(), phone, captcha.getCode(), 3600);
    }

    public boolean isValid(CachePrefix prefix, String phone, String captcha) {
        String value = cacheService.read(prefix, phone, String.class);
        return StringUtils.equals(value, captcha);
    }
}
