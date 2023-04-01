package com.fudy.shop.infrastructure.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.models.*;
import com.fudy.shop.infrastructure.file.PrivateProperties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AliyunSmsService {
    private static Client client;
    static {
        try {
            client = createClient(PrivateProperties.getAccessKey(), PrivateProperties.getAccessKeySecret());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new Client(config);
    }

    public static SendSmsResponse sendSms(SendSmsRequest request) throws Exception {
        return client.sendSms(request);
    }
}
