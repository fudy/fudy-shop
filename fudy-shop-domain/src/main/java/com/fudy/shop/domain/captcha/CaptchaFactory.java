package com.fudy.shop.domain.captcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CaptchaFactory {
    @Autowired
    private Map<String, CaptchaSender> container;

    public CaptchaSender getCaptchaService(CaptchaType type) {
        return container.getOrDefault(type, container.get(CaptchaType.MOCK));
    }
}
