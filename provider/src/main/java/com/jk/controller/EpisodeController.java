package com.jk.controller;

import com.jk.entity.EpisodeNumberBean;
import com.jk.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EpisodeController {

    @Autowired
    private EpisodeService episodeService;

   @RequestMapping("selEpisodeNumber")
    public List<EpisodeNumberBean> selEpisodeNumber(){
        return episodeService.selEpisodeNumber();
    }
}
