package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.web.service.answerservice.AnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 回答Controller
 * Created by huanglei on 2015/8/28.
 */
@Controller
@RequestMapping("/sunAnswer")
public class SunAnswerController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "answerService")
    private AnswerService answerService;

}
