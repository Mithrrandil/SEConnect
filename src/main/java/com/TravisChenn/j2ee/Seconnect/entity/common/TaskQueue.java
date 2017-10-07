package com.TravisChenn.j2ee.Seconnect.entity.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * **************************************************************
 * 公司名称    :杭州质慧股份有限公司
 * 系统名称    :南方电网智能锁柜系统
 * 类 名 称    :TaskQueue
 * 功能描述    :任务实体类
 * 业务描述    :无
 * 作 者 名    :@Author TravisChenn
 * 开发日期    :2017-9-22 21:15:08
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Data
@NoArgsConstructor
public class TaskQueue {


    /**任务类型*/
    public enum TaskType{

        /**增加柜级锁体数据*/
        ADD_SINGLE_LOCK_TASK("柜级锁体数据增加请求"),

        /**增加柜级锁体数据*/
        LOCK_ERROR("锁体异常提交"),

        /**增加柜级锁体数据*/
        ADD_OPERATOR_TASK("操作员增加"),

        /**强制开锁权限*/
        MANDATORY_UNLOCK_AUTHORITY("强制开锁权限请求");

        /**中文*/
        private String ZN;

        TaskType(String ZN) {
            this.ZN = ZN;
        }

        public String getZN() {
            return ZN;
        }

        public void setZN(String ZN) {
            this.ZN = ZN;
        }

    }

    /**任务完成情况*/
    public enum TaskState {

        /**已完成*/
        FINISHED,

        /**等待确认*/
        UN_CONFIRMATION,

        /**未完成*/
        INCOMPLETE,

        /**提交时间间隔过短*/
        TIME_LIMIT,

        /**被拒绝*/
        REFUSED
    }

    /**任务ID*/
    private Integer id;

    /**任务类型*/
    private String taskType;

    /**任务提出人*/
    private String taskOrder;

    /**任务目标人*/
    private String taskTarget;

    /**任务内容*/
    private String taskContent;

    /**任务请求时间*/
    private String taskDate;

    /**任务完成情况*/
    private TaskState taskState;

}
