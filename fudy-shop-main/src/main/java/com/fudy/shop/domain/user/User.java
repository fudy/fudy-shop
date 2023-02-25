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
        this.password = this.encryptPassword(this.password, this.salt);
    }

    public void encryptPassword(String password) {
        this.password = this.encryptPassword(password, this.salt);
    }

    public String encryptPassword(String password, String salt) {
        String text = new StringBuilder(password).append(salt).toString();
        return SHA1Util.digest(text);
    }

    public boolean authenticate(String userName, String password) {
        if (!this.userName.equals(userName)) {
            return false;
        }
        String encryptPassword = this.encryptPassword(password, this.salt);
        return this.password.equals(encryptPassword);
    }

    public void generateSalt() {
        final Random r = new SecureRandom();
        byte[] salt = new byte[12];
        r.nextBytes(salt);
        this.salt = Base64.encodeBase64String(salt);
    }
}
