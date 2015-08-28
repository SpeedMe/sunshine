package com.zhubajie.sunshine.web.service.answerservice.impl;

import com.zhubajie.sunshine.core.constant.TemperatureConstant;
import com.zhubajie.sunshine.web.mapper.SunAnswerThankMapper;
import com.zhubajie.sunshine.web.mapper.SunChannelTopicMapper;
import com.zhubajie.sunshine.web.mapper.SunShineChannelMapper;
import com.zhubajie.sunshine.web.mapper.SunTopicAnswerMapper;
import com.zhubajie.sunshine.web.model.*;
import com.zhubajie.sunshine.web.service.answerservice.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 话题回复接口实现类
 * Created by huanglei on 2015/8/28.
 */
@Service("answerService")
public class AnswerServiceImpl implements AnswerService {

    @Autowired  //话题回复
    private SunTopicAnswerMapper sunTopicAnswerMapper;

    @Autowired  //话题
    private SunChannelTopicMapper sunChannelTopicMapper;

    @Autowired  //频道
    private SunShineChannelMapper sunShineChannelMapper;

    @Autowired  //感谢回答
    private SunAnswerThankMapper sunAnswerThankMapper;

    /**
     * 话题回复
     * @param sunTopicAnswer
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public boolean answerTopic(SunTopicAnswer sunTopicAnswer) throws Exception {
        //插入回复表
        sunTopicAnswerMapper.insertSelective(sunTopicAnswer);

        //增加话题温度
        SunChannelTopic sunChannelTopic = increaseTopicTemp(sunTopicAnswer.getTopicId(), TemperatureConstant.TOPIC_ANSWER_TEMP);

        //增加频道温度
        increaseChannleTemp(sunChannelTopic.getChannelId(), TemperatureConstant.TOPIC_ANSWER_TEMP);

        return true;
    }

    /**
     * 感谢回答
     * @param sunAnswerThank
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public SunAnswerThank thankAnswer(SunAnswerThank sunAnswerThank) throws Exception {
        //插入感谢回答记录
        sunAnswerThankMapper.insertSelective(sunAnswerThank);

        //增加回答温度
        SunTopicAnswer sunTopicAnswer = increaseAnswerTemp(sunAnswerThank.getAnswerThankId(), TemperatureConstant.ANSWER_THANK_TEMP);

        //增加话题温度
        SunChannelTopic sunChannelTopic = increaseTopicTemp(sunTopicAnswer.getTopicId(), TemperatureConstant.ANSWER_THANK_TEMP);

        //增加频道温度
        increaseChannleTemp(sunChannelTopic.getChannelId(), TemperatureConstant.ANSWER_THANK_TEMP);

        return sunAnswerThank;
    }

    /**
     * 是否已感谢回答
     * @param sunAnswerThank
     * @return
     * @throws Exception
     */
    @Override
    public boolean hasThankedAnswer(SunAnswerThank sunAnswerThank) throws Exception {

        SunAnswerThankExample sunAnswerThankExample = new SunAnswerThankExample();
        sunAnswerThankExample.createCriteria().andUserIdEqualTo(sunAnswerThank.getUserId()).andTopicAnswerIdEqualTo(sunAnswerThank.getTopicAnswerId());

        return sunAnswerThankMapper.selectByExample(sunAnswerThankExample).size() == 0 ? false : true;
    }

    /**
     * 得到话题回答数量
     * @param topicId
     * @return
     * @throws Exception
     */
    @Override
    public Integer countTopicAnswer(Integer topicId) throws Exception {
        SunTopicAnswerExample sunTopicAnswerExample = new SunTopicAnswerExample();
        sunTopicAnswerExample.createCriteria().andTopicIdEqualTo(topicId);

        return sunTopicAnswerMapper.selectByExample(sunTopicAnswerExample).size();
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
