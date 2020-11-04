package com.jk.dao;

import com.jk.entity.ComicVideo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ComicVideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ComicVideo record);

    int insertSelective(ComicVideo record);

    ComicVideo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ComicVideo record);

    int updateByPrimaryKey(ComicVideo record);

    List<ComicVideo> selectComicVideo();
}