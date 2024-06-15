package com.fudy.shop.domain.modal.payment;

import lombok.Getter;

@Getter
public enum PaymentMethod {
    ALIPAY(0, "支付宝");

    private final int value;
    private final String desc;

    PaymentMethod(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
