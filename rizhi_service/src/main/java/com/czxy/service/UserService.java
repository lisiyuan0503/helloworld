package com.czxy.service;

import com.czxy.domain.User;

public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);
}
