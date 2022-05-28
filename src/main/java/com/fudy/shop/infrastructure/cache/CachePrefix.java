package com.fudy.shop.infrastructure.cache;

public enum CachePrefix {
    MOCK,
    USER_LOGIN,
    USER_REGISTRY; //用户注册

    public String append(String value) {
        return new StringBuilder(this.name()).append("__").append(value).toString();
    }
}
