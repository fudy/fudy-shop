package com.fudy.shop.infrastructure.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fudy.shop.application.ImageCaptchaManager;
import com.fudy.shop.application.UserManager;
import com.fudy.shop.application.dto.UserLoginDTO;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private ImageCaptchaManager imageCaptchaManager;
    private UserManager userManager;

    public CustomUsernamePasswordAuthenticationFilter(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        logger.info("User authenticated successfully.");
        super.successfulAuthentication(request, response, chain, authResult);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        try {
            UserLoginDTO dto = objectMapper.readValue(request.getInputStream(), UserLoginDTO.class);
            userManager.checkValid(dto, request.getSession());
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
            // Allow subclasses to set the "details" property
            setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }
}
