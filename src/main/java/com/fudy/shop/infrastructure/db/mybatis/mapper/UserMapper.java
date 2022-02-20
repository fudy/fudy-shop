package com.fudy.shop.infrastructure.db.mybatis.mapper;

import com.fudy.shop.infrastructure.db.data.UserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,user_name,nick_name,password,phone";
    String COLUMNS = "id," + NO_ID_COLUMNS;

    @Select("select " + COLUMNS + " from user where user_name = #{userName}")
    UserDO select(@Param("userName") String userName);

    @Select("select " + COLUMNS + " from user limit 200")
    List<UserDO> selectList();

    @Insert("insert into user("+NO_ID_COLUMNS+") values(now(), now(), #{userName}, #{nickName}, #{password}, #{phone})")
    void insert(UserDO userDO);

    @Update("update user set modified_time=now(), nick_name=#{nickName}, password=#{password}, phone=#{phone} " +
            "where user_name = #{userName}")
    void update(UserDO userDO);

    @Delete("delete from user where user_name = #{userName}")
    void delete(@Param("userName") String userName);
}
