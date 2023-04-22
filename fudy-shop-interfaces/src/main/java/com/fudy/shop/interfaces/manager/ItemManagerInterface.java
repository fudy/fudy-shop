package com.fudy.shop.interfaces.manager;

import com.fudy.shop.item.api.dto.ItemDTO;
import com.fudy.shop.item.api.dto.ItemQuery;

public interface ItemManagerInterface {
    ItemDTO getItem(ItemQuery query) throws Exception;
}
