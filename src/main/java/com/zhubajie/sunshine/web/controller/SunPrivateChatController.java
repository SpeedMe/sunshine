package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.core.entity.FeResponse;
import com.zhubajie.sunshine.web.model.SunPrivateChat;
import com.zhubajie.sunshine.web.service.privatechat.PrivateChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.swing.text.html.HTML;
import java.util.List;

/**
 * 聊天Controller
 * Created by huanglei on 2015/8/28.
 */
@Controller
@RequestMapping("/privateChat")
public class SunPrivateChatController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "privateChatService")
    private PrivateChatService privateChatService;

    /**
     * 发送聊天消息
     * @param sunPrivateChat
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sendPrivateChat", method = RequestMethod.POST)
    public FeResponse<String> sendPrivateChat(SunPrivateChat sunPrivateChat){
        FeResponse<String> response;

        try{
            privateChatService.sendPrivateChat(sunPrivateChat);
            response = new FeResponse<String>(HttpStatus.OK.value(),"发送成功","success");
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<String>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }

        return response;
    }

    /**
     * 阅读聊天记录
     * @param sunPrivateChat
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/readPrivateChat",method = RequestMethod.POST)
    public FeResponse<String> readPrivateChat(SunPrivateChat sunPrivateChat){
        FeResponse<String> response;

        try{
            privateChatService.readPrivateChat(sunPrivateChat);
            response = new FeResponse<String>(HttpStatus.OK.value(),"成功阅读","success");
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<String>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }
        return response;
    }

    /**
     * 得到用户的聊天记录
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getChatsByUserId/{userId}",method = RequestMethod.GET)
    public FeResponse<List> getChatsByUserId(@PathVariable String userId){
        FeResponse<List> response;

        try{
            List<SunPrivateChat> sunPrivateChats = privateChatService.getChatsByUserId(Integer.parseInt(userId));
            response = new FeResponse<List>(HttpStatus.OK.value(),"查找成功",sunPrivateChats);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<List>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }
        return response;
    }
}
