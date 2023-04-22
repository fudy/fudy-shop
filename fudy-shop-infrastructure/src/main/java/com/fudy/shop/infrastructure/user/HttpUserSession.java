package com.fudy.shop.infrastructure.user;

import com.fudy.shop.domain.user.User;
import com.fudy.shop.domain.user.session.UserSession;

import javax.servlet.http.HttpSession;

public class HttpUserSession implements UserSession {
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String PHONE = "phone";
    public static final String NICK_NAME = "nick_name";
    private HttpSession httpSession;

    public HttpUserSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public void putUserId(Long id) {
        httpSession.setAttribute(USER_ID, id);
    }

    public Long getUserId() {
        return (Long)httpSession.getAttribute(USER_ID);
    }

    public void putUserName(String userName) {
        httpSession.setAttribute(USER_NAME, userName);
    }

    public String getUserName() {
        return (String)httpSession.getAttribute(USER_NAME);
    }

    public void putPhone(String phone) {
        httpSession.setAttribute(PHONE, phone);
    }

    public String getPhone() {
        return (String)httpSession.getAttribute(PHONE);
    }

    public void putNickName(String nickName) {
        httpSession.setAttribute(NICK_NAME, nickName);
    }

    public String getNickName() {
        return (String) httpSession.getAttribute(NICK_NAME);
    }

    public void save(User user) {
        putUserId(user.getId());
        putUserName(user.getUserName());
        putPhone(user.getPhone());
        putNickName(user.getNickName());
    }

    public void invalidate() {
        httpSession.invalidate();
    }
}
