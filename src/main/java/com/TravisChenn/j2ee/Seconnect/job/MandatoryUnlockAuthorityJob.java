package com.TravisChenn.j2ee.Seconnect.job;

import com.TravisChenn.j2ee.Seconnect.dao.OperatorDao;
import com.TravisChenn.j2ee.Seconnect.entity.member.Operator;
import lombok.Getter;
import lombok.Setter;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.Resource;

/**
 * **************************************************************
 * 公司名称    :杭州质慧股份有限公司
 * 系统名称    :南方电网智能锁柜系统
 * 类 名 称    :MandatoryUnlockAuthorityJob
 * 功能描述    :强制开锁权限定时任务
 * 业务描述    :无
 * 作 者 名    :@Author TravisChenn
 * 开发日期    :2017-10-5 15:19:22
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class MandatoryUnlockAuthorityJob implements Job {

    @Resource
    private OperatorDao operatorDao;

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //获取要恢复权限的用户ID
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        String operatorID = jobDataMap.getString("operatorID");

        Operator operator = new Operator();
        operator.setId(Integer.parseInt(operatorID));
        operator.setMandatoryUnlockAuthority(Operator.MandatoryUnlockAuthority.DENIED.getZN());
        operatorDao.updateByPrimaryKeySelective(operator);
    }

}
