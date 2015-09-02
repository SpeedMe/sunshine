package com.zhubajie.sunshine.web.service.channelservice;

import com.zhubajie.sunshine.web.model.SunShineChannel;

import java.util.List;

/**
 * 频道操作
 * Created by huanglei on 2015/8/28.
 */
public interface ChannelService {
    /**
     * 获取到所有频道,按照温度排序
     * @return
     * @throws Exception
     */
    List<SunShineChannel> getAllChannelsOrderByTemp() throws Exception;

    /**
     * 根据channelId获取到频道信息
     * @param channelId
     * @return
     * @throws Exception
     */
    SunShineChannel getChannelById(Integer channelId) throws Exception;
}
