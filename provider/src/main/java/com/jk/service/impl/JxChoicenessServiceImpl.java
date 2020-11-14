package com.jk.service.impl;

import com.jk.dao.JxChoicenessMapper;
import com.jk.entity.JxChoiceness;
import com.jk.service.JxChoicenessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JxChoicenessServiceImpl implements JxChoicenessService {
    @Autowired
    private JxChoicenessMapper  jxChoicenessMapper;

    @Override
    public List<JxChoiceness> listJxC() {
        return jxChoicenessMapper.listJxC();
    }
}
