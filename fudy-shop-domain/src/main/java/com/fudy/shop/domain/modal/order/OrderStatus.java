package com.fudy.shop.domain.modal.order;

import lombok.Getter;

@Getter
public enum OrderStatus {
    // 订单处理过程中出现异常，需要人工介入处理
    EXCEPTION("异常", 0),
    // 订单已创建，但客户尚未完成支付
    UNPAID("待支付", 1),
    // 客户已完成支付，订单款项已到账
    PAID("已支付", 2),
    // 订单已支付，但商品尚未发货
    PENDING_FULFILLMENT("待发货", 3),
    // 商品已离开仓库，正在运往客户途中
    SHIPPED("已发货", 4),
    // 商品已发出，客户等待收货
    AWAITING_RECEIPT("待收货", 5),
    // 客户已收到商品，订单完成
    COMPLETED("已完结", 6),
    // 订单被取消
    CANCELLED("已取消", 7),
    // 客户已申请退款，退款流程正在进行中
    REFUND_PENDING("退款中", 8),
    // 退款已处理完成，款项已退还给客户
    REFUNDED("退款完成", 9),
    // 订单包含多个商品，部分商品已发货，部分尚未发货
    PARTIALLY_SHIPPED("部分发货", 10),
    // 客户已收到部分退款
    PARTIALLY_REFUNDED("部分退款", 11),
    // 订单被锁定，不允许进行任何操作（如修改、取消等），通常用于防止并发操作导致的状态冲突。
    LOCKED("锁定", 12),
    // 订单需要进一步审核，如风控审核、资质审核等
    PENDING_REVIEW("待审核", 13),
    // 客户拒收商品，商品正在返回仓库途中
    REJECTED("拒绝", 14)
    ;

    private final String statusDescription;
    private final int statusCode;

    OrderStatus(String statusDescription, int statusCode) {
        this.statusDescription = statusDescription;
        this.statusCode = statusCode;
    }

    public static OrderStatus fromStatusCode(int statusCode) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getStatusCode() == statusCode) {
                return status;
            }
        }
        return null;
    }
}
