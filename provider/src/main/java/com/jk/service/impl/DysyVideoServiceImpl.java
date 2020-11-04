package com.jk.service.impl;

import com.jk.dao.DysyVideoMapper;
import com.jk.entity.DysyVideo;
import com.jk.service.DysyVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DysyVideoServiceImpl implements DysyVideoService {
    @Autowired
    private DysyVideoMapper  dysyVideoMapper;
    @Override
    public List<DysyVideo> selectVideo() {
        return dysyVideoMapper.selectVideo();
    }
}
