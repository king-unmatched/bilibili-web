package com.jk.controller;

import com.jk.entity.ComicVideo;
import com.jk.entity.EpisodeNumber;
import com.jk.service.ComicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("listAll")
public class ComicVideoController {
    @Autowired
    private ComicVideoService  comicVideoService;

    @RequestMapping("listComic")
    @ResponseBody
    public List<ComicVideo>listComic(){
        return comicVideoService.selectComicVideo();
    }

    @RequestMapping("selectComic")
    @ResponseBody
    public List<ComicVideo> selectComic(Integer comicNumber){
        List<ComicVideo> comicList= comicVideoService.selectComic(comicNumber);
        return comicList;
    }

}
