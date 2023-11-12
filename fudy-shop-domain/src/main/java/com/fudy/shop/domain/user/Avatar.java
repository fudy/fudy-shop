package com.fudy.shop.domain.user;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Avatar {
    private String value;

    public Avatar(String value) {
        this.value = value;
    }

    public String getAvatarUrl(@NonNull String prefix) {
        return prefix + value;
    }
}
