package com.fudy.shop.domain.modal.payment;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    UNPAID(0, "待支付"),
    PAID(1, "已支付"),
    FAILED(2, "支付失败"),
    CANCELLED(3, "订单被取消")
    ;
    private final int value;
    private final String desc;

    PaymentStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
