<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加操作员</title>
    <link href="../../../../static/layui/css/layui.css" rel="stylesheet">
    <link href="../../../../static/common/css/common.css" rel="stylesheet">
</head>
<body class="window">

<div class="window-header">
    <div class="window-header-icon">
        <i class="layui-icon">&#xe613;</i><span class="window-header-text">操作员增加</span>
    </div>
</div>

<hr>

<div class="window-body">
    <form class="layui-form" action="">

        <div class="layui-form-item">
            <label class="layui-form-label">真实姓名</label>
            <div class="layui-input-block" style="margin-right: 40px" style="margin-right: 40px">
                <input type="text" name="realName" class="layui-input" autocomplete="off" lay-verify="required" placeholder="真实姓名" required>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block" style="margin-right: 40px">
                <select name="gender" lay-verify="required" lay-filter="gender">
                    <option selected>请选择性别</option>
                    <option value="MALE">男</option>
                    <option value="FEMALE">女</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block" style="margin-right: 40px">
                <input type="text" name="loginUsername" class="layui-input" autocomplete="off" lay-verify="required" placeholder="用户名" required>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block" style="margin-right: 40px">
                <input type="password" name="loginPassword" class="layui-input" autocomplete="off" lay-verify="required" placeholder="密码" required>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">手机号码</label>
            <div class="layui-input-block" style="margin-right: 40px">
                <input type="text" name="mobile" class="layui-input" autocomplete="off" lay-verify="required" placeholder="手机号码" required>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">电子邮件</label>
            <div class="layui-input-block" style="margin-right: 40px">
                <input type="email" name="email" class="layui-input" autocomplete="off" lay-verify="required" placeholder="电子邮件" required>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">联系地址</label>
            <div class="layui-input-block" style="margin-right: 40px">
                <input type="text" name="address" class="layui-input" autocomplete="off" lay-verify="required" placeholder="联系地址" required>
            </div>
        </div>

    </form>
</div>

<hr>

<div class="window-footer">
    <button id="btn-insert-member-save" class="layui-btn" style="width: 100%;margin-top: 10px">提交</button>
</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../../../../static/layui/layui.all.js"></script>
<script type="text/javascript" src="../../../../static/common/js/common.js"></script>
<script type="text/javascript" src="../../../../static/common/js/manager-operatorList.js"></script>
</body>
</html>