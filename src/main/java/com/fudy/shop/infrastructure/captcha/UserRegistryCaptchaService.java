package com.fudy.shop.infrastructure.captcha;

import com.alibaba.fastjson.JSON;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.fudy.shop.infrastructure.cache.CachePrefix;
import com.fudy.shop.infrastructure.file.PrivateProperties;
import com.fudy.shop.infrastructure.sms.AliyunSmsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("captcha-user-registry")
public class UserRegistryCaptchaService implements CaptchaService {

    @Override
    public void send(String phone, String captcha) throws Exception {
        Map<String, Object> templateParam = new HashMap<>();
        templateParam.put("code", captcha);
        SendSmsRequest request = new SendSmsRequest().setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setPhoneNumbers(PrivateProperties.getSmsTestPhone())
                .setTemplateParam(JSON.toJSONString(templateParam));
        AliyunSmsService.sendSms(request);
    }

    @Override
    public CachePrefix getPrefix() {
        return CachePrefix.USER_REGISTRY;
    }
}
