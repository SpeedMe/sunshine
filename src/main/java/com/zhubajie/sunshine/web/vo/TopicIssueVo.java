package com.zhubajie.sunshine.web.vo;

import java.util.Date;

/**
 * @description: 用户发布的话题页面显示实体类
 * @author: HuangLei
 * date: 2015/9/5
 */
public class TopicIssueVo {
    //频道实体
    private Integer channelId;

    private String channelName;

    private Integer channelTemp;


    //话题实体
    private Integer topicId;

    private Integer topicTemp;

    private String topicName;

    private String topicContent;

    private Date topicCreateTime;

    private Boolean isAnonymityTopic;

    //关注人数
    private Integer followPeopleNum;

    //回答数
    private Integer answerNum;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getChannelTemp() {
        return channelTemp;
    }

    public void setChannelTemp(Integer channelTemp) {
        this.channelTemp = channelTemp;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
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
        this.topicName = topicName;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public Date getTopicCreateTime() {
        return topicCreateTime;
    }

    public void setTopicCreateTime(Date topicCreateTime) {
        this.topicCreateTime = topicCreateTime;
    }

    public Boolean getIsAnonymityTopic() {
        return isAnonymityTopic;
    }

    public void setIsAnonymityTopic(Boolean isAnonymityTopic) {
        this.isAnonymityTopic = isAnonymityTopic;
    }

    public Integer getFollowPeopleNum() {
        return followPeopleNum;
    }

    public void setFollowPeopleNum(Integer followPeopleNum) {
        this.followPeopleNum = followPeopleNum;
    }

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    @Override
    public String toString() {
        return "TopicIssueVo{" +
                "channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                ", channelTemp=" + channelTemp +
                ", topicId=" + topicId +
                ", topicTemp=" + topicTemp +
                ", topicName='" + topicName + '\'' +
                ", topicContent='" + topicContent + '\'' +
                ", topicCreateTime=" + topicCreateTime +
                ", isAnonymityTopic=" + isAnonymityTopic +
                ", followPeopleNum=" + followPeopleNum +
                ", answerNum=" + answerNum +
                '}';
    }
}
