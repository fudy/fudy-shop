package com.fudy.shop.domain.modal.user;

import lombok.Getter;

public class UserId {
    @Getter
    private final Long value;

    public UserId(Long value) {
        this.value = value;
    }

    public UserId(String value) {
        this.value = Long.parseLong(value);
    }
}
