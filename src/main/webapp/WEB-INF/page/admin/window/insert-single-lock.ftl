<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>单锁体信息增加</title>
    <link href="../../../../static/layui/css/layui.css" rel="stylesheet">
    <link href="../../../../static/common/css/common.css" rel="stylesheet">
</head>
<body>

<fieldset class="layui-elem-field" style="margin-top: 30px">
    <legend>注意</legend>
    <div class="layui-field-box">
        &nbsp;&nbsp;&nbsp;&nbsp;柜级锁体数据请求只能在 <strong>一周</strong> 之内提交一次<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;请求提交后将第一时间通知至超级管理员处,请耐心等待<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;请求通过后,锁体增加的材料将通过快递的形式交您的手中,请保持电话通畅<br/>
    </div>
</fieldset>


<form class="layui-form layui-form-pane" action="" style="margin-top: 30px">
    <div class="layui-form-item" pane>
        <label class="layui-form-label">锁体数量</label>
        <div class="layui-input-block">
            <input type="text" name="lockNumber" required lay-verify="required" placeholder="请输入请求的锁体数量"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
</form>

<button id="insert-single-lock-submit" class="layui-btn" style="width: 100%;margin-top: 10px">提交</button>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../../../../static/layui/layui.all.js"></script>
<script type="text/javascript" src="../../../../static/common/js/common.js"></script>
</body>
</html>