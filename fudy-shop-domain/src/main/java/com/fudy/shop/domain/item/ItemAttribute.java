package com.fudy.shop.domain.item;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 商品属性，如 <颜色，[红色，绿色，蓝色]>
 * */
@Data
public class ItemAttribute {
    private Map<String, List<Object>> map;
    public ItemAttribute() {
    }
    public ItemAttribute(JSONObject obj) {
        Set<String> set = obj.keySet();
        Map<String, List<Object>> result = new HashMap<>();
        for (String key : set) {
            Object value = obj.get(key);
            result.put(key, (List<Object>) value);
        }
        this.map = result;
    }
}
