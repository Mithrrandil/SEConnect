package com.TravisChenn.j2ee.Seconnect.entity.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * **************************************************************
 * 公司名称    :杭州质慧股份有限公司
 * 系统名称    :南方电网智能锁柜系统
 * 类 名 称    :BaseMember
 * 功能描述    :用户抽象超类
 * 业务描述    :无
 * 作 者 名    :@Author TravisChenn
 * 开发日期    :2017-9-18 19:16:04
 * Created    :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Data
@NoArgsConstructor
public abstract class BaseMember implements Serializable{

    /**登录渠道*/
    public enum Channel{

        /**安卓端登录*/
        ANDROID,

        /**后台登录*/
        ADMIN,

        /**全端通用*/
        ALL
    }

    /**登录结果选项*/
    public enum LoginResultIndex{

        /**登录成功*/
        SUCCESS("登录成功"),

        /**用户名密码错误*/
        INVALID_USERNAME_PASSWORD("用户名密码错误"),

        /**用户不存在*/
        MEMBER_NOT_EXIST("用户不存在"),

        /**登录渠道拒绝*/
        DENIED_AUTHORITY_BY_CHANNEL("登录渠道拒绝"),

        /**登录用户类型拒绝*/
        DENIED_AUTHORITY_BY_MEMBER_TYPE("登录用户类型拒绝"),

        /**登录信息不全*/
        LACK_OF_INFORMATION("登录信息不全");

        /**中文*/
        private String ZN;

        LoginResultIndex(String ZN) {
            this.ZN = ZN;
        }

        public String getZN() {
            return ZN;
        }

        public void setZN(String ZN) {
            this.ZN = ZN;
        }
    }

    /**用户类型*/
   public enum MemberType{

        /**超级管理员*/
        ADMINISTRATOR,

        /**管理员*/
        MANAGER,

        /**操作员*/
        OPERATOR
    }


    /**用户性别*/
    public enum Gender {

        /** 男 */
        MALE("男"),

        /** 女 */
        FEMALE("女"),

        /** 保密 **/
        SECRECY("保密");

        /**中文*/
        private String ZN;

        Gender(String ZN) {
            this.ZN = ZN;
        }

        public String getZN() {
            return ZN;
        }

        public void setZN(String ZN) {
            this.ZN = ZN;
        }
    }

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
