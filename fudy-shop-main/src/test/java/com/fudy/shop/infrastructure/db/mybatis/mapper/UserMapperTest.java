package com.fudy.shop.infrastructure.db.mybatis.mapper;

import com.fudy.shop.infrastructure.db.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.fudy.shop.infrastructure.db.data.UserDO;
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDO userDO = new UserDO();
        userDO.setUserName("test");
        userDO.setPassword("123456");
        userDO.setNickName("testNick");
        userDO.setPhone("111111111111");
        userMapper.insert(userDO);
    }
    @Test
    public void testSelect() {
        UserDO user = userMapper.select("test");
        System.out.println(user);
        assertNotNull(user);
        assertEquals("111111111111", user.getPhone() );
        assertEquals("test", user.getUserName() );
    }

}
