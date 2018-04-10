<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>业务通知单</title>
    <!-- 导入jquery核心类库 -->
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <!-- 导入easyui类库 -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/css/default.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
    <script
            src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
            type="text/javascript"></script>
    <script type="text/javascript">

        function doadd() {
            window.location.href = "/property/addPage";
        }

        function doCancel() {
            alert("销单...");
        }

        function doSearch() {
            $('#searchWindow').window("open");
        }

        //工具栏
        var toolbar = [{
            id: 'button-search',
            text: '查询',
            iconCls: 'icon-search',
            handler: doSearch
        }, {
            id: 'button-add',
            text: '添加',
            iconCls: 'icon-add',
            handler: doadd
        }, {
            id: 'button-cancel',
            text: '删除',
            iconCls: 'icon-cancel',
            handler: doCancel
        }];
        // 定义列
        var columns = [[{
            field: 'id',
            checkbox: true,
        }, {
            field: 'name',
            title: '姓名',
            width: 120,
            align: 'center'
        }, {
            field: 'number',
            title: '编号',
            width: 120,
            align: 'center'
        }, {
            field: 'telphone',
            title: '号码',
            width: 120,
            align: 'center'
        }, {
            field: 'sex',
            title: '性别',
            width: 120,
            align: 'center'
        }, {
            field: 'education',
            title: '学历',
            width: 120,
            align: 'center'
        }, {
            field: 'timeofentry',
            title: '创建时间',
            width: 100,
            align: 'center'
        }]];

        $(function () {
            // 先将body隐藏，再显示，不会出现页面刷新效果
            $("body").css({visibility: "visible"});

            // 收派标准数据表格
            $('#grid').datagrid({
                iconCls: 'icon-forward',
                fit: true,
                border: true,
                rownumbers: true,
                striped: true,
                pageList: [30, 50, 100],
                pagination: true,
                toolbar: toolbar,
                url: "/property/list",
                idField: 'id',
                columns: columns,
                onDblClickRow: doDblClickRow
            });

            // 查询分区
            $('#searchWindow').window({
                title: '查询人员',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable: false
            });
            $("#btn").click(function () {
                $('#grid').datagrid({
                    queryParams: {
                        name: $('#number').val(),
                        number:$('#userName').val(),
                        date:$('#date').val(),
                    }
                });
                $("#searchForm").get(0).reset();// 重置查询表单
                $("#searchWindow").window("close"); // 关闭窗口


            });
        });

        function doDblClickRow() {
            alert("双击表格数据...");
        }
    </script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
<div region="center" border="false">
    <table id="grid"></table>
</div>

<!-- 查询分区 -->
<div class="easyui-window" title="查询窗口" id="searchWindow" collapsible="false" minimizable="false" maximizable="false"
     style="top:20px;left:200px">
    <div style="overflow:auto;padding:5px;" border="false">
        <form id="searchForm">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td colspan="2">查询条件</td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><input type="text" id="userName" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>编号</td>
                    <td><input type="text"  id="number" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>创建时间</td>
                    <td><input type="text"  id="date" class="easyui-datebox " required="true"/></td>
                </tr>
                <tr>
                    <td colspan="2"><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>