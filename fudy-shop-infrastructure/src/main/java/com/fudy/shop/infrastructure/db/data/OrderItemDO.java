package com.fudy.shop.infrastructure.db.data;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderItemDO extends CommonDO {
    /** 订单ID */
    private Long orderId;
    /** 商品ID */
    private Long itemId;
    /** sku */
    private String sku;
    /** 数量 */
    private Integer quantity;
    /** 单价 */
    private BigDecimal unitPrice;
    /** 小计 */
    private BigDecimal subtotal;
}
