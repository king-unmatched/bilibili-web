package com.jk.controller;

import com.jk.entity.BigEs;
import com.jk.entity.ComicVideo;
import com.jk.service.ComicVideoService;
import com.jk.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EsController {
    @Autowired
    private EsService esService;

    @RequestMapping("fuzzes")
    public ArrayList<BigEs> listSearchByPinyin(@RequestParam  String value){
        return esService.listSearchByPinyin(value);
    }

    @RequestMapping("zdbq")
    public List<String> listSuggestCompletion(@RequestParam String value){
        return esService.listSuggestCompletion(value);
    }
}
