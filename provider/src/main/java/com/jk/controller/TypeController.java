package com.jk.controller;

import com.jk.entity.SyTypeBean;
import com.jk.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;


    @RequestMapping("seltype")
    public List<SyTypeBean> seltype(){
        return typeService.seltype();
    }
}
