package com.zhubajie.sunshine.web.mapper;

import com.zhubajie.sunshine.web.model.SunTopicAnswer;
import com.zhubajie.sunshine.web.model.SunTopicAnswerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SunTopicAnswerMapper {
    int countByExample(SunTopicAnswerExample example);

    int deleteByExample(SunTopicAnswerExample example);

    int deleteByPrimaryKey(Integer topicAnswerId);

    int insert(SunTopicAnswer record);

    int insertSelective(SunTopicAnswer record);

    List<SunTopicAnswer> selectByExample(SunTopicAnswerExample example);

    SunTopicAnswer selectByPrimaryKey(Integer topicAnswerId);

    int updateByExampleSelective(@Param("record") SunTopicAnswer record, @Param("example") SunTopicAnswerExample example);

    int updateByExample(@Param("record") SunTopicAnswer record, @Param("example") SunTopicAnswerExample example);

    int updateByPrimaryKeySelective(SunTopicAnswer record);

    int updateByPrimaryKey(SunTopicAnswer record);
}