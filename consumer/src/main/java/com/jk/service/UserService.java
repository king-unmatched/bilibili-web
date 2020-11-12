package com.jk.service;

import com.jk.entity.Order;
import com.jk.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "provider")
public interface UserService {

    @RequestMapping("login")
    public User login(@RequestParam String usercode);

    @RequestMapping("loginto")
    public void loginto(@RequestBody User ccc);

    @RequestMapping("update")
    public void update(@RequestParam String createtime, @RequestParam Integer id);

    @RequestMapping("select")
    public List<User> select();

    @RequestMapping("updates")
    public void updates(@RequestParam Integer id);

    @RequestMapping("xiu")
    public void xiu(@RequestParam Integer id,@RequestParam String password);

    @RequestMapping("create")
    public void creatOrder(@RequestParam String out_trade_no,@RequestParam String trade_no,@RequestParam String total_amount);

    @RequestMapping("findAll")
    public List<Order> findAll(@RequestParam String out_trade_no);
}
