package com.jk.dao;

import com.jk.entity.EpisodeNumberBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EpisodeNumberBeanMapper {
    int deleteByPrimaryKey(Integer episodeId);

    int insert(EpisodeNumberBean record);

    int insertSelective(EpisodeNumberBean record);

    EpisodeNumberBean selectByPrimaryKey(Integer episodeId);

    int updateByPrimaryKeySelective(EpisodeNumberBean record);

    int updateByPrimaryKey(EpisodeNumberBean record);

    List<EpisodeNumberBean> selEpisodeNumber();
}