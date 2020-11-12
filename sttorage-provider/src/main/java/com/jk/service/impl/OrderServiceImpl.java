package com.jk.service.impl;

import com.jk.dao.OrderMapper;
import com.jk.entity.Order;
import com.jk.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @GlobalTransactional
    @Override
    public void creatOrder(String out_trade_no, String trade_no, String total_amount) {
        Date date = new Date();
        orderMapper.creatOrder(out_trade_no,trade_no,total_amount,date);
    }

    @Override
    public List<Order> findAll(String out_trade_no) {
        return orderMapper.findAll(out_trade_no);
    }
}
