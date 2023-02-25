package com.fudy.shop.domain.user;

import com.fudy.shop.infrastructure.common.RandomUtil;
import lombok.Getter;

public class Captcha {
    @Getter
    private String code;

    public Captcha() {
        this.code = RandomUtil.randomDigits(4);
    }

}
