package com.fudy.shop.infrastructure.db.mybatis.mapper;

import com.fudy.shop.infrastructure.db.data.ItemAttributeValueDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ItemAttributeValueMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,value_name,attribute_id";
    String COLUMNS = "id," + NO_ID_COLUMNS;

    @Select("select " + COLUMNS + " from item_attribute_value where id = #{id}")
    ItemAttributeValueDO select(@Param("id") Long id);
}
