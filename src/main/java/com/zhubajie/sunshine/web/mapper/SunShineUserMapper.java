package com.zhubajie.sunshine.web.mapper;

import com.zhubajie.sunshine.web.model.SunShineUser;
import com.zhubajie.sunshine.web.model.SunShineUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SunShineUserMapper {
    int countByExample(SunShineUserExample example);

    int deleteByExample(SunShineUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SunShineUser record);

    int insertSelective(SunShineUser record);

    List<SunShineUser> selectByExample(SunShineUserExample example);

    SunShineUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SunShineUser record, @Param("example") SunShineUserExample example);

    int updateByExample(@Param("record") SunShineUser record, @Param("example") SunShineUserExample example);

    int updateByPrimaryKeySelective(SunShineUser record);

    int updateByPrimaryKey(SunShineUser record);
}