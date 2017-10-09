<div class="tpl-navbar-member" style="margin-bottom: 50px">
    <!--用户头像-->
    <div class="layui-row">
        <div class="layui-col-xs6 layui-col-sm5 layui-col-md6 layui-col-lg6 layui-col-xs-offset3 layui-col-sm-offset4 layui-col-md-offset3 layui-col-lg-offset3" align="center">
            <img src="../../../static/common/images/head.jpg" class="tpl-mid-navbar-header">
        </div>
    </div>

    <!--用户真实姓名-->
    <div class="layui-row">
        <div class="layui-col-xs6 layui-col-sm5 layui-col-md6 layui-col-lg6 layui-col-xs-offset3 layui-col-sm-offset4 layui-col-md-offset3 layui-col-lg-offset3" align="center">
            <span>${memberRealname!}</span>
        </div>
    </div>
</div>

<!--树状导航-->
<ul class="layui-nav layui-nav-tree" lay-filter="test" style="width: 100%;height: 100%">
    <li class="layui-nav-item layui-nav-itemed">
        <a>
            <i class="layui-icon tpl-mid-navbar-node-icon">&#xe613;</i>人员信息管理
        </a>
        <dl class="layui-nav-child">
            <dd>
                <a  id="operator-list">
                    <i class="layui-icon tpl-mid-navbar-node-icon-child">&#xe602;</i>操作员管理
                </a>
            </dd>
        </dl>
    </li>
    <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;">
            <i class="layui-icon tpl-mid-navbar-node-icon">&#xe64c;</i>锁体信息管理
        </a>
        <dl class="layui-nav-child">
            <dd>
                <a id="insert-single-lock">
                    <i class="layui-icon tpl-mid-navbar-node-icon-child">&#xe602;</i>锁柜增加
                </a>
            </dd>
        </dl>
        <dl class="layui-nav-child">
            <dd>
                <a id="insert-single-lock">
                    <i class="layui-icon tpl-mid-navbar-node-icon-child">&#xe602;</i>强制开锁请求
                </a>
            </dd>
        </dl>
        <dl class="layui-nav-child">
            <dd>
                <a id="insert-single-lock">
                    <i class="layui-icon tpl-mid-navbar-node-icon-child">&#xe602;</i>消息中心
                </a>
            </dd>
        </dl>
    </li>
</ul>
