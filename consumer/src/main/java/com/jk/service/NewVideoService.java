package com.jk.service;

import com.jk.entity.NewVideo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(value = "provider")
public interface NewVideoService {

    @RequestMapping("listNewVideo")
    public List<NewVideo> listNewVideo();
}
