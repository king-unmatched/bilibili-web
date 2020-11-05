package com.jk.service;

import com.jk.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider")
public interface UserService {
    @RequestMapping("login")
    public User login(@RequestParam Long userPhone);
}
