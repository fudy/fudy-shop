package com.fudy.shop.domain.user;

import com.fudy.shop.infrastructure.secure.SHA1Util;
import lombok.Data;
import org.apache.commons.codec.binary.Base64;

import java.security.SecureRandom;
import java.util.Random;

@Data
public class User extends Entity {
    private String userName;

    private String nickName;

    private String password;

    private String phone;

    private String captcha;
    //用于密码加盐
    private String salt;

    public void encryptPassword() {
        String text = new StringBuilder(this.password).append(this.salt).toString();
        this.password = SHA1Util.digest(text);
    }

    public void generateSalt() {
        final Random r = new SecureRandom();
        byte[] salt = new byte[12];
        r.nextBytes(salt);
        this.salt = Base64.encodeBase64String(salt);
    }
}
