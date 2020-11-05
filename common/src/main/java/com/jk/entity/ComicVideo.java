package com.jk.entity;

<<<<<<< HEAD
import lombok.Data;
=======
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
>>>>>>> 6db4745694ca679a28ccd2e8e761ac23327681ce

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

<<<<<<< HEAD
    private Integer comicNumber;

    private Date toUpdate;

    private Integer jiNumber;

    private String comicXiaoimg;

    private String ztvip;

    public String getZtvip() {
        return ztvip;
    }

    public void setZtvip(String ztvip) {
        this.ztvip = ztvip;
    }

    public Integer getJiNumber() {
        return jiNumber;
    }

    public void setJiNumber(Integer jiNumber) {
        this.jiNumber = jiNumber;
    }

    public Integer getComicNumber() {
        return comicNumber;
    }

    public void setComicNumber(Integer comicNumber) {
        this.comicNumber = comicNumber;
    }

    public String getComicXiaoimg() {
        return comicXiaoimg;
    }

    public void setComicXiaoimg(String comicXiaoimg) {
        this.comicXiaoimg = comicXiaoimg;
    }
=======
    private Integer setNumber;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toUpdate;

    private Integer number;
>>>>>>> 6db4745694ca679a28ccd2e8e761ac23327681ce

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getPlayback() {
        return playback;
    }

    public void setPlayback(Integer playback) {
        this.playback = playback;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }


    public Date getToUpdate() {
        return toUpdate;
    }

    public void setToUpdate(Date toUpdate) {
        this.toUpdate = toUpdate;
    }

}