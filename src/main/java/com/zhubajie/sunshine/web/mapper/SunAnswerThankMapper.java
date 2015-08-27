package com.zhubajie.sunshine.web.mapper;

import com.zhubajie.sunshine.web.model.SunAnswerThank;
import com.zhubajie.sunshine.web.model.SunAnswerThankExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SunAnswerThankMapper {
    int countByExample(SunAnswerThankExample example);

    int deleteByExample(SunAnswerThankExample example);

    int deleteByPrimaryKey(Integer answerThankId);

    int insert(SunAnswerThank record);

    int insertSelective(SunAnswerThank record);

    List<SunAnswerThank> selectByExample(SunAnswerThankExample example);

    SunAnswerThank selectByPrimaryKey(Integer answerThankId);

    int updateByExampleSelective(@Param("record") SunAnswerThank record, @Param("example") SunAnswerThankExample example);

    int updateByExample(@Param("record") SunAnswerThank record, @Param("example") SunAnswerThankExample example);

    int updateByPrimaryKeySelective(SunAnswerThank record);

    int updateByPrimaryKey(SunAnswerThank record);
}