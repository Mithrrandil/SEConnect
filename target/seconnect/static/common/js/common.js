/**
 * 获取Cookie
 * @param name Cookie的名称
 * @returns Cookie的值
 */
function getCookie(name) {
    if (name !== null) {
        var value = new RegExp("(?:^|; )" + encodeURIComponent(String(name)) + "=([^;]*)").exec(document.cookie);
        return value ? decodeURIComponent(value[1]) : null;
    }
}

/**
 * 获取URL中的参数
 * @param name 参数名称
 * @returns 参数值
 * @constructor
 */
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r !== null) return unescape(r[2]);
    return null;
}

/**
 * 获取当前的URL
 * @return string
 */
function getUrl() {
    return window.location.href;
}

/**
 * 跳转到登录界面
 */
function locationToLogin() {
    window.location.href = "/admin/pages/login"
}

//登录检测定时任务
window.setInterval(loginCheck, 3000);

//登录检测
function loginCheck() {
    if (getCookie("SECONNECT_ID") === null || getCookie("SECONNECT_REALNAME") === null) {

        //提示用户登录已过期
        toastr.error('对不起登录已过期,请重新登录');

        setInterval(locationToLogin, 2000);
    }
}

//左侧导航条 [操作员管理] 点击事件
$('#operator-list').click(function () {
    if (getUrl().indexOf("/admin/pages/manager-operator-list") >= 0) {
        toastr.warning("您已经在指定的页面,无需跳转");
    } else {
        window.location.href = "/admin/pages/manager-operator-list";
    }
});

//左侧导航条 [锁柜增加] 点击事件
$('#insert-single-lock').click(function () {

    // //清空原先窗口中的数据
    // $(':input[name=lockNumber]').val("");

    layer.open({

        //iframe
        type: 2,

        //不显示标题
        title: false,

        //不显示确认按钮
        btn: false,

        //关闭模态窗效果
        shade: 0,

        //设置大小
        area: ['600px', '300px'],

        //设置弹出动画
        anim: 5,

        //显示目标页面
        content: ['/admin/window/insert-single-lock']
    });



});

//顶部消息框弹出
$('#msg').click(function () {

    //消息框对象
    var msgObj = $('#msg');

    var X = msgObj.offset().top + 60;
    var Y = msgObj.offset().left - 300;

    layer.open({

        type: 2,

        //不显示标题
        title: false,

        //不显示模态窗效果
        shade: 0,

        //不显示确认按钮
        btn: false,

        //自动关闭时间
        // time: 5000,

        //设置大小
        area: ['350px', '400px'],

        //设置显示位置
        offset: [X, Y],

        //设置弹出动画
        anim: 5,

        //显示目标页面
        content: '/admin/common/msg',

        //关闭刷新编号
        cancel: function(index, layero){

            //1: 获取当前任务数量编号 DOM 对象
            var lockNumObj = $('#msg-num');

            // 2: 刷新编号
            $.ajax({
                type: "POST",
                url: "/task/getRapeLockTaskNum",
                success: function (data) {

                    // 2.1 关闭窗体
                    layer.close(index);

                    // 2.2 解析 JSON
                    var message = JSON.parse(data);

                    if (message.type === 'SUCCESS') {
                        lockNumObj.text(message.msg);
                    }
                },
                error: function () {
                    toastr.error("服务器请求失败请检查网络");
                }
            });

            return false;
        }

    });
});

//右上角消息弹出窗按钮点击事件
$(".msg-button").click(function () {

    //获取当前任务的ID
    var taskID = $(this).parents(".layui-row").attr("id");

    //获取当前任务的请求结果
    var taskResult = $(this).attr("name");

    //删除当前任务信息容器
    var content = $(this).parents(".layui-row");

    //根据任务类型判断提示语句
    if (taskResult === 'FINISHED') {
        var confirmMsg = "您确定要同意当前请求吗"
    }else if(taskResult === 'LOCK_ERROR_FINISHED'){
        var confirmMsg = "您已经安排好维修任务了吗";
        taskResult = "FINISHED";
    } else {
        var confirmMsg = "您确定要拒绝当前请求吗"
    }

    parent.layer.confirm(confirmMsg, {icon: 3, title: '提示'}, function (index) {

        //异步请求删除任务接口
        $.ajax({
            type: "POST",
            url: "/task/dealWithMandatoryUnlockAuthority",
            data: {
                id: taskID,
                taskResult: taskResult
            },
            success: function (data) {

                var message = JSON.parse(data);

                if (message.type === 'SUCCESS') {

                    //移除DOM元素
                    content.remove();

                    //当结果类型为同意时重载表格
                    if (taskResult === 'FINISHED') {
                        parent.table.reload('operatorTableID', {
                            url: "/member/selectOperatorByManagerIDLimitByPages/"
                        });
                    }

                    //提示用户删除成功
                    parent.toastr.success("成功处理一条消息推送");
                }

            },
            error: function () {
                toastr.error("服务器请求失败请检查网络");
            }
        });

        parent.layer.close(index);

    });

});

//增加柜级锁体数据保存点击事件
$('#insert-single-lock-submit').click(function () {


    //1：获取用户输入的增加锁柜数目
    var singleLockNumber = $(':input[name=lockNumber]').val();
    console.log(singleLockNumber);

    var regexp = new RegExp(/^[0-9]+$/);

    if(regexp.test(singleLockNumber)){
        //2: 异步请求增加锁柜接口
        $.ajax({
            type: "POST",
            url: "/task/addSingleLockTask",
            data: {
                managerLoginUsername: getCookie("SECONNECT_LOGIN_USERNAME"),
                managerRealName: getCookie("SECONNECT_REALNAME"),
                singleLockNumber: singleLockNumber
            },
            success: function (data) {

                var message = JSON.parse(data);

                if (message.type === 'SUCCESS') {
                    parent.toastr.success("提交请求成功,请求进度请关注消息推送");
                } else if (message.type === 'ERROR') {
                    parent.toastr.error(message.msg);
                }
            },
            error: function () {
                parent.toastr.error('服务器请求失败，请检查网络');
            }
        });
    }else{
        parent.toastr.error("请您输入一个合法的正整数");
    }

});

//顶部logo点击事件
$('#logo').click(function () {
    window.location.href = "/admin/pages/common";
});

//用户登出
$('#login-out').click(function () {
    $.ajax({
        type: "POST",
        url: "/login/loginOut",
        success: function (data) {

            var message = JSON.parse(data);

            if (message.type === 'SUCCESS') {
                locationToLogin();
            }
        },
        error: function () {
            toastr.error('服务器请求失败，请检查网络');
        }
    });
});



