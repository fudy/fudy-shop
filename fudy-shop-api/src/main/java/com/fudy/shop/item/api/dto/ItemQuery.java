package com.fudy.shop.item.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemQuery implements Serializable {
    private static final long serialVersionUID = 8923361965337372135L;
    /** 商品id */
    private Long itemId;
}
