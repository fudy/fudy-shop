package com.fudy.shop.application.assembler;

import com.fudy.shop.domain.captcha.Captcha;
import com.fudy.shop.domain.user.*;

public class UserMapper {
    public UserName toUserName(String username) {
        return new UserName(username);
    }

    public Password toPassword(String password) {
        return new Password(password);
    }

    public NickName toNickName(String nickName) {
        return new NickName(nickName);
    }

    public PhoneNumber toPhoneNumber(String phone) {
        return new PhoneNumber(phone);
    }

    public Captcha toCaptcha(String captcha) {
        return new Captcha(captcha);
    }

    public PasswordSalt toPasswordSalt(String salt) {
        return new PasswordSalt(salt);
    }

    public String toPasswordSalt(PasswordSalt salt) {
        return null == salt ? null : salt.getValue();
    }

    public String toPhoneNumber(PhoneNumber phoneNumber) {
        return null == phoneNumber ? null : phoneNumber.getValue();
    }

    public String toCaptcha(Captcha captcha) {
        return null == captcha ? null : captcha.getCode();
    }

    public String toUserName(UserName username) {
        return null == username ? null : username.getValue();
    }

    public String toPassword(Password password) {
        return null == password ? null : password.getValue();
    }

    public String toNickName(NickName nickName) {
        return null == nickName ? null : nickName.getNickName();
    }
}
