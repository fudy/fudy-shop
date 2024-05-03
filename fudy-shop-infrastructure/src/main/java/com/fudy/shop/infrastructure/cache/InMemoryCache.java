package com.fudy.shop.infrastructure.cache;

import com.fudy.shop.domain.modal.cache.CachePrefix;
import com.fudy.shop.domain.service.CacheService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@ConditionalOnProperty(prefix = "app", name = "cache.type", havingValue = "memory")
public class InMemoryCache implements CacheService {
    private Map<String, CacheItem> cache = new ConcurrentHashMap<>();

    @Override
    public void write(CachePrefix prefix, String key, Serializable value, int expireSecond) {
        CacheItem cacheItem = new CacheItem(value, expireSecond*1000 + System.currentTimeMillis());
        cache.put(prefix.append(key), cacheItem);
    }

    public <T> T read(CachePrefix prefix, String key, Class<T> clazz) {
        CacheItem cacheItem = cache.get(prefix.append(key));
        if (null == cacheItem || null == cacheItem.getData()) {
            return null;
        }
        //已经过期
        if (System.currentTimeMillis() > cacheItem.getExpireTime()) {
            cache.remove(key);
            return null;
        }
        if (clazz.isAssignableFrom(cacheItem.getData().getClass())) {
            return (T)cacheItem.getData();
        }
        return null;
    }


}
