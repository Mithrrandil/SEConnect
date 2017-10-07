package com.TravisChenn.j2ee.Seconnect.entity.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * **************************************************************
 * 公司名称    :杭州质慧股份有限公司
 * 系统名称    :南方电网智能锁柜系统
 * 类 名 称    :Message
 * 功能描述    :消息实体类
 * 业务描述    :无
 * 作 者 名    :@Author TravisChenn
 * 开发日期    :2017-9-23 11:53:19
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Data
@NoArgsConstructor
public class Message {

    /**消息类型*/
    public enum Type{

        /**成功*/
        SUCCESS,

        /**警告*/
        WARN,

        /**异常*/
        ERROR,

        /**权限拒绝*/
        PERMISSION_DENIED
    }

    /**通用消息*/
    public enum CommonContent{

        /**通用成功标识*/
        COMMON_SUCCESS,

        /**通用警告标识*/
        COMMON_WARN,

        /**通用异常标识*/
        COMMON_ERROR
    }

    /**消息状态码*/
    private Integer code;

    /**消息类型*/
    private Type type;

    /**消息内容*/
    private String msg;

    /**分页总数量*/
    private Integer count;

    /**分页内容*/
    private List<?> data;

}
