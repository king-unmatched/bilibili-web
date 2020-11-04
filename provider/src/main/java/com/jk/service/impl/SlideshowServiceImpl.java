package com.jk.service.impl;

import com.jk.dao.SlideshowBeanMapper;
import com.jk.entity.SlideshowBean;
import com.jk.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlideshowServiceImpl implements SlideshowService {
    @Autowired
    private SlideshowBeanMapper slideshowBeanMapper;

    @Override
    public List<SlideshowBean> selselideshow() {
        return slideshowBeanMapper.selselideshow();
    }
}
