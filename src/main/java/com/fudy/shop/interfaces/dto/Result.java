package com.fudy.shop.interfaces.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -1;

    private boolean success;

    private String errMsg;

    private T data;

    public static <T> Result<T> success(T t) {
        Result<T> result = new Result();
        result.setSuccess(true);
        result.setData(t);
        return result;
    }
}
