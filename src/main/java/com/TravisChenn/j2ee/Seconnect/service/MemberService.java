package com.TravisChenn.j2ee.Seconnect.service;

import com.TravisChenn.j2ee.Seconnect.entity.base.BaseMember;
import com.TravisChenn.j2ee.Seconnect.entity.member.Operator;

import java.util.List;

public interface MemberService {

    /**
     * 插入一个操作员
     *
     * @param operator 操作员对象
     * @return 结果
     */
    boolean insertOperator(Operator operator);


    /**
     * 根据 [父ID] 下的子对象集合
     *
     * @param managerID 父对象ID
     * @param pageNum   分页索引
     * @param pageSize  分页数量
     * @return 父 ID 不存在 = null
     * 类型上下级错误 = null
     * 查询结果不存在 = null
     * 结果存在 = List<Object>
     */
    List<Operator> selectOperatorListByManagerID(Integer managerID, Integer pageNum, Integer pageSize);

    /**
     * 根据用户类型进行判断用户登录权限
     * @param loginUsername 用户名
     * @param loginPassword 密码
     * @param memberType 用户类型
     * @return
     */
    BaseMember.LoginResultIndex memberCheck(String loginUsername, String loginPassword, String memberType);
}
