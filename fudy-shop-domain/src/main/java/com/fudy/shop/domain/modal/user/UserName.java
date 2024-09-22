package com.fudy.shop.domain.modal.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class UserName implements Serializable {
    private static final long serialVersionUID = -5837551206502836147L;
    @Getter @Setter
    private final String value;

    public UserName(String value) {
        this.value = value;
    }
}
