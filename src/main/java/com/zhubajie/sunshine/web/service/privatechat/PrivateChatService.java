package com.zhubajie.sunshine.web.service.privatechat;

import com.zhubajie.sunshine.web.model.SunPrivateChat;

import java.util.List;

/**
 * 私聊接口
 * Created by huanglei on 2015/8/28.
 */
public interface PrivateChatService {
    /**
     * 发送私聊
     * @param sunPrivateChat
     * @throws Exception
     */
    void sendPrivateChat(SunPrivateChat sunPrivateChat) throws Exception;

    /**
     * 阅读私聊内容
     * @param sunPrivateChat
     * @throws Exception
     */
    void readPrivateChat(SunPrivateChat sunPrivateChat) throws Exception;

    /**
     * 得到用户下面的所有聊天记录
     * @param userId
     * @return
     * @throws Exception
     */
    List<SunPrivateChat> getChatsByUserId(Integer userId) throws Exception;
}
