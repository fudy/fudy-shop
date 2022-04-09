package com.fudy.shop.infrastructure.file;

import org.junit.jupiter.api.Test;

public class PrivatePropertiesTest {

    @Test
    public void testGetSmsTestPhone() {
        String phone = PrivateProperties.getSmsTestPhone();
        System.out.println(phone);
    }
}
