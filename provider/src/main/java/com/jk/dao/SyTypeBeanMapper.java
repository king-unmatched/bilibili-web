package com.jk.dao;

import com.jk.entity.SyTypeBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SyTypeBeanMapper {
    int deleteByPrimaryKey(Integer syId);

    int insert(SyTypeBean record);

    int insertSelective(SyTypeBean record);

    SyTypeBean selectByPrimaryKey(Integer syId);

    int updateByPrimaryKeySelective(SyTypeBean record);

    int updateByPrimaryKey(SyTypeBean record);

    List<SyTypeBean> seltype();
}