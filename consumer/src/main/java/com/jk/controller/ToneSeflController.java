package com.jk.controller;

import com.jk.entity.ToneSelfBean;
import com.jk.service.ToneSeflService;
import com.jk.utils.AliyunOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("tone")
public class ToneSeflController {
    @Autowired
    private ToneSeflService toneSeflService;


    @RequestMapping(value = "/headImg", method = RequestMethod.POST)
    public Object headImg(MultipartFile file)  {

        try {
            MultipartFile multipartFile = file;
            String fileName = file.getOriginalFilename();
            String url = AliyunOSSUtil.uploadFile(fileName, multipartFile);
            System.out.println(url);
            return url;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "false";
    }
    @RequestMapping("inserToneSelf")
    public void inserToneSelf(ToneSelfBean toneSelfBean){
        toneSeflService.insertToneSefl(toneSelfBean);
    }

}
