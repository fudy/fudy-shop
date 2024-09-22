package com.fudy.shop.domain.modal.user;

import com.fudy.shop.domain.util.SHA1Util;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;

@Data
public class Password implements Serializable {
    private static final long serialVersionUID = -4452608298349618556L;
    public static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Getter @Setter
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
