package com.fudy.shop.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class CaptchaDTO implements Serializable {
    private static final long serialVersionUID = -3384173053319144220L;
    @NotBlank(message = "手机号不能为空")
    @Pattern(message = "手机号格式错误", regexp = "^1[0-9]{10}$") //1开头，加上10位数字
    private String phone;

    @NotBlank(message = "验证码类型不能为空")
    private String type;
}
