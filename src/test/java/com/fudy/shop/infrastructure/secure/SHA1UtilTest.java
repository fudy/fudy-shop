package com.fudy.shop.infrastructure.secure;

import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class SHA1UtilTest {
    @Test
    public void testEncode() throws NoSuchAlgorithmException {
        String result = SHA1Util.digest("hello");
        System.out.println(result);
    }
}
