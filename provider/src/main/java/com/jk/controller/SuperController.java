package com.jk.controller;

import com.jk.entity.SuperBean;
import com.jk.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuperController {
    @Autowired
    private SuperService superService;
    @RequestMapping("selsuper")
    public List<SuperBean> selsuper(){
        return superService.selsuper();
    }
}
