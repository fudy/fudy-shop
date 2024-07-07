package com.fudy.shop.infrastructure.web;

import com.fudy.shop.domain.repository.UserSessionRepository;
import com.fudy.shop.domain.modal.user.NickName;
import com.fudy.shop.domain.modal.user.PhoneNumber;
import com.fudy.shop.domain.modal.user.UserId;
import com.fudy.shop.domain.modal.user.UserName;
import com.fudy.shop.domain.modal.user.session.UserSession;

import javax.servlet.http.HttpSession;

public class ServletUserSessionRepository implements UserSessionRepository {
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String PHONE = "phone";
    public static final String NICK_NAME = "nick_name";

    private HttpSession httpSession;

    public ServletUserSessionRepository(HttpSession httpSession) {
        this.httpSession = httpSession;
    }


    public Long getUserId() {
        return (Long)httpSession.getAttribute(USER_ID);
    }


    public String getUserName() {
        return (String)httpSession.getAttribute(USER_NAME);
    }


    public String getPhone() {
        return (String)httpSession.getAttribute(PHONE);
    }


    public String getNickName() {
        return (String) httpSession.getAttribute(NICK_NAME);
    }

    @Override
    public void save(UserSession user) {
        httpSession.setAttribute(USER_ID, user.getUserId());
        httpSession.setAttribute(USER_NAME, user.getUserName());
        httpSession.setAttribute(PHONE, user.getPhone());
        httpSession.setAttribute(NICK_NAME, user.getNickName());
    }

    @Override
    public UserSession getUserSession() {
        if(null == getUserName()) {
            return null;
        }
        UserSession userSession = new UserSession();
        userSession.setUserId(new UserId(getUserId()));
        userSession.setUserName(new UserName(getUserName()));
        userSession.setPhone(new PhoneNumber(getPhone()));
        userSession.setNickName(new NickName(getNickName()));
        return userSession;
    }

    @Override
    public void invalidate() {
        httpSession.invalidate();
    }
}
