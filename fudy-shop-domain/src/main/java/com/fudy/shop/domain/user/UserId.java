package com.fudy.shop.domain.user;

import lombok.Getter;

public class UserId {
    @Getter
    private final Long value;

    public UserId(Long value) {
        this.value = value;
    }
}
