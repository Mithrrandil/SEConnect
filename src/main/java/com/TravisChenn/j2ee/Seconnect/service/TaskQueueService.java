package com.TravisChenn.j2ee.Seconnect.service;

import java.util.Map;

public interface TaskQueueService {


    /**
     * 获取制定管理员的任务列表
     * @param managerLoginUsername 管理员ID
     * @return 当前管理员任务队列数量
     */
    int getTaskListNum(String managerLoginUsername);


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

}
