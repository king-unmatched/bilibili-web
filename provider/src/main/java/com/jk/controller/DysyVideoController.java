package com.jk.controller;

import com.jk.entity.DysyVideo;
import com.jk.service.DysyVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DysyVideoController {
    @Autowired
    private DysyVideoService dysyVideoService;

    @RequestMapping("selectVideo")
    public List<DysyVideo>selectVideo(){
        return dysyVideoService.selectVideo();
    }
}
