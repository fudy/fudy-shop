package com.fudy.shop.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UserLoginDTO implements Serializable {
    private static final long serialVersionUID = 3727307416485855910L;
    @NotBlank(message = "用户名不能为空")
    @Size(min=4, max=16, message = "用户名长度为4-16个字符")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "图片验证码不能为空")
    private String imageCaptcha;

}
