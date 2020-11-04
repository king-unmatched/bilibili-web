package com.jk.controller;

import com.jk.entity.DssyTeleplay;
import com.jk.service.DssyTeleplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("select")
public class DssyTeleplayController {
    @Autowired
    private DssyTeleplayService dssyTeleplayService;

    @RequestMapping("listAll")
    @ResponseBody
    public List<DssyTeleplay>listAll(){
        return dssyTeleplayService.list();
    }
}
