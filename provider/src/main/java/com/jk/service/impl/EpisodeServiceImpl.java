package com.jk.service.impl;

import com.jk.dao.EpisodeNumberBeanMapper;
import com.jk.entity.EpisodeNumberBean;
import com.jk.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService {
    @Autowired
    private EpisodeNumberBeanMapper episodeNumberBeanMapper;

    @Override
    public List<EpisodeNumberBean> selEpisodeNumber() {
        return episodeNumberBeanMapper.selEpisodeNumber();
    }
}
