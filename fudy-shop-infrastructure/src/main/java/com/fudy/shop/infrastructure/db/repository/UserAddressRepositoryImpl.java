package com.fudy.shop.infrastructure.db.repository;

import com.fudy.shop.domain.repository.UserAddressRepository;
import com.fudy.shop.domain.modal.user.UserAddress;
import com.fudy.shop.domain.modal.user.UserId;
import com.fudy.shop.infrastructure.db.convertor.UserAddressConvertor;
import com.fudy.shop.infrastructure.db.data.UserAddressDO;
import com.fudy.shop.infrastructure.db.mybatis.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAddressRepositoryImpl implements UserAddressRepository {
    @Autowired
    private UserAddressMapper mapper;
    @Autowired
    private UserAddressConvertor convertor;

    @Override
    public List<UserAddress> findUserAddresses(UserId userId) {
        List<UserAddressDO> list = mapper.selectList(userId.getValue());
        return convertor.toUserAddressList(list);
    }
}
