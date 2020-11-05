package com.jk.service;

import com.jk.entity.YcOriginal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(value = "provider")
public interface YcOriginalService {

    @RequestMapping("listYC")
    public List<YcOriginal> listYC();
}
