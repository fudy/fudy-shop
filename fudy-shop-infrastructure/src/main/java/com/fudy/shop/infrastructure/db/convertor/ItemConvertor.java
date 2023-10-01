package com.fudy.shop.infrastructure.db.convertor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fudy.shop.application.assembler.ItemCommonConverter;
import com.fudy.shop.domain.item.*;
import com.fudy.shop.infrastructure.db.data.ItemSkuDO;
import com.fudy.shop.infrastructure.db.data.ItemSpuDO;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring", uses = {ItemCommonConverter.class})
public interface ItemConvertor {
    Item toItem(ItemSpuDO itemSpuDO);

    ItemSku toItemSku(ItemSkuDO itemSkuDO);

    List<ItemSku> toItemSkuList(List<ItemSkuDO> itemSkuDOList);

    default ItemSkuSpec toItemSkuSpec(String spec) {
        if (null == spec) {
            return null;
        }
        Map<String, Object> specMap = JSON.parseObject(spec);
        return new ItemSkuSpec(specMap);
    }

    default List<ItemAttribute> toItemAttributeList(String attributeList) {
        if (null == attributeList) {
            return null;
        }
        JSONArray arr = JSON.parseArray(attributeList);
        List<ItemAttribute> list = new ArrayList<>();
        for (Object attribute : arr) {
            list.add(new ItemAttribute((JSONObject) attribute));
        }
        return list;
    }

    default List<ItemImage> toItemImageList(String imageList) {
        if (null == imageList) {
            return null;
        }
        String[] imageArr = StringUtils.split(imageList, ",");
        List<ItemImage> list = new ArrayList<>();
        for (String image : imageArr) {
            list.add(new ItemImage(image));
        }
        return list;
    }


}
