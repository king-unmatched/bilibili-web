package com.jk.entity;

import lombok.Data;

@Data
public class DysyVideo {
    private Integer videoId;

    private String videoImg;

    private String videoDuration;

    private String videoUrl;

    private String videoName;

    private String videoRank;

    private Float videoTypeid;

    private Integer videoHeat;

    private Integer videoStatus;

    private String videoTitle;

    private String videoXiaoimg;

    private String xvip;

    public String getXvip() {
        return xvip;
    }

    public void setXvip(String xvip) {
        this.xvip = xvip;
    }

    public String getVideoXiaoimg() {
        return videoXiaoimg;
    }

    public void setVideoXiaoimg(String videoXiaoimg) {
        this.videoXiaoimg = videoXiaoimg;
    }

    public Float getVideoTypeid() {
        return videoTypeid;
    }

    public void setVideoTypeid(Float videoTypeid) {
        this.videoTypeid = videoTypeid;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg == null ? null : videoImg.trim();
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration == null ? null : videoDuration.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public String getVideoRank() {
        return videoRank;
    }

    public void setVideoRank(String videoRank) {
        this.videoRank = videoRank == null ? null : videoRank.trim();
    }


    public Integer getVideoHeat() {
        return videoHeat;
    }

    public void setVideoHeat(Integer videoHeat) {
        this.videoHeat = videoHeat;
    }

    public Integer getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(Integer videoStatus) {
        this.videoStatus = videoStatus;
    }
}