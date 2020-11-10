package com.jk.entity;

public class JxChoiceness {
    private Integer choicenessId;

    private String choicenessInfo;

    private String choicenessName;

    private String choicenessSc;

    private String choicenessUrl;

    private String choicenessImg;

    private String choicenessZhongxin;

    private String choicenessTouxiang;

    public String getChoicenessTouxiang() {
        return choicenessTouxiang;
    }

    public void setChoicenessTouxiang(String choicenessTouxiang) {
        this.choicenessTouxiang = choicenessTouxiang;
    }

    public String getChoicenessZhongxin() {
        return choicenessZhongxin;
    }

    public void setChoicenessZhongxin(String choicenessZhongxin) {
        this.choicenessZhongxin = choicenessZhongxin;
    }

    public Integer getChoicenessId() {
        return choicenessId;
    }

    public void setChoicenessId(Integer choicenessId) {
        this.choicenessId = choicenessId;
    }

    public String getChoicenessInfo() {
        return choicenessInfo;
    }

    public void setChoicenessInfo(String choicenessInfo) {
        this.choicenessInfo = choicenessInfo == null ? null : choicenessInfo.trim();
    }

    public String getChoicenessName() {
        return choicenessName;
    }

    public void setChoicenessName(String choicenessName) {
        this.choicenessName = choicenessName == null ? null : choicenessName.trim();
    }

    public String getChoicenessSc() {
        return choicenessSc;
    }

    public void setChoicenessSc(String choicenessSc) {
        this.choicenessSc = choicenessSc == null ? null : choicenessSc.trim();
    }

    public String getChoicenessUrl() {
        return choicenessUrl;
    }

    public void setChoicenessUrl(String choicenessUrl) {
        this.choicenessUrl = choicenessUrl == null ? null : choicenessUrl.trim();
    }

    public String getChoicenessImg() {
        return choicenessImg;
    }

    public void setChoicenessImg(String choicenessImg) {
        this.choicenessImg = choicenessImg == null ? null : choicenessImg.trim();
    }
}