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
public class UserRegistryCaptchaSender implements CaptchaSender {

    @Override
    public void send(PhoneNumber phone, Captcha captcha) throws Exception {
        log.warn("send user registry captcha, phone: {}, captcha: {}", phone.getValue(), captcha.getCode());
        /*
        Map<String, Object> templateParam = new HashMap<>();
        templateParam.put("code", captcha);
        SendSmsRequest request = new SendSmsRequest().setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setPhoneNumbers(PrivateProperties.getSmsTestPhone())
                .setTemplateParam(JSON.toJSONString(templateParam));
        AliyunSmsService.sendSms(request);
         */
    }

    @Override
    public CachePrefix getCachePrefix() {
        return CachePrefix.USER_REGISTRY;
    }

    @Override
    public CaptchaType getType() {
        return CaptchaType.USER_REGISTRY;
    }
}
