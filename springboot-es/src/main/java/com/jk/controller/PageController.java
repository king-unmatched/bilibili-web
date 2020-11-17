package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PageController {

    @RequestMapping("1")
    public  String  query(){

        return "1";
    }
    @RequestMapping("2")
    public  String  query2(){

        return "2";
    }
}
