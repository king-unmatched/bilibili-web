package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/go")
public class PagejumpController {


    @RequestMapping("/index")
    public String index(){
        return "index";
    }



}
