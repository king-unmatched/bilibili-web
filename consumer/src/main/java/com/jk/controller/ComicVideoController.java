package com.jk.controller;

import com.jk.entity.ComicVideo;
import com.jk.service.ComicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
