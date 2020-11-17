package com.jk.service;

import com.jk.entity.ToneSelfBean;

import java.util.List;

public interface ToneSelfService {
    void insertToneSefl(ToneSelfBean toneSelfBean);

    List<ToneSelfBean> selToneSelfBean();
}
