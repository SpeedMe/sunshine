package com.zhubajie.sunshine.web.vo;

import java.util.Date;
import java.util.List;

/**
 * @description: 单个话题详情页面
 * @author: HuangLei
 * date: 2015/9/3
 */
public class TopicDetailVo {
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

    //回复实体集合
    private List<AnswerVo> answerVos;

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

    public List<AnswerVo> getAnswerVos() {
        return answerVos;
    }

    public void setAnswerVos(List<AnswerVo> answerVos) {
        this.answerVos = answerVos;
    }

    @Override
    public String toString() {
        return "TopicDetailVo{" +
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
                ", answerVos=" + answerVos +
                '}';
    }
}
