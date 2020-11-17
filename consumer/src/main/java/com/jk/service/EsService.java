package com.jk.service;

import com.jk.entity.BigEs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@FeignClient(value = "es")
public interface EsService {

    @RequestMapping("listfuzzes")
    ArrayList<BigEs> listSearchByPinyin(@RequestParam String value);

    @RequestMapping("queryzdbq")
    List<String> listSuggestCompletion(@RequestParam String value);
}
