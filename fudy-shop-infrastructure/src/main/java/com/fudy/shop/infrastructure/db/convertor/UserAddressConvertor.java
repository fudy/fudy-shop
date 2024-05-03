package com.fudy.shop.infrastructure.db.convertor;

import com.fudy.shop.application.assembler.UserCommonConvertor;
import com.fudy.shop.domain.modal.user.UserAddress;
import com.fudy.shop.infrastructure.db.data.UserAddressDO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserCommonConvertor.class)
public interface UserAddressConvertor {

    UserAddress toUserAddress(UserAddressDO userAddressDO);

    List<UserAddress> toUserAddressList(List<UserAddressDO> userAddressDOs);

    default boolean toDefaultAddress(String defaultAddress) {
        return "Y".equals(defaultAddress);
    }
}
