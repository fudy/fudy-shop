package com.fudy.shop.domain.user.session;

import com.fudy.shop.domain.user.User;

public interface UserSession {

    Long getUserId();

    String getUserName();

    String getPhone();

    String getNickName();

    void save(User user);
}
