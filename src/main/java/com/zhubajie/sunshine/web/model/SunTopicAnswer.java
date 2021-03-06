package com.zhubajie.sunshine.web.model;

import java.util.Date;

public class SunTopicAnswer {
    private Integer topicAnswerId;

    private Integer topicId;

    private Integer userId;

    private Integer topicAnswerTemp;

    private String topicAnswerContent;

    private Date topicAnswerTime;

    private Boolean isAnonymity;

    public Integer getTopicAnswerId() {
        return topicAnswerId;
    }

    public void setTopicAnswerId(Integer topicAnswerId) {
        this.topicAnswerId = topicAnswerId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicAnswerTemp() {
        return topicAnswerTemp;
    }

    public void setTopicAnswerTemp(Integer topicAnswerTemp) {
        this.topicAnswerTemp = topicAnswerTemp;
    }

    public String getTopicAnswerContent() {
        return topicAnswerContent;
    }

    public void setTopicAnswerContent(String topicAnswerContent) {
        this.topicAnswerContent = topicAnswerContent == null ? null : topicAnswerContent.trim();
    }

    public Date getTopicAnswerTime() {
        return topicAnswerTime;
    }

    public void setTopicAnswerTime(Date topicAnswerTime) {
        this.topicAnswerTime = topicAnswerTime;
    }

    public Boolean getIsAnonymity() {
        return isAnonymity;
    }

    public void setIsAnonymity(Boolean isAnonymity) {
        this.isAnonymity = isAnonymity;
    }

    @Override
    public String toString() {
        return "SunTopicAnswer{" +
                "topicAnswerId=" + topicAnswerId +
                ", topicId=" + topicId +
                ", userId=" + userId +
                ", topicAnswerTemp=" + topicAnswerTemp +
                ", topicAnswerContent='" + topicAnswerContent + '\'' +
                ", topicAnswerTime=" + topicAnswerTime +
                ", isAnonymity=" + isAnonymity +
                '}';
    }
}