package com.fudy.shop.infrastructure.db.data;

import lombok.Data;

@Data
public class ItemCategoryDO extends CommonDO {
    //父类目id
    private Long parentId;
    //类目名称
    private String categoryName;
}
