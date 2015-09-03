package com.zhubajie.sunshine.web.vo;

import java.util.Date;

/**
 * @description: 单个回答详情
 * @author: HuangLei
 * date: 2015/9/2
 */
public class AnswerVo {
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
        return "AnswerVo{" +
                "topicAnswerId=" + topicAnswerId +
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
