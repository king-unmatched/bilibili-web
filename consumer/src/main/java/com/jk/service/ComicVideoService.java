package com.jk.service;

import com.jk.entity.ComicVideo;
import com.jk.entity.EpisodeNumber;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(value = "provider")
public interface ComicVideoService {

    @RequestMapping("selectComicVideo")
    public List<ComicVideo> selectComicVideo();

    @RequestMapping("selectComic")
    public List<ComicVideo> selectComic(@RequestParam Integer comicNumber);

    @RequestMapping("findgoodbyid")
    public EpisodeNumber findgoodbyid(@RequestParam int episodeId);
}
