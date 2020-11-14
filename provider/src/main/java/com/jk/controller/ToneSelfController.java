package com.jk.controller;

import com.jk.entity.ToneSelfBean;
import com.jk.service.ToneSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToneSelfController {
    @Autowired
    private ToneSelfService toneSelfService;
    @RequestMapping("insertToneSefl")
    public void insertToneSefl(@RequestBody ToneSelfBean toneSelfBean){
        toneSelfService.insertToneSefl(toneSelfBean);
    }
}
