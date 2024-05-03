package com.fudy.shop.infrastructure.db.repository;

import com.fudy.shop.domain.repository.UserRepository;
import com.fudy.shop.domain.repository.query.UserQuery;
import com.fudy.shop.domain.modal.user.PhoneNumber;
import com.fudy.shop.domain.modal.user.UserName;
import com.fudy.shop.infrastructure.db.convertor.UserConvertor;
import com.fudy.shop.infrastructure.db.data.UserDO;
import com.fudy.shop.domain.modal.user.User;
import com.fudy.shop.infrastructure.db.mybatis.mapper.UserMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserConvertor convertor;


    @Override
    public User saveUser(@NonNull User user) throws Exception {
        UserDO userDO = convertor.toUserDO(user);
        if (user.hasId()) {
            userMapper.update(userDO);
        } else {
            userMapper.insert(userDO);
        }
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
    public User getUser(@NonNull PhoneNumber phone) {
        UserDO userDO = userMapper.selectByPhone(phone.getValue());
        return convertor.toUser(userDO);
    }

    @Override
    public User getUser(UserName userName) {
        UserDO userDO = userMapper.select(userName.getValue());
        return convertor.toUser(userDO);
    }

}
