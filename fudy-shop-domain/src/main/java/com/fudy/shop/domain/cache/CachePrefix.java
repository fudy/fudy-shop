package com.fudy.shop.domain.cache;

public enum CachePrefix {
    MOCK,
    LOCK,
    USER_LOGIN,
    FORGET_PASSWORD,//忘记密码
    USER_REGISTRY; //用户注册

    public String append(String value) {
        return new StringBuilder(this.name()).append("__").append(value).toString();
    }
}
