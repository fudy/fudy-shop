package com.fudy.shop.domain.user;

import com.fudy.shop.domain.user.User;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testGenerateSalt() {
        User user = new User();
        user.generateSalt();
        System.out.println(user.getSalt());
    }

    @Test
    public void testEncryptPassword() {
        User user = new User();
        user.setPassword("1234");
        user.encryptPassword();
        System.out.println(user.getPassword());
    }

    @Test
    public void testEncryptPassword2() {
        User user = new User();
        String encryptPassword = user.encryptPassword("gv0gdQkpHvBjGUHx", "A12345");
        System.out.println(encryptPassword);
    }
}
