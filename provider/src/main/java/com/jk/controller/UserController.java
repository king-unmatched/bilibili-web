package com.jk.controller;

import com.jk.entity.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
    @RequestMapping("update")
    public void update(@RequestParam String createtime,@RequestParam Integer id){
        userService.update(createtime,id);
    }
    @RequestMapping("select")
    public List<User> select(){
        return userService.select();
    }
    @RequestMapping("updates")
    public void updates(@RequestParam Integer id){
        userService.updates(id);
    }
    @RequestMapping("xiu")
    public void xiu(@RequestParam Integer id,@RequestParam String password){
        userService.xiu(id,password);
    }
}
