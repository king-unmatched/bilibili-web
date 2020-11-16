package com.jk.service;

import com.jk.entity.ToneSelfBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient(value = "provider")
public interface ToneSeflService {

    @RequestMapping("insertToneSefl")
    public void insertToneSefl(@RequestBody ToneSelfBean toneSelfBean);
}
