package com.jk.controller;

import com.jk.entity.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@EnableScheduling
@Component
@Controller
@RequestMapping("task")
public class ScheduledTask {
    @Autowired
    private UserService UserService;

    @Scheduled(cron="0 0 10,14,16 * * ?")
    public void testOne() {
        List<User> select = UserService.select();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        for (User user : select) {
            if (sim.format(user.getCreatetime()).equals(sim.format(new Date()))){
                UserService.updates(user.getId());
                System.out.println(user.getUsername()+"会员到期");
            }
        }

    }
}
