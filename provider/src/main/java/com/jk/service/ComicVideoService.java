package com.jk.service;

import com.jk.entity.ComicVideo;
import com.jk.entity.EpisodeNumber;

import java.util.List;

public interface ComicVideoService {
    List<ComicVideo> selectComicVideo();

    List<ComicVideo> selectComic(Integer comicNumber);

    EpisodeNumber findgoodbyid(int episodeId);
}
