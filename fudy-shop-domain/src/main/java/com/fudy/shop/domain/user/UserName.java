package com.fudy.shop.domain.user;

import lombok.Getter;

public class UserName {
    @Getter
    private final String value;

    public UserName(String value) {
        this.value = value;
    }
}
