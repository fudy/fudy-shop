package com.fudy.shop.interfaces.dto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 8027492582082435418L;

    private Long id;

    @NotBlank(message = "用户名不能为空")
    @Size(min=4, max=16, message = "用户名长度为4-16个字符")
    private String userName;

    @NotBlank(message = "昵称不能为空")
    private String nickName;

    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "电话号码不能为空")
    private String phone;

    @NotBlank(message = "验证码不能为空")
    private String captcha;
}
