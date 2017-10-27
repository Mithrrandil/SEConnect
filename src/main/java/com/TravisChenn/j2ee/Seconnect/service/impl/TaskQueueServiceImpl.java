package com.TravisChenn.j2ee.Seconnect.service.impl;

import com.TravisChenn.j2ee.Seconnect.dao.TaskQueueDao;
import com.TravisChenn.j2ee.Seconnect.entity.common.TaskQueue;
import com.TravisChenn.j2ee.Seconnect.entity.example.TaskQueueExample;
import com.TravisChenn.j2ee.Seconnect.entity.member.Operator;
import com.TravisChenn.j2ee.Seconnect.service.TaskQueueService;
import com.TravisChenn.j2ee.Seconnect.utils.DateUtil;
import com.TravisChenn.j2ee.Seconnect.utils.WebUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service(value = "taskService")

/*IDEA Spring配置文件异常*/
@SuppressWarnings("unused")
public class TaskQueueServiceImpl implements TaskQueueService {

    @Resource
    private TaskQueueDao taskQueueDao;

    public int getTaskListNum(String managerRealname) {
        TaskQueueExample taskQueueExample = new TaskQueueExample();

        TaskQueueExample.Criteria taskQueueCriteria = taskQueueExample.createCriteria();
        taskQueueCriteria.andTaskTargetEqualTo(managerRealname).andTaskStateNotEqualTo(String.valueOf(TaskQueue.TaskState.FINISHED)).andTaskStateNotEqualTo(String.valueOf(TaskQueue.TaskState.REFUSED));
        List<TaskQueue> taskQueueList = taskQueueDao.selectByExample(taskQueueExample);

        return taskQueueList.size();
    }

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
        Map<String,Integer> operatorMap = new HashMap<String, Integer>();

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
}
