<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录 | Login</title>
    <link rel="icon" href="../../../../static/common/images/icon/icon_small.png"/>
    <link href="../../../../static/layui/css/layui.css" rel="stylesheet">
    <link rel="stylesheet" href="../../../../static/common/css/common.css"/>
    <link rel="stylesheet" href="../../../../static/toastr/toastr.min.css"/>
</head>
<body>


<div class="layui-row">
    <div class="layui-col-xs10 layui-col-sm10 layui-col-md2 layui-col-lg2 layui-col-xs-offset1 layui-col-sm-offset1 layui-col-md-offset5 layui-col-lg-offset5 login-container">
        <div class="login-container-logo" align="center">
            <img src="../../../../static/common/images/login_logo.png">
        </div>
        <div class="login-container-form">
            <div class="login-container-form-item">
                <i class="layui-icon login-box-icon" style="font-size: 20px;font-weight: bold; color: #264480">&#xe628;</i> <input class="login-box-input" name="username" type="text" placeholder="请输入用户名">
                <div class="login-container-form-item-split-line"></div>
            </div>
            <div class="login-container-form-item">
                <i class="layui-icon login-box-icon" style="font-size: 20px;font-weight: bold; color: #264480">&#xe64e;</i> <input class="login-box-input" name="password" type="password" placeholder="请输入密码">
                <div class="login-container-form-item-split-line"></div>
            </div>
            <div class="layui-form">
                <select id="member-type" name="member-type" lay-filter="member-type">
                    <option selected>请选择登录类型</option>
                    <option value="MANAGER">用户管理员</option>
                    <option value="ADMINISTRATOR">数据管理员</option>
                </select>
            </div>
        </div>
        <div class="login-container-button">
            <button id="submit" class="layui-btn layui-btn-primary" style="width: 100%">登录</button>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js"></script>
<script type="text/javascript" src="../../../../static/layui/layui.all.js"></script>
<script type="text/javascript" src="../../../../static/toastr/toastr.min.js"></script>
<script type="text/javascript" src="../../../../static/common/js/login.js"></script>
</body>
</html>