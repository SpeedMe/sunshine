package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.core.entity.FeResponse;
import com.zhubajie.sunshine.web.model.SunAnswerThank;
import com.zhubajie.sunshine.web.model.SunTopicAnswer;
import com.zhubajie.sunshine.web.service.answerservice.AnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * 回复话题
     * @param sunTopicAnswer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public FeResponse<Boolean> answerTopic(SunTopicAnswer sunTopicAnswer){
        FeResponse<Boolean> response;

        try{
            boolean success = answerService.answerTopic(sunTopicAnswer);
            response = new FeResponse<Boolean>(HttpStatus.OK.value(),"回复成功",success);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<Boolean>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }
        return response;
    }

    /**
     * 感谢回复
     * @param sunAnswerThank
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public FeResponse<SunAnswerThank> thankAnswer(SunAnswerThank sunAnswerThank){
        FeResponse<SunAnswerThank> response;

        try{
            SunAnswerThank sunAnswerThankReal = answerService.thankAnswer(sunAnswerThank);

            response = new FeResponse<SunAnswerThank>(HttpStatus.OK.value(),"感谢成功",sunAnswerThankReal);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<SunAnswerThank>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }

        return response;
    }

    /**
     * 是否已经感谢回复
     * @param sunAnswerThank
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.POST)
    public FeResponse<Boolean> hasThankedAnswer(SunAnswerThank sunAnswerThank){
        FeResponse<Boolean> response;

        try{
            boolean hasThankedAnswer = answerService.hasThankedAnswer(sunAnswerThank);

            response = new FeResponse<Boolean>(HttpStatus.OK.value(),"操作成功",hasThankedAnswer);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<Boolean>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }

        return response;
    }

}
