package com.fudy.shop.application.repository;

import com.fudy.shop.infrastructure.db.convertor.ItemConvertor;
import com.fudy.shop.domain.item.Item;
import com.fudy.shop.domain.item.ItemSku;
import com.fudy.shop.infrastructure.db.data.ItemSkuDO;
import com.fudy.shop.infrastructure.db.data.ItemSpuDO;
import com.fudy.shop.infrastructure.db.mybatis.mapper.ItemSkuMapper;
import com.fudy.shop.infrastructure.db.mybatis.mapper.ItemSpuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {
    @Autowired
    private ItemSpuMapper itemSpuMapper;
    @Autowired
    private ItemSkuMapper itemSkuMapper;
    @Autowired
    private ItemConvertor convertor;

    private ItemSpuDO getItemSpuDO(Long itemId) {
        //TODO get from cache
        ItemSpuDO spu = itemSpuMapper.select(itemId);
        //TODO write to cache
        return spu;

    }

    private List<ItemSkuDO> getItemSkuDOList(Long itemId) {
        //TODO get from cache
        List<ItemSkuDO> skuDOList = itemSkuMapper.selectList(itemId);
        //TODO write to cache
        return skuDOList;
    }

    public Item getItem(Long itemId) {
        // get item spu
        ItemSpuDO itemSpuDO = getItemSpuDO(itemId);
        Item item = convertor.toItem(itemSpuDO);
        // get sku list
        List<ItemSkuDO> itemSkuDOList = getItemSkuDOList(itemId);
        List<ItemSku> skuList = convertor.toItemSkuList(itemSkuDOList);
        item.setSkuList(skuList);
        return item;
    }
}
