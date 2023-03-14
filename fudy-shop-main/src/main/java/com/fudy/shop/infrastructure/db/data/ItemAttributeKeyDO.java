package com.fudy.shop.infrastructure.db.data;

import lombok.Data;

@Data
public class ItemAttributeKeyDO extends CommonDO {
    /** 商品属性名称 */
    private String attributeName;
    /** 商品类目名称 */
    private Long categoryId;
}
