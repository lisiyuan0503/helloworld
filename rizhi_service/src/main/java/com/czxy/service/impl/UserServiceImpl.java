package com.czxy.service.impl;

import com.czxy.dao.UserMapper;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username,String password) {
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            if (user.getUsername().equals(username) &&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
