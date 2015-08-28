package com.zhubajie.sunshine.web.service.channelservice.impl;

import com.zhubajie.sunshine.core.constant.DatabaseParamConstant;
import com.zhubajie.sunshine.web.mapper.SunShineChannelMapper;
import com.zhubajie.sunshine.web.model.SunShineChannel;
import com.zhubajie.sunshine.web.model.SunShineChannelExample;
import com.zhubajie.sunshine.web.service.channelservice.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 频道接口实现类
 * Created by huanglei on 2015/8/28.
 */
@Service("channleService")
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private SunShineChannelMapper sunShineChannelMapper;

    /**
     * 根据频道温度排序获取所有频道
     * @return
     * @throws Exception
     */
    @Override
    public List<SunShineChannel> getAllChannelsOrderByTemp() throws Exception {

        SunShineChannelExample sunShineChannelExample = new SunShineChannelExample();
        sunShineChannelExample.setOrderByClause(DatabaseParamConstant.CHANNEL_TEMP);

        return sunShineChannelMapper.selectByExample(sunShineChannelExample);
    }
}
