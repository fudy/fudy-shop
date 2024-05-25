package com.fudy.shop.domain.modal.item;

import com.fudy.shop.domain.modal.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class ItemSku extends Entity {
    //规格
    private ItemSkuSpec spec;
    //价格
    private BigDecimal price;
    //图片
    private ItemImage image;
    //商品id
    private Long itemId;

    public ItemSku() {
    }

    public ItemSku(Long itemId, Map<String, Object> spec) {
        this.spec = new ItemSkuSpec(spec);
        this.itemId = itemId;
    }
}
