package com.fudy.shop.application.assembler;

import com.fudy.shop.interfaces.dto.UserDTO;
import com.fudy.shop.domain.user.User;
import com.fudy.shop.domain.user.session.UserSession;
import com.fudy.shop.interfaces.dto.SimpleUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserAssembler {
    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    SimpleUserDTO toSimpleUserDTO(User user);

    @Mapping(target="id", source="userSession.userId")
    SimpleUserDTO toSimpleUserDTO(UserSession userSession);
}
