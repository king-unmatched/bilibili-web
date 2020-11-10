package com.jk.controller;

import com.jk.entity.YcOriginal;
import com.jk.service.YcOriginalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("listYCO")
public class YcOriginalController {
    @Autowired
    private YcOriginalService  ycOriginalService;

    @RequestMapping("selectlistYCO")
    @ResponseBody
    public List<YcOriginal>selectlistYCO(){
        return ycOriginalService.listYC();
    }
}
