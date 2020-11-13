package com.jk.controller;

import com.jk.config.RedisConstant;
import com.jk.entity.NewVideo;
import com.jk.entity.SlideshowBean;
import com.jk.entity.SuperBean;
import com.jk.entity.TypeBean;
import com.jk.service.SlideshowService;
import com.jk.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("slide")
public class SlideshowController {
    @Autowired
    private SlideshowService slideshowService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("slideshow")
    public List<SlideshowBean> slideshow(){
        List<SlideshowBean> slideshow = (List<SlideshowBean>) redisUtil.get(RedisConstant.SLIDESHOW_KEY);
        if (slideshow == null || slideshow.isEmpty()) {
            slideshow = slideshowService.selslideshow();
            redisUtil.set(RedisConstant.SLIDESHOW_KEY, slideshow);
            redisUtil.expire(RedisConstant.SLIDESHOW_KEY, 60);
        }
        return slideshow;
    }

    @RequestMapping("seltype")
    public List<TypeBean> seltype(){
        return slideshowService.seltype();
    }

    @RequestMapping("selsuper")
    public List<SuperBean> selsuper(){
        return slideshowService.selsuper();
    }
}
