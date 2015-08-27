package com.zhubajie.sunshine.web.model;

public class SunShineChannel {
    private Integer channelId;

    private String channelName;

    private Integer channelTemp;

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
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public Integer getChannelTemp() {
        return channelTemp;
    }

    public void setChannelTemp(Integer channelTemp) {
        this.channelTemp = channelTemp;
    }
}