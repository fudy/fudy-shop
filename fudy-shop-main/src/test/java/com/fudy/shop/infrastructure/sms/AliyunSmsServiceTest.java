package com.fudy.shop.infrastructure.sms;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.fudy.shop.infrastructure.file.PrivateProperties;
import com.fudy.shop.infrastructure.sms.AliyunSmsService;
import org.junit.jupiter.api.Test;

public class AliyunSmsServiceTest {
    @Test
    public void testSendSms() throws Exception {
        SendSmsRequest request = new SendSmsRequest().setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setPhoneNumbers(PrivateProperties.getSmsTestPhone())
                .setTemplateParam("{\"code\":\"123456\"}");
        AliyunSmsService.sendSms(request);
    }
}
