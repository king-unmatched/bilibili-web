package com.jk.controller;

import com.jk.entity.DssyTeleplay;
import com.jk.service.DssyTeleplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DssyTeleplayController {
    @Autowired
    private DssyTeleplayService dssyTeleplayService;

    @RequestMapping("list")
    public List<DssyTeleplay>list(){
        return dssyTeleplayService.list();
    }
}
