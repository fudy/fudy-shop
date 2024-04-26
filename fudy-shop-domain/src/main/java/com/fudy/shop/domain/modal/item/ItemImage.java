package com.fudy.shop.domain.modal.item;

import lombok.Data;

@Data
public class ItemImage {
    private String image;
    public ItemImage() {
    }
    public ItemImage(String image) {
        this.image = image;
    }

    public String getImageUrl(String uriPrefix) {
        return uriPrefix + image;
    }
}
