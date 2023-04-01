package com.fudy.shop.infrastructure.db.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemSkuDO extends CommonDO {
    //商品id
    private Long itemId;
    //商品规格
    private String spec;
    //商品价格
    private BigDecimal price;
    //商品库存
    private int stock;
    //商品sku图片
    private String image;
}
