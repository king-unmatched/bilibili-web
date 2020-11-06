package com.jk.dao;

import com.jk.entity.SuperBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> 1bba3192b07a643ea723ea1c0eb01cc18faaba62
@Mapper
public interface SuperBeanMapper {
    int deleteByPrimaryKey(Integer zbId);

    int insert(SuperBean record);

    int insertSelective(SuperBean record);

    SuperBean selectByPrimaryKey(Integer zbId);

    int updateByPrimaryKeySelective(SuperBean record);

    int updateByPrimaryKey(SuperBean record);

    List<SuperBean> selsuper();
}