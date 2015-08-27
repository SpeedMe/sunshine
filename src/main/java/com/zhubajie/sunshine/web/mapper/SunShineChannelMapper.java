package com.zhubajie.sunshine.web.mapper;

import com.zhubajie.sunshine.web.model.SunShineChannel;
import com.zhubajie.sunshine.web.model.SunShineChannelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SunShineChannelMapper {
    int countByExample(SunShineChannelExample example);

    int deleteByExample(SunShineChannelExample example);

    int deleteByPrimaryKey(Integer channelId);

    int insert(SunShineChannel record);

    int insertSelective(SunShineChannel record);

    List<SunShineChannel> selectByExample(SunShineChannelExample example);

    SunShineChannel selectByPrimaryKey(Integer channelId);

    int updateByExampleSelective(@Param("record") SunShineChannel record, @Param("example") SunShineChannelExample example);

    int updateByExample(@Param("record") SunShineChannel record, @Param("example") SunShineChannelExample example);

    int updateByPrimaryKeySelective(SunShineChannel record);

    int updateByPrimaryKey(SunShineChannel record);
}