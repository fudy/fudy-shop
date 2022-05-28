package com.fudy.shop.infrastructure.captcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CaptchaFactory {
    @Autowired
    private Map<String, CaptchaService> container;
    @Value("${app.captcha.type}")
    private String type;

    public CaptchaService getCaptchaService(String type) {
        return null != type ? container.get(type) : container.get(this.type);
    }
}
