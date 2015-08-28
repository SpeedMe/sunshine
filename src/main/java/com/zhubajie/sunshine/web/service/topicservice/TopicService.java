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
     * 根据topicId获取到话题
     * @param topicId
     * @return
     * @throws Exception
     */
    SunChannelTopic getTopicByTopicId(Integer topicId) throws Exception;

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
    SunChannelTopic followTopic(SunTopicAttention sunTopicAttention) throws Exception;

    /**
     * 取消关注
     * @param sunTopicAttention
     * @return
     * @throws Exception
     */
    boolean unfollowTopic(SunTopicAttention sunTopicAttention) throws Exception;

    /**
     * 是否已经关注
     * @param sunTopicAttention
     * @return
     * @throws Exception
     */
    boolean hasFollowedTopic(SunTopicAttention sunTopicAttention) throws Exception;

    /**
     * 得到话题关注量
     * @param topicId
     * @return
     * @throws Exception
     */
    Integer countFollowTopic(Integer topicId) throws Exception;

    /**
     * 根据名字模糊查找话题
     * @param topicName
     * @return
     * @throws Exception
     */
    List<SunChannelTopic> queryTopicByName(String topicName) throws Exception;

    /**
     * 查询用户下面所有发布的话题
     * @param userId
     * @return
     * @throws Exception
     */
    List<SunChannelTopic> queryIssueTopicByUserId(Integer userId) throws Exception;

    /**
     * 查询用户下面关注的话题
     * @param userId
     * @return
     * @throws Exception
     */
    List<SunChannelTopic> queryFollowTopicByUserId(Integer userId) throws Exception;

}
