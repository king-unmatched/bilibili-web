package com.jk.service;

import com.jk.entity.DysyVideo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@FeignClient(value = "provider")
public interface DysyVideoService {

    @RequestMapping("selectVideo")
    public List<DysyVideo> selectVideo();
}
