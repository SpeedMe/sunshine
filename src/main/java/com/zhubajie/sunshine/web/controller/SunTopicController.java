package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.core.convertor.Convertor;
import com.zhubajie.sunshine.core.entity.FeResponse;
import com.zhubajie.sunshine.web.model.*;
import com.zhubajie.sunshine.web.service.answerservice.AnswerService;
import com.zhubajie.sunshine.web.service.channelservice.ChannelService;
import com.zhubajie.sunshine.web.service.topicservice.TopicService;
import com.zhubajie.sunshine.web.service.userservice.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 话题Controller
 * Created by huanglei on 2015/8/28.
 */
@Controller
@RequestMapping("/sunTopic")
public class SunTopicController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "topicService")    //话题
    private TopicService topicService;

    @Resource(name = "answerService")   //回复
    private AnswerService answerService;

    @Resource(name = "channelService")  //频道
    private ChannelService channelService;

    @Resource(name = "userService")     //用户
    private UserService userService;

    /**
     * 根据频道id获取到所有话题，按照温度排序
     *
     * @param channelId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getTopicsByChannelIdOrderByTemp/{channelId}", method = RequestMethod.GET)
    public ModelAndView getTopicsByChannelIdOrderByTemp(@PathVariable String channelId) {
        ModelAndView modelAndView = new ModelAndView("topic");
        FeResponse<List<TopicVo>> response;
        SunShineChannel sunShineChannel = null;
        try {
            List<SunChannelTopic> sunChannelTopics = topicService.getTopicsByChannelIdOrderByTemp(Integer.parseInt(channelId));

            List<TopicVo> topicVos = new LinkedList<TopicVo>();

            sunShineChannel = channelService.getChannelById(Integer.parseInt(channelId));
            for (SunChannelTopic sunChannelTopic : sunChannelTopics) {
                SunShineUser userTopic = userService.getUserById(sunChannelTopic.getUserId());
                SunTopicAnswer sunTopicAnswer = answerService.getMaxTempAnswer(sunChannelTopic.getTopicId());

                SunShineUser userAnswer = null;

                if (sunTopicAnswer != null) {
                    userAnswer = userService.getUserById(sunTopicAnswer.getUserId());
                }

                topicVos.add(Convertor.convertToTopicVo(sunShineChannel, sunChannelTopic, userTopic, sunTopicAnswer, userAnswer));

            }

            response = new FeResponse<List<TopicVo>>(HttpStatus.OK.value(), "查询成功", topicVos);
        } catch (Exception e) {
            logger.error(e.getMessage());
            response = new FeResponse<List<TopicVo>>(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage(), null);
        }

        modelAndView.addObject("channel",sunShineChannel);
        modelAndView.addObject("topicResponse", response);
        return modelAndView;
    }


    /**
     * 得到某频道最大温度的话题
     *
     * @param channelId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMaxTempTopicByChannelId/{channelId}", method = RequestMethod.GET)
    public FeResponse<SunChannelTopic> getMaxTempTopicByChannelId(@PathVariable String channelId) {
        FeResponse<SunChannelTopic> response;

        try {
            List<SunChannelTopic> sunChannelTopics = topicService.getTopicsByChannelIdOrderByTemp(Integer.parseInt(channelId));

            if (sunChannelTopics.size() == 0) {
                response = new FeResponse<SunChannelTopic>(HttpStatus.OK.value(), "查询成功", null);
            } else {
                response = new FeResponse<SunChannelTopic>(HttpStatus.OK.value(), "查询成功", sunChannelTopics.get(sunChannelTopics.size() - 1));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            response = new FeResponse<SunChannelTopic>(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage(), null);
        }

        return response;
    }


    /**
     * 发布话题
     *
     * @param sunChannelTopic
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/issueTopic", method = RequestMethod.POST)
    public FeResponse<SunChannelTopic> issueTopic(SunChannelTopic sunChannelTopic) {
        FeResponse<SunChannelTopic> response;

        try {
            SunChannelTopic topicResult = topicService.issueTopic(sunChannelTopic);

            response = new FeResponse<SunChannelTopic>(HttpStatus.OK.value(), "发布成功", topicResult);
        } catch (Exception e) {
            logger.error(e.getMessage());
            response = new FeResponse<SunChannelTopic>(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage(), null);
        }

        return response;
    }

    /**
     * 关注话题
     *
     * @param sunTopicAttention
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/followTopic", method = RequestMethod.POST)
    public FeResponse<SunChannelTopic> followTopic(SunTopicAttention sunTopicAttention) {
        FeResponse<SunChannelTopic> response;

        try {
            SunChannelTopic sunChannelTopic = topicService.followTopic(sunTopicAttention);

            response = new FeResponse<SunChannelTopic>(HttpStatus.OK.value(), "关注成功", sunChannelTopic);
        } catch (Exception e) {
            logger.error(e.getMessage());

            response = new FeResponse<SunChannelTopic>(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage(), null);
        }

        return response;
    }

    /**
     * 取消关注
     *
     * @param sunTopicAttention
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/unfollowTopic", method = RequestMethod.POST)
    public FeResponse<Boolean> unfollowTopic(SunTopicAttention sunTopicAttention) {
        FeResponse<Boolean> response;

        try {
            boolean unfollowFlag = topicService.unfollowTopic(sunTopicAttention);

            response = new FeResponse<Boolean>(HttpStatus.OK.value(), "取消成功", unfollowFlag);
        } catch (Exception e) {
            logger.error(e.getMessage());

            response = new FeResponse<Boolean>(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage(), null);
        }

        return response;
    }


    /**
     * 是否已经关注话题
     *
     * @param sunTopicAttention
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/hasFollowedTopic", method = RequestMethod.GET)
    public FeResponse<Boolean> hasFollowedTopic(SunTopicAttention sunTopicAttention) {
        FeResponse<Boolean> response;

        try {
            boolean hasFollowedTopic = topicService.hasFollowedTopic(sunTopicAttention);

            response = new FeResponse<Boolean>(HttpStatus.OK.value(), "请求成功", hasFollowedTopic);
        } catch (Exception e) {
            logger.error(e.getMessage());

            response = new FeResponse<Boolean>(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage(), null);
        }
        return response;
    }

    /**
     * 根据topicId获取话题
     *
     * @param topicId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getTopicByTopicId/{topicId}", method = RequestMethod.GET)
    public FeResponse<SunChannelTopic> getTopicByTopicId(@PathVariable String topicId) {
        FeResponse<SunChannelTopic> response;

        try {
            SunChannelTopic sunChannelTopic = topicService.getTopicByTopicId(Integer.parseInt(topicId));
            response = new FeResponse<SunChannelTopic>(HttpStatus.OK.value(), "查找成功", sunChannelTopic);
        } catch (Exception e) {
            logger.error(e.getMessage());
            response = new FeResponse<SunChannelTopic>(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage(), null);
        }

        return response;
    }

}
