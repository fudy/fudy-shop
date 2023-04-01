package com.fudy.shop.infrastructure.db.data;

import lombok.Data;

import java.util.Date;

@Data
public class CommonDO {
    private Long id;
    private Date createdTime;
    private Date modifiedTime;
}
