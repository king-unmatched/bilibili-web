package com.jk.dao;

import com.jk.entity.SlideshowBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SlideshowBeanMapper {
    int deleteByPrimaryKey(Integer slideshowId);

    int insert(SlideshowBean record);

    int insertSelective(SlideshowBean record);

    SlideshowBean selectByPrimaryKey(Integer slideshowId);

    int updateByPrimaryKeySelective(SlideshowBean record);

    int updateByPrimaryKey(SlideshowBean record);

    List<SlideshowBean> selselideshow();
}