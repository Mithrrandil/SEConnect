
<div class="operator-list">
    <!--顶部按钮组-->
    <div class="tool-bar" style="text-align: left;">
        <button id="btn-insert-operator" class="layui-btn layui-btn-primary">
            <i class="layui-icon">&#xe654;</i>&nbsp;&nbsp;增加
        </button>

        <button id="btn-delete-operator" class="layui-btn layui-btn-primary">
            <i class="layui-icon">&#xe640;</i>&nbsp;&nbsp;删除
        </button>

        <button id="btn-refresh-operator" class="layui-btn layui-btn-primary">
            <i class="layui-icon">&#x1002;</i>&nbsp;&nbsp;刷新
        </button>
    </div>

    <!--中间显示内容-->
    <div class="tool-table">
        <table id="operatorTable" lay-filter="operatorTableID"></table>
    </div>
</div>
