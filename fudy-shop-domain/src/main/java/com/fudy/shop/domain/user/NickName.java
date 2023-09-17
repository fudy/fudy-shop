package com.fudy.shop.domain.user;

import lombok.Getter;

public class NickName {
    @Getter
    private final String nickName;

    public NickName(String nickName) {
        this.nickName = nickName;
    }
}
