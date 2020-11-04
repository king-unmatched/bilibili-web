package com.jk.controller;

import com.jk.entity.DysyVideo;
import com.jk.service.DysyVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("select")
public class DysyVideoController {
    @Autowired
    private DysyVideoService  dysyVideoService;

    @RequestMapping("list")
    @ResponseBody
    public List<DysyVideo>list(){
        return dysyVideoService.selectVideo();
    }
}
