package com.fudy.shop.infrastructure.db.convertor;

import com.fudy.shop.domain.user.User;
import com.fudy.shop.infrastructure.db.data.UserDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConvertor {

    UserDO toUserDO(User user);

    User toUser(UserDO userDO);
}
