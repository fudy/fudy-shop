package com.fudy.shop.application.repository;

import com.fudy.shop.domain.user.User;

public interface UserRepository {
    User createUser(User user) throws Exception;

    User getUser(String username);
}
