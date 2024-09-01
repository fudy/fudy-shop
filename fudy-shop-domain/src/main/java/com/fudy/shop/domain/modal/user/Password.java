package com.fudy.shop.domain.modal.user;

import com.fudy.shop.domain.util.SHA1Util;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class Password {
    public static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Getter
    private String value;
    @Getter
    private boolean encrypted;

    public Password(String value) {
        this.value = value;
    }

    /** 加密 */
    public void encrypt() {
        if(!this.encrypted) {
            this.value = passwordEncoder.encode(value);
            this.encrypted = true;
        }
    }

    /** 是否匹配 */
    public boolean matches(String rawPassword) {
        return this.encrypted ? passwordEncoder.matches(rawPassword, this.value) : false;
    }
}
