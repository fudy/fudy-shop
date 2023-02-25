package com.fudy.shop.infrastructure.config;

import com.fudy.shop.infrastructure.config.NacosConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NacosConfigTest {
    @Autowired
    private NacosConfig config;

    @Test
    public void test1() throws Exception{
        int i=6;
        while(i-- > 0) {
            System.out.println("name: " + config.getName());
            Thread.sleep(10000);
        }
    }
}
