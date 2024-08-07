package com.fudy.shop.application.assembler;

import com.fudy.shop.application.dto.SimpleUserDTO;
import com.fudy.shop.application.dto.UserDTO;
import com.fudy.shop.domain.modal.user.User;
import com.fudy.shop.domain.modal.user.session.UserSession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserCommonConvertor.class)
public interface UserAssembler {
    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    SimpleUserDTO toSimpleUserDTO(User user);

    default SimpleUserDTO toSimpleUserDTO(UserSession userSession) {
        if (null == userSession) {
            return null;
        }
        SimpleUserDTO dto = new SimpleUserDTO();
        dto.setUserName(userSession.getUserName());
        dto.setId(null == userSession.getUserId() ? null : String.valueOf(userSession.getUserId()));
        dto.setNickName(userSession.getNickName());
        return dto;
    }
}
