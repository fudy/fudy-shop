package com.fudy.shop.infrastructure.common;

import org.junit.jupiter.api.Test;

public class RandomUtilTest {
    @Test
    public void test() {
        String s = RandomUtil.randomDigits(4);
        System.out.println(s);
    }
}
