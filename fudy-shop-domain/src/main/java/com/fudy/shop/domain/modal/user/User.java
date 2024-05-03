package com.fudy.shop.domain.modal.user;

import com.fudy.shop.domain.modal.Entity;
import com.fudy.shop.domain.modal.captcha.Captcha;
import lombok.Data;
import org.apache.commons.codec.binary.Base64;

import java.security.SecureRandom;
import java.util.Random;

@Data
public class User extends Entity {
    private UserName userName;

    private NickName nickName;

    private Password password;

    private PhoneNumber phone;

    private Captcha captcha;
    //用于密码加盐
    private PasswordSalt salt;

    private Avatar avatar;

    public boolean authenticate(UserName userName, Password password) {
        if (!this.userName.equals(userName)) {
            return false;
        }
        String encryptPassword = password.getEncryptedPassword(this.salt);
        return this.password.getValue().equals(encryptPassword);
    }

    public void encryptPassword() {
        if (null == password) {
            return;
        }
        this.salt = generateSalt();
        password.encrypt(salt);
    }

    private PasswordSalt generateSalt() {
        final Random r = new SecureRandom();
        byte[] salt = new byte[12];
        r.nextBytes(salt);
        return new PasswordSalt(Base64.encodeBase64String(salt));
    }

    public boolean phoneNumberEquals(PhoneNumber phoneNumber) {
        if (null == this.phone || null == phoneNumber) {
            return false;
        }
        return this.phone.equals(phoneNumber);
    }
}
