package com.fudy.shop.domain.repository;

import com.fudy.shop.domain.repository.query.UserQuery;
import com.fudy.shop.domain.user.PhoneNumber;
import com.fudy.shop.domain.user.User;
import com.fudy.shop.domain.user.UserName;

public interface UserRepository {
    User saveUser(User user) throws Exception;

    User getUser(UserQuery query);

    User getUser(PhoneNumber phone);

    User getUser(UserName userName);

}
