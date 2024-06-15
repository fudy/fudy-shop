package com.fudy.shop.domain.modal.delivery;

import lombok.Getter;

@Getter
public enum DeliveryStatus {
    PENDING_FULFILLMENT(0, "待发货"), // 订单已支付，但商品尚未发货
    SHIPPED(1, "已发货"), // 商品已离开仓库，正在运往客户途中
    IN_TRANSIT(2, "运输中"), // 运输中
    AWAITING_RECEIPT(3, "待收货"), // 商品已发出，客户等待收货
    RECEIPTED(4,"已收货"), // 客户已收到商品，订单完成
    ;
    private final int value;
    private final String desc;

    DeliveryStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
