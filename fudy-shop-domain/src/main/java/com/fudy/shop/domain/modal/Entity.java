package com.fudy.shop.domain.modal;

import lombok.Data;

@Data
public class Entity {
    private Long id;

    public boolean hasId() {
        return null != id;
    }
}
