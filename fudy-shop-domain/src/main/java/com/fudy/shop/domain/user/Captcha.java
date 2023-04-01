package com.fudy.shop.domain.user;

import com.fudy.shop.domain.util.RandomUtil;
import lombok.Getter;

public class Captcha {
    @Getter
    private String code;

    public Captcha() {
        this.code = RandomUtil.randomDigits(4);
    }

}
