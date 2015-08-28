package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.core.entity.FeResponse;
import com.zhubajie.sunshine.web.model.SunShineChannel;
import com.zhubajie.sunshine.web.service.channelservice.ChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 频道Controller
 * Created by huanglei on 2015/8/28.
 */
@Controller
@RequestMapping("/sunChannel")
public class SunChannelController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "channleService")
    private ChannelService channelService;

    /**
     * 根据温度排序得到所有频道内容
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllChannelsOrderByTemp", method = RequestMethod.GET)
    public FeResponse<List> getAllChannelsOrderByTemp(){
        FeResponse<List> response;

        try{
            List<SunShineChannel> sunShineChannels = channelService.getAllChannelsOrderByTemp();
            response = new FeResponse<List>(HttpStatus.OK.value(),"查询成功",sunShineChannels);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<List>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }

        return response;
    }
}
