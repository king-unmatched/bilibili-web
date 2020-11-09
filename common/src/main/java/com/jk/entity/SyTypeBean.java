package com.jk.entity;

import lombok.Data;

import java.util.List;

@Data
public class SyTypeBean {
    private Integer syId;

    private String syName;

    private Integer syPid;

    private List<SyTypeBean> typeList;

}