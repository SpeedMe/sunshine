package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.web.service.privatechat.PrivateChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
}
