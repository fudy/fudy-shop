package com.fudy.shop.infrastructure.spring;

import com.alibaba.fastjson.JSON;
import com.fudy.shop.application.dto.Result;
import com.fudy.shop.application.dto.SimpleUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response
            , Authentication authentication) throws IOException, ServletException {
        // 设置响应的状态码为 200 OK
        response.setStatus(HttpStatus.OK.value());
        // 设置响应的内容类型为 application/json
        response.setContentType("application/json;charset=UTF-8");
        // 调用控制器中的方法
        try (PrintWriter out = response.getWriter()) {
            CustomUserDetail user = (CustomUserDetail)authentication.getPrincipal();
            SimpleUserDTO userDTO = new SimpleUserDTO();
            userDTO.setUserName(user.getUsername());
            userDTO.setAvatar(user.getAvatar());
            // 输出结果
            out.print(JSON.toJSONString(Result.success(userDTO)));
        }
    }
}
