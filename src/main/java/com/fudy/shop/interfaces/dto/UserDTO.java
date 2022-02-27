package com.fudy.shop.interfaces.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 8027492582082435418L;

    private String userName;

    private String nickName;

    private String password;

    private String phone;
}
