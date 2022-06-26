package com.fudy.shop.infrastructure.common;

import org.junit.jupiter.api.Test;

public class RandomUtilTest {
    @Test
    public void test() {
        String s = RandomUtil.randomDigits(4);
        System.out.println(s);
    }

    @Test
    public void test2() {
        String s = RandomUtil.randomStr(4);
        System.out.println(s);
    }
}
