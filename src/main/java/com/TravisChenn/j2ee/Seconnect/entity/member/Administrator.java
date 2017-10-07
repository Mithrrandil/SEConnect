package com.TravisChenn.j2ee.Seconnect.entity.member;


import com.TravisChenn.j2ee.Seconnect.entity.base.BaseMember;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * **************************************************************
 * 公司名称    :杭州质慧股份有限公司
 * 系统名称    :南方电网智能锁柜系统
 * 类 名 称    :Administrator
 * 功能描述    :超级管理员实体类
 * 业务描述    :无
 * 作 者 名    :@Author TravisChenn
 * 开发日期    :2017-9-18 19:15:40
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Administrator extends BaseMember {

    /**ID*/
    private Integer Id;

    /**用户类型*/
    private MemberType memberType;

    /**渠道类型*/
    private Channel channel;

    /**真实姓名*/
    private String realName;

    /** 用户性别 */
    private String gender;

    /**登录用户名*/
    private String loginUsername;

    /**登录密码*/
    private String loginPassword;

    /**手机号码[一级联系方式]*/
    private String mobile;

    /**邮箱[二级联系方式]*/
    private String email;

    /**联系地址*/
    private String address;

}