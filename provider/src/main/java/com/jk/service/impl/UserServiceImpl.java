package com.jk.service.impl;

import com.jk.dao.UserMapper;
import com.jk.entity.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String usercode) {
        return userMapper.login(usercode);
    }

    @Override
    public void loginto(User ccc) {
        ccc.setUserimg("https://i02piccdn.sogoucdn.com/cf5266090060c69e");
        userMapper.insert(ccc);
    }

    @Override
    public void update(String createtime,Integer id) {
        userMapper.update(createtime,id);
    }

    @Override
    public List<User> select() {
        return userMapper.select();
    }

    @Override
    public void updates(Integer id) {
        userMapper.updates(id);
    }

    @Override
    public void xiu(Integer id, String password) {
        userMapper.xiu(id,password);
    }
}
