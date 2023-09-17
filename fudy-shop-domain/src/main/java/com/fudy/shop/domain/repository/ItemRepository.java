package com.fudy.shop.domain.repository;

import com.fudy.shop.domain.item.Item;

public interface ItemRepository {
    Item getItem(Long itemId);
}
