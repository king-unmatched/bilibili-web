package com.jk.controller;

import com.jk.config.RedisConstant;
import com.jk.entity.JxChoiceness;
import com.jk.entity.NewVideo;
import com.jk.service.NewVideoService;
import com.jk.util.RedisUtil;
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
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("selectNewVideo")
    @ResponseBody
    public List<NewVideo>selectNewVideo(){
        List<NewVideo> selectNewVideo = (List<NewVideo>) redisUtil.get(RedisConstant.SELECT_NEWVIDEO_KEY);
        if (selectNewVideo == null || selectNewVideo.isEmpty()) {
            selectNewVideo = newVideoService.listNewVideo();
            redisUtil.set(RedisConstant.SELECT_NEWVIDEO_KEY, selectNewVideo);
            redisUtil.expire(RedisConstant.SELECT_NEWVIDEO_KEY, 60);
        }
        return selectNewVideo;
    }
}
