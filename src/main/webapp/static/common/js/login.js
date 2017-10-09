$(function () {

    //Layui表单对象
    var form = layui.form;

    //用户名输入框
    var inputUsername = $("input[name='username']");

    //密码输入框
    var inputPassword = $("input[name='password']");

    //用户类型
    var memberType = "";

    //监听用户类型选中事件
    form.on('select(member-type)', function (data) {
        memberType = data.value;
    });

    $('#submit').click(function () {

        if (inputUsername.val() === "") {
            toastr.error("请填写用户名");
            inputUsername.focus();
        } else if (inputPassword.val() === "") {
            toastr.error("请填写密码");
        } else if ("" === memberType) {
            toastr.error("请选择登录类型");
        } else {
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
                        toastr.error("用户名或者密码错误");
                    } else {
                    }
                },
                error: function () {
                    toastr.error("服务器请求失败,请检查网络")
                }
            });
        }
    });

});