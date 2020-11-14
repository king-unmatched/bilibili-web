package com.jk.service.impl;

import com.jk.dao.NewVideoMapper;
import com.jk.entity.NewVideo;
import com.jk.service.NewVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewVideoServiceImpl implements NewVideoService {
    @Autowired
    private NewVideoMapper  newVideoMapper;

    @Override
    public List<NewVideo> listNewVideo() {
        return newVideoMapper.listNewVideo();
    }
}
