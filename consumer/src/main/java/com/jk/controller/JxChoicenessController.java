package com.jk.controller;

import com.jk.entity.JxChoiceness;
import com.jk.service.JxChoicenessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("selectJx")
public class JxChoicenessController {
    @Autowired
    private JxChoicenessService  jxChoicenessService;

    @RequestMapping("listJxChoiceness")
    @ResponseBody
    public List<JxChoiceness>listJxChoiceness(){
        return jxChoicenessService.listJxC();
    }
}
