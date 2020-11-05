package com.jk.controller;

import com.jk.entity.YcOriginal;
import com.jk.service.YcOriginalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class YcOriginalController {
    @Autowired
    private YcOriginalService   ycOriginalService;

    @RequestMapping("listYC")
    public List<YcOriginal>listYC(){
        return ycOriginalService.listYC();
    }
}
