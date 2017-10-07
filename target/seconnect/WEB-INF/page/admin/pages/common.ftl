<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1">
    <link rel="icon" href="../../../../static/common/images/icon/icon_small.png" type="image/x-icon"/>
    <title>智能锁柜后台管理系统</title>

    <link href="../../../../static/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="../../../../static/layui/css/layui.css" rel="stylesheet">
    <link href="../../../../static/toastr/toastr.min.css" rel="stylesheet">
    <link href="../../../../static/common/css/common.css" rel="stylesheet">
</head>

<body>

<!--顶部导航-->
<div class="layui-row tpl-header">
    <#include "../common/header.ftl">
</div>

<!--侧边导航栏-->
<div class="layui-row tpl-mid">

    <!--模块导航-->
    <div class="layui-col-xs5 layui-col-sm4 layui-col-md3 layui-col-lg2 tpl-mid-navbar">
        <#include "../common/navbar.ftl">
    </div>

    <!--模块内容-->
    <div class="layui-col-xs7 layui-col-sm8 layui-col-md9 layui-col-lg10 tpl-mid-content">
        <#include "../content/common.ftl">
    </div>

</div>

<!--柜级锁体数据增加请求模态窗-->
<#--<#include "../common/task-lock-add.ftl">-->

<script type="text/javascript" src="../../../../static/echarts/echarts.min .js"></script>
<script type="text/javascript" src="../../../../static/jQuery/jquery.min.js"></script>
<script type="text/javascript" src="../../../../static/layui/layui.all.js"></script>
<script type="text/javascript" src="../../../../static/toastr/toastr.min.js"></script>
<script type="text/javascript" src="../../../../static/common/js/common.js"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var mandatoryUnlockAuthorityTaskQueue = echarts.init(document.getElementById('echarts-mandatoryUnlockAuthority-task-queue'));
    var lockErrorTaskQueue = echarts.init(document.getElementById('echarts-lock-error-task-queue'));

    // 指定图表的配置项和数据
    var mandatoryUnlockAuthorityOption = {
        title: {
            text: '近7天强制开锁信息请求',
            subtext: '数据未能正常显示,请刷新表格'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        toolbox: {
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: {readOnly: false},
                magicType: {type: ['line', 'bar']},
                restore: {},
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: ['第一天', '第二天', '第三天', '第四天', '第五天', '第六天', '第七天']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '强制开锁请求',
                type: 'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data:${mandatoryUnlockAuthorityTaskInSevenDays}
            }
        ]
    };


    var lockError = {
        title: {
            text: '近七天锁体异常提交分布',
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            x: 'center',
            y: 'bottom',
            data: ['rose1', 'rose2', 'rose3', 'rose4', 'rose5', 'rose6', 'rose7', 'rose8']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {
                    show: true,
                    type: ['pie', 'funnel']
                },
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        series: [
            {
                name: '锁体异常提交报表',
                type: 'pie',
                radius: [30, 110],
                center: ['50%', '50%'],
                roseType: 'area',
                data: [
                <#list lockErrorTaskInSevenDays?keys as key>
                    {value: ${lockErrorTaskInSevenDays[key]!}, name: '${key!}'},
                </#list>
                ]
            }
        ]
    };


    // 使用刚指定的配置项和数据显示图表。
    mandatoryUnlockAuthorityTaskQueue.setOption(mandatoryUnlockAuthorityOption);
    lockErrorTaskQueue.setOption(lockError);
</script>
</body>
</html>