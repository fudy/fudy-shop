package com.fudy.shop.domain.service;

import com.fudy.shop.domain.modal.cache.CachePrefix;

import java.io.Serializable;

public interface CacheService {
    /** 写缓存,指定秒级过期时间 */
    void write(CachePrefix prefix, String key, Serializable value, int expireSecond);
    /** 读缓存 */
    <T> T read(CachePrefix prefix, String key, Class<T> clazz);
}
