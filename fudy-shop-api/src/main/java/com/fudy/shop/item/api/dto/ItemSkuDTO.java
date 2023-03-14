package com.fudy.shop.item.api.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

@Data
public class ItemSkuDTO implements Serializable {
    private static final long serialVersionUID = 9214169657214615084L;
    //规格
    private Map<String, Object> spec;
    //价格
    private BigDecimal price;
    //图片
    private String image;
}
