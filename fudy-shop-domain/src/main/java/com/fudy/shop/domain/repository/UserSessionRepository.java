package com.fudy.shop.domain.repository;

import com.fudy.shop.domain.modal.user.session.UserSession;

public interface UserSessionRepository {

    void save(UserSession user);

    UserSession getUserSession();

    void invalidate();

}
