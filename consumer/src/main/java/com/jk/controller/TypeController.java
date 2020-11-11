package com.jk.controller;

import com.jk.entity.TypeBean;
import com.jk.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/typeList")
    public List<TypeBean> typeLlist(){
        return typeService.typeLlist();
    }
}
