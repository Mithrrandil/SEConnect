package com.TravisChenn.j2ee.Seconnect.controller;

import com.TravisChenn.j2ee.Seconnect.dao.ManagerDao;
import com.TravisChenn.j2ee.Seconnect.dao.StationDao;
import com.TravisChenn.j2ee.Seconnect.dao.TaskQueueDao;
import com.TravisChenn.j2ee.Seconnect.entity.Station;
import com.TravisChenn.j2ee.Seconnect.entity.common.TaskQueue;
import com.TravisChenn.j2ee.Seconnect.entity.example.TaskQueueExample;
import com.TravisChenn.j2ee.Seconnect.entity.example.TaskQueueExample.Criteria;
import com.TravisChenn.j2ee.Seconnect.entity.member.Manager;
import com.TravisChenn.j2ee.Seconnect.service.MemberService;
import com.TravisChenn.j2ee.Seconnect.service.TaskQueueService;
import com.TravisChenn.j2ee.Seconnect.utils.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")

/*IDEA Spring配置文件识别异常*/
@SuppressWarnings("unused")
public class ViewController {

    @Resource
    private TaskQueueDao taskQueueDao;

    @Resource
    private StationDao stationDao;

    @Resource
    private ManagerDao managerDao;

    @Resource
    private TaskQueueService taskQueueService;

    /**
     * @return 首页模板
     */
    @RequestMapping(value = "admin/pages/common")
    public ModelAndView
    common(HttpServletRequest request) {

        String managerLoginUsername = WebUtil.getCookie(request, "SECONNECT_LOGIN_USERNAME");
        String managerRealname = WebUtil.getCookie(request, "SECONNECT_REALNAME");
        Integer managerID = Integer.parseInt(WebUtil.getCookie(request, "SECONNECT_ID"));
        ModelAndView modelAndView = new ModelAndView();

        //当前登录的用户真实姓名
        modelAndView.addObject("memberRealname", managerRealname);

        //消息推送数量
        modelAndView.addObject("taskListNumber", taskQueueService.getTaskListNum(managerRealname));

        //锁柜总数
        modelAndView.addObject("lockNum", String.valueOf(stationDao.selectLockNumByManagerStationID(managerID).get(0).getLockNumber()));

        //增加锁柜数
        TaskQueueExample taskQueueExample = new TaskQueueExample();
        Criteria taskQueueCriteria = taskQueueExample.createCriteria();
        taskQueueCriteria.andTaskTypeEqualTo(TaskQueue.TaskType.ADD_SINGLE_LOCK_TASK.getZN());
        taskQueueCriteria.andTaskStateEqualTo(String.valueOf(TaskQueue.TaskState.FINISHED));

        List<TaskQueue> taskQueueList = taskQueueDao.selectByExample(taskQueueExample);
        modelAndView.addObject("insertLockTaskNum", taskQueueList.size());

        //操作员数
        Manager manager = managerDao.selectByPrimaryKey(managerID).get(0);
        modelAndView.addObject("operatorNum", manager.getOperatorNumber());

        //增加的操作员数
        TaskQueueExample OperatorNumTaskQueueExample = new TaskQueueExample();
        Criteria OperatorNumTaskQueueCriteria = OperatorNumTaskQueueExample.createCriteria();
        OperatorNumTaskQueueCriteria.andTaskTypeEqualTo(TaskQueue.TaskType.ADD_OPERATOR_TASK.getZN());
        OperatorNumTaskQueueCriteria.andTaskStateEqualTo(String.valueOf(TaskQueue.TaskState.FINISHED));

        List<TaskQueue> OperatorNumTaskQueueList = taskQueueDao.selectByExample(OperatorNumTaskQueueExample);
        modelAndView.addObject("insertOperatorTaskNum", OperatorNumTaskQueueList.size());

        //近七天强制开锁请求
        modelAndView.addObject("mandatoryUnlockAuthorityTaskInSevenDays", taskQueueService.getMandatoryUnlockAuthorityTaskInSevenDays());

        //近七天异常报修请求
        modelAndView.addObject("lockErrorTaskInSevenDays", taskQueueService.getLockErrorTaskInSevenDays());

        return modelAndView;
    }

    /**
     * @return 管理员 - 操作员管理模块
     */
    @RequestMapping(value = "admin/pages/manager-operator-list")
    public ModelAndView
    managerOperatorList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        String managerRealname = WebUtil.getCookie(request, "SECONNECT_REALNAME");

        //当前登录的用户真实姓名
        modelAndView.addObject("memberRealname", managerRealname);

        modelAndView.addObject("taskListNumber", taskQueueService.getTaskListNum(managerRealname));
        return modelAndView;
    }

    /**
     * @return 登录模块
     */
    @RequestMapping(value = "admin/pages/login")
    public ModelAndView
    login() {
        return new ModelAndView();
    }

    /**
     * @return 信息提示页面
     */
    @RequestMapping(value = "admin/common/msg")
    public ModelAndView
    msg(HttpServletRequest request) {

        //1：获取当前登录的管理员用户名
        String managerRealName = WebUtil.getCookie(request, "SECONNECT_REALNAME");

        List<TaskQueue> taskQueueList = new ArrayList<TaskQueue>();
        if (managerRealName != null) {

            //2：根据指定的用户获取当前用户的任务列表
            TaskQueueExample taskQueueExample = new TaskQueueExample();

            Criteria taskQueueCriteria = taskQueueExample.createCriteria();
            taskQueueCriteria.andTaskTargetEqualTo(managerRealName).andTaskStateNotEqualTo(String.valueOf(TaskQueue.TaskState.FINISHED)).andTaskStateNotEqualTo(String.valueOf(TaskQueue.TaskState.REFUSED));
            taskQueueList = taskQueueDao.selectByExample(taskQueueExample);
        }

        ModelAndView modelAndView = new ModelAndView();

        if (taskQueueList.isEmpty()) {
            modelAndView.addObject("taskList", null);
            return modelAndView;
        }

        //3：将任务列表放入到对象中

        modelAndView.addObject("taskList", taskQueueList);

        return modelAndView;
    }

    /**
     * @return 锁体增加请求
     */
    @RequestMapping(value = "admin/window/insert-single-lock")
    public ModelAndView
    insertSingleLock(HttpServletRequest request) {
        return new ModelAndView();
    }

    /**
     * @return 操作员增加
     */
    @RequestMapping(value = "admin/window/insert-operator")
    public ModelAndView
    insertOperator(HttpServletRequest request) {
        return new ModelAndView();
    }

}
