package com.fudy.shop.domain.service;

import com.fudy.shop.domain.modal.user.Password;
import com.fudy.shop.domain.modal.user.PhoneNumber;
import com.fudy.shop.domain.modal.user.User;
import com.fudy.shop.domain.modal.user.UserName;
import com.fudy.shop.domain.repository.UserRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(@NonNull User user) throws Exception {
        user.encryptPassword();
        return userRepository.saveUser(user);
    }

    public User getUser(PhoneNumber phone) {
        return userRepository.getUser(phone);
    }

    public User getUser(UserName userName) {
        return userRepository.getUser(userName);
    }

    public User login(UserName userName, Password password) throws Exception {
        User user = userRepository.getUser(userName);
        Objects.requireNonNull(user, "用户名和密码不正确");
        boolean isValid = user.authenticate(user.getUserName(), password);
        if (!isValid) {
            throw new Exception("用户名和密码不正确");
        }
        return user;
    }

    public void checkUser(String userId) {
        //TODO
    }
}
