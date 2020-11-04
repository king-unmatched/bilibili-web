package com.jk.entity;

public class DssyTeleplay {
    private Integer teleplayId;

    private String teleplayImg;

    private String teleplayName;

    private String teleplayUrl;

    private String teleplayHeat;

    private String teleplayExplain;

    private Integer teleplayStatus;

    private Integer teleplayTypeid;

    public Integer getTeleplayId() {
        return teleplayId;
    }

    public void setTeleplayId(Integer teleplayId) {
        this.teleplayId = teleplayId;
    }

    public String getTeleplayImg() {
        return teleplayImg;
    }

    public void setTeleplayImg(String teleplayImg) {
        this.teleplayImg = teleplayImg == null ? null : teleplayImg.trim();
    }

    public String getTeleplayName() {
        return teleplayName;
    }

    public void setTeleplayName(String teleplayName) {
        this.teleplayName = teleplayName == null ? null : teleplayName.trim();
    }

    public String getTeleplayUrl() {
        return teleplayUrl;
    }

    public void setTeleplayUrl(String teleplayUrl) {
        this.teleplayUrl = teleplayUrl == null ? null : teleplayUrl.trim();
    }

    public String getTeleplayHeat() {
        return teleplayHeat;
    }

    public void setTeleplayHeat(String teleplayHeat) {
        this.teleplayHeat = teleplayHeat == null ? null : teleplayHeat.trim();
    }

    public String getTeleplayExplain() {
        return teleplayExplain;
    }

    public void setTeleplayExplain(String teleplayExplain) {
        this.teleplayExplain = teleplayExplain == null ? null : teleplayExplain.trim();
    }

    public Integer getTeleplayStatus() {
        return teleplayStatus;
    }

    public void setTeleplayStatus(Integer teleplayStatus) {
        this.teleplayStatus = teleplayStatus;
    }

    public Integer getTeleplayTypeid() {
        return teleplayTypeid;
    }

    public void setTeleplayTypeid(Integer teleplayTypeid) {
        this.teleplayTypeid = teleplayTypeid;
    }
}