package com.fudy.shop.application.repository.impl;

import com.fudy.shop.application.repository.UserRepository;
import com.fudy.shop.application.repository.query.UserQuery;
import com.fudy.shop.domain.user.User;
import com.fudy.shop.infrastructure.db.convertor.UserConvertor;
import com.fudy.shop.infrastructure.db.data.UserDO;
import com.fudy.shop.infrastructure.db.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserConvertor convertor;

    @Override
    public User createUser(User user) throws Exception{
        UserDO userDO = userMapper.select(user.getUserName());
        if (null != userDO) {
            throw new Exception("用户"+user.getUserName()+"已经存在");
        }
        userDO = userMapper.selectByPhone(user.getPhone());
        if (null != userDO) {
            throw new Exception("手机号"+user.getPhone()+"已经被注册");
        }
        userDO = convertor.toUserDO(user);
        //下面这句会带出id
        userMapper.insert(userDO);
        return convertor.toUser(userDO);
    }

    @Override
    public User getUser(UserQuery query) {
        UserDO userDO = null;
        if (null != query.getUsername()) {
            userDO = userMapper.select(query.getUsername());
        } else if (null != query.getPhone()) {
            userDO = userMapper.selectByPhone(query.getPhone());
        }
        return convertor.toUser(userDO);
    }

    @Override
    public void updateUser(User user) throws Exception {
        UserDO userDO = convertor.toUserDO(user);
        Objects.requireNonNull(userDO, "user is null");
        userMapper.update(userDO);
    }
}
