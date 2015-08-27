package com.zhubajie.sunshine.web.model;

import java.util.Date;

public class SunPrivateChat {
    private Integer privateChatId;

    private Integer sendUserId;

    private Integer receiveUserId;

    private String chatContent;

    private Date chatTime;

    private Boolean isReaded;

    public Integer getPrivateChatId() {
        return privateChatId;
    }

    public void setPrivateChatId(Integer privateChatId) {
        this.privateChatId = privateChatId;
    }

    public Integer getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent == null ? null : chatContent.trim();
    }

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }

    public Boolean getIsReaded() {
        return isReaded;
    }

    public void setIsReaded(Boolean isReaded) {
        this.isReaded = isReaded;
    }
}