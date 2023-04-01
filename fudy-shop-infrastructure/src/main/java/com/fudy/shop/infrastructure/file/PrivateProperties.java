package com.fudy.shop.infrastructure.file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Properties;
@Slf4j
public class PrivateProperties {
    private static final String PRIVATE_PROPERTIES = "/var/fudy-shop/private.properties";
    private static Properties properties = new Properties();
    //将私有的配置文件读取到properties里
    static {
        try {
            properties.load(new FileInputStream(PRIVATE_PROPERTIES));
        } catch (FileNotFoundException e) {
            log.error("file in the path {} not found", PRIVATE_PROPERTIES);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 获取短信验证的手机号
     * @return
     */
    public static String getSmsTestPhone() {
        return properties.getProperty("app.sms.test.phone");
    }

    /**
     * 获取阿里云AK
     * @return
     */
    public static String getAccessKey() {
        return properties.getProperty("app.sms.ak");
    }

    /**
     * 获取阿里云SK
     * @return
     */
    public static String getAccessKeySecret() {
        return properties.getProperty("app.sms.sk");
    }

}
