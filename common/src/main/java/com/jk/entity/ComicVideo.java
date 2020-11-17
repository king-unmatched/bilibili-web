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

    //集表
    private Integer episodeId;
    private Integer episodeNum;
    private String episodeUrl;
    private Integer videoId;
    private Integer episodeStatus;
    private String comicTitle;

    public String getComicTitle() {
        return comicTitle;
    }

    public void setComicTitle(String comicTitle) {
        this.comicTitle = comicTitle;
    }

    public String getZtvip() {
        return ztvip;
    }


}