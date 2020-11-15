package com.jk.service.impl;

import com.jk.dao.ComicVideoMapper;
import com.jk.entity.ComicVideo;
import com.jk.entity.EpisodeNumber;
import com.jk.service.ComicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicVideoServiceImpl implements ComicVideoService {
    @Autowired
    private ComicVideoMapper comicVideoMapper;
    @Override
    public List<ComicVideo> selectComicVideo() {
        return comicVideoMapper.selectComicVideo();
    }

    @Override
    public List<ComicVideo> selectComic(Integer comicNumber) {
        return comicVideoMapper.selectComic(comicNumber);
    }

    @Override
    public EpisodeNumber findgoodbyid(int episodeId) {
        return comicVideoMapper.findgoodbyid(episodeId);
    }
}
