package com.fudy.shop.domain.item;

import lombok.Data;

@Data
public class ItemImage {
    private String image;
    public ItemImage() {
    }
    public ItemImage(String image) {
        this.image = image;
    }
}
