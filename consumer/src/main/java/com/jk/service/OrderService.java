package com.jk.service;

import com.jk.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "sttorage-provider")
public interface OrderService {

    @RequestMapping("create")
    public void creatOrder(@RequestParam String out_trade_no, @RequestParam String trade_no, @RequestParam String total_amount);

    @RequestMapping("findAll")
    public List<Order> findAll(@RequestParam String out_trade_no);
}
