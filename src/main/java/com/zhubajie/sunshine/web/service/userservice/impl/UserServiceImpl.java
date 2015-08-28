package com.zhubajie.sunshine.web.service.userservice.impl;

import com.zhubajie.sunshine.web.mapper.SunShineUserMapper;
import com.zhubajie.sunshine.web.model.SunShineUser;
import com.zhubajie.sunshine.web.model.SunShineUserExample;
import com.zhubajie.sunshine.web.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户操作接口实现类
 * Created by huanglei on 2015/8/28.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private SunShineUserMapper sunShineUserMapper;

    @Override
    public boolean addUser(SunShineUser sunShineUser) throws Exception {
        return sunShineUserMapper.insertSelective(sunShineUser) == 1 ? true :false;
    }

    @Override
    public boolean updateUser(SunShineUser sunShineUser) throws Exception {
        return sunShineUserMapper.updateByPrimaryKeySelective(sunShineUser) == 1 ? true : false;
    }

    @Override
    public SunShineUser getUserById(Integer userId) throws Exception {
        return sunShineUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public boolean login(SunShineUser sunShineUser) throws Exception {
        SunShineUserExample sunShineUserExample = new SunShineUserExample();
        sunShineUserExample.createCriteria().andNicknameEqualTo(sunShineUser.getNickname());

        List<SunShineUser> userRealList = sunShineUserMapper.selectByExample(sunShineUserExample);

        if (userRealList.size() == 0){
            throw new Exception("不存在此用户名");
        }

        if (!sunShineUser.getPassword().equals(userRealList.get(0).getPassword())){
            throw new Exception("密码错误");
        }

        return true;
    }

    /**
     * 根据名字模糊查询用户
     * @param nickname
     * @return
     * @throws Exception
     */
    @Override
    public List<SunShineUser> queryUserByName(String nickname) throws Exception {
        SunShineUserExample sunShineUserExample = new SunShineUserExample();
        sunShineUserExample.createCriteria().andNicknameLike("%" + nickname + "%");

        return sunShineUserMapper.selectByExample(sunShineUserExample);
    }


}
