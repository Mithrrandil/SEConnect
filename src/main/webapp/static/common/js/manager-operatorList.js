//表格对象
var table = layui.table;

//表单对象
var form = layui.form;

//[增加操作员-性别]
var gender;

//表格执行渲染
table.render({

    //渲染对象
    elem: '#operatorTable',

    //表格高度
    height: 460,

    //开启隔行背景
    even: true,

    //请求接口地址
    url: "/member/selectOperatorByManagerIDLimitByPages/",

    //请求参数
    where: {managerID: 1},

    //开启分页
    page: true,

    //分页层级
    limits: [10, 20, 30, 40, 50],

    //分页大小
    limit: 10,

    //设置容器唯一ID
    id: 'operatorTableID',

    //表头选项
    cols: [[

        //列头复选框
        {checkbox: true, LAY_CHECKED: true},

        //表格字段名称,表格可编辑
        {field: 'id', title: 'ID'},
        {field: 'realName', title: '真实姓名', width: 100, edit: 'text'},
        {field: 'gender', title: '性别', width: 100, sort: true, edit: 'text'},
        {field: 'loginUsername', title: '用户名', width: 80},
        {field: 'loginPassword', title: '密码', width: 100, edit: 'text'},
        {field: 'mobile', title: '电话号码', width: 150, sort: true, edit: 'text'},
        {field: 'email', title: '邮箱', width: 200, sort: true, edit: 'text'},
        {field: 'address', title: '联系地址', width: 250, edit: 'text'},
        {field: 'mandatoryUnlockAuthority', title: '强制开锁权限', width: 200, edit: 'text'}
    ]]
});

//刷新按钮点击事件
$('#btn-refresh-operator').on("click", function () {

    //刷新页面
    table.reload('operatorTableID', {
        url: "/member/selectOperatorByManagerIDLimitByPages/"
    });

    //提示用户
    toastr.success("刷新成功");
});

//删除按钮点击事件
$('#btn-delete-operator').on("click", function () {

    //1：获取选中的行对象
    var checkStatus = table.checkStatus('operatorTableID');

    //2：删除用户数量检查
    if (checkStatus.data.length === 0) {
        toastr.error("请选择您要删除的对象");
    } else {

        //确认用户动作
        layer.confirm('您确定要删除当前选中的用户吗?', {icon: 2, title: '注意'}, function (index) {

            //3：准备分离ID的容器
            var IDS = "";

            //4：将ID放到容器中
            for (var i = 0; i < checkStatus.data.length; i++) {

                if (i === 0) {
                    IDS += checkStatus.data[i].id;
                } else {
                    IDS += "," + checkStatus.data[i].id;
                }

            }

            //5：请求后台的删除接口
            $.ajax({
                url: "/member/deleteOperatorsByIDS",
                type: "POST",
                data: {
                    IDS: IDS,
                    managerID:getCookie("SECONNECT_ID")
                },
                success: function (result) {

                    var resultObj = JSON.parse(result);

                    //6：删除成功 - 刷新表格 - 提示用户删除成功
                    if (resultObj.type === "SUCCESS") {

                        //7：刷新表格
                        table.reload('operatorTableID', {
                            url: "/member/selectOperatorByManagerIDLimitByPages/"
                        });

                        toastr.success("删除成功");
                    }
                }
            });


            //8：关闭提示窗
            layer.close(index);
        });
    }
});

//增加按钮点击事件
$('#btn-insert-operator').on("click", function () {
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
        area: ['600px', '535px'],

        //设置弹出动画
        anim: 5,

        //显示目标页面
        content: ['/admin/window/insert-operator']
    });
});

//增加用户异步请求
$("#btn-insert-member-save").click(function () {

    var realName = $(':input[name=realName]').val();

    var loginUsername = $(':input[name=loginUsername]').val();
    var loginPassword = $(':input[name=loginPassword]').val();
    var mobile = $(':input[name=mobile]').val();
    var email = $(':input[name=email]').val();
    var address = $(':input[name=address]').val();




    //判空验证
    if (!mobile.match(/^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$/)) {
        parent.toastr.error("手机格式不正确");
    } else if (!email.match(/^\w+((-\w+)|(\.\w+))*@[A-Za-z0-9]+(([.-])[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
        parent.toastr.error("邮箱格式不正确");
    } else {
        $.ajax({
            type: "POST",
            url: "/member/insertOperator",
            data: {
                realName: realName,
                gender: gender,
                loginUsername: loginUsername,
                loginPassword: loginPassword,
                managerID: getCookie("SECONNECT_ID"),
                mobile: mobile,
                email: email,
                address: address
            },
            success: function (deleteResult) {

                var resultObj = JSON.parse(deleteResult);

                if (resultObj.type === "SUCCESS") {

                    //刷新窗口
                    table.reload('operatorTableID', {
                        url: "/member/selectOperatorByManagerIDLimitByPages/"
                    });

                    //关闭弹窗
                    //得到当前iframe层的索引
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);

                    //提示用户
                    parent.toastr.success("添加成功");

                } else if (resultObj.type === "ERROR") {
                    parent.toastr.error(resultObj.msg);
                }
            }
        });
    }

});

//编辑事件监听
table.on('edit(operatorTableID)', function (obj) {

    $.ajax({
        type: "POST",
        url: "/member/updateOperatorsByID",
        data: {
            id: obj.data.id,
            field: obj.field,
            value: obj.value
        },
        success: function (deleteResult) {

            var resultObj = JSON.parse(deleteResult);

            if (resultObj.type === "SUCCESS") {

                //刷新窗口
                table.reload('operatorTableID', {
                    url: "/member/selectOperatorByManagerIDLimitByPages/"
                });

                //提示用户
                toastr.success("修改成功");
            }
        }
    });
});

//监听下拉框事件
form.on('select(gender)', function (data) {
    gender = data.value;
});



