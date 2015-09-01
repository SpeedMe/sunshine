package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.core.entity.FeResponse;
import com.zhubajie.sunshine.web.model.SunChannelTopic;
import com.zhubajie.sunshine.web.model.SunShineChannel;
import com.zhubajie.sunshine.web.service.channelservice.ChannelService;
import com.zhubajie.sunshine.web.service.topicservice.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 频道Controller
 * Created by huanglei on 2015/8/28.
 */
@Controller
@RequestMapping("/sunChannel")
public class SunChannelController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "channelService")
    private ChannelService channelService;

    @Resource(name = "topicService")
    private TopicService topicService;

    /**
     * 根据温度排序得到所有频道内容
     * @return
     */
    @RequestMapping(value = "/getAllChannelsOrderByTemp")
    public ModelAndView getAllChannelsOrderByTemp(){
        FeResponse<Map<SunShineChannel,SunChannelTopic>> response;
        ModelAndView modelAndView = new ModelAndView("channel");
        try{
            List<SunShineChannel> sunShineChannels = channelService.getAllChannelsOrderByTemp();

            //频道和其最高温度的话题
            Map<SunShineChannel,SunChannelTopic> channelAndTopicMap = new HashMap<SunShineChannel, SunChannelTopic>();

            for (SunShineChannel sunShineChannel : sunShineChannels){
                channelAndTopicMap.put(sunShineChannel,topicService.getMaxTempTopic(sunShineChannel.getChannelId()));
            }

            response = new FeResponse<Map<SunShineChannel,SunChannelTopic>>(HttpStatus.OK.value(),"查询成功",channelAndTopicMap);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<Map<SunShineChannel,SunChannelTopic>>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }
        modelAndView.addObject("response",response);

        return modelAndView;
    }
}
