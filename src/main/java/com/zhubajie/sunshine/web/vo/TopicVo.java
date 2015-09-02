package com.zhubajie.sunshine.web.vo;

import java.util.Date;

/**
 * @description:
 * @author: HuangLei
 * date: 2015/9/2
 */
public class TopicVo {
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

    //发送话题的用户实体
    private Integer userIdTopic;

    private String nicknameTopic;

    private String avatarPathTopic;


    //回复实体
    private Integer topicAnswerId;

    private Integer topicAnswerTemp;

    private String topicAnswerContent;

    private Date topicAnswerTime;

    private Boolean isAnonymityAnswer;


    //回复的用户实体
    private Integer userIdAnswer;

    private String nicknameAnswer;

    private String avatarPathAnswer;

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

    public Integer getUserIdTopic() {
        return userIdTopic;
    }

    public void setUserIdTopic(Integer userIdTopic) {
        this.userIdTopic = userIdTopic;
    }

    public String getNicknameTopic() {
        return nicknameTopic;
    }

    public void setNicknameTopic(String nicknameTopic) {
        this.nicknameTopic = nicknameTopic;
    }

    public String getAvatarPathTopic() {
        return avatarPathTopic;
    }

    public void setAvatarPathTopic(String avatarPathTopic) {
        this.avatarPathTopic = avatarPathTopic;
    }

    public Integer getTopicAnswerId() {
        return topicAnswerId;
    }

    public void setTopicAnswerId(Integer topicAnswerId) {
        this.topicAnswerId = topicAnswerId;
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
        this.topicAnswerContent = topicAnswerContent;
    }

    public Date getTopicAnswerTime() {
        return topicAnswerTime;
    }

    public void setTopicAnswerTime(Date topicAnswerTime) {
        this.topicAnswerTime = topicAnswerTime;
    }

    public Boolean getIsAnonymityAnswer() {
        return isAnonymityAnswer;
    }

    public void setIsAnonymityAnswer(Boolean isAnonymityAnswer) {
        this.isAnonymityAnswer = isAnonymityAnswer;
    }

    public Integer getUserIdAnswer() {
        return userIdAnswer;
    }

    public void setUserIdAnswer(Integer userIdAnswer) {
        this.userIdAnswer = userIdAnswer;
    }

    public String getNicknameAnswer() {
        return nicknameAnswer;
    }

    public void setNicknameAnswer(String nicknameAnswer) {
        this.nicknameAnswer = nicknameAnswer;
    }

    public String getAvatarPathAnswer() {
        return avatarPathAnswer;
    }

    public void setAvatarPathAnswer(String avatarPathAnswer) {
        this.avatarPathAnswer = avatarPathAnswer;
    }

    @Override
    public String toString() {
        return "TopicVo{" +
                "channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                ", channelTemp=" + channelTemp +
                ", topicId=" + topicId +
                ", topicTemp=" + topicTemp +
                ", topicName='" + topicName + '\'' +
                ", topicContent='" + topicContent + '\'' +
                ", topicCreateTime=" + topicCreateTime +
                ", isAnonymityTopic=" + isAnonymityTopic +
                ", userIdTopic=" + userIdTopic +
                ", nicknameTopic='" + nicknameTopic + '\'' +
                ", avatarPathTopic='" + avatarPathTopic + '\'' +
                ", topicAnswerId=" + topicAnswerId +
                ", topicAnswerTemp=" + topicAnswerTemp +
                ", topicAnswerContent='" + topicAnswerContent + '\'' +
                ", topicAnswerTime=" + topicAnswerTime +
                ", isAnonymityAnswer=" + isAnonymityAnswer +
                ", userIdAnswer=" + userIdAnswer +
                ", nicknameAnswer='" + nicknameAnswer + '\'' +
                ", avatarPathAnswer='" + avatarPathAnswer + '\'' +
                '}';
    }
}
