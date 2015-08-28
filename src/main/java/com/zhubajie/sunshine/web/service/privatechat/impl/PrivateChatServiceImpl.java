package com.zhubajie.sunshine.web.service.privatechat.impl;

import com.zhubajie.sunshine.web.mapper.SunPrivateChatMapper;
import com.zhubajie.sunshine.web.model.SunPrivateChat;
import com.zhubajie.sunshine.web.model.SunPrivateChatExample;
import com.zhubajie.sunshine.web.service.privatechat.PrivateChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 私聊接口实现类
 * Created by huanglei on 2015/8/28.
 */
@Service("privateChatService")
public class PrivateChatServiceImpl implements PrivateChatService {

    @Autowired  //私聊
    private SunPrivateChatMapper sunPrivateChatMapper;

    /**
     * 发送私聊
     * @param sunPrivateChat
     * @throws Exception
     */
    @Override
    public void sendPrivateChat(SunPrivateChat sunPrivateChat) throws Exception {
        //插入私聊内容表
        sunPrivateChatMapper.insertSelective(sunPrivateChat);
    }

    /**
     * 阅读消息
     * @param sunPrivateChat
     * @throws Exception
     */
    @Override
    public void readPrivateChat(SunPrivateChat sunPrivateChat) throws Exception {
        sunPrivateChat.setIsReaded(true);

        sunPrivateChatMapper.updateByPrimaryKey(sunPrivateChat);
    }

    /**
     * 得到某用户下面的所有聊天记录
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<SunPrivateChat> getChatsByUserId(Integer userId) throws Exception {
        SunPrivateChatExample sunPrivateChatExample = new SunPrivateChatExample();

        sunPrivateChatExample.or().andSendUserIdEqualTo(userId);
        sunPrivateChatExample.or().andReceiveUserIdEqualTo(userId);

        return sunPrivateChatMapper.selectByExample(sunPrivateChatExample);
    }


}
