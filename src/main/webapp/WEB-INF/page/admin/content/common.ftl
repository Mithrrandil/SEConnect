<div class="layui-row" style="height: 150px;">
    <!--锁体数据情况-->
    <div class="layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4">
        <div class="card-box" style="background-color: #32c5d2">
            <div class="layui-row">
                <!--content-->
                <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-col-lg9">

                    <!--header-->
                    <div class="card-box-header">锁柜总数</div>

                    <!--content-->
                    <div class="card-box-content">${lockNum}</div>

                    <!--description-->
                    <div class="card-box-description">本季度增加了 ${insertLockTaskNum}个 锁柜</div>
                </div>
                <!--logo-->
                <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 layui-col-lg3" style="padding-top: 17px">
                    <i class="layui-icon card-box-logo">&#xe64d;</i>
                </div>
            </div>
        </div>
    </div>

    <!--人员数据情况-->
    <div class="layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4">
        <div class="card-box" style="background-color: #8E44AD">
            <div class="layui-row">
                <!--content-->
                <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-col-lg9">

                    <!--header-->
                    <div class="card-box-header">操作员总数</div>

                    <!--content-->
                    <div id="lock-number" class="card-box-content">${operatorNum}</div>

                    <!--description-->
                    <div class="card-box-description">本季度增加了 ${insertOperatorTaskNum}个 操作员</div>
                </div>
                <!--logo-->
                <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 layui-col-lg3" style="padding-top: 8px">
                    <i class="layui-icon card-box-logo">&#xe628;</i>
                </div>
            </div>
        </div>
    </div>

    <!--消息推送数据情况-->
    <div class="layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4">
        <div class="card-box" style="background-color: #e7505a">
            <div class="layui-row">
                <!--content-->
                <div class="layui-col-xs9 layui-col-sm9 layui-col-md9 layui-col-lg9">

                    <!--header-->
                    <div class="card-box-header">待处理消息推送</div>

                    <!--content-->
                    <div id="lock-number" class="card-box-content">${taskListNumber}</div>

                    <!--description-->
                    <div class="card-box-description">请您尽快处理消息</div>
                </div>
                <!--logo-->
                <div class="layui-col-xs3 layui-col-sm3 layui-col-md3 layui-col-lg3" style="padding-top: 15px">
                    <i class="layui-icon card-box-logo">&#xe63c;</i>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="layui-row">
    <div class="layui-col-xs6 layui-col-sm6 layui-col-md6 layui-col-lg6">
        <div id="echarts-mandatoryUnlockAuthority-task-queue" class="card-box" style="height: 310px"></div>
    </div>
    <div class="layui-col-xs6 layui-col-sm6 layui-col-md6 layui-col-lg6">
        <div id="echarts-lock-error-task-queue" class="card-box" style="height: 310px"></div>
    </div>
</div>