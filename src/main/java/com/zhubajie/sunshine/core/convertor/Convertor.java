package com.zhubajie.sunshine.core.convertor;

import com.zhubajie.sunshine.web.model.SunChannelTopic;
import com.zhubajie.sunshine.web.model.SunShineChannel;
import com.zhubajie.sunshine.web.model.SunShineUser;
import com.zhubajie.sunshine.web.model.SunTopicAnswer;
import com.zhubajie.sunshine.web.vo.*;

import java.util.Date;
import java.util.List;

/**
 * @description: 频道实体转换工具类
 * @author: HuangLei
 * date: 2015/9/2
 */
public class Convertor {

    /**
     * 转换成频道页面显示实体
     *
     * @param channel 频道信息
     * @param topic   话题信息
     * @param user    用户信息
     * @return
     */
    public static ChannelVo convertToChannelVo(SunShineChannel channel, SunChannelTopic topic, SunShineUser user) {
        ChannelVo channelVo = new ChannelVo();

        channelVo.setChannelId(channel.getChannelId());
        channelVo.setChannelName(channel.getChannelName());
        channelVo.setChannelTemp(channel.getChannelTemp());

        channelVo.setTopicId(topic.getTopicId());
        channelVo.setTopicName(topic.getTopicName());
        channelVo.setTopicContent(topic.getTopicContent());
        channelVo.setTopicCreateTime(topic.getTopicCreateTime());
        channelVo.setTopicTemp(topic.getTopicTemp());
        channelVo.setIsAnonymityTopic(topic.getIsAnonymity());

        channelVo.setUserIdTopic(user.getUserId());
        channelVo.setNicknameTopic(user.getNickname());
        channelVo.setAvatarPathTopic(user.getAvatarPath());

        return channelVo;
    }

    /**
     * 转换为话题页面显示实体
     *
     * @param channel    频道信息
     * @param topic      话题信息
     * @param userTopic  发表话题的用户信息
     * @param answer     温度最高回复信息
     * @param userAnswer 回复的用户信息
     * @return
     */
    public static TopicVo convertToTopicVo(SunShineChannel channel, SunChannelTopic topic, SunShineUser userTopic, SunTopicAnswer answer, SunShineUser userAnswer) {

        TopicVo topicVo = new TopicVo();

        topicVo.setChannelId(channel.getChannelId());
        topicVo.setChannelName(channel.getChannelName());
        topicVo.setChannelTemp(channel.getChannelTemp());

        if (topic != null) {
            topicVo.setTopicId(topic.getTopicId());
            topicVo.setTopicTemp(topic.getTopicTemp());
            topicVo.setTopicName(topic.getTopicName());
            topicVo.setTopicContent(topic.getTopicContent());
            topicVo.setTopicCreateTime(topic.getTopicCreateTime());
            topicVo.setIsAnonymityTopic(topic.getIsAnonymity());
        }

        if (userTopic != null) {
            topicVo.setUserIdTopic(userTopic.getUserId());
            topicVo.setNicknameTopic(userTopic.getNickname());
            topicVo.setAvatarPathTopic(userTopic.getAvatarPath());
        }

        if (answer != null) {
            topicVo.setTopicAnswerId(answer.getTopicAnswerId());
            topicVo.setTopicAnswerTemp(answer.getTopicAnswerTemp());
            topicVo.setTopicAnswerContent(answer.getTopicAnswerContent());
            topicVo.setTopicAnswerTime(answer.getTopicAnswerTime());
            topicVo.setIsAnonymityAnswer(answer.getIsAnonymity());
        }

        if (userAnswer != null) {
            topicVo.setUserIdAnswer(userAnswer.getUserId());
            topicVo.setNicknameAnswer(userAnswer.getNickname());
            topicVo.setAvatarPathAnswer(userAnswer.getAvatarPath());
        }

        return topicVo;
    }

    /**
     * 转换为前端单个话题详情页面
     *
     * @param channel
     * @param topic
     * @param answerVos
     * @return
     */
    public static TopicDetailVo convertToTopicDetailVo(SunShineChannel channel, SunChannelTopic topic, SunShineUser userTopic, List<AnswerVo> answerVos) {
        TopicDetailVo topicDetailVo = new TopicDetailVo();

        topicDetailVo.setChannelId(channel.getChannelId());
        topicDetailVo.setChannelName(channel.getChannelName());
        topicDetailVo.setChannelTemp(channel.getChannelTemp());

        topicDetailVo.setTopicId(topic.getTopicId());
        topicDetailVo.setTopicTemp(topic.getTopicTemp());
        topicDetailVo.setTopicName(topic.getTopicName());
        topicDetailVo.setTopicContent(topic.getTopicContent());
        topicDetailVo.setTopicCreateTime(topic.getTopicCreateTime());
        topicDetailVo.setIsAnonymityTopic(topic.getIsAnonymity());

        topicDetailVo.setUserIdTopic(userTopic.getUserId());
        topicDetailVo.setNicknameTopic(userTopic.getNickname());
        topicDetailVo.setAvatarPathTopic(userTopic.getAvatarPath());

        topicDetailVo.setAnswerVos(answerVos);
        return topicDetailVo;
    }

    /**
     * 转换为前端显示的回复实体
     *
     * @param answer
     * @param userAnswer
     * @return
     */
    public static AnswerVo convertToAnswerVo(SunTopicAnswer answer, SunShineUser userAnswer) {
        AnswerVo answerVo = new AnswerVo();

        answerVo.setTopicAnswerId(answer.getTopicAnswerId());
        answerVo.setTopicAnswerTemp(answer.getTopicAnswerTemp());
        answerVo.setTopicAnswerContent(answer.getTopicAnswerContent());
        answerVo.setTopicAnswerTime(answer.getTopicAnswerTime());

        answerVo.setUserIdAnswer(userAnswer.getUserId());
        answerVo.setNicknameAnswer(userAnswer.getNickname());
        answerVo.setAvatarPathAnswer(userAnswer.getNickname());

        return answerVo;
    }

    /**
     * 转化用户发布的话题显示实体类
     * @param channel
     * @param topic
     * @param followPeopleNum
     * @param answerNum
     * @return
     */
    public static TopicIssueVo convertToTopicIssueVo(SunShineChannel channel, SunChannelTopic topic, Integer followPeopleNum, Integer answerNum) {
        TopicIssueVo topicIssueVo = new TopicIssueVo();

        topicIssueVo.setChannelId(channel.getChannelId());
        topicIssueVo.setChannelName(channel.getChannelName());
        topicIssueVo.setChannelTemp(channel.getChannelTemp());

        if (topic != null) {
            topicIssueVo.setTopicId(topic.getTopicId());
            topicIssueVo.setTopicTemp(topic.getTopicTemp());
            topicIssueVo.setTopicName(topic.getTopicName());
            topicIssueVo.setTopicContent(topic.getTopicContent());
            topicIssueVo.setTopicCreateTime(topic.getTopicCreateTime());
            topicIssueVo.setIsAnonymityTopic(topic.getIsAnonymity());
        }

        topicIssueVo.setFollowPeopleNum(followPeopleNum);
        topicIssueVo.setAnswerNum(answerNum);

        return topicIssueVo;
    }
}
