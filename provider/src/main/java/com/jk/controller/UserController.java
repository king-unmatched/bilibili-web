package com.jk.controller;

import com.jk.entity.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public User login(@RequestParam String usercode){
        return  userService.login(usercode);
    }
    @RequestMapping("loginto")
    public void loginto(@RequestBody User ccc){
        userService.loginto(ccc);
    }
}
