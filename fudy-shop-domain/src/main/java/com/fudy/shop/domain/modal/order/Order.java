package com.fudy.shop.domain.modal.order;

import com.fudy.shop.domain.modal.Entity;
import com.fudy.shop.domain.modal.delivery.DeliveryStatus;
import com.fudy.shop.domain.modal.payment.PaymentMethod;
import com.fudy.shop.domain.modal.payment.PaymentStatus;
import com.fudy.shop.domain.modal.user.UserId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Order extends Entity {
    /** 订单ID */
    private OrderID orderId;
    /** 用户ID */
    private UserId userId;
    /** 订单状态 */
    private OrderStatus status = OrderStatus.NEW;
    /** 实际金额 */
    private BigDecimal actualAmount;
    /** 折扣金额 */
    private BigDecimal discountAmount;
    /** 总金额 */
    private BigDecimal totalAmount;
    /** 支付状态 */
    private PaymentStatus paymentStatus;
    /** 支付时间 */
    private Date paymentTime;
    /** 支付方式 */
    private PaymentMethod paymentMethod;
    /** 收获地址ID */
    private Long deliveryAddressId;
    /** 发货状态 */
    private DeliveryStatus deliveryStatus;
    /** 运费 */
    private BigDecimal freightAmount;
    /** 用户备注 */
    private String note;
    /** 订单中的商品*/
    private List<OrderItem> orderItems;
}
