package com.zhubajie.sunshine.web.service.topicservice;

import com.zhubajie.sunshine.web.model.SunChannelTopic;

import java.util.List;

/**
 * 话题操作接口
 * Created by huanglei on 2015/8/28.
 */
public interface TopicService {
    List<SunChannelTopic> getTopicsByChannelIdOrderByTemp(Integer channelId) throws Exception;
}
