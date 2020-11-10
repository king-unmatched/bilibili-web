package com.jk.dao;

import com.jk.entity.SuperBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> 287a1f2ddb4f977a03e68fa6a79cb1be2709fca1
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