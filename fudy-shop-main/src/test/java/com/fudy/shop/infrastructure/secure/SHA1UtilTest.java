package com.fudy.shop.infrastructure.secure;

import com.fudy.shop.infrastructure.secure.SHA1Util;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class SHA1UtilTest {
    @Test
    public void testEncode() throws NoSuchAlgorithmException {
        String result = SHA1Util.digest("hello");
        System.out.println(result);
    }
}
