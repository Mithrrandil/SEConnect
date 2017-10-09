<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1">
    <link rel="icon" href="../../../../static/common/images/icon/icon_small.png" type="image/x-icon"/>
    <title>智能锁柜后台管理系统</title>

    <link href="../../../../static/layui/css/layui.css" rel="stylesheet">
    <link href="../../../../static/toastr/toastr.min.css" rel="stylesheet">
    <link href="../../../../static/common/css/common.css" rel="stylesheet">
</head>

<body>

<!--顶部导航-->
<div class="layui-row tpl-header">
<#include "../common/header.ftl">
</div>

<!--侧边导航栏-->
<div class="layui-row tpl-mid">

    <!--模块导航-->
    <div class="layui-col-xs5 layui-col-sm4 layui-col-md3 layui-col-lg2 tpl-mid-navbar">
    <#include "../common/navbar.ftl">
    </div>

    <!--模块内容-->
    <div class="layui-col-xs7 layui-col-sm8 layui-col-md9 layui-col-lg10 tpl-mid-content">

    </div>

</div>

<script src="https://cdn.bootcss.com/echarts/3.7.2/echarts-en.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../../../../static/layui/layui.all.js"></script>
<script type="text/javascript" src="../../../../static/toastr/toastr.min.js"></script>
<script type="text/javascript" src="../../../../static/common/js/common.js"></script>
</body>
</html>