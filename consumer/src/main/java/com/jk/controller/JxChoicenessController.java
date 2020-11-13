package com.jk.controller;

import com.jk.config.RedisConstant;
import com.jk.entity.ComicVideo;
import com.jk.entity.JxChoiceness;
import com.jk.service.JxChoicenessService;
import com.jk.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("selectJx")
public class JxChoicenessController {
    @Autowired
    private JxChoicenessService jxChoicenessService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("listJxChoiceness")
    @ResponseBody
    public List<JxChoiceness> listJxChoiceness() {
        List<JxChoiceness> listJxChoiceness = (List<JxChoiceness>) redisUtil.get(RedisConstant.LIST_JXCHOICENESS_KEY);
        if (listJxChoiceness == null || listJxChoiceness.isEmpty()) {
            listJxChoiceness = jxChoicenessService.listJxC();
            redisUtil.set(RedisConstant.LIST_JXCHOICENESS_KEY, listJxChoiceness);
            redisUtil.expire(RedisConstant.LIST_JXCHOICENESS_KEY, 60);
        }
        return listJxChoiceness;
    }
}