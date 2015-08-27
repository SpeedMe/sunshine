package com.zhubajie.sunshine.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SunAnswerThankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SunAnswerThankExample() {
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

        public Criteria andAnswerThankIdIsNull() {
            addCriterion("answer_thank_id is null");
            return (Criteria) this;
        }

        public Criteria andAnswerThankIdIsNotNull() {
            addCriterion("answer_thank_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerThankIdEqualTo(Integer value) {
            addCriterion("answer_thank_id =", value, "answerThankId");
            return (Criteria) this;
        }

        public Criteria andAnswerThankIdNotEqualTo(Integer value) {
            addCriterion("answer_thank_id <>", value, "answerThankId");
            return (Criteria) this;
        }

        public Criteria andAnswerThankIdGreaterThan(Integer value) {
            addCriterion("answer_thank_id >", value, "answerThankId");
            return (Criteria) this;
        }

        public Criteria andAnswerThankIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_thank_id >=", value, "answerThankId");
            return (Criteria) this;
        }

        public Criteria andAnswerThankIdLessThan(Integer value) {
            addCriterion("answer_thank_id <", value, "answerThankId");
            return (Criteria) this;
        }

        public Criteria andAnswerThankIdLessThanOrEqualTo(Integer value) {
            addCriterion("answer_thank_id <=", value, "answerThankId");
            return (Criteria) this;
        }

        public Criteria andAnswerThankIdIn(List<Integer> values) {
            addCriterion("answer_thank_id in", values, "answerThankId");
            return (Criteria) this;
        }

        public Criteria andAnswerThankIdNotIn(List<Integer> values) {
            addCriterion("answer_thank_id not in", values, "answerThankId");
            return (Criteria) this;
        }

        public Criteria andAnswerThankIdBetween(Integer value1, Integer value2) {
            addCriterion("answer_thank_id between", value1, value2, "answerThankId");
            return (Criteria) this;
        }

        public Criteria andAnswerThankIdNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_thank_id not between", value1, value2, "answerThankId");
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

        public Criteria andThankTimeIsNull() {
            addCriterion("thank_time is null");
            return (Criteria) this;
        }

        public Criteria andThankTimeIsNotNull() {
            addCriterion("thank_time is not null");
            return (Criteria) this;
        }

        public Criteria andThankTimeEqualTo(Date value) {
            addCriterion("thank_time =", value, "thankTime");
            return (Criteria) this;
        }

        public Criteria andThankTimeNotEqualTo(Date value) {
            addCriterion("thank_time <>", value, "thankTime");
            return (Criteria) this;
        }

        public Criteria andThankTimeGreaterThan(Date value) {
            addCriterion("thank_time >", value, "thankTime");
            return (Criteria) this;
        }

        public Criteria andThankTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("thank_time >=", value, "thankTime");
            return (Criteria) this;
        }

        public Criteria andThankTimeLessThan(Date value) {
            addCriterion("thank_time <", value, "thankTime");
            return (Criteria) this;
        }

        public Criteria andThankTimeLessThanOrEqualTo(Date value) {
            addCriterion("thank_time <=", value, "thankTime");
            return (Criteria) this;
        }

        public Criteria andThankTimeIn(List<Date> values) {
            addCriterion("thank_time in", values, "thankTime");
            return (Criteria) this;
        }

        public Criteria andThankTimeNotIn(List<Date> values) {
            addCriterion("thank_time not in", values, "thankTime");
            return (Criteria) this;
        }

        public Criteria andThankTimeBetween(Date value1, Date value2) {
            addCriterion("thank_time between", value1, value2, "thankTime");
            return (Criteria) this;
        }

        public Criteria andThankTimeNotBetween(Date value1, Date value2) {
            addCriterion("thank_time not between", value1, value2, "thankTime");
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