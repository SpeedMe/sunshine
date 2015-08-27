package com.zhubajie.sunshine.web.mapper;

import com.zhubajie.sunshine.web.model.SunChannelTopic;
import com.zhubajie.sunshine.web.model.SunChannelTopicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SunChannelTopicMapper {
    int countByExample(SunChannelTopicExample example);

    int deleteByExample(SunChannelTopicExample example);

    int deleteByPrimaryKey(Integer topicId);

    int insert(SunChannelTopic record);

    int insertSelective(SunChannelTopic record);

    List<SunChannelTopic> selectByExampleWithBLOBs(SunChannelTopicExample example);

    List<SunChannelTopic> selectByExample(SunChannelTopicExample example);

    SunChannelTopic selectByPrimaryKey(Integer topicId);

    int updateByExampleSelective(@Param("record") SunChannelTopic record, @Param("example") SunChannelTopicExample example);

    int updateByExampleWithBLOBs(@Param("record") SunChannelTopic record, @Param("example") SunChannelTopicExample example);

    int updateByExample(@Param("record") SunChannelTopic record, @Param("example") SunChannelTopicExample example);

    int updateByPrimaryKeySelective(SunChannelTopic record);

    int updateByPrimaryKeyWithBLOBs(SunChannelTopic record);

    int updateByPrimaryKey(SunChannelTopic record);
}