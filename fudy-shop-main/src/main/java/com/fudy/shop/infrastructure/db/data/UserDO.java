package com.fudy.shop.infrastructure.db.data;

import lombok.Data;

@Data
public class UserDO extends CommonDO {
    private String userName;
    private String nickName;
    private String password;
    private String phone;
    private String salt;
}
