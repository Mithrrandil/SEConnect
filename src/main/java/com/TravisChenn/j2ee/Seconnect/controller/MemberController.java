package com.TravisChenn.j2ee.Seconnect.controller;

import com.TravisChenn.j2ee.Seconnect.dao.Impl.ManagerDaoImpl;
import com.TravisChenn.j2ee.Seconnect.dao.ManagerDao;
import com.TravisChenn.j2ee.Seconnect.dao.OperatorDao;
import com.TravisChenn.j2ee.Seconnect.dao.TaskQueueDao;
import com.TravisChenn.j2ee.Seconnect.entity.common.Message;
import com.TravisChenn.j2ee.Seconnect.entity.base.BaseMember;
import com.TravisChenn.j2ee.Seconnect.entity.common.TaskQueue;
import com.TravisChenn.j2ee.Seconnect.entity.member.Manager;
import com.TravisChenn.j2ee.Seconnect.entity.member.Operator;
import com.TravisChenn.j2ee.Seconnect.service.MemberService;
import com.TravisChenn.j2ee.Seconnect.utils.DateUtil;
import com.TravisChenn.j2ee.Seconnect.utils.MessageUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/member")

/*IDEA Spring配置文件识别异常*/
@SuppressWarnings("unused")
public class MemberController {

    @Resource
    private ManagerDaoImpl managerDaoImpl;

    @Resource
    private ManagerDao managerDao;

    @Resource
    private OperatorDao operatorDao;

    @Resource
    private TaskQueueDao taskQueueDao;

    @Resource
    private MemberService memberService;



    @RequestMapping(value = "/insertOperator", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String insert(@RequestParam(name = "realName") String realName, @RequestParam(name = "gender") String gender, @RequestParam(name = "loginUsername") String loginUsername, @RequestParam(name = "loginPassword") String loginPassword, @RequestParam(name = "managerID") String managerID, @RequestParam(name = "mobile") String mobile, @RequestParam(name = "email") String email, @RequestParam(name = "address") String address) {


        Operator operator = new Operator();
        operator.setMemberType(BaseMember.MemberType.OPERATOR);
        operator.setChannel(BaseMember.Channel.ANDROID);
        operator.setRealName(realName);

        if (gender.equals("男")) {
            operator.setGender(BaseMember.Gender.MALE.getZN());
        } else {
            operator.setGender(BaseMember.Gender.FEMALE.getZN());
        }

        operator.setLoginUsername(loginUsername);
        operator.setLoginPassword(loginPassword);
        operator.setManagerId(Integer.parseInt(managerID));
        operator.setMobile(mobile);
        operator.setEmail(email);
        operator.setAddress(address);
        operator.setLog(" ");
        operator.setMandatoryUnlockAuthority(Operator.MandatoryUnlockAuthority.DENIED.getZN());

        boolean result = memberService.insertOperator(operator);

        if (result) {

            //获取当前操作员的数量
            int operatorNum = managerDao.selectByPrimaryKey(Integer.valueOf(managerID)).get(0).getOperatorNumber();

            //新建更新的对象
            Manager manager = new Manager();
            manager.setId(Integer.parseInt(managerID));
            manager.setOperatorNumber(operatorNum+1);

            //同步到数据库
            managerDao.updateByPrimaryKeySelective(manager);

            //同步到任务列表
            TaskQueue addOperatorTaskQueue = new TaskQueue();
            addOperatorTaskQueue.setTaskState(TaskQueue.TaskState.FINISHED);
            addOperatorTaskQueue.setTaskType(TaskQueue.TaskType.ADD_OPERATOR_TASK.getZN());
            addOperatorTaskQueue.setTaskTarget("chenqk");
            addOperatorTaskQueue.setTaskContent("1");

            addOperatorTaskQueue.setTaskDate(DateUtil.getTimeNow());
            addOperatorTaskQueue.setTaskOrder(realName);

            taskQueueDao.insert(addOperatorTaskQueue);

            return MessageUtil.commonSuccess();
        } else {
            return MessageUtil.commonMessage(Message.Type.ERROR, "当前用户名已经存在");
        }

    }

    @RequestMapping(value = "/deleteOperatorsByIDS", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String delete(@RequestParam(name = "IDS") String IDS , @RequestParam(name = "managerID") String managerID) {

        //删除操作员
        managerDaoImpl.deleteOperatorInIDS(IDS);

        //获取当前操作员的数量
        int operatorNum = managerDao.selectByPrimaryKey(Integer.valueOf(managerID)).get(0).getOperatorNumber();

        //新建更新的对象
        Manager manager = new Manager();
        manager.setId(Integer.parseInt(managerID));
        manager.setOperatorNumber(operatorNum-IDS.split(",").length);

        //同步到数据库
        managerDao.updateByPrimaryKeySelective(manager);

        return MessageUtil.commonSuccess();
    }

    @RequestMapping(value = "/updateOperatorsByID", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String update(@RequestParam(name = "id") String id, @RequestParam(name = "field") String field, @RequestParam(name = "value") String value) {

        //设置准备更新的操作员容器
        Operator operator = new Operator();

        //设置操作员id
        operator.setId(Integer.valueOf(id));

        //根据传进来的字段进行更新
        if (field.equals("realName")) {
            operator.setRealName(value);
        } else if (field.equals("gender")) {
            operator.setGender(BaseMember.Gender.valueOf(value).getZN());
        } else if (field.equals("loginPassword")) {
            operator.setLoginPassword(value);
        } else if (field.equals("mobile")) {
            operator.setMobile(value);
        } else if (field.equals("email")) {
            operator.setEmail(value);
        } else if (field.equals("address")) {
            operator.setAddress(value);
        } else if (field.equals("mandatoryUnlockAuthority")) {
            operator.setMandatoryUnlockAuthority(value);
        }

        //同步到数据库
        operatorDao.updateByPrimaryKeySelective(operator);

        return MessageUtil.commonSuccess();
    }

    @RequestMapping(value = "/selectOperatorByManagerIDLimitByPages", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String select(@RequestParam(name = "managerID") String managerID, @RequestParam(name = "page") String page, @RequestParam(name = "limit") String limit) {

        //1：获取筛选用户数据
        List<Operator> operatorList = memberService.selectOperatorListByManagerID(Integer.parseInt(managerID), Integer.parseInt(page), Integer.parseInt(limit));

        //2：根据 layui 接口格式返回数据
        Message message = new Message();
        message.setCode(0);
        message.setMsg("");
        message.setCount(managerDaoImpl.selectOperatorNumberByManagerID(managerID));
        message.setData(operatorList);

        return JSON.toJSON(message).toString();
    }


}
