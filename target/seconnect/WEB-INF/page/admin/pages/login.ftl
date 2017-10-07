<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录 | Login</title>
    <link rel="icon" href="../../../../static/common/images/icon/icon_small.png"/>
    <link href="../../../../static/bootstrap/css/bootstrap.css" rel="stylesheet"/>

    <style>
        #login_header_text {
            font-size: 40px;
        }

        .login_bar {
            text-align: center;
            height: 300px;
            position: absolute;
            top: 50%;
            margin-top: -150px;
        }

        .login_form {
            margin-top: 15px;
        }

        .login_type {
            margin-top: 15px;
        }
        .wCanvas{
            display: block;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>

<!--背景特效-->
<canvas id="background_canvas" class="wCanvas"></canvas>

<div class="container-fluid">
    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md4 layui-col-lg4  layui-col-mdoffset-4 layui-col-lgoffset-4 login_bar">

            <span id="login_header">
                <span id="login_header_text">SEConnect</span>
            </span>

            <span>
                 <img src="../../../../static/common/images/lock.png" alt=""
                      style="width: 45px;height: 45px;margin-left: 20px;margin-bottom: 15px">
            </span>

            <div class="login_form">
                <div class="input-group" id="input_group_username" style="margin-top: 15px">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-user"></span>
                    </span>
                    <input type="text" class="form-control" placeholder="请输入用户名" name="username">
                </div>

                <div class="input-group" id="input_group_password" style="margin-top: 15px">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-pencil"></span>
                    </span>
                    <input type="password" class="form-control" placeholder="请输入密码" name="password">
                </div>
            </div>

            <div class="login_type">
                <div class="btn-group btn-group-justified" data-toggle="buttons">
                    <label id="option_manager" class="btn btn-danger active">
                        <input type="radio" name="options" value="option_manager" autocomplete="off">管理员点这里
                    </label>
                    <label id="option_administrator" class="btn btn-danger">
                        <input type="radio" name="options" value="option_administrator" autocomplete="off">超级管理员点这里
                    </label>
                </div>
            </div>

            <div id="login_error" class="alert alert-danger alert-dismissible" role="alert" hidden
                 style="margin-top: 15px">
                <strong id="login_error_text">抱歉 用户名或者密码错误</strong>
            </div>

            <button type="button" class="btn btn-primary btn-block" id="btn_submit" style="margin-top: 15px">登录</button>

        </div>
    </div>
</div>
<script src="../../../../static/jQuery/jquery.min.js"></script>
<script src="../../../../static/bootstrap/js/bootstrap.js"></script>

<!--离散背景特效-->
<script type="text/javascript">
    var w = window.innerWidth;
    var h = window.innerHeight;
    var canvas = document.getElementById("background_canvas");
    var ctx = canvas.getContext("2d");
    canvas.width = w;
    canvas.height = h;

    function fnRandom(min, max) {
        return parseInt((max - min) * Math.random() + min + 1)
    }

    function Round() {
        this.r = fnRandom(10, 30);
        var x = fnRandom(0, canvas.width - this.r);
        this.x = x < this.r ? this.r : x;
        var y = fnRandom(0, canvas.height - this.r);
        this.y = y < this.r ? this.r : y;
        var speed = fnRandom(2, 4) / 10;
        this.speedX = fnRandom(0, 4) > 2 ? speed : -speed;
        this.speedY = fnRandom(0, 4) > 2 ? speed : -speed;
        this.color = "#286090";
    }

    Round.prototype.draw = function () {
        ctx.fillStyle = this.color;
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.r, 0, Math.PI * 2, true);
        ctx.closePath();
        ctx.fill();
    };
    Round.prototype.move = function () {
        this.x += this.speedX;
        if (this.x > canvas.width - this.r) {
            this.speedX *= -1;
            this.x = this.r
        } else if (this.x < this.r) {
            this.x = canvas.width - this.r
        }
        this.y += this.speedY;
        if (this.y > canvas.height - this.r) {
            this.speedY *= -1;
            this.y = this.r
        } else if (this.y < this.r) {
            this.y = canvas.height - this.r
        }
    };
    var allRound = [];

    function initRound() {
        for (var i = 0; i < 5; i++) {
            var obj = new Round();
            obj.draw();
            obj.move();
            allRound.push(obj);
        }
    }

    initRound();
    var dxdy = [];

    function roundMove() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        for (var i = 0; i < allRound.length; i++) {
            var round = allRound[i];
            round.draw();
            round.move();
            dxdy[i] = {dx: round.x, dy: round.y};
            var dx = dxdy[i].dx;
            var dy = dxdy[i].dy;
            for (var j = 0; j < i; j++) {
                var sx = dxdy[j].dx;
                var sy = dxdy[j].dy;
                length = Math.sqrt((dx - sx) * (dx - sx) + (dy - sy) * (dy - sy));
                var C = 1 / length * 7 - 0.009;
                var o = C > 0.03 ? 0.03 : C;
                ctx.strokeStyle = 'rgba(0,0,0,' + 0.08 + ')';
                ctx.beginPath();
                ctx.lineWidth = 3;
                ctx.moveTo(dxdy[i].dx, dxdy[i].dy);
                ctx.lineTo(dxdy[j].dx, dxdy[j].dy);
                ctx.closePath();
                ctx.stroke()
            }
        }
        window.requestAnimationFrame(roundMove)
    }

    roundMove();
</script>

<!--主程序JS-->
<script language="javascript" type="text/javascript">

    /*用户登陆按键登陆*/
    $(document).ready(function () {
        $('#btn_submit').click(function () {
            new CheckErrorWindow();
            if (Check()) {
                submit();
            }
        });
    });

    /*用户回车键按键登陆*/
    $(this).keypress(function (e) {
        switch (e.which) {
            case 13:
                new CheckErrorWindow();
                if (Check()) {
                    submit();
                }
                break;
        }
    });

    //用户名输入框
    var inputUsername = $("input[name='username']");

    //用户名输入框组
    var inputGroupUsername = $("#input_group_username");

    //密码输入框
    var inputPassword = $("input[name='password']");

    //密码输入框组
    var inputGroupPassword = $("#input_group_password");

    //数据管理员单选框
    var optionAdministrator = $("#option_administrator");

    //人员管理单选框
    var optionManager = $("#option_manager");

    //错误框
    var windowError = $("#login_error");

    //错误框中的文字
    var windowErrorText = $('#login_error_text');

    //默认权限类型
    var memberType = "MANAGER";

    //管理员按钮点击事件
    optionManager.on('click', function () {
        memberType = "MANAGER";
    });

    //超级管理员点击事件
    optionAdministrator.on('click', function () {
        memberType = "ADMINISTRATOR";
    });

    /**
     * 校验用户名密码是否为空
     * @returns {boolean}
     * @constructor
     */
    function Check() {

        var flag = true;

        if (inputUsername.val() === "") {
            inputGroupUsername.addClass("has-error");
            inputUsername.focus();
            flag = false;
        }

        if (inputPassword.val() === "") {
            inputGroupPassword.addClass("has-error");
            inputPassword.focus();
            flag = false;
        }

        if (inputUsername.val() !== "") {
            inputGroupUsername.removeClass("has-error");
        }

        if (inputPassword.val() !== "") {
            inputGroupPassword.removeClass("has-error");
        }
        return flag;
    }

    /**
     * 错误窗口与异常显示
     * @constructor
     */
    function CheckErrorWindow() {
        if (!windowError.is(":hidden")) {
            windowError.hide();
        }
    }

    /**
     * 提交登录
     */
    function submit() {
        $.ajax({
            type: "POST",
            url: "/login/submit",
            data: {
                loginUsername: inputUsername.val(),
                loginPassword: inputPassword.val(),
                channel: "ADMIN",
                memberType: memberType
            },
            success: function (data) {

                var message = JSON.parse(data);

                if (message.type === 'SUCCESS') {
                    location.href = '/admin/pages/common?memberType=' + memberType;
                } else if (message.type === 'ERROR') {
                    windowErrorText.text(message.msg);
                    windowError.show();
                }
            },
            error: function () {
                windowErrorText.text('请求服务器失败请检查网络');
                windowError.show();
            }
        });
    }
</script>

</body>
</html>