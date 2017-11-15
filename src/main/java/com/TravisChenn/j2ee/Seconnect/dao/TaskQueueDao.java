package com.TravisChenn.j2ee.Seconnect.dao;

import com.TravisChenn.j2ee.Seconnect.entity.common.TaskQueue;
import com.TravisChenn.j2ee.Seconnect.entity.example.TaskQueueExample;
import org.apache.ibatis.annotations.Param;
import com.TravisChenn.j2ee.Seconnect.entity.common.TaskQueue.TaskType;

import java.util.List;

public interface TaskQueueDao {
    int countByExample(TaskQueueExample example);

    int deleteByExample(TaskQueueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskQueue record);

    int insertSelective(TaskQueue record);

    List<TaskQueue> selectByExample(TaskQueueExample example);

    TaskQueue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskQueue record, @Param("example") TaskQueueExample example);

    int updateByExample(@Param("record") TaskQueue record, @Param("example") TaskQueueExample example);

    int updateByPrimaryKeySelective(TaskQueue record);

    int updateByPrimaryKey(TaskQueue record);


    /**
     * 查找最近7天的强制开锁任务列表
     *
     * @return 最近7天的强制开锁任务列表
     */
    List<TaskQueue> selectMandatoryUnlockAuthorityTaskInSevenDays();

    /**
     * 查找最近7天的强制开锁任务列表
     *
     * @return 最近7天的锁体异常报修请求列表
     */
    List<TaskQueue> selectLockErrorTaskInSevenDays();


    /**
     * 获取 [指定天数] [指定用户] [指定任务] 之内的任务数据    (注意: 不包括当日)
     * @param taskTypeDescribe   任务类型
     * @param days               指定天数
     * @return                   任务列表
     */
    List<TaskQueue> selectTaskInDays(@Param("taskTarget") String taskTarget , @Param("taskType") String taskTypeDescribe, @Param("days") int days);


}