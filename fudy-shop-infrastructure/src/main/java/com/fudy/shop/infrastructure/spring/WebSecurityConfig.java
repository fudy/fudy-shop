package com.fudy.shop.infrastructure.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests((requests) -> requests
                    .antMatchers("/api/user/login",
                            "/api/user/logout",
                            "/api/image-captcha").permitAll()
                    .anyRequest().authenticated()
            ).formLogin((form) -> form
                    .loginPage("http://localhost:3000/login")
                    .defaultSuccessUrl("/")
                    .failureUrl("http://localhost:3000/login?error")
                    .permitAll()
            ).logout((logout) -> logout
                    .logoutUrl("http://localhost:3000/logout")
                    .logoutSuccessUrl("/login?logout")
                    .invalidateHttpSession(true)
            ).exceptionHandling(e -> e.authenticationEntryPoint(customAuthenticationEntryPoint))
                .authenticationProvider(authenticationProvider());

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(customUserDetailsService.getPasswordEncoder());
        return provider;
    }

}
