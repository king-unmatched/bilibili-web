package com.jk.controller;

import com.jk.entity.Order;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService ser;

    @RequestMapping("create")
    public void creatOrder(@RequestParam String out_trade_no, @RequestParam String trade_no, @RequestParam String total_amount){
        ser.creatOrder(out_trade_no,trade_no,total_amount);
    }
    @RequestMapping("findAll")
    public List<Order> findAll(@RequestParam String out_trade_no){
        return ser.findAll(out_trade_no);
    }
}
