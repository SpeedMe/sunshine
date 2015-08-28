package com.zhubajie.sunshine.web.mapper.custom;

import com.zhubajie.sunshine.web.model.SunShineChannel;

import java.util.List;

/**
 * 自定义频道Mapper
 * Created by huanglei on 2015/8/28.
 */
public interface ChannelCustomMapper {
    List<SunShineChannel> getAllChannelsOrderByTemp();
}
