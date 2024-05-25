package com.fudy.shop.domain.modal.order;

import com.fudy.shop.domain.modal.Entity;
import com.fudy.shop.domain.modal.item.ItemSku;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem extends Entity {
    /** 订单ID */
    private OrderID orderId;
    /** 商品 */
    private ItemSku itemSku;
    /** 数量 */
    private Integer quantity;
    /** 小计 */
    private BigDecimal subtotal;
}
