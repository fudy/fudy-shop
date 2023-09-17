package com.fudy.shop.infrastructure.spring;

import com.fudy.shop.domain.captcha.CaptchaSender;
import com.fudy.shop.domain.captcha.CaptchaType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class BeanConfiguration {

    @Bean
    public Map<CaptchaType, CaptchaSender> captchaServiceMap(Collection<CaptchaSender> captchaSenders) {
        return captchaSenders.stream()
                .collect(Collectors.toMap(CaptchaSender::getType, Function.identity()));

    }
}
