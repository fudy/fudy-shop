package com.fudy.shop.infrastructure.db.data;

import lombok.Data;

@Data
public class ItemSpuDO extends CommonDO {
    //商品标题
    private String title;
    //类目id
    private Long categoryId;
    //商品描述
    private String desc;
    //主图
    private String mainImage;
    //商品图片列表
    private String imageList;
    //商品状态
    private int status;
    //商品属性列表
    private String attributeList;
    //销量
    private int sales;

}
