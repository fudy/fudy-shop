package com.fudy.shop.infrastructure.db.mybatis.mapper;

import com.fudy.shop.infrastructure.db.data.ItemAttributeKeyDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ItemAttributeKeyMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,parent_id,category_name";
    String COLUMNS = "id," + NO_ID_COLUMNS;
    @Select("select " + COLUMNS + " from item_attribute_key where id = #{id}")
    ItemAttributeKeyDO select(@Param("id") Long id);
}
