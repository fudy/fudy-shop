package com.fudy.shop.domain.item;

import lombok.Data;

import java.util.Map;

@Data
public class ItemSkuSpec {
    private Map<String, Object> spec;

    public ItemSkuSpec(Map<String, Object> spec) {
        this.spec = spec;
    }
}
