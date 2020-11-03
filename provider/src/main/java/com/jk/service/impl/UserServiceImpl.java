package com.jk.service.impl;

import com.jk.dao.UserMapper;
import com.jk.entity.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(Long userPhone) {
        return userMapper.login(userPhone);
    }
}
