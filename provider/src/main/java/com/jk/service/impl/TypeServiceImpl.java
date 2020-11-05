package com.jk.service.impl;

import com.jk.dao.SyTypeBeanMapper;
import com.jk.entity.SyTypeBean;
import com.jk.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private SyTypeBeanMapper syTypeBeanMapper;

    @Override
    public List<SyTypeBean> seltype() {
        return syTypeBeanMapper.seltype();
    }
}
