package com.fudy.shop.infrastructure.cache;

import com.fudy.shop.domain.modal.cache.CachePrefix;
import com.fudy.shop.domain.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Repository
@ConditionalOnProperty(prefix = "app", name = "cache.type", havingValue = "redis")
public class RedisCache implements CacheService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void write(CachePrefix prefix, String key, Serializable value, int expireSecond) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(prefix.append(key), value, expireSecond, TimeUnit.SECONDS);
    }

    @Override
    public <T> T read(CachePrefix prefix, String key, Class<T> clazz) {
        return (T)redisTemplate.opsForValue().get(prefix.append(key));
    }
}
