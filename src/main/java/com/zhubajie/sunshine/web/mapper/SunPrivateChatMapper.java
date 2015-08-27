package com.zhubajie.sunshine.web.mapper;

import com.zhubajie.sunshine.web.model.SunPrivateChat;
import com.zhubajie.sunshine.web.model.SunPrivateChatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SunPrivateChatMapper {
    int countByExample(SunPrivateChatExample example);

    int deleteByExample(SunPrivateChatExample example);

    int deleteByPrimaryKey(Integer privateChatId);

    int insert(SunPrivateChat record);

    int insertSelective(SunPrivateChat record);

    List<SunPrivateChat> selectByExample(SunPrivateChatExample example);

    SunPrivateChat selectByPrimaryKey(Integer privateChatId);

    int updateByExampleSelective(@Param("record") SunPrivateChat record, @Param("example") SunPrivateChatExample example);

    int updateByExample(@Param("record") SunPrivateChat record, @Param("example") SunPrivateChatExample example);

    int updateByPrimaryKeySelective(SunPrivateChat record);

    int updateByPrimaryKey(SunPrivateChat record);
}