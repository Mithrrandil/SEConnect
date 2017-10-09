<!--Logo-->
<div id="logo" class="layui-col-xs3 layui-col-sm3 layui-col-md2 layui-col-lg2">
    <img src="../../../../static/common/images/logo.png" class="tpl-header-logo">
</div>

<!--消息推送-->
<div id="msg" class="layui-col-xs2 layui-col-sm1 layui-col-md1  layui-col-lg1 layui-col-xs-offset3 layui-col-sm-offset6 layui-col-md-offset7 layui-col-lg-offset7 tpl-header-msg">
    <!--消息图标-->
    <div class="tpl-header-item">
        <i class="layui-icon" style="font-size: 25px">&#xe629;</i>
    </div>
    <!--消息数量图标-->
    <div class="tpl-header-item-num">
        <span class="layui-badge tpl-header-item-num-badge">${taskListNumber!}</span>
    </div>
</div>

<!--异常推送-->
<div id="error-msg" class="layui-col-xs2 layui-col-sm1 layui-col-md1  layui-col-lg1 tpl-header-msg">
    <!--消息图标-->
    <div class="tpl-header-item">
        <i class="layui-icon" style="font-size: 25px;">&#xe60f;</i>
    </div>
    <!--消息数量图标-->
    <div class="tpl-header-item-num">
        <span class="layui-badge tpl-header-item-num-badge">0</span>
    </div>
</div>

<!--退出-->
<div id="login-out" class="layui-col-xs2 layui-col-sm1 layui-col-md1  layui-col-lg1 tpl-header-msg">
    <div class="tpl-header-item">
        <i class="layui-icon" style="font-size: 25px;">&#xe65b;</i>
    </div>
</div>