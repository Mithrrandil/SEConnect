<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>消息推送</title>

    <link href="../../../../static/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="../../../../static/layui/css/layui.css" rel="stylesheet">
    <link href="../../../../static/common/css/common.css" rel="stylesheet">

    <style>
        body{
            overflow: scroll;
        }
    </style>
</head>

<body>

<#if (taskList??)>
    <#list taskList! as taskQueue>
    <div class="layui-row" id="${taskQueue.id}" style="margin: 0">

        <!--头像-->
        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 layui-col-lg3 msg-item" align="center">
            <img src="../../../../static/common/images/header_male.jpg" alt="头像">
        </div>

        <!--任务队列内容-->
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md6 layui-col-lg6 msg-item tpl-border-left">
            <!--任务请求人-->
            <div id="msg-taskOrder" style="margin-top: 15px">${taskQueue.taskOrder}</div>

            <!--任务内容-->
            <#if taskQueue.taskType == "强制开锁权限请求">
                <div id="msg-taskType" style="margin-top: 8px">${taskQueue.taskType}${taskQueue.taskContent}小时</div>
            <#elseif taskQueue.taskType == "请求增加柜级锁体数据">
                <div id="msg-taskType" style="margin-top: 8px">${taskQueue.taskType}${taskQueue.taskContent}个</div>
            </#if>

            <!--任务时间戳-->
            <div id="msg-taskDate" style="margin-top: 8px;font-size: small">${taskQueue.taskDate}</div>
        </div>

        <!--任务队列结果-->
        <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 layui-col-lg3 msg-item">
            <div class="result" style="margin-top: 15px">
                <button class="layui-btn layui-btn-primary layui-btn-small msg-button" name="FINISHED">
                    <i class="fa fa-check-circle-o"></i>
                </button>
            </div>
            <div class="result">
                <button class="layui-btn layui-btn-primary layui-btn-small msg-button" name="REFUSED" style="margin-top: 15px">
                    <i class="fa fa-times-circle-o"></i>
                </button>
            </div>
        </div>

        <!--任务分割线-->
        <hr class="layui-bg-gray">
    </div>
    </#list>
<#else>
<div class="layui-row" style="margin: 200px 0 0;">
    <img src="../../../../static/common/images/404.gif" alt="" style="width: 100px;height: 100px;margin-left: 95px"><span style="font-weight: bold ;margin-top: 5px">没有任务请求</span>
</div>

</#if>

<script type="text/javascript" src="../../../../static/jQuery/jquery.min.js"></script>
<script type="text/javascript" src="../../../../static/layui/layui.all.js"></script>
<script type="text/javascript" src="../../../../static/common/js/common.js"></script>
</body>
</html>