package com.fudy.shop.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class SmsUserLoginDTO implements Serializable {
    private static final long serialVersionUID = 4660095680304414307L;
    @NotBlank(message = "电话号码不能为空")
    private String phone;

    @NotBlank(message = "验证码不能为空")
    private String captcha;
}
