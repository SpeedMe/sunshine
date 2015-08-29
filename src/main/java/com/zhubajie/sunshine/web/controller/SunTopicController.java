package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.core.entity.FeResponse;
import com.zhubajie.sunshine.web.model.SunChannelTopic;
import com.zhubajie.sunshine.web.model.SunTopicAttention;
import com.zhubajie.sunshine.web.service.topicservice.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 话题Controller
 * Created by huanglei on 2015/8/28.
 */
@Controller
@RequestMapping("/sunTopic")
public class SunTopicController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "topicService")
    private TopicService topicService;

    /**
     * 根据频道id获取到所有话题，按照温度排序
     *
     * @param channelId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getTopicsByChannelIdOrderByTemp/{channelId}", method = RequestMethod.GET)
    public FeResponse<List> getTopicsByChannelIdOrderByTemp(@PathVariable String channelId) {
        FeResponse<List> response;

        try {
            List<SunChannelTopic> sunChannelTopics = topicService.getTopicsByChannelIdOrderByTemp(Integer.parseInt(channelId));

            response = new FeResponse<List>(HttpStatus.OK.value(), "查询成功", sunChannelTopics);
        } catch (Exception e) {
            logger.error(e.getMessage());
            response = new FeResponse<List>(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage(), null);
        }

        return response;
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
