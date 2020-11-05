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

    private Integer setNumber;

    private Date toUpdate;

    private Integer 
number;

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

    public Integer getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(Integer setNumber) {
        this.setNumber = setNumber;
    }

    public Date getToUpdate() {
        return toUpdate;
    }

    public void setToUpdate(Date toUpdate) {
        this.toUpdate = toUpdate;
    }

    public Integer getnumber() {
        return number;
    }

    public void setnumber(Integer number) {
        this.number = number;
    }
}