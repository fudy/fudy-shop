package com.fudy.shop.domain.user;

import com.fudy.shop.domain.util.SHA1Util;
import lombok.Getter;

public class Password {
    @Getter
    private final String value;

    public Password(String value) {
        this.value = value;
    }

    public String getEncryptedPassword(PasswordSalt salt) {
        String text = new StringBuilder(this.value).append(salt.getValue()).toString();
        return SHA1Util.digest(text);
    }
}
