package com.zhubajie.sunshine.web.service.userservice;

import com.zhubajie.sunshine.web.model.SunShineUser;

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
    boolean addUser(SunShineUser sunShineUser) throws Exception;

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
    SunShineUser queryUserById(Integer userId) throws Exception;

    /**
     * 登录操作
     * @param sunShineUser
     * @return
     * @throws Exception
     */
    boolean login(SunShineUser sunShineUser) throws Exception;
}
