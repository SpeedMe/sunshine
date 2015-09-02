package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.core.convertor.Convertor;
import com.zhubajie.sunshine.core.entity.FeResponse;
import com.zhubajie.sunshine.web.model.SunChannelTopic;
import com.zhubajie.sunshine.web.model.SunShineChannel;
import com.zhubajie.sunshine.web.model.SunShineUser;
import com.zhubajie.sunshine.web.service.channelservice.ChannelService;
import com.zhubajie.sunshine.web.service.topicservice.TopicService;
import com.zhubajie.sunshine.web.service.userservice.UserService;
import com.zhubajie.sunshine.web.vo.ChannelVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 频道Controller
 * Created by huanglei on 2015/8/28.
 */
@Controller
@RequestMapping("/sunChannel")
public class SunChannelController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "channelService")  //频道
    private ChannelService channelService;

    @Resource(name = "topicService")    //话题
    private TopicService topicService;

    @Resource(name = "userService")     //用户
    private UserService userService;

    /**
     * 根据温度排序得到所有频道内容
     * @return
     */
    @RequestMapping(value = "/getAllChannelsOrderByTemp")
    public ModelAndView getAllChannelsOrderByTemp(){
        ModelAndView modelAndView = new ModelAndView("channel");

        FeResponse<List<ChannelVo>> response;

        try{
            List<SunShineChannel> sunShineChannels = channelService.getAllChannelsOrderByTemp();

            List<ChannelVo> channelVos = new LinkedList<ChannelVo>();

            for (SunShineChannel sunShineChannel : sunShineChannels){

                //温度最高话题
                SunChannelTopic sunChannelTopic = topicService.getMaxTempTopic(sunShineChannel.getChannelId());

                //温度最高话题发表用户
                SunShineUser sunShineUser = userService.getUserById(sunChannelTopic.getUserId());

                channelVos.add(Convertor.convertToChannelVo(sunShineChannel, sunChannelTopic, sunShineUser));
            }

            response = new FeResponse<List<ChannelVo>>(HttpStatus.OK.value(),"查询成功",channelVos);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<List<ChannelVo>>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }
        modelAndView.addObject("response",response);

        return modelAndView;
    }
}
