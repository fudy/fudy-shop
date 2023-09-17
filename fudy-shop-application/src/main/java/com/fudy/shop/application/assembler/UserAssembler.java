package com.fudy.shop.application.assembler;

import com.fudy.shop.application.dto.SimpleUserDTO;
import com.fudy.shop.application.dto.UserDTO;
import com.fudy.shop.domain.user.User;
import com.fudy.shop.domain.user.session.UserSession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface UserAssembler {
    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    SimpleUserDTO toSimpleUserDTO(User user);

    default SimpleUserDTO toSimpleUserDTO(UserSession userSession) {
        SimpleUserDTO dto = new SimpleUserDTO();
        dto.setUserName(userSession.getUserName());
        dto.setId(null == userSession.getUserId() ? null : String.valueOf(userSession.getUserId()));
        dto.setNickName(userSession.getNickName());
        return dto;
    }
}
