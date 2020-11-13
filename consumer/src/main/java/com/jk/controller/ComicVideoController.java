package com.jk.controller;

import com.jk.config.RedisConstant;
import com.jk.entity.ComicVideo;
import com.jk.service.ComicVideoService;
import com.jk.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("listAll")
public class ComicVideoController {
    @Autowired
    private ComicVideoService  comicVideoService;
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("listComic")
    @ResponseBody
    public List<ComicVideo>listComic(){
        List<ComicVideo>listComic= (List<ComicVideo>) redisUtil.get(RedisConstant.LIST_COMIC_KEY);
        if(listComic==null || listComic.isEmpty()){
            listComic=comicVideoService.selectComicVideo();
            redisUtil.set(RedisConstant.LIST_COMIC_KEY,listComic);
            redisUtil.expire(RedisConstant.LIST_COMIC_KEY,60);
        }
        return listComic;
    }

}
