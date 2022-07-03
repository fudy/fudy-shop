package com.fudy.shop.infrastructure.captcha;

import com.fudy.shop.infrastructure.cache.CachePrefix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("captcha-user-registry")
@Slf4j
public class UserRegistryCaptchaService implements CaptchaService {

    @Override
    public void send(String phone, String captcha) throws Exception {
        log.warn("send user registry captcha, phone: {}, captcha: {}", phone, captcha);
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
    public CachePrefix getPrefix() {
        return CachePrefix.USER_REGISTRY;
    }
}
