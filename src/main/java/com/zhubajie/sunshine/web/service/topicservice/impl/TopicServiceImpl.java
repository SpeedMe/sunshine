package com.zhubajie.sunshine.web.service.topicservice.impl;

import com.zhubajie.sunshine.core.constant.DatabaseParamConstant;
import com.zhubajie.sunshine.web.mapper.SunChannelTopicMapper;
import com.zhubajie.sunshine.web.model.SunChannelTopic;
import com.zhubajie.sunshine.web.model.SunChannelTopicExample;
import com.zhubajie.sunshine.web.service.topicservice.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 话题操作接口实现类
 * Created by huanglei on 2015/8/28.
 */
@Service("topicService")
public class TopicServiceImpl implements TopicService {
    @Autowired
    private SunChannelTopicMapper sunChannelTopicMapper;

    /**
     * 得到某频道下所有话题，按照温度排序
     * @param channelId
     * @return
     * @throws Exception
     */
    @Override
    public List<SunChannelTopic> getTopicsByChannelIdOrderByTemp(Integer channelId) throws Exception {
        SunChannelTopicExample sunChannelTopicExample = new SunChannelTopicExample();
        sunChannelTopicExample.createCriteria().andChannelIdEqualTo(channelId);
        sunChannelTopicExample.setOrderByClause(DatabaseParamConstant.TOPIC_TEMP);

        return sunChannelTopicMapper.selectByExample(sunChannelTopicExample);
    }

    @Override
    public SunChannelTopic issueTopic(SunChannelTopic sunChannelTopic) throws Exception {

        return null;
    }
}
