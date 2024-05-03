package com.fudy.shop.application;

import com.fudy.shop.application.assembler.UserAddressAssembler;
import com.fudy.shop.application.dto.UserAddressDTO;
import com.fudy.shop.domain.repository.UserAddressRepository;
import com.fudy.shop.domain.modal.user.UserAddress;
import com.fudy.shop.domain.modal.user.UserId;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAddressManager {
    @Autowired
    private UserAddressRepository repository;
    @Autowired
    private UserAddressAssembler assembler;

    public List<UserAddressDTO> findUserAddressList(@NonNull String userId) {
        List<UserAddress> userAddresses = repository.findUserAddresses(new UserId(userId));
        return assembler.toUserAddressDTOs(userAddresses);
    }
}
