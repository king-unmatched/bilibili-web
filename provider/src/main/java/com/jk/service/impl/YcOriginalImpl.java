package com.jk.service.impl;

import com.jk.dao.YcOriginalMapper;
import com.jk.entity.YcOriginal;
import com.jk.service.YcOriginalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YcOriginalImpl implements YcOriginalService {
    @Autowired
    private YcOriginalMapper ycOriginalMapper;

    @Override
    public List<YcOriginal> listYC() {
        return ycOriginalMapper.listYC();
    }
}
