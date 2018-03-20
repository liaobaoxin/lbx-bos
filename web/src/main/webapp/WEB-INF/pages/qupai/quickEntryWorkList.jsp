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

        function doSearch(value) {
            var preDate = $('#preDate').datetimebox('getValue');
            var sutDate = $('#sutDate').datetimebox('getValue');
            $('#grid').datagrid({
                queryParams: {
                    keyWord: value,
                    preDate: preDate,
                    sutDate: sutDate
                }
            });
        }

        function editUser(index) {
            var rows = $('#grid').datagrid('getRows');
            var row = rows[index];
            if (row) {
                $('#dd').dialog({
                    title: '物流查询',
                    width: 500,
                    height: 700,
                    resizable: true,
                    closed: false,
                    cache: false,
                    href: 'logisticsState?orderNum=' + row.orderNum,
                    modal: true
                });
            }
        }


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
            if (editIndex != undefined) {
                $("#grid").datagrid('endEdit', editIndex);
            }
            if (updateRow != undefined) {
                $('#grid').datagrid('endEdit', updateRow);
                //获得修改数据
                var rows = $('#grid').datagrid('getRows');
                var row = rows[updateRow];
                $.post('/quick/update', row, function (data) {
                    updateRow = undefined;
                })
            }
        }

        function doCancel() {
            if (editIndex != undefined) {
                updateRow = undefined;
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

        function refresh() {
            $('#sutDate').datebox('setValue', '');
            $('#preDate').datebox('setValue', '');
            $('#searchbox').searchbox('setValue', '');

            $('#grid').datagrid('reload');
        }


        function doDelete() {
            var data = $("#grid").datagrid('getSelections');
            if (data.length == 0) {
                $.messager.alert('提示', '请至少选中一行记录', 'warning');
                return;
            }
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
                        }
                    });
                }

            });

        }


        //工具栏
        var toolbar = [{
            id: 'button-add',
            text: '新增一行',
            iconCls: 'icon-add',
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
        }, /*{
            id: 'button-save',
            text: '保存',
            iconCls: 'icon-save',
            handler: doSave
        },*/ {
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
                field: 'id',
                checkbox: true
            }, {
                field: 'name',
                title: '姓名',
                width: 100,
                align: 'center',
                editor: {
                    type: 'validatebox',
                    options: {
                        required: true
                    }
                },
                formatter: function (value, row, index) {
                    var orderNum = row.orderNum;
                    if (orderNum != undefined && orderNum != null && orderNum != "") {
                        return '<a href="#" style="font-size: 17px;line-height: 20px" onclick="editUser(' + index + ')">' + value + '</a>';//改变表格中内容字体的大小
                    } else {
                        return '<span style="font-size: 17px;line-height: 20px">' + value + '</span>';//改变表格中内容字体的大小
                    }
                }
            }, {
                field: 'telephone',
                title: '电话号码',
                width: 140,
                align: 'center',
                editor: {
                    type: 'numberbox',
                    options: {
                        required: true
                    }
                },
                formatter: function (value, row, index) {
                    return '<span style="font-size: 17px;line-height: 30px">' + value + '</span>';//改变表格中内容字体的大小
                }
            }, {
                field: 'address',
                title: '地址',
                width: 700,
                align: 'center',
                editor: {
                    type: 'validatebox',
                    options: {
                        required: true
                    }
                },
                formatter: function (value, row, index) {
                    return '<span style="font-size: 17px;line-height: 30px">' + value + '</span>';//改变表格中内容字体的大小
                }
            }, {
                field: 'goodsDesc',
                title: '商品描述',
                width: 150,
                align: 'center',
                editor: {
                    type: 'validatebox',
                    options: {}
                },
                formatter: function (value, row, index) {
                    return '<span style="font-size: 17px;line-height: 30px">' + value + '</span>';//改变表格中内容字体的大小
                }
            }, {
                field: 'orderNum',
                title: '订单编号',
                width: 200,
                align: 'center',
                editor: {
                    type: 'validatebox',
                    options: {}
                },
                formatter: function (value, row, index) {
                    return '<span style="font-size: 17px;line-height: 30px">' + value + '</span>';//改变表格中内容字体的大小
                }
            },]];

        $(function () {
            // 先将body隐藏，再显示，不会出现页面刷新效果
            $("body").css({visibility: "visible"});

            // 收派标准数据表格
            $('#grid').datagrid({
                iconCls: 'icon-forward',
                fit: true,
                border: true,
                autoRowHeight: true,
                rownumbers: true,
                striped: true,
                pageList: [30, 50, 100],
                pagination: true,
                toolbar: '#tb',
                url: "list?" + new Date(),
                idField: 'id',
                columns: columns,
                onDblClickCell: doDblClickCell,
                checkOnSelect: true,
                onAfterEdit: function (rowIndex, rowData, changes) {
                    console.info(rowData);
                    editIndex = undefined;
                    $.post('/quick/add', rowData, function (data) {
                        if (data == '0') {
                            $.messager.alert("提示信息", "录入失败！", "error");
                        }
                    });
                },
            });
            $('#btn-upload').upload({
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
            if (updateRow != undefined) {
                alert("请为编辑的数据敲回车键");
                return;
            }
            $('#grid').datagrid('beginEdit', rowIndex);
            var ed = $('#grid').datagrid('getEditor', {index: rowIndex, field: field});
            editIndex = rowIndex;
            updateRow = rowIndex;
            $(ed.target).keydown(function (e) {
                if (e.which == 13) {
                    $('#grid').datagrid('endEdit', rowIndex);
                    //获得修改数据
                    var rows = $('#grid').datagrid('getRows');
                    var row = rows[rowIndex];
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
    <div id="win"></div>
</div>
<%--工具栏--%>
<div id="tb" class="datagrid-toolbar">
    <table border="0" cellpadding="0" cellspacing="0" style="width: 100%;">
        <tr>
            <td style="width: 700px;">
                <%--正常的设备列表--%>
                <div id="normal">
                    <div style="float: left; padding: 0px; height: auto">
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
                           onclick="doAdd();">增加一行</a>
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true"
                           onclick="doCancel();">取消编辑</a>
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
                           onclick="doDelete();">删除</a>
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true"
                           onclick="doExport();">导出</a>
                        <a id="btn-upload" href="#" class="easyui-linkbutton" style="display:block"
                           data-options="iconCls:'icon-redo',plain:true">导入</a>

                    </div>
                    <%--分割线--%>
                    <div id="separator" style="float: left;" class="datagrid-btn-separator">
                    </div>
                    <div style="float: left; padding: 0px; height: auto">
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true"
                           onclick="doSave();">保存</a>
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
                           onclick="refresh();">刷新</a>
                        订单日期 <input id="preDate" class="easyui-datebox"
                                    style="width:150px;">
                        &nbsp; 至 &nbsp;&nbsp;<input class="easyui-datebox" id="sutDate"
                                                    style="width:150px;">
                    </div>

                    <div>

                    </div>
                    <%--分割线--%>
                    <%--下拉搜索框--%>
                    <div id="searchboxWrapper" style="display: inline-block; padding-top: 3px; text-align: left;
                            width: 200px;">
                        <input id="searchbox" class="easyui-searchbox" searcher="doSearch" prompt="请输入手机号码或者姓名或者快递单号"
                               style="width: 300px; margin-top: 10px; padding-top: 10px;"/>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>


</body>
</html>