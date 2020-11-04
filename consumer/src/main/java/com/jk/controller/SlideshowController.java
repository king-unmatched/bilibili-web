package com.jk.controller;

import com.jk.entity.SlideshowBean;
import com.jk.entity.SuperBean;
import com.jk.entity.SyTypeBean;
import com.jk.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("slide")
public class SlideshowController {
    @Autowired
    private SlideshowService slideshowService;
    @RequestMapping("slideshow")
    public List<SlideshowBean> slideshow(){
        return slideshowService.selslideshow();
    }


    @RequestMapping("seltype")
    public List<SyTypeBean> seltype(){
        return slideshowService.seltype();
    }

    @RequestMapping("selsuper")
    public List<SuperBean> selsuper(){
        return slideshowService.selsuper();
    }
}
