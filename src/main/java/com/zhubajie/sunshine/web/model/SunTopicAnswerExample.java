package com.zhubajie.sunshine.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SunTopicAnswerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SunTopicAnswerExample() {
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

        public Criteria andTopicAnswerIdIsNull() {
            addCriterion("topic_answer_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerIdIsNotNull() {
            addCriterion("topic_answer_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerIdEqualTo(Integer value) {
            addCriterion("topic_answer_id =", value, "topicAnswerId");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerIdNotEqualTo(Integer value) {
            addCriterion("topic_answer_id <>", value, "topicAnswerId");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerIdGreaterThan(Integer value) {
            addCriterion("topic_answer_id >", value, "topicAnswerId");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_answer_id >=", value, "topicAnswerId");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerIdLessThan(Integer value) {
            addCriterion("topic_answer_id <", value, "topicAnswerId");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_answer_id <=", value, "topicAnswerId");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerIdIn(List<Integer> values) {
            addCriterion("topic_answer_id in", values, "topicAnswerId");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerIdNotIn(List<Integer> values) {
            addCriterion("topic_answer_id not in", values, "topicAnswerId");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_answer_id between", value1, value2, "topicAnswerId");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_answer_id not between", value1, value2, "topicAnswerId");
            return (Criteria) this;
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

        public Criteria andTopicAnswerTempIsNull() {
            addCriterion("topic_answer_temp is null");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTempIsNotNull() {
            addCriterion("topic_answer_temp is not null");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTempEqualTo(Integer value) {
            addCriterion("topic_answer_temp =", value, "topicAnswerTemp");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTempNotEqualTo(Integer value) {
            addCriterion("topic_answer_temp <>", value, "topicAnswerTemp");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTempGreaterThan(Integer value) {
            addCriterion("topic_answer_temp >", value, "topicAnswerTemp");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTempGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_answer_temp >=", value, "topicAnswerTemp");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTempLessThan(Integer value) {
            addCriterion("topic_answer_temp <", value, "topicAnswerTemp");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTempLessThanOrEqualTo(Integer value) {
            addCriterion("topic_answer_temp <=", value, "topicAnswerTemp");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTempIn(List<Integer> values) {
            addCriterion("topic_answer_temp in", values, "topicAnswerTemp");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTempNotIn(List<Integer> values) {
            addCriterion("topic_answer_temp not in", values, "topicAnswerTemp");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTempBetween(Integer value1, Integer value2) {
            addCriterion("topic_answer_temp between", value1, value2, "topicAnswerTemp");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTempNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_answer_temp not between", value1, value2, "topicAnswerTemp");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeIsNull() {
            addCriterion("topic_answer_time is null");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeIsNotNull() {
            addCriterion("topic_answer_time is not null");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeEqualTo(Date value) {
            addCriterion("topic_answer_time =", value, "topicAnswerTime");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeNotEqualTo(Date value) {
            addCriterion("topic_answer_time <>", value, "topicAnswerTime");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeGreaterThan(Date value) {
            addCriterion("topic_answer_time >", value, "topicAnswerTime");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("topic_answer_time >=", value, "topicAnswerTime");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeLessThan(Date value) {
            addCriterion("topic_answer_time <", value, "topicAnswerTime");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeLessThanOrEqualTo(Date value) {
            addCriterion("topic_answer_time <=", value, "topicAnswerTime");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeIn(List<Date> values) {
            addCriterion("topic_answer_time in", values, "topicAnswerTime");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeNotIn(List<Date> values) {
            addCriterion("topic_answer_time not in", values, "topicAnswerTime");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeBetween(Date value1, Date value2) {
            addCriterion("topic_answer_time between", value1, value2, "topicAnswerTime");
            return (Criteria) this;
        }

        public Criteria andTopicAnswerTimeNotBetween(Date value1, Date value2) {
            addCriterion("topic_answer_time not between", value1, value2, "topicAnswerTime");
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