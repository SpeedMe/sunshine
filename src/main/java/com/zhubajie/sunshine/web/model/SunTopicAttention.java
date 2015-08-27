package com.zhubajie.sunshine.web.model;

import java.util.Date;

public class SunTopicAttention {
    private Integer topicAttentionId;

    private Integer userId;

    private Integer topicId;

    private Date topicAttentionTime;

    public Integer getTopicAttentionId() {
        return topicAttentionId;
    }

    public void setTopicAttentionId(Integer topicAttentionId) {
        this.topicAttentionId = topicAttentionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Date getTopicAttentionTime() {
        return topicAttentionTime;
    }

    public void setTopicAttentionTime(Date topicAttentionTime) {
        this.topicAttentionTime = topicAttentionTime;
    }
}