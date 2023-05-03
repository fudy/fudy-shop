package com.fudy.shop.common;

import lombok.Data;

@Data
public class PagingResult<T> extends Result<T> {
    private static final long serialVersionUID = 363140642118976596L;
    /** 总数 */
    private int total;

    public static <T> PagingResult<T> fail(String code, String message) {
        PagingResult<T> result = new PagingResult<>();
        result.setErrorMsg(message);
        result.setErrorCode(code);
        result.setSuccess(false);
        return result;
    }

    public static <T> PagingResult<T> success(T data, int total) {
        PagingResult<T> result = new PagingResult<>();
        result.setData(data);
        result.setTotal(total);
        result.setSuccess(true);
        return result;
    }
}
