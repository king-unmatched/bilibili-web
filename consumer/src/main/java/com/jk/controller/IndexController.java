package com.jk.controller;

import com.jk.entity.User;
import com.jk.pojo.Result;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("index")
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("logins")
    @ResponseBody
    public Result login(User user){
        User login = userService.login(user.getUserPhone());
        if (login != null && !"".equals(login)) {
            //判断密码是否存在
            if (user.getUserPassword().equals(login.getUserPassword())) {
                //登录成功
                return new Result(true, "登录成功！");
            } else {
                return new Result(false,"密码错误！");
            }
        } else {
            return new Result(false, "账号不存在！");
        }
    }

    @RequestMapping("zhifu")
    public String zhifu(){
        return "buyvip";
    }

    @RequestMapping("tohistory")
    public String history(){
        return "history";
    }

}
