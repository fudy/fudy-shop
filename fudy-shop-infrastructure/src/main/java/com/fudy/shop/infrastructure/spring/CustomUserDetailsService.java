package com.fudy.shop.infrastructure.spring;

import com.fudy.shop.infrastructure.db.data.UserDO;
import com.fudy.shop.infrastructure.db.mybatis.mapper.UserMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    public CustomUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库或其他存储中加载用户信息
        UserDO user = userMapper.select(username);
        // 返回一个实现了 UserDetails 接口的对象，例如：
        return new User(username, user.getPassword(), AuthorityUtils.createAuthorityList("USER"));
    }

}
