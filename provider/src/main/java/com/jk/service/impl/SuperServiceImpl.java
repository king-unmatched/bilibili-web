package com.jk.service.impl;

import com.jk.dao.SuperBeanMapper;
import com.jk.entity.SuperBean;
import com.jk.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperServiceImpl implements SuperService {
    @Autowired
    private SuperBeanMapper superBeanMapper;

    @Override
    public List<SuperBean> selsuper() {
        return superBeanMapper.selsuper();
    }
}
