package com.fudy.shop.infrastructure.spring;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetail implements UserDetails {

    private String password;
    private String username;
    @Getter
    private String avatar;
    @Getter
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetail(String username, String password, String avatar, Collection<? extends GrantedAuthority> authorities) {
        this.password = password;
        this.username = username;
        this.avatar = avatar;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
