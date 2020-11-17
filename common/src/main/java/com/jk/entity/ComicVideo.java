package com.jk.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ComicVideo {
    private Integer id;

    private String name;

    private String info;

    private Integer playback;

    private String img;

    private Integer type;

    private String url;

    private Integer comicNumber;

    private Date toUpdate;

    private Integer jiNumber;

    private String comicXiaoimg;

    private String ztvip;

    private String comicTitle;

}