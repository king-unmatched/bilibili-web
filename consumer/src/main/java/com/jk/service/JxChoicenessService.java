package com.jk.service;

import com.jk.entity.JxChoiceness;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(value = "provider")
public interface JxChoicenessService {

    @RequestMapping("listJxC")
    public List<JxChoiceness> listJxC();
}
