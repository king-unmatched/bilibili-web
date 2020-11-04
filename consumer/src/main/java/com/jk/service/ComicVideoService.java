package com.jk.service;

import com.jk.entity.ComicVideo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(value = "provider")
public interface ComicVideoService {

    @RequestMapping("selectComicVideo")
    public List<ComicVideo> selectComicVideo();
}
