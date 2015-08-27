package com.zhubajie.sunshine.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SunPrivateChatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SunPrivateChatExample() {
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

        public Criteria andPrivateChatIdIsNull() {
            addCriterion("private_chat_id is null");
            return (Criteria) this;
        }

        public Criteria andPrivateChatIdIsNotNull() {
            addCriterion("private_chat_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateChatIdEqualTo(Integer value) {
            addCriterion("private_chat_id =", value, "privateChatId");
            return (Criteria) this;
        }

        public Criteria andPrivateChatIdNotEqualTo(Integer value) {
            addCriterion("private_chat_id <>", value, "privateChatId");
            return (Criteria) this;
        }

        public Criteria andPrivateChatIdGreaterThan(Integer value) {
            addCriterion("private_chat_id >", value, "privateChatId");
            return (Criteria) this;
        }

        public Criteria andPrivateChatIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("private_chat_id >=", value, "privateChatId");
            return (Criteria) this;
        }

        public Criteria andPrivateChatIdLessThan(Integer value) {
            addCriterion("private_chat_id <", value, "privateChatId");
            return (Criteria) this;
        }

        public Criteria andPrivateChatIdLessThanOrEqualTo(Integer value) {
            addCriterion("private_chat_id <=", value, "privateChatId");
            return (Criteria) this;
        }

        public Criteria andPrivateChatIdIn(List<Integer> values) {
            addCriterion("private_chat_id in", values, "privateChatId");
            return (Criteria) this;
        }

        public Criteria andPrivateChatIdNotIn(List<Integer> values) {
            addCriterion("private_chat_id not in", values, "privateChatId");
            return (Criteria) this;
        }

        public Criteria andPrivateChatIdBetween(Integer value1, Integer value2) {
            addCriterion("private_chat_id between", value1, value2, "privateChatId");
            return (Criteria) this;
        }

        public Criteria andPrivateChatIdNotBetween(Integer value1, Integer value2) {
            addCriterion("private_chat_id not between", value1, value2, "privateChatId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdIsNull() {
            addCriterion("send_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSendUserIdIsNotNull() {
            addCriterion("send_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendUserIdEqualTo(Integer value) {
            addCriterion("send_user_id =", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdNotEqualTo(Integer value) {
            addCriterion("send_user_id <>", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdGreaterThan(Integer value) {
            addCriterion("send_user_id >", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_user_id >=", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdLessThan(Integer value) {
            addCriterion("send_user_id <", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("send_user_id <=", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdIn(List<Integer> values) {
            addCriterion("send_user_id in", values, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdNotIn(List<Integer> values) {
            addCriterion("send_user_id not in", values, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdBetween(Integer value1, Integer value2) {
            addCriterion("send_user_id between", value1, value2, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("send_user_id not between", value1, value2, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIsNull() {
            addCriterion("receive_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIsNotNull() {
            addCriterion("receive_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdEqualTo(Integer value) {
            addCriterion("receive_user_id =", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotEqualTo(Integer value) {
            addCriterion("receive_user_id <>", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdGreaterThan(Integer value) {
            addCriterion("receive_user_id >", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_user_id >=", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdLessThan(Integer value) {
            addCriterion("receive_user_id <", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("receive_user_id <=", value, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdIn(List<Integer> values) {
            addCriterion("receive_user_id in", values, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotIn(List<Integer> values) {
            addCriterion("receive_user_id not in", values, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdBetween(Integer value1, Integer value2) {
            addCriterion("receive_user_id between", value1, value2, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andReceiveUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_user_id not between", value1, value2, "receiveUserId");
            return (Criteria) this;
        }

        public Criteria andChatContentIsNull() {
            addCriterion("chat_content is null");
            return (Criteria) this;
        }

        public Criteria andChatContentIsNotNull() {
            addCriterion("chat_content is not null");
            return (Criteria) this;
        }

        public Criteria andChatContentEqualTo(String value) {
            addCriterion("chat_content =", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentNotEqualTo(String value) {
            addCriterion("chat_content <>", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentGreaterThan(String value) {
            addCriterion("chat_content >", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentGreaterThanOrEqualTo(String value) {
            addCriterion("chat_content >=", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentLessThan(String value) {
            addCriterion("chat_content <", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentLessThanOrEqualTo(String value) {
            addCriterion("chat_content <=", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentLike(String value) {
            addCriterion("chat_content like", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentNotLike(String value) {
            addCriterion("chat_content not like", value, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentIn(List<String> values) {
            addCriterion("chat_content in", values, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentNotIn(List<String> values) {
            addCriterion("chat_content not in", values, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentBetween(String value1, String value2) {
            addCriterion("chat_content between", value1, value2, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatContentNotBetween(String value1, String value2) {
            addCriterion("chat_content not between", value1, value2, "chatContent");
            return (Criteria) this;
        }

        public Criteria andChatTimeIsNull() {
            addCriterion("chat_time is null");
            return (Criteria) this;
        }

        public Criteria andChatTimeIsNotNull() {
            addCriterion("chat_time is not null");
            return (Criteria) this;
        }

        public Criteria andChatTimeEqualTo(Date value) {
            addCriterion("chat_time =", value, "chatTime");
            return (Criteria) this;
        }

        public Criteria andChatTimeNotEqualTo(Date value) {
            addCriterion("chat_time <>", value, "chatTime");
            return (Criteria) this;
        }

        public Criteria andChatTimeGreaterThan(Date value) {
            addCriterion("chat_time >", value, "chatTime");
            return (Criteria) this;
        }

        public Criteria andChatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("chat_time >=", value, "chatTime");
            return (Criteria) this;
        }

        public Criteria andChatTimeLessThan(Date value) {
            addCriterion("chat_time <", value, "chatTime");
            return (Criteria) this;
        }

        public Criteria andChatTimeLessThanOrEqualTo(Date value) {
            addCriterion("chat_time <=", value, "chatTime");
            return (Criteria) this;
        }

        public Criteria andChatTimeIn(List<Date> values) {
            addCriterion("chat_time in", values, "chatTime");
            return (Criteria) this;
        }

        public Criteria andChatTimeNotIn(List<Date> values) {
            addCriterion("chat_time not in", values, "chatTime");
            return (Criteria) this;
        }

        public Criteria andChatTimeBetween(Date value1, Date value2) {
            addCriterion("chat_time between", value1, value2, "chatTime");
            return (Criteria) this;
        }

        public Criteria andChatTimeNotBetween(Date value1, Date value2) {
            addCriterion("chat_time not between", value1, value2, "chatTime");
            return (Criteria) this;
        }

        public Criteria andIsReadedIsNull() {
            addCriterion("is_readed is null");
            return (Criteria) this;
        }

        public Criteria andIsReadedIsNotNull() {
            addCriterion("is_readed is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadedEqualTo(Boolean value) {
            addCriterion("is_readed =", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedNotEqualTo(Boolean value) {
            addCriterion("is_readed <>", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedGreaterThan(Boolean value) {
            addCriterion("is_readed >", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_readed >=", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedLessThan(Boolean value) {
            addCriterion("is_readed <", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_readed <=", value, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedIn(List<Boolean> values) {
            addCriterion("is_readed in", values, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedNotIn(List<Boolean> values) {
            addCriterion("is_readed not in", values, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_readed between", value1, value2, "isReaded");
            return (Criteria) this;
        }

        public Criteria andIsReadedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_readed not between", value1, value2, "isReaded");
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