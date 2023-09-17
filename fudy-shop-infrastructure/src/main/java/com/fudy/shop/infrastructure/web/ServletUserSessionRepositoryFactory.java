package com.fudy.shop.infrastructure.web;

import com.fudy.shop.domain.repository.UserSessionRepository;
import com.fudy.shop.domain.repository.UserSessionRepositoryFactory;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;

@Repository
public class ServletUserSessionRepositoryFactory implements UserSessionRepositoryFactory<HttpSession> {

    public UserSessionRepository newUserSessionRepository(HttpSession httpSession) {
        return new ServletUserSessionRepository(httpSession);
    }

}
