package com.jk.dao;

import com.jk.entity.DssyTeleplay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DssyTeleplayMapper {
    int deleteByPrimaryKey(Integer teleplayId);

    int insert(DssyTeleplay record);

    int insertSelective(DssyTeleplay record);

    DssyTeleplay selectByPrimaryKey(Integer teleplayId);

    int updateByPrimaryKeySelective(DssyTeleplay record);

    int updateByPrimaryKey(DssyTeleplay record);

    List<DssyTeleplay> list();
}