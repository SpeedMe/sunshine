package com.zhubajie.sunshine.web.service.topicservice.impl;

import com.zhubajie.sunshine.core.constant.DatabaseParamConstant;
import com.zhubajie.sunshine.core.constant.TemperatureConstant;
import com.zhubajie.sunshine.web.mapper.SunChannelTopicMapper;
import com.zhubajie.sunshine.web.mapper.SunShineChannelMapper;
import com.zhubajie.sunshine.web.mapper.SunTopicAnswerMapper;
import com.zhubajie.sunshine.web.mapper.SunTopicAttentionMapper;
import com.zhubajie.sunshine.web.model.*;
import com.zhubajie.sunshine.web.service.topicservice.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * 话题操作接口实现类
 * Created by huanglei on 2015/8/28.
 */
@Service("topicService")
public class TopicServiceImpl implements TopicService {
    @Autowired  //话题
    private SunChannelTopicMapper sunChannelTopicMapper;

    @Autowired  //频道
    private SunShineChannelMapper sunShineChannelMapper;

    @Autowired  //话题关注
    private SunTopicAttentionMapper sunTopicAttentionMapper;

    @Autowired  //回答
    private SunTopicAnswerMapper sunTopicAnswerMapper;

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

    /**
     * 查找用户发布的话题，按时间排序
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<SunChannelTopic> getTopicsByUserIdOrderByTime(Integer userId) throws Exception {
        SunChannelTopicExample sunChannelTopicExample = new SunChannelTopicExample();
        sunChannelTopicExample.createCriteria().andUserIdEqualTo(userId);
        sunChannelTopicExample.setOrderByClause(DatabaseParamConstant.TOPIC_CREATE_TIME);

        return sunChannelTopicMapper.selectByExample(sunChannelTopicExample);
    }

    @Override
    public SunChannelTopic getTopicByTopicId(Integer topicId) throws Exception {
        return sunChannelTopicMapper.selectByPrimaryKey(topicId);
    }

    /**
     * 发布话题
     * @param sunChannelTopic
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public SunChannelTopic issueTopic(SunChannelTopic sunChannelTopic) throws Exception {
        //插入话题
        sunChannelTopicMapper.insertSelective(sunChannelTopic);

        //增加频道温度
        increaseChannleTemp(sunChannelTopic.getChannelId(), TemperatureConstant.TOPIC_ISSUE_TEMP);

        return sunChannelTopicMapper.selectByPrimaryKey(sunChannelTopic.getTopicId());
    }

    /**
     * 关注话题
     * @param sunTopicAttention
     * @return
     * @throws Exception
     */
    @Override
    public SunChannelTopic followTopic(SunTopicAttention sunTopicAttention) throws Exception {

        //插入关注表
        sunTopicAttentionMapper.insertSelective(sunTopicAttention);

        //增加话题温度
        SunChannelTopic sunChannelTopic = increaseTopicTemp(sunTopicAttention.getTopicId(), TemperatureConstant.TOPIC_ATTENTION_TEMP);

        //增加频道温度
        increaseChannleTemp(sunChannelTopic.getChannelId(), TemperatureConstant.TOPIC_ATTENTION_TEMP);

        return sunChannelTopic;
    }

    /**
     * 取消关注
     * @param sunTopicAttention
     * @return
     * @throws Exception
     */
    @Override
    public boolean unfollowTopic(SunTopicAttention sunTopicAttention) throws Exception {

        SunTopicAttentionExample sunTopicAttentionExample = new SunTopicAttentionExample();
        sunTopicAttentionExample.createCriteria().andTopicIdEqualTo(sunTopicAttention.getTopicId()).andUserIdEqualTo(sunTopicAttention.getUserId());

        //删除关注记录
        sunTopicAttentionMapper.deleteByExample(sunTopicAttentionExample);

        //减少话题温度
        SunChannelTopic sunChannelTopic = increaseTopicTemp(sunTopicAttention.getTopicId(), -TemperatureConstant.TOPIC_ATTENTION_TEMP);

        //减少频道温度
        increaseChannleTemp(sunChannelTopic.getChannelId(), -TemperatureConstant.TOPIC_ATTENTION_TEMP);

        return true;
    }

    /**
     * 是否已关注
     * @param sunTopicAttention
     * @return
     * @throws Exception
     */
    @Override
    public boolean hasFollowedTopic(SunTopicAttention sunTopicAttention) throws Exception {

        SunTopicAttentionExample sunTopicAttentionExample = new SunTopicAttentionExample();
        sunTopicAttentionExample.createCriteria().andUserIdEqualTo(sunTopicAttention.getUserId()).andTopicIdEqualTo(sunTopicAttention.getTopicId());

        return sunTopicAttentionMapper.selectByExample(sunTopicAttentionExample).size() == 0 ? false : true;
    }

    /**
     * 获取到话题关注量
     * @param topicId 话题id
     * @return
     * @throws Exception
     */
    @Override
    public Integer countFollowTopic(Integer topicId) throws Exception {
        SunTopicAttentionExample sunTopicAttentionExample = new SunTopicAttentionExample();
        sunTopicAttentionExample.createCriteria().andTopicIdEqualTo(topicId);

        return sunTopicAttentionMapper.selectByExample(sunTopicAttentionExample).size();
    }

    /**
     * 根据名字模糊查询话题
     * @param topicName
     * @return
     * @throws Exception
     */
    @Override
    public List<SunChannelTopic> queryTopicByName(String topicName) throws Exception {
        SunChannelTopicExample sunChannelTopicExample = new SunChannelTopicExample();
        sunChannelTopicExample.createCriteria().andTopicNameLike("%" + topicName + "%");

        return sunChannelTopicMapper.selectByExample(sunChannelTopicExample);
    }

    /**
     * 查询用户下面所有发布的话题
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<SunChannelTopic> queryIssueTopicByUserId(Integer userId) throws Exception {
        SunChannelTopicExample sunChannelTopicExample = new SunChannelTopicExample();
        sunChannelTopicExample.createCriteria().andUserIdEqualTo(userId);

        return sunChannelTopicMapper.selectByExample(sunChannelTopicExample);
    }

    /**
     * 查询用户关注的话题
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<SunChannelTopic> getFollowedTopicsByUserId(Integer userId) throws Exception {
        //找出用户关注的所有话题id
        List<Integer> topicIds = new LinkedList<Integer>();
        SunTopicAttentionExample sunTopicAttentionExample = new SunTopicAttentionExample();
        sunTopicAttentionExample.createCriteria().andUserIdEqualTo(userId);
        List<SunTopicAttention> sunTopicAttentions = sunTopicAttentionMapper.selectByExample(sunTopicAttentionExample);

        for (SunTopicAttention sunTopicAttention : sunTopicAttentions){
            topicIds.add(sunTopicAttention.getTopicId());
        }

        SunChannelTopicExample sunChannelTopicExample = new SunChannelTopicExample();
        sunChannelTopicExample.createCriteria().andTopicIdIn(topicIds);

        return sunChannelTopicMapper.selectByExample(sunChannelTopicExample);
    }

    /**
     * 得到最大温度的话题
     * @param channelId
     * @return
     * @throws Exception
     */
    @Override
    public SunChannelTopic getMaxTempTopic(Integer channelId) throws Exception {
        SunChannelTopicExample sunChannelTopicExample = new SunChannelTopicExample();
        sunChannelTopicExample.createCriteria().andChannelIdEqualTo(channelId);
        sunChannelTopicExample.setOrderByClause(DatabaseParamConstant.TOPIC_TEMP_Max);
        List<SunChannelTopic> sunChannelTopics = sunChannelTopicMapper.selectByExample(sunChannelTopicExample);
        return sunChannelTopics.size() == 0 ? null : sunChannelTopics.get(0);
    }


    /**
     * 增加频道温度
     * @param channelId
     * @param temperature
     * @throws Exception
     */
    private SunShineChannel increaseChannleTemp(Integer channelId, Integer temperature) throws Exception{
        SunShineChannel sunShineChannel = sunShineChannelMapper.selectByPrimaryKey(channelId);
        sunShineChannel.setChannelTemp(sunShineChannel.getChannelTemp() + temperature);
        sunShineChannelMapper.updateByPrimaryKey(sunShineChannel);

        return sunShineChannel;
    }


    /**
     * 增加话题温度
     * @param topicId
     * @param temperature
     * @throws Exception
     */
    private SunChannelTopic increaseTopicTemp(Integer topicId, Integer temperature) throws Exception{
        SunChannelTopic sunChannelTopic = sunChannelTopicMapper.selectByPrimaryKey(topicId);
        sunChannelTopic.setTopicTemp(sunChannelTopic.getTopicTemp() + temperature);
        sunChannelTopicMapper.updateByPrimaryKey(sunChannelTopic);

        return sunChannelTopic;
    }

    /**
     * 增加回答温度
     * @param answerId
     * @param temperature
     * @throws Exception
     */
    private SunTopicAnswer increaseAnswerTemp(Integer answerId, Integer temperature) throws Exception{
        SunTopicAnswer sunTopicAnswer = sunTopicAnswerMapper.selectByPrimaryKey(answerId);
        sunTopicAnswer.setTopicAnswerTemp(sunTopicAnswer.getTopicAnswerTemp() + temperature);
        sunTopicAnswerMapper.updateByPrimaryKey(sunTopicAnswer);

        return sunTopicAnswer;
    }
}
