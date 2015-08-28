package com.zhubajie.sunshine.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SunChannelTopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SunChannelTopicExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTopicIdIsNull() {
            addCriterion("topic_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNotNull() {
            addCriterion("topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIdEqualTo(Integer value) {
            addCriterion("topic_id =", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotEqualTo(Integer value) {
            addCriterion("topic_id <>", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThan(Integer value) {
            addCriterion("topic_id >", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_id >=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThan(Integer value) {
            addCriterion("topic_id <", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_id <=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIn(List<Integer> values) {
            addCriterion("topic_id in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotIn(List<Integer> values) {
            addCriterion("topic_id not in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_id between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_id not between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Integer value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Integer value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Integer value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Integer value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Integer> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Integer> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTopicTempIsNull() {
            addCriterion("topic_temp is null");
            return (Criteria) this;
        }

        public Criteria andTopicTempIsNotNull() {
            addCriterion("topic_temp is not null");
            return (Criteria) this;
        }

        public Criteria andTopicTempEqualTo(Integer value) {
            addCriterion("topic_temp =", value, "topicTemp");
            return (Criteria) this;
        }

        public Criteria andTopicTempNotEqualTo(Integer value) {
            addCriterion("topic_temp <>", value, "topicTemp");
            return (Criteria) this;
        }

        public Criteria andTopicTempGreaterThan(Integer value) {
            addCriterion("topic_temp >", value, "topicTemp");
            return (Criteria) this;
        }

        public Criteria andTopicTempGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_temp >=", value, "topicTemp");
            return (Criteria) this;
        }

        public Criteria andTopicTempLessThan(Integer value) {
            addCriterion("topic_temp <", value, "topicTemp");
            return (Criteria) this;
        }

        public Criteria andTopicTempLessThanOrEqualTo(Integer value) {
            addCriterion("topic_temp <=", value, "topicTemp");
            return (Criteria) this;
        }

        public Criteria andTopicTempIn(List<Integer> values) {
            addCriterion("topic_temp in", values, "topicTemp");
            return (Criteria) this;
        }

        public Criteria andTopicTempNotIn(List<Integer> values) {
            addCriterion("topic_temp not in", values, "topicTemp");
            return (Criteria) this;
        }

        public Criteria andTopicTempBetween(Integer value1, Integer value2) {
            addCriterion("topic_temp between", value1, value2, "topicTemp");
            return (Criteria) this;
        }

        public Criteria andTopicTempNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_temp not between", value1, value2, "topicTemp");
            return (Criteria) this;
        }

        public Criteria andTopicNameIsNull() {
            addCriterion("topic_name is null");
            return (Criteria) this;
        }

        public Criteria andTopicNameIsNotNull() {
            addCriterion("topic_name is not null");
            return (Criteria) this;
        }

        public Criteria andTopicNameEqualTo(String value) {
            addCriterion("topic_name =", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotEqualTo(String value) {
            addCriterion("topic_name <>", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameGreaterThan(String value) {
            addCriterion("topic_name >", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameGreaterThanOrEqualTo(String value) {
            addCriterion("topic_name >=", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameLessThan(String value) {
            addCriterion("topic_name <", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameLessThanOrEqualTo(String value) {
            addCriterion("topic_name <=", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameLike(String value) {
            addCriterion("topic_name like", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotLike(String value) {
            addCriterion("topic_name not like", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameIn(List<String> values) {
            addCriterion("topic_name in", values, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotIn(List<String> values) {
            addCriterion("topic_name not in", values, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameBetween(String value1, String value2) {
            addCriterion("topic_name between", value1, value2, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotBetween(String value1, String value2) {
            addCriterion("topic_name not between", value1, value2, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeIsNull() {
            addCriterion("topic_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeIsNotNull() {
            addCriterion("topic_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeEqualTo(Date value) {
            addCriterion("topic_create_time =", value, "topicCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeNotEqualTo(Date value) {
            addCriterion("topic_create_time <>", value, "topicCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeGreaterThan(Date value) {
            addCriterion("topic_create_time >", value, "topicCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("topic_create_time >=", value, "topicCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeLessThan(Date value) {
            addCriterion("topic_create_time <", value, "topicCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("topic_create_time <=", value, "topicCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeIn(List<Date> values) {
            addCriterion("topic_create_time in", values, "topicCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeNotIn(List<Date> values) {
            addCriterion("topic_create_time not in", values, "topicCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeBetween(Date value1, Date value2) {
            addCriterion("topic_create_time between", value1, value2, "topicCreateTime");
            return (Criteria) this;
        }

        public Criteria andTopicCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("topic_create_time not between", value1, value2, "topicCreateTime");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityIsNull() {
            addCriterion("is_anonymity is null");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityIsNotNull() {
            addCriterion("is_anonymity is not null");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityEqualTo(Boolean value) {
            addCriterion("is_anonymity =", value, "isAnonymity");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityNotEqualTo(Boolean value) {
            addCriterion("is_anonymity <>", value, "isAnonymity");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityGreaterThan(Boolean value) {
            addCriterion("is_anonymity >", value, "isAnonymity");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_anonymity >=", value, "isAnonymity");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityLessThan(Boolean value) {
            addCriterion("is_anonymity <", value, "isAnonymity");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityLessThanOrEqualTo(Boolean value) {
            addCriterion("is_anonymity <=", value, "isAnonymity");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityIn(List<Boolean> values) {
            addCriterion("is_anonymity in", values, "isAnonymity");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityNotIn(List<Boolean> values) {
            addCriterion("is_anonymity not in", values, "isAnonymity");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityBetween(Boolean value1, Boolean value2) {
            addCriterion("is_anonymity between", value1, value2, "isAnonymity");
            return (Criteria) this;
        }

        public Criteria andIsAnonymityNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_anonymity not between", value1, value2, "isAnonymity");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}