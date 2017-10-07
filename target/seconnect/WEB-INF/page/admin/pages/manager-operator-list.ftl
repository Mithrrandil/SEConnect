<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1">
    <link rel="icon" href="../../../../static/common/images/icon/icon_small.png" type="image/x-icon"/>
    <title>智能锁柜后台管理系统</title>

    <link href="../../../../static/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="../../../../static/layui/css/layui.css" rel="stylesheet">
    <link href="../../../../static/toastr/toastr.min.css" rel="stylesheet">
    <link href="../../../../static/common/css/common.css" rel="stylesheet">
</head>

<body>

<!--顶部导航-->
<div class="row tpl-header">
    <#include "../common/header.ftl">
</div>

<!--侧边导航栏-->
<div class="row tpl-mid">

    <!--模块导航-->
    <div class="layui-col-xs5 layui-col-sm4 layui-col-md2 layui-col-lg2 tpl-mid-navbar">
        <#include "../common/navbar.ftl">
    </div>

    <!--模块内容-->
    <div class="layui-col-xs7 layui-col-sm8 layui-col-md10 layui-col-lg10 tpl-mid-content">
        <#include "../content/task-lock-add.ftl">
    </div>

</div>

<!--柜级锁体数据增加请求模态窗-->
<#--<#include "../common/task-lock-add.ftl">-->

<!--增加用户模态窗-->
<#--<div class="modal fade bs-example-modal-lg" id="btn-insert-operator-modal" tabindex="-1" role="dialog"-->
     <#--data-backdrop=false data-keyboard=false>-->
    <#--<div class="modal-dialog modal-lg" role="document">-->
        <#--<div class="modal-content">-->
            <#--<div class="modal-header">-->
                <#--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>-->
                <#--</button>-->
                <#--<h4 class="modal-title">-->
                    <#--<i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;增加操作员-->
                <#--</h4>-->
            <#--</div>-->
            <#--<div class="modal-body">-->
                <#--<form class="form-horizontal">-->
                    <#--<div class="form-group">-->
                        <#--<label for="realName" class="layui-col-sm2 control-label">真实姓名</label>-->
                        <#--<div class="layui-col-sm10">-->
                            <#--<input type="text" class="form-control" id="realName" placeholder="真实姓名">-->
                        <#--</div>-->
                    <#--</div>-->

                    <#--<div class="form-group">-->
                        <#--<label for="gender" class="layui-col-sm2 control-label">性别</label>-->
                        <#--<div class="layui-col-sm10">-->
                            <#--<div class="login_type">-->
                                <#--<div class="btn-group btn-group-justified" data-toggle="buttons">-->
                                    <#--<label id="option_male" class="btn btn-default active">-->
                                        <#--<input type="radio" name="gender" value="MALE" autocomplete="off">男-->
                                    <#--</label>-->
                                    <#--<label id="option_female" class="btn btn-default">-->
                                        <#--<input type="radio" name="gender" value="FEMALE" autocomplete="off">女-->
                                    <#--</label>-->
                                <#--</div>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->

                    <#--<div class="form-group">-->
                        <#--<label for="loginUsername" class="layui-col-sm2 control-label">用户名</label>-->
                        <#--<div class="layui-col-sm10">-->
                            <#--<input type="text" class="form-control" id="loginUsername" placeholder="用户名">-->
                        <#--</div>-->
                    <#--</div>-->

                    <#--<div class="form-group">-->
                        <#--<label for="loginPassword" class="layui-col-sm2 control-label">密码</label>-->
                        <#--<div class="layui-col-sm10">-->
                            <#--<input type="password" class="form-control" id="loginPassword" placeholder="密码">-->
                        <#--</div>-->
                    <#--</div>-->

                    <#--<div class="form-group">-->
                        <#--<label for="mobile" class="layui-col-sm2 control-label">手机号码</label>-->
                        <#--<div class="layui-col-sm10">-->
                            <#--<input type="text" class="form-control" id="mobile" placeholder="手机号码">-->
                        <#--</div>-->
                    <#--</div>-->

                    <#--<div class="form-group">-->
                        <#--<label for="email" class="layui-col-sm2 control-label">电子邮件</label>-->
                        <#--<div class="layui-col-sm10">-->
                            <#--<input type="text" class="form-control" id="email" placeholder="电子邮件">-->
                        <#--</div>-->
                    <#--</div>-->

                    <#--<div class="form-group">-->
                        <#--<label for="address" class="layui-col-sm2 control-label">联系地址</label>-->
                        <#--<div class="layui-col-sm10">-->
                            <#--<input type="text" class="form-control" id="address" placeholder="联系地址">-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</form>-->
            <#--</div>-->
            <#--<div class="modal-footer">-->
                <#--<button type="button" class="btn btn-primary" id="btn-insert-member-save">保存</button>-->
                <#--<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->

<script type="text/javascript" src="../../../../static/jQuery/jquery.min.js"></script>
<script type="text/javascript" src="../../../../static/layui/layui.all.js"></script>
<script type="text/javascript" src="../../../../static/toastr/toastr.min.js"></script>
<script type="text/javascript" src="../../../../static/common/js/common.js"></script>
<script type="text/javascript" src="../../../../static/common/js/manager-operatorList.js"></script>
</body>
</html>