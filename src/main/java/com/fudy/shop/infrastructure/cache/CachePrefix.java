package com.fudy.shop.infrastructure.cache;

public enum CachePrefix {
    USER_REGISTRY; //用户注册

    public String append(String value) {
        return new StringBuilder(this.name()).append("__").append(value).toString();
    }
}
