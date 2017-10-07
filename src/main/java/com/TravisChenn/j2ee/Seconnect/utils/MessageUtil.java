package com.TravisChenn.j2ee.Seconnect.utils;

import com.TravisChenn.j2ee.Seconnect.entity.common.Message;
import com.alibaba.fastjson.JSON;
import com.sun.istack.internal.NotNull;

/**
 * **************************************************************
 * 公司名称    :杭州质慧股份有限公司
 * 系统名称    :南方电网智能锁柜系统
 * 类 名 称    :MessageUtil
 * 功能描述    :消息工具类
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

public class MessageUtil {

    /**
     *
     * @return 通用消息
     */
    public static String commonMessage(Message.Type type, @NotNull String content){

        Message message = new Message();

        if(type != null){
            message.setType(type);
        }

        message.setMsg(content);
        return JSON.toJSONString(message);
    }

    /**
     * @return 通用成功消息
     */
    public static String commonSuccess(){
        Message message = new Message();
        message.setType(Message.Type.SUCCESS);
        message.setMsg(Message.CommonContent.COMMON_SUCCESS.toString());
        return JSON.toJSONString(message);
    }

    /**
     * @return 通用警告消息
     */
    public static String commonWarn(){
        Message message = new Message();
        message.setType(Message.Type.WARN);
        message.setMsg(Message.CommonContent.COMMON_WARN.toString());
        return JSON.toJSONString(message);
    }

    /**
     * @return 通用错误消息
     */
    public static String commonError(){
        Message message = new Message();
        message.setType(Message.Type.ERROR);
        message.setMsg(Message.CommonContent.COMMON_ERROR.toString());
        return JSON.toJSONString(message);
    }
}
