package com.fudy.shop.domain.modal.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class PhoneNumber implements Serializable {

    private static final long serialVersionUID = 2436485805535335012L;
    @Getter @Setter
    private final String value;

    public PhoneNumber(String value) {
        this.value = value;
    }
}
