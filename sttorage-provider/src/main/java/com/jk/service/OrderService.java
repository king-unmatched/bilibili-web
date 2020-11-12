package com.jk.service;

import com.jk.entity.Order;

import java.util.List;

public interface OrderService {
    void creatOrder(String out_trade_no, String trade_no, String total_amount);

    List<Order> findAll(String out_trade_no);
}
