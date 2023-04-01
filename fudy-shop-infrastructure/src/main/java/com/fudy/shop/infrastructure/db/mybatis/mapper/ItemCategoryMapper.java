package com.fudy.shop.infrastructure.db.mybatis.mapper;

import com.fudy.shop.infrastructure.db.data.ItemCategoryDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ItemCategoryMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,parent_id,category_name";
    String COLUMNS = "id," + NO_ID_COLUMNS;

    @Select("select " + COLUMNS + " from item_category where id = #{id}")
    ItemCategoryDO select(@Param("id") Long id);
}
