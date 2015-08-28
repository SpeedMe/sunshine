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
    public SunShineUser addUser(SunShineUser sunShineUser) throws Exception {

        if (existEmailOrNickname(sunShineUser)){
            throw new Exception("已经存在此用户名或者邮箱");
        }
        sunShineUserMapper.insertSelective(sunShineUser);
        return sunShineUser;
    }

    /**
     * 是否已经存在此用户名或者邮箱
     * @param sunShineUser
     * @return
     * @throws Exception
     */
    private boolean existEmailOrNickname(SunShineUser sunShineUser) throws Exception{
        SunShineUserExample sunShineUserExample = new SunShineUserExample();
        sunShineUserExample.or().andNicknameEqualTo(sunShineUser.getNickname());
        sunShineUserExample.or().andEmailEqualTo(sunShineUser.getEmail());

        return sunShineUserMapper.selectByExample(sunShineUserExample).size() == 0 ? false :true;
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
    public SunShineUser login(SunShineUser sunShineUser) throws Exception {
        SunShineUserExample sunShineUserExample = new SunShineUserExample();
        sunShineUserExample.createCriteria().andNicknameEqualTo(sunShineUser.getNickname());

        List<SunShineUser> userRealList = sunShineUserMapper.selectByExample(sunShineUserExample);

        if (userRealList.size() == 0){
            throw new Exception("不存在此用户名");
        }

        if (!sunShineUser.getPassword().equals(userRealList.get(0).getPassword())){
            throw new Exception("密码错误");
        }

        return userRealList.get(0);
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
