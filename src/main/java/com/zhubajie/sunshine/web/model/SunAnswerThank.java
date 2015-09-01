package com.zhubajie.sunshine.web.model;

import java.util.Date;

public class SunAnswerThank {
    private Integer answerThankId;

    private Integer userId;

    private Integer topicAnswerId;

    private Date thankTime;

    public Integer getAnswerThankId() {
        return answerThankId;
    }

    public void setAnswerThankId(Integer answerThankId) {
        this.answerThankId = answerThankId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicAnswerId() {
        return topicAnswerId;
    }

    public void setTopicAnswerId(Integer topicAnswerId) {
        this.topicAnswerId = topicAnswerId;
    }

    public Date getThankTime() {
        return thankTime;
    }

    public void setThankTime(Date thankTime) {
        this.thankTime = thankTime;
    }

    @Override
    public String toString() {
        return "SunAnswerThank{" +
                "answerThankId=" + answerThankId +
                ", userId=" + userId +
                ", topicAnswerId=" + topicAnswerId +
                ", thankTime=" + thankTime +
                '}';
    }
}