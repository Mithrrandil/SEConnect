package com.TravisChenn.j2ee.Seconnect.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * **************************************************************
 * 公司名称    :杭州质慧股份有限公司
 * 系统名称    :南方电网智能锁柜系统
 * 类 名 称    :ProjectStatistics
 * 功能描述    :系统重要信息存储实体类
 * 业务描述    :无
 * 作 者 名    :@Author TravisChenn
 * 开发日期    :2017-9-18 19:21:20
 * Created    :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Data
@NoArgsConstructor
public class ProjectStatistics {

    /**当前锁体数目*/
    private Integer currentLockNumber;

    /**当前管理员数目*/
    private Integer currentManagerNumber;

}