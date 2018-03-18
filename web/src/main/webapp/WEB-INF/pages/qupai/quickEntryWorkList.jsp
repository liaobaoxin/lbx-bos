<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>工作单快速录入</title>
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
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>
    <script type="text/javascript">
        var editIndex;//全局变量
        var updateRow;


        function doAdd() {
            if (editIndex != undefined) {
                $("#grid").datagrid('endEdit', editIndex);
            }
            if (editIndex == undefined) {
                //alert("快速添加电子单...");
                $("#grid").datagrid('insertRow', {
                    index: 0,
                    row: {}
                });
                $("#grid").datagrid('beginEdit', 0);
                editIndex = 0;
            }
        }

        function doSave() {
            alert("保存")
        }

        function doCancel() {
            if (editIndex != undefined) {
                $("#grid").datagrid('cancelEdit', editIndex);
                if ($('#grid').datagrid('getRows')[editIndex].id == undefined) {
                    $("#grid").datagrid('deleteRow', editIndex);
                }
                editIndex = undefined;
            }
        }

        function doExport() {
            window.location.href = "/quick/export";
        }


        function doDelete() {
            var data = $("#grid").datagrid('getSelections');
            var names = new Array();
            var ids = new Array();

            for (var i = 0; i < data.length; i++) {
                names.push(data[i].name);
                ids.push(data[i].id);
            }
            $.messager.confirm('提示', '你确定要删除姓名为' + names + '的数据吗？', function (r) {
                if (r) {
                    var url = '/quick/delete?ids=' + ids;
                    $.ajax({
                        type: "GET",
                        url: url,
                        success: function (data) {
                            $('#grid').datagrid('reload'); // 刷新当前页数据
                            alert(data)
                        }
                    });
                }

            });

        }


        //工具栏
        var toolbar = [{
            id: 'button-add',
            text: '新增一行',
            iconCls: 'icon-edit',
            handler: doAdd
        }, {
            id: 'button-cancel',
            text: '取消编辑',
            iconCls: 'icon-cancel',
            handler: doCancel
        }, {
            id: 'button-delete',
            text: '删除',
            iconCls: 'icon-remove',
            handler: doDelete
        }, {
            id: 'button-save',
            text: '保存',
            iconCls: 'icon-save',
            handler: doSave
        }, {
            id: 'button-export',
            text: '导出',
            iconCls: 'icon-undo',
            handler: doExport
        }, {
            id: 'btn-upload',
            text: '批量导入',
            iconCls: 'icon-redo'
        }];
        // 定义列
        var columns = [[
            {
                field: 'name',
                title: '姓名',
                width: 120,
                align: 'center',
                editor: {
                    type: 'validatebox',
                    options: {
                        required: true
                    }
                }
            }, {
                field: 'telephone',
                title: '电话号码',
                width: 120,
                align: 'center',
                editor: {
                    type: 'numberbox',
                    options: {
                        required: true
                    }
                }
            }, {
                field: 'address',
                title: '地址',
                width: 300,
                align: 'center',
                editor: {
                    type: 'validatebox',
                    options: {
                        required: true
                    }
                }
            }, {
                field: 'goodsDesc',
                title: '商品描述',
                width: 150,
                align: 'center',
                editor: {
                    type: 'validatebox',
                    options: {}
                }
            }, {
                field: 'orderNum',
                title: '订单编号',
                width: 120,
                align: 'center',
                editor: {
                    type: 'validatebox',
                    options: {}
                }
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
                url: "list?" + new Date(),
                idField: 'id',
                columns: columns,
                onDblClickCell: doDblClickCell,
                onAfterEdit: function (rowIndex, rowData, changes) {
                    console.info(rowData);
                    editIndex = undefined;
                    $.post('/quick/add', rowData, function (data) {
                        if (data == '0') {
                            $.messager.alert("提示信息", "录入失败！", "error");
                        }
                    });
                }
            });

            // 一键上传
            $("#btn-upload").upload({
                name: 'orderFile',  // <input name="file" />
                action: '${pageContext.request.contextPath}/import',  // 提交请求action路径
                enctype: 'multipart/form-data', // 编码格式
                autoSubmit: true, // 选中文件提交表单
                onComplete: function (response) {
                    if (response == "success") {
                        $.messager.alert("提示信息", "数据导入成功！", "info");
                        $("#grid").datagrid("reload");
                    } else {
                        $.messager.alert("错误提示", response, "error");
                    }
                }// 请求完成时 调用函数
            });
        });

        function doDblClickCell(rowIndex, field, value) {
            if (updateRow == "OK") {
                alert("请为编辑的数据敲回车键");
                return;
            }
            $('#grid').datagrid('beginEdit', rowIndex);
            var ed = $('#grid').datagrid('getEditor', {index: rowIndex, field: field});
            editIndex = rowIndex;
            updateRow = "OK";
            $(ed.target).keydown(function (e) {
                if (e.which == 13) {
                    $('#grid').datagrid('endEdit', rowIndex);
                    //获得修改数据
                    var rows = $('#grid').datagrid('getRows');
                    var row = rows[rowIndex];
                    alert(JSON.stringify(row));
                    $.post('/quick/update', row, function (data) {
                        alert("一" + data);
                        updateRow = undefined;
                    })

                }
            });

        }


    </script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
<div region="center" border="false">
    <table id="grid"></table>
</div>

<div class="track-rcol">
    <div class="track-list">
        <ul>
            <li class="first">
                <i class="node-icon"></i>
                <span class="time">2016-03-10 18:07:15</span>
                <span class="txt">感谢您在京东购物，欢迎您再次光临！</span>
            </li>
            <li>
                <i class="node-icon"></i>
                <span class="time">2016-03-10 18:07:15</span>
                <span class="txt">【京东到家】京东配送员【申国龙】已出发，联系电话【18410106883，感谢您的耐心等待，参加评价还能赢取京豆呦】</span>
            </li>
            <li>
                <i class="node-icon"></i>
                <span class="time">2016-03-10 18:07:15</span>
                <span class="txt">感谢您在京东购物，欢迎您再次光临！</span>
            </li>
            <li>
                <i class="node-icon"></i>
                <span class="time">2016-03-10 18:07:15</span>
                <span class="txt">感谢您在京东购物，欢迎您再次光临！</span>
            </li>
            <li>
                <i class="node-icon"></i>
                <span class="time">2016-03-10 18:07:15</span>
                <span class="txt">感谢您在京东购物，欢迎您再次光临！</span>
            </li>
            <li>
                <i class="node-icon"></i>
                <span class="time">2016-03-10 18:07:15</span>
                <span class="txt">感谢您在京东购物，欢迎您再次光临！</span>
            </li>
        </ul>
    </div>
</div>
<div id="delete">Dialog Content.</div>
</body>
</html>