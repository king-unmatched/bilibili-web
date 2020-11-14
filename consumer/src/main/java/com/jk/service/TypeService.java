package com.jk.service;

import com.jk.entity.TypeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.net.idn.Punycode;

import java.util.List;

@FeignClient(value = "provider")
public interface TypeService {

    @RequestMapping("/typeLlist")
    public List<TypeBean> typeLlist();
}
