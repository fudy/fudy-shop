package com.fudy.shop.infrastructure.spring;

import com.fudy.shop.infrastructure.db.data.UserDO;
import com.fudy.shop.infrastructure.db.mybatis.mapper.UserMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Getter
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public CustomUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库或其他存储中加载用户信息
        UserDO user = userMapper.select(username);
        // 返回一个实现了 UserDetails 接口的对象，例如：
        return new org.springframework.security.core.userdetails.User(
                username, // 用户名
                passwordEncoder.encode(user.getPassword()), // 密码，注意：这里应该使用之前定义的passwordEncoder加密后的密码
                AuthorityUtils.createAuthorityList("USER")); // 用户角色
    }

}
