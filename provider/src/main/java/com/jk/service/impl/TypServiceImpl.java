package com.jk.service.impl;

import com.jk.dao.TypeMapper;
import com.jk.entity.TypeBean;
import com.jk.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<TypeBean> typeLlist() {
        int pid = 0;
        List<TypeBean> list = getTypeBeans(pid);
        return list;
    }

    private List<TypeBean> getTypeBeans(int pid) {
        List<TypeBean> list = typeMapper.typeLlist(pid);
        for (TypeBean type:
            list) {
            List<TypeBean> list1 = getTypeBeans(type.getSyId());
            type.setTypeList(list1);
        }
        return list;
    }
}
