package com.fudy.shop.infrastructure.file;

import com.fudy.shop.infrastructure.file.PrivateProperties;
import org.junit.jupiter.api.Test;

public class PrivatePropertiesTest {

    @Test
    public void testGetSmsTestPhone() {
        String phone = PrivateProperties.getSmsTestPhone();
        System.out.println(phone);
    }
}
