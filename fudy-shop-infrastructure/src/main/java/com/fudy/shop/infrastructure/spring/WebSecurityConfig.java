package com.fudy.shop.infrastructure.spring;


import com.fudy.shop.domain.modal.user.Password;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationFailureHandler;

import java.time.Duration;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager(); //Spring Security 6.x新写法
     //   return new ProviderManager(authenticationProvider()); //这样也是生效的
    }

    /** 指定认证提供者信息，包括所需的解密算法、用户信息从哪获取 */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        /** 指定和用户注册时相同的PasswordEncoder */
        provider.setPasswordEncoder(Password.passwordEncoder);
        return provider;
    }

    /** 认证授权配置，指定哪些url需要认证 */
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter = getCustomUsernamePasswordAuthenticationFilter(authenticationManager);

        http.cors().configurationSource(corsConfigurationSource()).and() //在这里让cors配置生效
                .csrf().disable().authorizeHttpRequests((requests) -> requests
                    .antMatchers("/api/user/login",
                            "/api/users",
                            "/api/user/logout",
                            "/api/captcha",
                            "/api/image-captcha").permitAll()
                    .anyRequest().authenticated()
            ).formLogin((form) -> form
                    .loginPage("http://localhost:3000/login")
                    .loginProcessingUrl("/api/user/login")
                    .successHandler(new ForwardAuthenticationSuccessHandler("/api/auth"))
                    .failureHandler(new ForwardAuthenticationFailureHandler("/api/auth"))
                    .permitAll()
            ).logout((logout) -> logout
                    .logoutUrl("http://localhost:3000/logout")
                    .logoutSuccessUrl("/login?logout")
                    .invalidateHttpSession(true)
            ).exceptionHandling(e -> e.authenticationEntryPoint(customAuthenticationEntryPoint))
                // 将customUsernamePasswordAuthenticationFilter设置在UsernamePasswordAuthenticationFilter之前执行
                .addFilterBefore(customUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider());
        return http.build();

    }

    private static CustomUsernamePasswordAuthenticationFilter getCustomUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
        CustomUsernamePasswordAuthenticationFilter filter = new CustomUsernamePasswordAuthenticationFilter();
        //记得一定要设置这个url，不然自定义的filter不会被调用
        filter.setFilterProcessesUrl("/api/user/login");
        filter.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler());
  //      filter.setAuthenticationFailureHandler(null); TODO
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setMaxAge(Duration.ofHours(1));
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }


}
