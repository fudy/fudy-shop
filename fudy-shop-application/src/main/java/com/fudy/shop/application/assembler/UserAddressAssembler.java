package com.fudy.shop.application.assembler;

import com.fudy.shop.application.dto.UserAddressDTO;
import com.fudy.shop.domain.user.UserAddress;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserCommonConvertor.class)
public interface UserAddressAssembler {

    UserAddressDTO toUserAddressDTO(UserAddress userAddress);

    List<UserAddressDTO> toUserAddressDTOs(List<UserAddress> userAddresses);
}
