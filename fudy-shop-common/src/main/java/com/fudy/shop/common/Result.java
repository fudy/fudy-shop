package com.fudy.shop.common;

import java.io.Serializable;
import lombok.Data;
/**
 * 可用于接口的返回参数
 * */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -2770896210087961844L;
    /** 是否成功 */
    private boolean success;
    /** 错误码 */
    private String errorCode;
    /** 错误信息 */
    private String errorMsg;
    /** 数据 */
    private T data;

    public static <T> Result<T> success(T t) {
        Result<T> result = new Result();
        result.setSuccess(true);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> fail(String errCode, String errMsg) {
        Result<T> result = new Result();
        result.setSuccess(false);
        result.setErrorCode(errCode);
        result.setErrorMsg(errMsg);
        return result;
    }
}
