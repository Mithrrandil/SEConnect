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
            <i class="fa fa-reddit-alien tpl-mid-navbar-node-icon" aria-hidden="true"></i>人员信息管理
        </a>
        <dl class="layui-nav-child">
            <dd>
                <a  id="operator-list">
                    <i class="fa fa-address-card tpl-mid-navbar-node-icon-child" aria-hidden="true"></i>操作员管理
                </a>
            </dd>
        </dl>
    </li>
    <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;">
            <i class="fa fa-chain-broken tpl-mid-navbar-node-icon" aria-hidden="true"></i>锁体信息管理
        </a>
        <dl class="layui-nav-child">
            <dd>
                <a href="javascript:;">
                    <i class="fa fa-plus-square tpl-mid-navbar-node-icon-child" aria-hidden="true"></i>锁柜增加
                </a>
            </dd>
        </dl>
    </li>
</ul>
