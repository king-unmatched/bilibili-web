package com.jk.service;

import com.jk.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    User login(String usercode);

    void loginto(User ccc);

    void update(String createtime,Integer id);

    List<User> select();

    void updates(Integer id);

    void xiu(Integer id, String password);
}
