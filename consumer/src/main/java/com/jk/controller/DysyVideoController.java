package com.jk.controller;

import com.jk.config.RedisConstant;
import com.jk.entity.DysyVideo;
import com.jk.service.DysyVideoService;
import com.jk.util.RedisUtil;
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
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("list")
    @ResponseBody
    public List<DysyVideo>list(){
        List<DysyVideo>list= (List<DysyVideo>) redisUtil.get(RedisConstant.LIST_KEY);
        if(list==null || list.isEmpty()){
           list=dysyVideoService.selectVideo();
            redisUtil.set(RedisConstant.LIST_KEY,list);
            redisUtil.expire(RedisConstant.LIST_KEY,60);
        }
        return list;
    }
}
