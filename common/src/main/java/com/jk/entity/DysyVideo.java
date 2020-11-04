package com.jk.entity;

public class DysyVideo {
    private Integer videoId;

    private String videoImg;

    private String videoDuration;

    private String videoUrl;

    private String videoName;

    private String videoRank;

    private Integer videoTypeid;

    private Integer videoHeat;

    private Integer videoStatus;

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

    public Integer getVideoTypeid() {
        return videoTypeid;
    }

    public void setVideoTypeid(Integer videoTypeid) {
        this.videoTypeid = videoTypeid;
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