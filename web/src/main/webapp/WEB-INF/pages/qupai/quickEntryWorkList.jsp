<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
            src="${pageContext.request.contextPath }/js/easyui/easyloader.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <%--    <script type="text/javascript"
                src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>--%>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/DateFormat.js"></script>

    <script src="${pageContext.request.contextPath }/js/jquery.ui.widget.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.iframe-transport.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.fileupload.js"></script>

    <script type="text/javascript">


        function shortMessage() {
            $('#shortMessage').dialog({
                title: '短信',
                width: 300,
                height: 500,
                buttons: '#bb',
                resizable: true,
                closed: false,
                cache: false,
                href: '/zTree/page',
                modal: true
            });
        }

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
                $('#win').dialog({
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


        var addIndex;//添加标识
        var updateRow;


        function doAdd() {
            if (addIndex == 0) {
                $("#grid").datagrid('endEdit', 0);
                var rowData = $("#grid").datagrid('getRows', 0);
                $.post('/quick/add', rowData[0], function (data) {
                    if (JSON.parse(data).msg == "OK") {
                    } else {
                        $.messager.alert("提示信息", "录入失败！", "error");
                    }
                });
                //alert("快速添加电子单...");
                $("#grid").datagrid('insertRow', {
                    index: 0,
                    row: {}
                });

                $("#grid").datagrid('beginEdit', 0);
                addIndex = 0;
            } else if (addIndex == undefined) {
                //alert("快速添加电子单...");
                $("#grid").datagrid('insertRow', {
                    index: 0,
                    row: {}
                });

                $("#grid").datagrid('beginEdit', 0);
                addIndex = 0;
            }
        }

        function doSave() {
            if (addIndex != undefined) {
                $("#grid").datagrid('endEdit', addIndex);
                var rowData = $("#grid").datagrid('getRows', 0);
                $.post('/quick/add', rowData[0], function (data) {
                    if (JSON.parse(data).msg == "OK") {
                    } else {
                        $.messager.alert("提示信息", "录入失败！", "error");
                    }
                });
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
            if (addIndex != undefined) {
                updateRow = undefined;
                $("#grid").datagrid('cancelEdit', addIndex);
                if ($('#grid').datagrid('getRows')[addIndex].id == undefined) {
                    $("#grid").datagrid('deleteRow', addIndex);
                }
                addIndex = undefined;
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
                            if (JSON.parse(data).msg == "OK") {
                                window.location.reload();
                            } else {
                                $.messager.alert("提示信息", "录入失败！", "error");
                            }
                        }

                    });

                } else {
                    window.location.reload();
                }

            });


        }

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
                        required: true,
                        validType: 'length[0,5]'
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
                    options: {
                        validType: 'length[10,90]'
                    }
                },
                formatter: function (value, row, index) {
                    return '<span style="font-size: 17px;line-height: 30px">' + value + '</span>';//改变表格中内容字体的大小
                }
            }, {
                field: 'addTime',
                title: '时间',
                width: 200,
                align: 'center',
                formatter: function (value, row, index) {
                    if (value == undefined) {
                        return '<span style="font-size: 17px;line-height: 30px">' + new Date().Format("yyyy-MM-dd hh:mm:ss");
                        +'</span>';//改变表格中内容字体的大小
                    } else {
                        return '<span style="font-size: 17px;line-height: 30px">' + value
                            + '</span>';//改变表格中内容字体的大小
                    }
                }
            }]];

        $(function () {
            $('#fileupload').fileupload({
                dataType: 'json',
                add: function (e, data) {
                    data.context = $('<button/>').text('Upload')
                        .appendTo(document.body)
                        .click(function () {
                            $(this).replaceWith($('<p/>').text('Uploading...'));
                            data.submit();
                        });
                },
                done: function (e, data) {
                    data.context.text('Upload finished.');
                }
            });

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

            });
        });


        function doDblClickCell(rowIndex, field, value) {
            if (updateRow != undefined) {
                alert("请为编辑的数据敲回车键");
                return;
            }
            $('#grid').datagrid('beginEdit', rowIndex);
            var ed = $('#grid').datagrid('getEditor', {index: rowIndex, field: field});
            addIndex = rowIndex;
            updateRow = rowIndex;
            $(ed.target).keydown(function (e) {
                if (e.which == 13) {
                    $('#grid').datagrid('endEdit', rowIndex);
                    //获得修改数据
                    var rows = $('#grid').datagrid('getRows');
                    var row = rows[rowIndex];
                    $.post('/quick/update', row, function (data) {
                        updateRow = undefined;
                    })

                }
            });
        }

        function filter(node) {
            if (node.level == 3) {
                return node;
            }
        }


        function ztreesave() {
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
            var nodes = treeObj.getNodesByFilter(filter);
            var ids = new Array();
            for (var i = 0; i < nodes.length; i++) {
                ids.push(nodes[i].id);
            }
            var url = "/quick/addShortMennsage?ids=" + ids;
            $.ajax({
                type: "GET",
                url: url,
                success: function (data) {
                    if (JSON.parse(data).msg == "OK") {
                        alert("添加成功");
                        $('#shortMessage').window('close');

                    }
                }
            });
        }

        function ztreeClose(){
            $('#shortMessage').window('close');
        }


    </script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
<div region="center" border="false">
    <table id="grid"></table>
    <div id="win"></div>
    <div id="shortMessage"></div>
    <div id="bb">
        <a href="#" onclick="ztreesave()" id="ztree-save" class="easyui-linkbutton">确定</a>
        <a href="#" class="easyui-linkbutton" onclick="ztreeClose()">关闭</a>
    </div>
</div>
<%--工具栏--%>
<div id="tb" class="datagrid-toolbar">
    <table border="0" cellpadding="0" cellspacing="0" style="width: 100%;">
        <tr>
            <td style="width: 700px;">
                <%--正常的设备列表--%>
                <div id="normal">
                    <div style="float: left; padding: 0px; height: auto">
                        <shiro:hasPermission name="quick-add">
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
                           onclick="doAdd();">增加一行</a>
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true"
                           onclick="doCancel();">取消编辑</a>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="quick-remove">
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
                           onclick="doDelete();">删除</a>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="quick-export">
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true"
                           onclick="doExport();">导出</a>
                        </shiro:hasPermission>

                        <shiro:hasPermission name="ztree-page">
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-tip',plain:true"
                           onclick="shortMessage();">短信</a>
                        </shiro:hasPermission>
                        <%-- <a id="btn-upload" class="easyui-linkbutton" style="display:block" onclick=""
                            data-options="iconCls:'icon-redo'">导入</a>--%>


                    </div>
                    <%--分割线--%>
                    <div id="separator" style="float: left;" class="datagrid-btn-separator">
                    </div>
                    <div style="float: left; padding: 0px; height: auto">
                        <shiro:hasPermission name="quick-save">
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true"
                           onclick="doSave();">保存</a>
                        </shiro:hasPermission>
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
                           onclick="refresh();">刷新</a>
                        <shiro:hasPermission name="quick-list">
                        订单日期 <input id="preDate" class="easyui-datebox"
                                    style="width:150px;">
                        &nbsp; 至 &nbsp;&nbsp;<input class="easyui-datebox" id="sutDate"
                                                    style="width:150px;">

                    </div>


                    <%--下拉搜索框--%>
                    <div id="searchboxWrapper" style="display: inline-block; padding-top: 3px; text-align: left;
                            width: 200px;">
                        <input id="searchbox" class="easyui-searchbox" searcher="doSearch" prompt="请输入手机号码或者姓名或者快递单号"
                               style="width: 300px; margin-top: 10px; padding-top: 10px;"/>
                    </div>
                    </shiro:hasPermission>

                </div>

            </td>
        </tr>
    </table>
</div>


</body>
</html>