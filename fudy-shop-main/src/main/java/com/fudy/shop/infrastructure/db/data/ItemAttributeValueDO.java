package com.fudy.shop.infrastructure.db.data;

import lombok.Data;

@Data
public class ItemAttributeValueDO extends CommonDO {
    /** 商品属性值的名称*/
    private String valueName;
    /** 商品属性key的id*/
    private Long attributeId;
}
