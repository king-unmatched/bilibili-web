package com.jk.dao;

import com.jk.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    void insert(User ccc);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(String usercode);

    void update(@Param("createtime")String createtime,@Param("id") Integer id);

    List<User> select();

    void updates(Integer id);

    void xiu(@Param("id")Integer id,@Param("password") String password);
}