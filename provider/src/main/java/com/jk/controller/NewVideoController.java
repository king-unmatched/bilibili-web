package com.jk.controller;

import com.jk.entity.NewVideo;
import com.jk.service.NewVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewVideoController {
    @Autowired
    private NewVideoService newVideoService;

    @RequestMapping("listNewVideo")
    public List<NewVideo>listNewVideo(){
       return newVideoService.listNewVideo();
    }
}
