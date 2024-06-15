package com.fudy.shop.domain.modal.item;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Map;

@Data
public class ItemSkuSpec {
    private Map<String, Object> spec;

    public ItemSkuSpec(Map<String, Object> spec) {
        this.spec = spec;
    }

    public String getStringValue() {
        return JSON.toJSONString(spec);
    }
}
