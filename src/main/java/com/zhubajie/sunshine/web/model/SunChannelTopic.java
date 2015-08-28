package com.zhubajie.sunshine.web.model;

import java.util.Date;

public class SunChannelTopic {
    private Integer topicId;

    private Integer channelId;

    private Integer userId;

    private Integer topicTemp;

    private String topicName;

    private String topicContent;

    private Date topicCreateTime;

    private Boolean isAnonymity;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicTemp() {
        return topicTemp;
    }

    public void setTopicTemp(Integer topicTemp) {
        this.topicTemp = topicTemp;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName == null ? null : topicName.trim();
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent == null ? null : topicContent.trim();
    }

    public Date getTopicCreateTime() {
        return topicCreateTime;
    }

    public void setTopicCreateTime(Date topicCreateTime) {
        this.topicCreateTime = topicCreateTime;
    }

    public Boolean getIsAnonymity() {
        return isAnonymity;
    }

    public void setIsAnonymity(Boolean isAnonymity) {
        this.isAnonymity = isAnonymity;
    }
}