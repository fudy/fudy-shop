package com.fudy.shop.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class OrderItemDTO {
    /** 商品ID */
    private Long itemId;

    /** 商品规格 */
    private Map<String, Object> itemSku;

    /** 数量 */
    private Integer quantity;

    /** 小计 */
    private BigDecimal subtotal;
}
