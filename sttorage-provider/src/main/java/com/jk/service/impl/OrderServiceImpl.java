package com.jk.service.impl;

import com.jk.dao.OrderMapper;
import com.jk.entity.Order;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper mapper;

    @Override
    public void creatOrder(String out_trade_no, String trade_no, String total_amount) {
        mapper.creatOrder(out_trade_no,trade_no,total_amount);
    }

    @Override
    public List<Order> findAll(String out_trade_no) {
        return mapper.findAll(out_trade_no);
    }
}
