package com.TravisChenn.j2ee.Seconnect.service;

import java.util.Map;

public interface TaskQueueService {


    /**
     * 获取指定管理员的任务列表
     * @param managerRealname 管理员真实姓名
     * @return 当前管理员任务队列数量
     */
    int getTaskListNum(String managerRealname);


    /**
     * 获取7天之内的强制开锁权限任务字符串
     * @return 7天之内的强制开锁权限任务字符串
     */
    String getMandatoryUnlockAuthorityTaskInSevenDays();

    /**
     * 获取7天之内的锁体异常提交列表
     * @return 7天之内的锁体异常提交列表
     */
    Map<String,Integer> getLockErrorTaskInSevenDays();


    /**
     * [指定用户] [指定天数] 内 [指定任务类型] 的 [任务数量]
     * @param taskTargetPerson 任务所属用户
     * @param taskType         任务类型
     * @param days             天数
     * @return                 对应天数长度的数组
     */
    Integer[] selectTaskInDays(String taskTargetPerson , String taskType , int days);

}
