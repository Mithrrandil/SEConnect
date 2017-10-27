package com.TravisChenn.j2ee.Seconnect.controller;

import com.TravisChenn.j2ee.Seconnect.dao.ManagerDao;
import com.TravisChenn.j2ee.Seconnect.dao.OperatorDao;
import com.TravisChenn.j2ee.Seconnect.dao.TaskQueueDao;
import com.TravisChenn.j2ee.Seconnect.entity.common.Message;
import com.TravisChenn.j2ee.Seconnect.entity.common.TaskQueue;
import com.TravisChenn.j2ee.Seconnect.entity.example.OperatorExample;
import com.TravisChenn.j2ee.Seconnect.entity.example.TaskQueueExample;
import com.TravisChenn.j2ee.Seconnect.entity.member.Operator;
import com.TravisChenn.j2ee.Seconnect.job.MandatoryUnlockAuthorityJob;
import com.TravisChenn.j2ee.Seconnect.service.TaskQueueService;
import com.TravisChenn.j2ee.Seconnect.utils.DateUtil;
import com.TravisChenn.j2ee.Seconnect.utils.MessageUtil;
import com.TravisChenn.j2ee.Seconnect.utils.WebUtil;
import org.quartz.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * **************************************************************
 * 公司名称    :杭州质慧股份有限公司
 * 系统名称    :南方电网智能锁柜系统
 * 类 名 称    :TaskQueueController
 * 功能描述    :消息队列控制类
 * 业务描述    :无
 * 作 者 名    :@Author TravisChenn
 * 开发日期    :2017-10-4 17:00:04
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */

@Controller
@RequestMapping("/task")

/*IDEA Spring配置文件识别异常*/
@SuppressWarnings("unused")
public class TaskQueueController {

    @Resource
    private TaskQueueDao taskQueueDao;

    @Resource
    private TaskQueueService taskQueueService;

    @Resource
    private OperatorDao operatorDao;

    @Resource
    private ManagerDao managerDao;

    @Resource
    private Scheduler scheduler;

    @RequestMapping(value = "/dealWithMandatoryUnlockAuthority", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String delete(@RequestParam(name = "id") String taskID, @RequestParam(name = "taskResult") String taskResult) {

        //更新用户权限数据
        OperatorExample operatorExample = new OperatorExample();
        OperatorExample.Criteria operatorCriteria = operatorExample.createCriteria();
        operatorCriteria.andRealNameEqualTo(taskQueueDao.selectByPrimaryKey(Integer.parseInt(taskID)).getTaskOrder());
        Operator operator = operatorDao.selectByExample(operatorExample).get(0);

        //更新任务队列列表
        TaskQueue taskQueue = new TaskQueue();
        taskQueue.setId(Integer.parseInt(taskID));
        taskQueue.setTaskState(TaskQueue.TaskState.valueOf(taskResult));
        taskQueueDao.updateByPrimaryKeySelective(taskQueue);

        //根据返回任务结果设置不同的锁体权限 并 开启定时任务
        if (taskResult.equals(TaskQueue.TaskState.FINISHED.name())) {

            //获取定时任务时间
            TaskQueue taskQueueJob = taskQueueDao.selectByPrimaryKey(Integer.parseInt(taskID));
            Integer duration = Integer.parseInt(taskQueueJob.getTaskContent());

            //计算推迟的时间 [单位: 小时]
            Date date = new Date();
            date.setTime(date.getTime() + duration * 60 * 60 * 1000);

            //设置JobDetail
            JobDetail jobDetail = JobBuilder.newJob(MandatoryUnlockAuthorityJob.class).withIdentity("MandatoryUnlockAuthorityJob" + taskID, "group1").usingJobData("operatorID", String.valueOf(operator.getId())).build();

            //设置Trigger
            SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                    .withIdentity("MandatoryUnlockAuthorityTrigger" + taskID, "group1")
                    .startAt(date)
                    .build();

            try {
                scheduler.start();
                scheduler.scheduleJob(jobDetail, trigger);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }

            operator.setMandatoryUnlockAuthority(Operator.MandatoryUnlockAuthority.PASS.getZN());

        } else if (taskResult.equals(TaskQueue.TaskState.REFUSED.name())) {
            operator.setMandatoryUnlockAuthority(Operator.MandatoryUnlockAuthority.DENIED.getZN());
        }

        //同步用户数据到数据库
        operatorDao.updateByPrimaryKey(operator);

        return MessageUtil.commonSuccess();
    }

    @RequestMapping(value = "/addSingleLockTask", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String addSingleLockTask(@RequestParam(name = "managerLoginUsername") String managerLoginUsername, @RequestParam(name = "managerRealName") String managerRealName, @RequestParam(name = "singleLockNumber") String singleLockNumber) {


        //获取当前时间
        Date timeNow = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //获取上一次提交锁体增加权限任务对象
        TaskQueueExample taskQueueExample = new TaskQueueExample();
        TaskQueueExample.Criteria taskQueueCriteria = taskQueueExample.createCriteria();
        taskQueueCriteria.andTaskOrderEqualTo(managerRealName).andTaskTypeEqualTo(TaskQueue.TaskType.ADD_SINGLE_LOCK_TASK.getZN());
        List<TaskQueue> taskQueueList = taskQueueDao.selectByExample(taskQueueExample);

        //判断有没有符合要求的历史提交
        if (taskQueueList.size() != 0) {

            //获取最后一个任务的时间
            TaskQueue taskQueue = taskQueueList.get(taskQueueList.size() - 1);
            String lastTimeFormat = taskQueue.getTaskDate();
            String lastTimeFixed = lastTimeFormat.substring(0, lastTimeFormat.length() - 2);
            Long lastTime = null;

            try {
                Date date = simpleDateFormat.parse(lastTimeFixed);
                lastTime = date.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //判断最后一个任务的时间和现在的时间的差值是否在一周之内
            Long time = DateUtil.getTimeDifference(DateUtil.TimeGranularity.SECOND, lastTime, new Date().getTime());

            if (time <= 7 * 24 * 60 * 60) {
                return MessageUtil.commonMessage(Message.Type.ERROR, "您不能再一周之内提交多次提交锁体增加请求");
            }

        }

        //实例化任务对象
        TaskQueue addLockTaskQueue = new TaskQueue();
        addLockTaskQueue.setTaskState(TaskQueue.TaskState.INCOMPLETE);
        addLockTaskQueue.setTaskType(TaskQueue.TaskType.ADD_SINGLE_LOCK_TASK.getZN());
        addLockTaskQueue.setTaskTarget("chenqk");
        addLockTaskQueue.setTaskContent(singleLockNumber);
        addLockTaskQueue.setTaskDate(simpleDateFormat.format(timeNow));
        addLockTaskQueue.setTaskOrder(managerRealName);

        //同步到数据库
        taskQueueDao.insert(addLockTaskQueue);

        return MessageUtil.commonSuccess();
    }

    @RequestMapping(value = "/addLockErrorTask", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String addLockErrorTask(@RequestParam(name = "taskType") String taskType, @RequestParam(name = "taskOrder") String taskOrder, @RequestParam(name = "managerID") String managerID, @RequestParam(name = "taskContent") String taskContent) {

        TaskQueue taskQueue = new TaskQueue();
        taskQueue.setTaskType(TaskQueue.TaskType.valueOf(taskType).getZN());
        taskQueue.setTaskOrder(taskOrder);

        taskQueue.setTaskTarget(managerDao.selectByPrimaryKey(Integer.valueOf(managerID)).get(0).getRealName());
        taskQueue.setTaskContent(taskContent);

        Date timeNow = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        taskQueue.setTaskDate(simpleDateFormat.format(timeNow));

        taskQueue.setTaskState(TaskQueue.TaskState.INCOMPLETE);

        taskQueueDao.insert(taskQueue);

        return MessageUtil.commonSuccess();
    }

    @RequestMapping(value = "/getRapeLockTaskNum", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String getRapeLockTaskNum(HttpServletRequest request) {

        //1: 获取当前登录的 管理员的真实姓名
        String managerRealname = WebUtil.getCookie(request, "SECONNECT_REALNAME");

        //2: 获取 ID 对应的管理员强制开锁任务数量
        int taskListNum = taskQueueService.getTaskListNum(managerRealname);

        return MessageUtil.commonMessage(Message.Type.SUCCESS , String.valueOf(taskListNum));
    }

}


