package com.fudy.shop.domain.modal.user;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class Avatar implements Serializable {

    private static final long serialVersionUID = -7702909288321479822L;
    private String value;

    public Avatar(String value) {
        this.value = value;
    }

    public String getAvatarUrl(@NonNull String prefix) {
        return prefix + value;
    }
}
