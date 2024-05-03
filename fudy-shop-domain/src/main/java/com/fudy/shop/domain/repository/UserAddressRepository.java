package com.fudy.shop.domain.repository;

import com.fudy.shop.domain.modal.user.UserAddress;
import com.fudy.shop.domain.modal.user.UserId;

import java.util.List;

public interface UserAddressRepository {
    /** 查询用户收货地址 */
    List<UserAddress> findUserAddresses(UserId userId);
}
