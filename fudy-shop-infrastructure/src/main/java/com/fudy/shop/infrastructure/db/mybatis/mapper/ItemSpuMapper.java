package com.fudy.shop.infrastructure.db.mybatis.mapper;

import com.fudy.shop.infrastructure.db.data.ItemSpuDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ItemSpuMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,title,category_id,`desc`,main_image,image_list,status,attribute_list,sales";
    String COLUMNS = "id," + NO_ID_COLUMNS;
    @Select("select " + COLUMNS + " from item_spu where id = #{id}")
    ItemSpuDO select(@Param("id") Long id);
}
