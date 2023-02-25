package com.fudy.shop.interfaces.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SimpleUserDTO implements Serializable {
    private static final long serialVersionUID = -1506202789702640624L;

    private String id;

    private String userName;

    private String nickName;
}
