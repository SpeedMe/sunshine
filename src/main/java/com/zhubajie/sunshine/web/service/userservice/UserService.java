package com.zhubajie.sunshine.web.service.userservice;

import com.zhubajie.sunshine.web.model.SunShineUser;

import java.util.List;

/**
 * 用户操作接口
 * Created by huanglei on 2015/8/28.
 */
public interface UserService {
    /**
     * 添加用户
     * @param sunShineUser 用户实体
     * @throws Exception
     */
    SunShineUser addUser(SunShineUser sunShineUser) throws Exception;

    /**
     * 更新用户信息
     * @param sunShineUser 用户实体
     * @throws Exception
     */
    boolean updateUser(SunShineUser sunShineUser) throws Exception;

    /**
     * 根据id查找用户
     * @param userId 用户id
     * @return 用户实体
     * @throws Exception
     */
    SunShineUser getUserById(Integer userId) throws Exception;

    /**
     * 登录操作
     * @param sunShineUser
     * @return
     * @throws Exception
     */
    SunShineUser login(SunShineUser sunShineUser) throws Exception;

    /**
     * 模糊查询用户
     * @param nickname
     * @return
     * @throws Exception
     */
    List<SunShineUser> queryUserByName(String nickname) throws Exception;
}
