package com.fudy.shop.item.api;

import com.fudy.shop.common.Result;
import com.fudy.shop.item.api.dto.ItemDTO;
import com.fudy.shop.item.api.dto.ItemQuery;

public interface ItemService {
    /** 根据商品id获取商品详情 */
    Result<ItemDTO> getItem(ItemQuery query);
}
