package com.fudy.shop.domain.modal.user;

import lombok.Getter;

public class PhoneNumber {
    @Getter
    private final String value;

    public PhoneNumber(String value) {
        this.value = value;
    }
}
