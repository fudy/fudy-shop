package com.fudy.shop.infrastructure.db.mybatis.mapper;

import com.fudy.shop.infrastructure.db.data.UserAddressDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserAddressMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,user_id,receiver,phone,province,city,district,street,address,zip_code,default";
    String COLUMNS = "id," + NO_ID_COLUMNS;

    @Select("select " + COLUMNS + " from user_address where user_id = #{userId}")
    List<UserAddressDO> selectList(@Param("userId") Long userId);
}
