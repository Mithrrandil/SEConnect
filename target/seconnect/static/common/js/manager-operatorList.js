//表格对象
var table = layui.table;

//默认权限类型
var operatorGender = "MALE";

//输入框对象容器
var inputObjArray = [];

inputObjArray[0] = $('#realName');
inputObjArray[1] = $('#loginUsername');
inputObjArray[2] = $('#loginPassword');
inputObjArray[3] = $('#mobile');
inputObjArray[4] = $('#email');
inputObjArray[5] = $('#address');

//性别选择器 - 男
$('#option_male').on('click', function () {
    operatorGender = "MALE";
});

//性别选择器 - 女
$('#option_female').on('click', function () {
    operatorGender = "FEMALE";
});

//执行渲染
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
    $('#btn-insert-operator-modal').modal('show');
});

//增加用户异步请求
$("#btn-insert-member-save").bind('click', function () {

    //判空验证
    if (!isFormObjBlank(inputObjArray)) {
        toastr.error("用户信息不能为空");
    } else if (!inputObjArray[3].val().match(/^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$/)) {
        toastr.error("手机格式不正确");
    } else if (!inputObjArray[4].val().match(/^\w+((-\w+)|(\.\w+))*@[A-Za-z0-9]+(([.-])[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
        toastr.error("邮箱格式不正确");
    } else {
        $.ajax({
            type: "POST",
            url: "/member/insertOperator",
            data: {
                realName: inputObjArray[0].val(),
                gender: operatorGender,
                loginUsername: inputObjArray[1].val(),
                loginPassword: inputObjArray[2].val(),
                managerID: getCookie("SECONNECT_ID"),
                mobile: inputObjArray[3].val(),
                email: inputObjArray[4].val(),
                address: inputObjArray[5].val()
            },
            success: function (deleteResult) {

                var resultObj = JSON.parse(deleteResult);

                if (resultObj.type === "SUCCESS") {

                    //1:关闭窗口
                    $('#btn-insert-operator-modal').modal('hide');

                    //2：刷新窗口
                    table.reload('operatorTableID', {
                        url: "/member/selectOperatorByManagerIDLimitByPages/"
                    });

                    //3：提示用户
                    toastr.success("添加成功");
                } else if (resultObj.type === "ERROR") {
                    toastr.error(resultObj.msg);
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

//模态框关闭事件
$('#btn-insert-operator-modal').on('hidden.bs.modal', function (e) {
    inputObjArray[0].val("");
    inputObjArray[1].val("");
    inputObjArray[2].val("");
    inputObjArray[3].val("");
    inputObjArray[4].val("");
    inputObjArray[5].val("");
});