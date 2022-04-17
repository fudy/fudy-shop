package com.fudy.shop.infrastructure.cache;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CacheItem implements Serializable {
    private static final long serialVersionUID = -680148501883865724L;
    private Serializable data;
    private long expireTime;
}
