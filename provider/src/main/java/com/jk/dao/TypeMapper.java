package com.jk.dao;


import com.jk.entity.TypeBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {

    List<TypeBean> typeLlist(int pid);
}
