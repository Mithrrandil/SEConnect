package com.TravisChenn.j2ee.Seconnect.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskQueueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskQueueExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("TASK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("TASK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("TASK_TYPE =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("TASK_TYPE <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("TASK_TYPE >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_TYPE >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("TASK_TYPE <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("TASK_TYPE <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("TASK_TYPE like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("TASK_TYPE not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("TASK_TYPE in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("TASK_TYPE not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("TASK_TYPE between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("TASK_TYPE not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskOrderIsNull() {
            addCriterion("TASK_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andTaskOrderIsNotNull() {
            addCriterion("TASK_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andTaskOrderEqualTo(String value) {
            addCriterion("TASK_ORDER =", value, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskOrderNotEqualTo(String value) {
            addCriterion("TASK_ORDER <>", value, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskOrderGreaterThan(String value) {
            addCriterion("TASK_ORDER >", value, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskOrderGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_ORDER >=", value, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskOrderLessThan(String value) {
            addCriterion("TASK_ORDER <", value, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskOrderLessThanOrEqualTo(String value) {
            addCriterion("TASK_ORDER <=", value, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskOrderLike(String value) {
            addCriterion("TASK_ORDER like", value, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskOrderNotLike(String value) {
            addCriterion("TASK_ORDER not like", value, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskOrderIn(List<String> values) {
            addCriterion("TASK_ORDER in", values, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskOrderNotIn(List<String> values) {
            addCriterion("TASK_ORDER not in", values, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskOrderBetween(String value1, String value2) {
            addCriterion("TASK_ORDER between", value1, value2, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskOrderNotBetween(String value1, String value2) {
            addCriterion("TASK_ORDER not between", value1, value2, "taskOrder");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNull() {
            addCriterion("TASK_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNotNull() {
            addCriterion("TASK_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContentEqualTo(String value) {
            addCriterion("TASK_CONTENT =", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotEqualTo(String value) {
            addCriterion("TASK_CONTENT <>", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThan(String value) {
            addCriterion("TASK_CONTENT >", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_CONTENT >=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThan(String value) {
            addCriterion("TASK_CONTENT <", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThanOrEqualTo(String value) {
            addCriterion("TASK_CONTENT <=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLike(String value) {
            addCriterion("TASK_CONTENT like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotLike(String value) {
            addCriterion("TASK_CONTENT not like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIn(List<String> values) {
            addCriterion("TASK_CONTENT in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotIn(List<String> values) {
            addCriterion("TASK_CONTENT not in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentBetween(String value1, String value2) {
            addCriterion("TASK_CONTENT between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotBetween(String value1, String value2) {
            addCriterion("TASK_CONTENT not between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskDateIsNull() {
            addCriterion("TASK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andTaskDateIsNotNull() {
            addCriterion("TASK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDateEqualTo(Date value) {
            addCriterion("TASK_DATE =", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateNotEqualTo(Date value) {
            addCriterion("TASK_DATE <>", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateGreaterThan(Date value) {
            addCriterion("TASK_DATE >", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateGreaterThanOrEqualTo(Date value) {
            addCriterion("TASK_DATE >=", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateLessThan(Date value) {
            addCriterion("TASK_DATE <", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateLessThanOrEqualTo(Date value) {
            addCriterion("TASK_DATE <=", value, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateIn(List<Date> values) {
            addCriterion("TASK_DATE in", values, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateNotIn(List<Date> values) {
            addCriterion("TASK_DATE not in", values, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateBetween(Date value1, Date value2) {
            addCriterion("TASK_DATE between", value1, value2, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskDateNotBetween(Date value1, Date value2) {
            addCriterion("TASK_DATE not between", value1, value2, "taskDate");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNull() {
            addCriterion("TASK_STATE is null");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNotNull() {
            addCriterion("TASK_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStateEqualTo(String value) {
            addCriterion("TASK_STATE =", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotEqualTo(String value) {
            addCriterion("TASK_STATE <>", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThan(String value) {
            addCriterion("TASK_STATE >", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_STATE >=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThan(String value) {
            addCriterion("TASK_STATE <", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThanOrEqualTo(String value) {
            addCriterion("TASK_STATE <=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLike(String value) {
            addCriterion("TASK_STATE like", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotLike(String value) {
            addCriterion("TASK_STATE not like", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateIn(List<String> values) {
            addCriterion("TASK_STATE in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotIn(List<String> values) {
            addCriterion("TASK_STATE not in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateBetween(String value1, String value2) {
            addCriterion("TASK_STATE between", value1, value2, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotBetween(String value1, String value2) {
            addCriterion("TASK_STATE not between", value1, value2, "taskState");
            return (Criteria) this;
        }
        public Criteria andTaskTargetIsNull() {
            addCriterion("TASK_TARGET is null");
            return (Criteria) this;
        }

        public Criteria andTaskTargetIsNotNull() {
            addCriterion("TASK_TARGET is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTargetEqualTo(String value) {
            addCriterion("TASK_TARGET =", value, "taskTarget");
            return (Criteria) this;
        }

        public Criteria andTaskTargetNotEqualTo(String value) {
            addCriterion("TASK_TARGET <>", value, "taskTarget");
            return (Criteria) this;
        }

        public Criteria andTaskTargetGreaterThan(String value) {
            addCriterion("TASK_TARGET >", value, "taskTarget");
            return (Criteria) this;
        }

        public Criteria andTaskTargetGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_TARGET >=", value, "taskTarget");
            return (Criteria) this;
        }

        public Criteria andTaskTargetLessThan(String value) {
            addCriterion("TASK_TARGET <", value, "taskTarget");
            return (Criteria) this;
        }

        public Criteria andTaskTargetLessThanOrEqualTo(String value) {
            addCriterion("TASK_TARGET <=", value, "taskTarget");
            return (Criteria) this;
        }

        public Criteria andTaskTargetLike(String value) {
            addCriterion("TASK_TARGET like", value, "taskTarget");
            return (Criteria) this;
        }

        public Criteria andTaskTargetNotLike(String value) {
            addCriterion("TASK_TARGET not like", value, "taskTarget");
            return (Criteria) this;
        }

        public Criteria andTaskTargetIn(List<String> values) {
            addCriterion("TASK_TARGET in", values, "taskTarget");
            return (Criteria) this;
        }

        public Criteria andTaskTargetNotIn(List<String> values) {
            addCriterion("TASK_TARGET not in", values, "taskTarget");
            return (Criteria) this;
        }

        public Criteria andTaskTargetBetween(String value1, String value2) {
            addCriterion("TASK_TARGET between", value1, value2, "taskTarget");
            return (Criteria) this;
        }

        public Criteria andTaskTargetNotBetween(String value1, String value2) {
            addCriterion("TASK_TARGET not between", value1, value2, "taskTarget");
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