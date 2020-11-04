package com.jk.entity;

import lombok.Data;

import java.util.Date;
@Data
public class SlideshowBean {
    private Integer slideshowId;

    private String slideshowName;

    private String slideshowUrl;

    private Date elapsedTime;

    private Date stopTime;

    private String slideshowImg;

    private String pagedisplay;


}