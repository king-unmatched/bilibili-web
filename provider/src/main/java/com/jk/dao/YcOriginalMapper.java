package com.jk.dao;

import com.jk.entity.YcOriginal;
import com.jk.service.YcOriginalService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface YcOriginalMapper {
    int deleteByPrimaryKey(Integer originalId);

    int insert(YcOriginal record);

    int insertSelective(YcOriginal record);

    YcOriginal selectByPrimaryKey(Integer originalId);

    int updateByPrimaryKeySelective(YcOriginal record);

    int updateByPrimaryKey(YcOriginal record);

    List<YcOriginal> listYC();
}