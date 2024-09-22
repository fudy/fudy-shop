package com.fudy.shop.infrastructure.spring;

import com.alibaba.fastjson.JSON;
import com.fudy.shop.application.UserManager;
import com.fudy.shop.application.dto.Result;
import com.fudy.shop.application.dto.SimpleUserDTO;
import com.fudy.shop.domain.modal.user.session.UserSession;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.fudy.shop.application.assembler.UserAssembler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private UserAssembler userAssembler;
    private UserManager userManager;

    public CustomAuthenticationSuccessHandler(UserAssembler userAssembler,UserManager userManager) {
        this.userAssembler = userAssembler;
        this.userManager = userManager;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response
            , Authentication authentication) throws IOException, ServletException {
        // 设置响应的状态码为 200 OK
        response.setStatus(HttpStatus.OK.value());
        // 设置响应的内容类型为 application/json
        response.setContentType("application/json;charset=UTF-8");
        // 调用控制器中的方法
        try (PrintWriter out = response.getWriter()) {
            CustomUserDetail userDetail = (CustomUserDetail)authentication.getPrincipal();
            SimpleUserDTO userDTO = userAssembler.toSimpleUserDTO(userDetail.getUser());
    //        userManager.getUserSessionRepository(request.getSession()).save(new UserSession(userDetail.getUser()));
            // 输出结果
            out.print(JSON.toJSONString(Result.success(userDTO)));
        }
    }
}
