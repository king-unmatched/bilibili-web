package com.jk.controller;

import com.jk.entity.EpisodeNumberBean;
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
    /**
     *  轮播图片查询
     */

    @RequestMapping("slideshow")
    public List<SlideshowBean> slideshow(){
        return slideshowService.selslideshow();
    }


    /**
     * 轮播图查询
     * @return
     */
    @RequestMapping("selsuper")
    public List<SuperBean> selsuper(){
        return slideshowService.selsuper();
    }

    /**
     * 分类查询
     * @return
     */
    @RequestMapping("seltype")
    public List<SyTypeBean> seltype(){
        return slideshowService.seltype();
    }

    /**
     * 选集查询
     * @return
     */
    @RequestMapping("selEpisodeNumber")
    public List<EpisodeNumberBean> selEpisodeNumber(){
        return slideshowService.selEpisodeNumber();
    }
}
