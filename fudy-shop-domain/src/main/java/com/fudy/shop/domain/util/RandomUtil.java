package com.fudy.shop.domain.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtil {
    private static String DIGITS = "0123456789";

    /** 随机生成指定位数的数字 */
    public static String randomDigits(int size) {
        char[] rands = new char[size];
        for (int i = 0; i < size; i++) {
            int rand = (int) (Math.random() * 10);
            rands[i] = DIGITS.charAt(rand);
        }
        return new String(rands);
    }

    public static String randomStr(int length) {
        return RandomStringUtils.random(length, true, true);
    }
}
