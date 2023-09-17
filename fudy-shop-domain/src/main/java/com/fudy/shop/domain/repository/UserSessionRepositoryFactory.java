package com.fudy.shop.domain.repository;

public interface UserSessionRepositoryFactory<T> {
    UserSessionRepository newUserSessionRepository(T httpSession);
}
