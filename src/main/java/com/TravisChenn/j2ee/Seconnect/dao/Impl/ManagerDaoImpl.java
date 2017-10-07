package com.TravisChenn.j2ee.Seconnect.dao.Impl;

import com.TravisChenn.j2ee.Seconnect.dao.ManagerDao;
import com.TravisChenn.j2ee.Seconnect.dao.OperatorDao;
import com.TravisChenn.j2ee.Seconnect.entity.member.Operator;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository(value = "managerDaoImpl")
public class ManagerDaoImpl {

    @Resource
    private OperatorDao operatorDao;

    @Resource
    private ManagerDao managerDao;

    /**
     * 通过 [管理员ID] + [分页信息] 获取操作员列表
     *
     * @param managerID 管理员ID
     * @param pageNum   当前页数
     * @param pageSize  分页页面大小
     * @return 操作员JsonArray对象
     */
    public List<Operator> selectOperatorByManagerIDLimitByPages(Integer managerID, Integer pageNum, Integer pageSize) {

        //1:分页限制
        PageHelper.startPage(pageNum,pageSize);

        //2:查询用户
        List<Operator> operatorList = operatorDao.selectByManagerID(managerID);

        //返回结果
        return operatorList;

    }

    /**
     * 删除指定 [管理员] + [IDS] 下的操作员
     * @param IDS       要删除的用户ID
     */
    public void deleteOperatorInIDS(String IDS){

        //1：分离IDS数组
        String[] ids = IDS.split(",");

        //2：将ID放入到容器中
        List<String> idList = new ArrayList<String>();
        idList.addAll(Arrays.asList(ids));

        //2：执行语句
        managerDao.batchDeleteByIDS(idList);

    }

    /**
     * 查找指定管理员下的操作员数目
     * @param managerID 管理员ID
     * @return 操作员数目
     */
    public Integer selectOperatorNumberByManagerID(String managerID){
        return operatorDao.selectByManagerID(Integer.parseInt(managerID)).size();
    }
}
