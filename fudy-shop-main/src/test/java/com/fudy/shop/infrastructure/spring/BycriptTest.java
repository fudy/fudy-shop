package com.fudy.shop.infrastructure.spring;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BycriptTest {
    @Test
    public void test() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode("myPassword");
        System.out.println(result);
        assertTrue(encoder.matches("myPassword", result));
    }
}
