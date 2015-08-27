package com.zhubajie.sunshine.web.mapper;

import com.zhubajie.sunshine.web.model.SunTopicAttention;
import com.zhubajie.sunshine.web.model.SunTopicAttentionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SunTopicAttentionMapper {
    int countByExample(SunTopicAttentionExample example);

    int deleteByExample(SunTopicAttentionExample example);

    int deleteByPrimaryKey(Integer topicAttentionId);

    int insert(SunTopicAttention record);

    int insertSelective(SunTopicAttention record);

    List<SunTopicAttention> selectByExample(SunTopicAttentionExample example);

    SunTopicAttention selectByPrimaryKey(Integer topicAttentionId);

    int updateByExampleSelective(@Param("record") SunTopicAttention record, @Param("example") SunTopicAttentionExample example);

    int updateByExample(@Param("record") SunTopicAttention record, @Param("example") SunTopicAttentionExample example);

    int updateByPrimaryKeySelective(SunTopicAttention record);

    int updateByPrimaryKey(SunTopicAttention record);
}