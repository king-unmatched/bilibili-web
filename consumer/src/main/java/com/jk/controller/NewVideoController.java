package com.jk.controller;

import com.jk.entity.NewVideo;
import com.jk.service.NewVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("selectList")
public class NewVideoController {
    @Autowired
    private NewVideoService  newVideoService;

    @RequestMapping("selectNewVideo")
    @ResponseBody
    public List<NewVideo>selectNewVideo(){
        return newVideoService.listNewVideo();
    }
}
