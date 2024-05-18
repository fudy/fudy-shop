package com.fudy.shop.infrastructure.db.data;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDO extends CommonDO {
    /** 订单ID */
    private Long orderId;
    /** 用户ID */
    private Long userId;
    /** 订单状态 */
    private Integer status;
    /** 实际金额 */
    private BigDecimal actualAmount;
    /** 折扣金额 */
    private BigDecimal discountAmount;
    /** 总金额 */
    private BigDecimal totalAmount;
    /** 支付状态 */
    private Integer paymentStatus;
    /** 支付时间 */
    private Date paymentTime;
    /** 支付方式 */
    private Integer paymentMethod;
    /** 收获地址ID */
    private Long deliveryAddressId;
    /** 发货状态 */
    private Integer deliveryStatus;
    /** 运费 */
    private BigDecimal freightAmount;
    /** 用户备注 */
    private String note;

}
