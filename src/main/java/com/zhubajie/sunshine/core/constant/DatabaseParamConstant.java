package com.zhubajie.sunshine.core.constant;

/**
 * 数据库字段名称
 * Created by huanglei on 2015/8/28.
 */
public class DatabaseParamConstant {

    //频道温度
    public final static String CHANNEL_TEMP = "channel_temp desc";

    //话题温度
    public final static String TOPIC_TEMP = "topic_temp desc";

    //回复温度
    public final static String ANSWER_TEMP = "topic_answer_temp desc";

    //最高频道温度
    public final static String CHANNEL_TEMP_Max = "channel_temp desc limit 1";

    //最高话题温度
    public final static String TOPIC_TEMP_Max = "topic_temp desc limit 1";

    //最高回复温度
    public final static String ANSWER_TEMP_Max = "topic_answer_temp desc limit 1";
}
