package com.jk.service.impl;

import com.jk.dao.DssyTeleplayMapper;
import com.jk.entity.DssyTeleplay;
import com.jk.service.DssyTeleplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DssyTeleplayServiceImpl implements DssyTeleplayService {
    @Autowired
    private DssyTeleplayMapper  dssyTeleplayMapper;

    @Override
    public List<DssyTeleplay> list() {
        return dssyTeleplayMapper.list();
    }
}

