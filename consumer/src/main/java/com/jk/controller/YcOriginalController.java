package com.jk.controller;

import com.jk.config.RedisConstant;
import com.jk.entity.JxChoiceness;
import com.jk.entity.YcOriginal;
import com.jk.service.YcOriginalService;
import com.jk.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("listYCO")
public class YcOriginalController {
    @Autowired
    private YcOriginalService  ycOriginalService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("selectlistYCO")
    @ResponseBody
    public List<YcOriginal>selectlistYCO(){
        List<YcOriginal> selectlistYCO = (List<YcOriginal>) redisUtil.get(RedisConstant.SELECT_LIST_YCO_KEY);
        if (selectlistYCO == null || selectlistYCO.isEmpty()) {
            selectlistYCO = ycOriginalService.listYC();
            redisUtil.set(RedisConstant.SELECT_LIST_YCO_KEY, selectlistYCO);
            redisUtil.expire(RedisConstant.SELECT_LIST_YCO_KEY, 60);
        }
        return selectlistYCO;
    }
}
