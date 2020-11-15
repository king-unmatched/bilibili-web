package com.jk.controller;

import com.jk.entity.ComicVideo;
import com.jk.entity.DysyVideo;
import com.jk.entity.EpisodeNumber;
import com.jk.service.ComicVideoService;
import com.jk.service.DysyVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComicVideoController {
    @Autowired
    private ComicVideoService comicVideoService;

    @RequestMapping("selectComicVideo")
    public List<ComicVideo> selectComicVideo(){
        return comicVideoService.selectComicVideo();
    }

    @RequestMapping("selectComic")
    public List<ComicVideo> selectComic(@RequestParam Integer comicNumber){
        return comicVideoService.selectComic(comicNumber);
    }

    @RequestMapping("findgoodbyid")
    public EpisodeNumber findgoodbyid(@RequestParam int episodeId){
        return comicVideoService.findgoodbyid(episodeId);
    }
}
