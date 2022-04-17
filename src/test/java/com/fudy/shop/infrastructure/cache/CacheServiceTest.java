package com.fudy.shop.infrastructure.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CacheServiceTest {
    @Autowired
    private CacheService cacheService;

    @Test
    public void test1() throws Exception {
        cacheService.write(CachePrefix.USER_REGISTRY, "key", "value", 1);
        String value = cacheService.read(CachePrefix.USER_REGISTRY, "key", String.class);
        System.out.println(value);
        assertEquals(value, "value");
    }

    @Test
    public void test2() throws Exception {
        cacheService.write(CachePrefix.USER_REGISTRY, "key", "value", 1);
        Thread.sleep(2000);
        String value = cacheService.read(CachePrefix.USER_REGISTRY, "key", String.class);
        System.out.println(value);
        assertNull(value);
    }
}
