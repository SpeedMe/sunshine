package com.zhubajie.sunshine.web.service.answerservice;

import com.zhubajie.sunshine.web.model.SunAnswerThank;
import com.zhubajie.sunshine.web.model.SunTopicAnswer;

import java.util.List;

/**
 * 话题回复接口
 * Created by huanglei on 2015/8/28.
 */
public interface AnswerService {
    /**
     * 回复话题
     * @param sunTopicAnswer
     * @return
     * @throws Exception
     */
    boolean answerTopic(SunTopicAnswer sunTopicAnswer) throws Exception;

    /**
     * 根据id获取回答信息
     * @param topicAnswerId
     * @return
     * @throws Exception
     */
    SunTopicAnswer getAnswerById(Integer topicAnswerId) throws Exception;

    /**
     * 感谢回答
     * @param sunAnswerThank
     * @return
     * @throws Exception
     */
    SunAnswerThank thankAnswer(SunAnswerThank sunAnswerThank) throws Exception;

    /**
     * 是否已感谢回答
     * @param sunAnswerThank
     * @return
     * @throws Exception
     */
    boolean hasThankedAnswer(SunAnswerThank sunAnswerThank) throws Exception;

    /**
     * 得到话题回答数量
     * @param topicId
     * @return
     * @throws Exception
     */
    Integer countTopicAnswer(Integer topicId) throws Exception;

    List<SunTopicAnswer> queryAnswersByTopicIdOrderByTemp(Integer topicId) throws Exception;

    /**
     * 得到话题温度最高的回答
     * @param topicId
     * @return
     * @throws Exception
     */
    SunTopicAnswer getMaxTempAnswer(Integer topicId) throws Exception;
}
