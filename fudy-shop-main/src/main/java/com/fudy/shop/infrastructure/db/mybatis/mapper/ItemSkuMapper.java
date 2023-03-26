package com.fudy.shop.infrastructure.db.mybatis.mapper;

import com.fudy.shop.infrastructure.db.data.ItemSkuDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemSkuMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,item_id,spec,price,stock,image";
    String COLUMNS = "id," + NO_ID_COLUMNS;
    @Select("select " + COLUMNS + " from item_sku where item_id = #{itemId}")
    ItemSkuDO select(@Param("itemId") Long itemId);

    @Select("select " + COLUMNS + " from item_sku where item_id = #{itemId}")
    List<ItemSkuDO> selectList(@Param("itemId") Long itemId);
}
