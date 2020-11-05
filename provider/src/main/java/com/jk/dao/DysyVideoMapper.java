package com.jk.dao;

import com.jk.entity.DysyVideo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DysyVideoMapper {

    List<DysyVideo> selectVideo();
}