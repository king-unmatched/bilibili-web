package com.jk.service;

import com.jk.entity.DssyTeleplay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(value = "provider")
public interface DssyTeleplayService {

    @RequestMapping("list")
    public List<DssyTeleplay> list();
}
