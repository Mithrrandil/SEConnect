package com.TravisChenn.j2ee.Seconnect.service;

import java.util.Map;

public interface TaskQueueService {


    /**
     * 获取制定管理员的任务列表
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

}
