package com.jk.dao;

import com.jk.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    void creatOrder(@Param("orderNum") String out_trade_no,@Param("orderName") String trade_no, @Param("orderPrice")String total_amount);

    List<Order> findAll(@Param("orderNum") String out_trade_no);
}
