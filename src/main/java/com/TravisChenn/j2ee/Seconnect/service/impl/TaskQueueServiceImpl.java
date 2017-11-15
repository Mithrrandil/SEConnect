package com.TravisChenn.j2ee.Seconnect.service.impl;

import com.TravisChenn.j2ee.Seconnect.dao.TaskQueueDao;
import com.TravisChenn.j2ee.Seconnect.entity.common.TaskQueue;
import com.TravisChenn.j2ee.Seconnect.entity.example.TaskQueueExample;
import com.TravisChenn.j2ee.Seconnect.service.TaskQueueService;
import com.TravisChenn.j2ee.Seconnect.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service(value = "taskService")

/*IDEA Spring配置文件异常*/
@SuppressWarnings("unused")
public class TaskQueueServiceImpl implements TaskQueueService {

    @Resource
    private TaskQueueDao taskQueueDao;

    @Override
    public int getTaskListNum(String managerRealname) {
        TaskQueueExample taskQueueExample = new TaskQueueExample();

        TaskQueueExample.Criteria taskQueueCriteria = taskQueueExample.createCriteria();
        taskQueueCriteria.andTaskTargetEqualTo(managerRealname).andTaskStateNotEqualTo(String.valueOf(TaskQueue.TaskState.FINISHED)).andTaskStateNotEqualTo(String.valueOf(TaskQueue.TaskState.REFUSED));
        List<TaskQueue> taskQueueList = taskQueueDao.selectByExample(taskQueueExample);

        return taskQueueList.size();
    }

    @Override
    public String getMandatoryUnlockAuthorityTaskInSevenDays() {

        //准备储存的对象
        int firstDay = 0;
        int secondDay = 0;
        int thirdDay = 0;
        int fourthDay = 0;
        int fifthDay = 0;
        int sixthDay = 0;
        int seventhDay = 0;

        //获取最近7天的任务列表
        List<TaskQueue> taskQueueList = taskQueueDao.selectMandatoryUnlockAuthorityTaskInSevenDays();

        if (taskQueueList.size() != 0) {

            //如果任务列表中的时间和指定天数的时间相等则指定天数的任务+1
            for (TaskQueue taskQueue : taskQueueList) {
                String taskDate = taskQueue.getTaskDate().substring(0, 10);

                if (taskDate.equals(DateUtil.getPastDate(0))) {
                    firstDay++;
                } else if (taskDate.equals(DateUtil.getPastDate(1))) {
                    secondDay++;
                } else if (taskDate.equals(DateUtil.getPastDate(2))) {
                    thirdDay++;
                } else if (taskDate.equals(DateUtil.getPastDate(3))) {
                    fourthDay++;
                } else if (taskDate.equals(DateUtil.getPastDate(4))) {
                    fifthDay++;
                } else if (taskDate.equals(DateUtil.getPastDate(5))) {
                    sixthDay++;
                } else if (taskDate.equals(DateUtil.getPastDate(6))) {
                    seventhDay++;
                }
            }

        }

        return "[" + firstDay + "," + secondDay + "," + thirdDay + "," + fourthDay + "," + fifthDay + "," + sixthDay + "," + seventhDay + "]";

    }

    public Map<String,Integer> getLockErrorTaskInSevenDays() {

        //准备储存的对象
        Map<String,Integer> operatorMap = new HashMap<>();

        //获取最近7天的锁体异常任务列表
        List<TaskQueue> taskQueueList = taskQueueDao.selectLockErrorTaskInSevenDays();

        if (taskQueueList.size() != 0) {
            for (TaskQueue taskQueue : taskQueueList) {
                String taskOrder = taskQueue.getTaskOrder();

                if(!operatorMap.containsKey(taskOrder)){
                    operatorMap.put(taskOrder,1);
                }else{
                    operatorMap.put(taskOrder,operatorMap.get(taskOrder)+1);
                }
            }
        }

        return operatorMap;
    }

    public Integer[] selectTaskInDays(String taskTarget, String taskType, int days) {

        //1: 准备任务结果容器
        Integer[] taskArray = new Integer[days];

        //2: 获取任务
        List<TaskQueue> taskQueueList = taskQueueDao.selectTaskInDays(taskTarget, taskType, days);

        //3:将任务列表中的数据通过时间进行分组  [java8: StreamAPI]
        Map<String, List<TaskQueue>> collect = taskQueueList.parallelStream().collect(Collectors.groupingBy(TaskQueue::getTaskDate));

        //4:将分组结果放入任务结果容器中


        return new Integer[0];
    }

}
