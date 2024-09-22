package com.fudy.shop.domain.modal.user;

import com.fudy.shop.domain.modal.Entity;
import com.fudy.shop.domain.modal.captcha.Captcha;
import lombok.Data;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Random;

@Data
public class User extends Entity implements Serializable {

    private static final long serialVersionUID = -99543818467394919L;

    private UserName userName;

    private NickName nickName;

    private Password password;

    private PhoneNumber phone;

    private Captcha captcha;

    private Avatar avatar;

    public String getPasswordValue() {
        return null == password ? null: password.getValue();
    }

    public String getUsernameValue() {
        return null == userName ? null : userName.getValue();
    }

    public String getAvatarValue() {
        return null == avatar ? null : avatar.getValue();
    }

    public boolean authenticate(UserName userName, Password password) {
        if (!this.userName.equals(userName)) {
            return false;
        }
        String encryptPassword = password.getValue();
        return this.password.getValue().equals(encryptPassword);
    }

    public void encryptPassword() {
        if (null == password) {
            return;
        }
        password.encrypt();
    }


    public boolean phoneNumberEquals(PhoneNumber phoneNumber) {
        if (null == this.phone || null == phoneNumber) {
            return false;
        }
        return this.phone.equals(phoneNumber);
    }
}
