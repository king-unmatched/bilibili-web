package com.jk.dao;

import com.jk.entity.DysyVideo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DysyVideoMapper {
    int deleteByPrimaryKey(Integer videoId);

    int insert(DysyVideo record);

    int insertSelective(DysyVideo record);

    DysyVideo selectByPrimaryKey(Integer videoId);

    int updateByPrimaryKeySelective(DysyVideo record);

    int updateByPrimaryKey(DysyVideo record);

    List<DysyVideo> selectVideo();
}