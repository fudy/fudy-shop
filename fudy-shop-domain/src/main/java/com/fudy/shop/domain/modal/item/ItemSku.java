package com.fudy.shop.domain.modal.item;

import com.fudy.shop.domain.Entity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemSku extends Entity {
    //规格
    private ItemSkuSpec spec;
    //价格
    private BigDecimal price;
    //图片
    private ItemImage image;
}
