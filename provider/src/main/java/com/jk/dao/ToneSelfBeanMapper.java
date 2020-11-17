package com.jk.dao;

import com.jk.entity.ToneSelfBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToneSelfBeanMapper {
    int deleteByPrimaryKey(Integer oneselfId);

    int insert(ToneSelfBean record);

    int insertSelective(ToneSelfBean record);

    ToneSelfBean selectByPrimaryKey(Integer oneselfId);

    int updateByPrimaryKeySelective(ToneSelfBean record);

    int updateByPrimaryKey(ToneSelfBean record);

    void insertToneSefl(ToneSelfBean toneSelfBean);

    List<ToneSelfBean> selToneSelfBean();
}