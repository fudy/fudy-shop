package com.fudy.shop.domain.modal.item;

import com.fudy.shop.domain.Entity;
import lombok.Data;

import java.util.List;

@Data
public class Item extends Entity {
    //商品标题
    private String title;
    //商品主图
    private ItemImage mainImage;
    //商品图片列表，含主图
    private List<ItemImage> imageList;
    //销量
    private int sales;
    //商品属性列表
    private List<ItemAttribute> attributeList;
    //sku列表
    private List<ItemSku> skuList;
    //商品详细描述
    private String desc;
}
