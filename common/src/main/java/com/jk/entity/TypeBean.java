package com.jk.entity;

import lombok.Data;

import java.util.List;

@Data
public class TypeBean {
    private Integer syId;

    private String syName;

    private Integer syPid;

    private String syTypeName;


    private List<TypeBean> typeList;


}