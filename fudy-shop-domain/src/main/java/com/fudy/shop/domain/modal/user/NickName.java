package com.fudy.shop.domain.modal.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class NickName implements Serializable {
    private static final long serialVersionUID = 3850207780261413983L;

    @Getter @Setter
    private final String nickName;

    public NickName(String nickName) {
        this.nickName = nickName;
    }
}
