package com.zhubajie.sunshine.web.service.answerservice;

import com.zhubajie.sunshine.web.model.SunTopicAnswer;

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
}
