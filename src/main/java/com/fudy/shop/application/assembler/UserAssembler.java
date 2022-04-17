package com.fudy.shop.application.assembler;

import com.fudy.shop.domain.user.User;
import com.fudy.shop.interfaces.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAssembler {
    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);
}
