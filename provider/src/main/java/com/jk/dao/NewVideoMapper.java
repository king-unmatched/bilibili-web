package com.jk.dao;

import com.jk.entity.NewVideo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewVideoMapper {
    int deleteByPrimaryKey(Integer newHotId);

    int insert(NewVideo record);

    int insertSelective(NewVideo record);

    NewVideo selectByPrimaryKey(Integer newHotId);

    int updateByPrimaryKeySelective(NewVideo record);

    int updateByPrimaryKey(NewVideo record);

    List<NewVideo> listNewVideo();
}