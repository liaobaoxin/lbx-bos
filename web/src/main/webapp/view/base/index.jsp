<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Full Layout - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/demo.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.easyui.min.js"></script>
</head>


<body class="easyui-layout">

<div data-options="region:'north',split:false" style="height:100px;"></div>

<div data-options="region:'south'" style="height:75px;"></div>


<div data-options="region:'west',title:'系统管理' ,split:false" style="width:150px;">
    <div class="easyui-accordion" fit="true" border="false">
        <div title="基本功能" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
            <ul id="treeMenu" class="ztree"></ul>
        </div>
        <div title="系统管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
            <ul id="adminMenu" class="ztree"></ul>
        </div>
    </div>
</div>

<div data-options="region:'center'" style="padding:5px;background:#eee;">
    <table id="dg"></table>
</div>

</body>

<!--引入脚本开始-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/base/index.js"></script>


</html>
