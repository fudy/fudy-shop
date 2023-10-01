package com.fudy.shop.item.api.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ItemDTO implements Serializable {
    private static final long serialVersionUID = 1365193080350363921L;
    private Long id;
    //商品标题
    private String title;
    //商品主图
    private String mainImage;
    //商品图片列表，含主图
    private List<String> imageList;
    //销量
    private int sales;
    //商品属性列表
    private List<Map<String, List<Object>>> attributeList;
    //sku列表
    private List<ItemSkuDTO> skuList;
    //商品详细描述
    private String desc;

}
