package com.TravisChenn.j2ee.Seconnect.service.impl;

import com.TravisChenn.j2ee.Seconnect.dao.AdministratorDao;
import com.TravisChenn.j2ee.Seconnect.dao.Impl.ManagerDaoImpl;
import com.TravisChenn.j2ee.Seconnect.dao.ManagerDao;
import com.TravisChenn.j2ee.Seconnect.dao.OperatorDao;
import com.TravisChenn.j2ee.Seconnect.entity.base.BaseMember;
import com.TravisChenn.j2ee.Seconnect.entity.example.AdministratorExample;
import com.TravisChenn.j2ee.Seconnect.entity.example.ManagerExample;
import com.TravisChenn.j2ee.Seconnect.entity.example.OperatorExample;
import com.TravisChenn.j2ee.Seconnect.entity.member.Administrator;
import com.TravisChenn.j2ee.Seconnect.entity.member.Manager;
import com.TravisChenn.j2ee.Seconnect.entity.member.Operator;
import com.TravisChenn.j2ee.Seconnect.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service(value = "memberService")

/*IDEA Spring配置文件异常*/
@SuppressWarnings("unused")
public class MemberServiceImpl implements MemberService {

    @Resource
    private OperatorDao operatorDao;

    @Resource
    private ManagerDao managerDao;

    @Resource
    private ManagerDaoImpl managerDaoImpl;

    @Resource
    private AdministratorDao administratorDao;

    public boolean insertOperator(Operator operator) {

        //获取当前操作员的用户名
        String loginUsername = operator.getLoginUsername();

        //将用户名当做查询条件进行查询
        OperatorExample operatorExample = new OperatorExample();
        operatorExample.or().andLoginUsernameEqualTo(loginUsername);
        List<Operator> operatorList = operatorDao.selectByExample(operatorExample);

        //当查询结果不为空时返回错误
        if (operatorList.size() != 0) {
            return false;
        } else {
            operatorDao.insert(operator);
        }

        return true;
    }

    public List<Operator> selectOperatorListByManagerID(Integer parentID, Integer pageNum, Integer pageSize) {

        //判断当前管理员ID是否存在
        List<Manager> managerList = managerDao.selectByPrimaryKey(parentID);

        if (managerList.size() == 0) {
            return null;
        }
        //根据管理员ID查找指定的操作员列表

        return managerDaoImpl.selectOperatorByManagerIDLimitByPages(parentID, pageNum, pageSize);

    }

    public BaseMember.LoginResultIndex memberCheck(String loginUsername, String loginPassword, String memberType) {

        //参数不为空
        if (StringUtils.isBlank(loginUsername) || StringUtils.isBlank(loginPassword) || StringUtils.isBlank(memberType)) {
            return BaseMember.LoginResultIndex.LACK_OF_INFORMATION;
        }

        //查询出来的用户数量
        int validNum = 0;

        //查询出来的密码
        String loginPasswordNow = null;

        //操作员
        if (memberType.equals(BaseMember.MemberType.OPERATOR.name())) {

            OperatorExample operatorExample = new OperatorExample();
            operatorExample.or().andLoginUsernameEqualTo(loginUsername);
            List<Operator> operatorList = operatorDao.selectByExample(operatorExample);

            if (operatorList.size() != 0) {
                validNum = operatorList.size();
            }

            loginPasswordNow = operatorList.get(0).getLoginPassword();

        } else if (memberType.equals(BaseMember.MemberType.MANAGER.name())) {

            ManagerExample managerExample = new ManagerExample();
            managerExample.or().andLoginUsernameEqualTo(loginUsername);
            List<Manager> managerList = managerDao.selectByExample(managerExample);

            if (managerList.size() != 0) {
                loginPasswordNow = managerList.get(0).getLoginPassword();
            }

            validNum = managerList.size();

        } else if (memberType.equals(BaseMember.MemberType.ADMINISTRATOR.name())) {

            AdministratorExample administratorExample = new AdministratorExample();
            administratorExample.or().andLoginUsernameEqualTo(loginUsername);
            List<Administrator> managerList = administratorDao.selectByExample(administratorExample);

            if (managerList.size() != 0) {
                loginPasswordNow = managerList.get(0).getLoginPassword();
            }

            validNum = managerList.size();

        }

        if (validNum == 0) {
            return BaseMember.LoginResultIndex.MEMBER_NOT_EXIST;
        } else if (!loginPasswordNow.equals(loginPassword)) {
            return BaseMember.LoginResultIndex.INVALID_USERNAME_PASSWORD;
        } else {
            return BaseMember.LoginResultIndex.SUCCESS;
        }

    }

}
