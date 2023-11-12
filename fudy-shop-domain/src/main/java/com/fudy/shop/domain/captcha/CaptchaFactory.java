package com.fudy.shop.domain.captcha;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CaptchaFactory {
    @Autowired
    private Map<CaptchaType, CaptchaSender> container;

    public CaptchaSender getCaptchaService(@NonNull CaptchaType type) {
        return container.getOrDefault(type, container.get(CaptchaType.MOCK));
    }
}
