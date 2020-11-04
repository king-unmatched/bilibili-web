package com.jk.service;

import com.jk.entity.SlideshowBean;
import com.jk.entity.SuperBean;
import com.jk.entity.SyTypeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "provider")
public interface SlideshowService {
    @RequestMapping("selslideshow")
    public List<SlideshowBean> selslideshow();




    @RequestMapping("seltype")
    public List<SyTypeBean> seltype();



    @RequestMapping("selsuper")
    public List<SuperBean> selsuper();
}
