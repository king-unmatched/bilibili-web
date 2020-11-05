package com.jk.entity;

public class NewVideo {
    private Integer newHotId;

    private String newHotName;

    private String newHotDuration;

    private String newHeat;

    private String newHotImg;

    private String newHotUrl;

    public Integer getNewHotId() {
        return newHotId;
    }

    public void setNewHotId(Integer newHotId) {
        this.newHotId = newHotId;
    }

    public String getNewHotName() {
        return newHotName;
    }

    public void setNewHotName(String newHotName) {
        this.newHotName = newHotName == null ? null : newHotName.trim();
    }

    public String getNewHotDuration() {
        return newHotDuration;
    }

    public void setNewHotDuration(String newHotDuration) {
        this.newHotDuration = newHotDuration == null ? null : newHotDuration.trim();
    }

    public String getNewHeat() {
        return newHeat;
    }

    public void setNewHeat(String newHeat) {
        this.newHeat = newHeat == null ? null : newHeat.trim();
    }

    public String getNewHotImg() {
        return newHotImg;
    }

    public void setNewHotImg(String newHotImg) {
        this.newHotImg = newHotImg == null ? null : newHotImg.trim();
    }

    public String getNewHotUrl() {
        return newHotUrl;
    }

    public void setNewHotUrl(String newHotUrl) {
        this.newHotUrl = newHotUrl == null ? null : newHotUrl.trim();
    }
}