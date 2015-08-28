package com.zhubajie.sunshine.web.service.topicservice;

import com.zhubajie.sunshine.web.model.SunChannelTopic;
import com.zhubajie.sunshine.web.model.SunTopicAttention;

import java.util.List;

/**
 * 话题操作接口
 * Created by huanglei on 2015/8/28.
 */
public interface TopicService {
    /**
     * 得到某频道下所有话题，按照温度排序
     * @param channelId
     * @return
     * @throws Exception
     */
    List<SunChannelTopic> getTopicsByChannelIdOrderByTemp(Integer channelId) throws Exception;

    /**
     * 发布话题
     * @param sunChannelTopic
     * @return
     * @throws Exception
     */
    SunChannelTopic issueTopic(SunChannelTopic sunChannelTopic) throws Exception;

    /**
     * 话题关注
     * @param sunTopicAttention
     * @return
     * @throws Exception
     */
    SunChannelTopic attentionTopic(SunTopicAttention sunTopicAttention) throws Exception;
}
