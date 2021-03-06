package com.zhubajie.sunshine.web.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhubajie.sunshine.core.convertor.Convertor;
import com.zhubajie.sunshine.core.entity.FeResponse;
import com.zhubajie.sunshine.core.util.DateStyle;
import com.zhubajie.sunshine.core.util.DateUtil;
import com.zhubajie.sunshine.web.model.SunAnswerThank;
import com.zhubajie.sunshine.web.model.SunShineUser;
import com.zhubajie.sunshine.web.model.SunTopicAnswer;
import com.zhubajie.sunshine.web.service.answerservice.AnswerService;
import com.zhubajie.sunshine.web.service.userservice.UserService;
import com.zhubajie.sunshine.web.vo.AnswerVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.Sun;

import javax.annotation.Resource;
import java.util.List;

/**
 * 回答Controller
 * Created by huanglei on 2015/8/28.
 */
@Controller
@RequestMapping("/sunAnswer")
public class SunAnswerController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "answerService")   //回复
    private AnswerService answerService;

    @Resource(name = "userService")     //用户
    private UserService userService;

    /**
     * 回复话题
     * @param sunTopicAnswer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/answerTopic", method = RequestMethod.POST)
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
    @RequestMapping(value = "/thankAnswer", method = RequestMethod.POST)
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
    @RequestMapping(value = "/hasThankedAnswer",method = RequestMethod.POST)
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

    /**
     * 得到话题所有答案，按温度排序
     * @param topicId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryAnswersByTopicIdOrderByTemp/{topicId}",method = RequestMethod.GET)
    public FeResponse<List> queryAnswersByTopicIdOrderByTemp(@PathVariable String topicId){
        FeResponse<List> response;

        try {
            List<SunTopicAnswer> sunTopicAnswers = answerService.queryAnswersByTopicIdOrderByTemp(Integer.parseInt(topicId));
            response = new FeResponse<List>(HttpStatus.OK.value(),"查询成功",sunTopicAnswers);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<List>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }

        return response;
    }

    /**
     * 得到温度最高的答复
     * @param topicId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryMaxTempAnswerByTopicId/{topicId}",method = RequestMethod.GET)
    public FeResponse<SunTopicAnswer> queryMaxTempAnswerByTopicId(@PathVariable String topicId){
        FeResponse<SunTopicAnswer> response;

        try {
            List<SunTopicAnswer> sunTopicAnswers = answerService.queryAnswersByTopicIdOrderByTemp(Integer.parseInt(topicId));
            if (sunTopicAnswers.size() == 0){
                response = new FeResponse<SunTopicAnswer>(HttpStatus.OK.value(),"查询成功",null);
            }else {
                response = new FeResponse<SunTopicAnswer>(HttpStatus.OK.value(),"查询成功",sunTopicAnswers.get(sunTopicAnswers.size()-1));
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<SunTopicAnswer>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);

        }

        return response;
    }

    /**
     * 根据id获取回复
     * @param topicAnswerId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAnswerById/{topicAnswerId}",method = RequestMethod.GET)
    public ModelAndView getAnswerById(@PathVariable String topicAnswerId){
        ModelAndView modelAndView = new ModelAndView("answer-detail");

        FeResponse<AnswerVo> response;

        try {
            SunTopicAnswer answer = answerService.getAnswerById(Integer.parseInt(topicAnswerId));

            SunShineUser userAnswer = userService.getUserById(answer.getUserId());

            //时间格式转换
            answer.setTopicAnswerTime(DateUtil.parseDate(DateUtil.formateDate(answer.getTopicAnswerTime(), DateStyle.YYYY_MM_DD_CN.getValue()),DateStyle.YYYY_MM_DD_CN.getValue()));

            response = new FeResponse<AnswerVo>(HttpStatus.OK.value(),"查找成功",Convertor.convertToAnswerVo(answer, userAnswer));
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<AnswerVo>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }

        modelAndView.addObject("answerDetailRes", response);

        return modelAndView;
    }

}
