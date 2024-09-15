package com.fudy.shop.infrastructure.spring;

import com.alibaba.fastjson.JSON;
import com.fudy.shop.application.dto.Result;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 设置响应的状态码为 200 OK
        response.setStatus(HttpStatus.OK.value());
        // 设置响应的内容类型为 application/json
        response.setContentType("application/json;charset=UTF-8");
        // 调用控制器中的方法
        try (PrintWriter out = response.getWriter()) {
            String message = exception.getMessage();
            if (message.equals("Bad credentials")) {
                message = "用户名和密码错误";
            }
            // 输出结果
            out.print(JSON.toJSONString(Result.fail(message)));
        }
    }
}
