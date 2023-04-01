package com.fudy.shop.domain.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
@Slf4j
public class SHA1Util {
    public static String digest(String text) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        byte[] result = md.digest(bytes);
        return Base64.encodeBase64String(result);
    }
}
