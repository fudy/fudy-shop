package com.fudy.shop.domain.modal.user;

import lombok.Getter;

public class PasswordSalt {
    @Getter
    private final String value;

    public PasswordSalt(String value) {
        this.value = value;
    }
}
