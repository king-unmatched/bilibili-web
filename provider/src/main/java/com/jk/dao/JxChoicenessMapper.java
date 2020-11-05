package com.jk.dao;

import com.jk.entity.JxChoiceness;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface JxChoicenessMapper {
    int deleteByPrimaryKey(Integer choicenessId);

    int insert(JxChoiceness record);

    int insertSelective(JxChoiceness record);

    JxChoiceness selectByPrimaryKey(Integer choicenessId);

    int updateByPrimaryKeySelective(JxChoiceness record);

    int updateByPrimaryKey(JxChoiceness record);

    List<JxChoiceness> listJxC();
}