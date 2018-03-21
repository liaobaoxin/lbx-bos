<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<HTML>
<HEAD>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/ztree/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>

</HEAD>

<script type="text/javascript">
    var setting = {
        async: {
            enable: true,
            url: "/ZTree/LoadTree",//异步加载时的请求地址
            autoParam: ["id"],//提交参数
            type: 'get',
            dataType: 'json'
        },
        checkable: true,
        showIcon: true,
        showLine: true,
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        expandSpeed: "",
        callback: {
            onClick: zTreeOnClick
        }
    };

    $(document).ready(function () {
        $.ajax({
            url: '/json/menu1.json',
            type: 'get',
            dataType: 'json',
            success: function (data) {
                $.fn.zTree.init($("#treeDemo"), setting, data);
            }
        });
    });

    //单击时获取zTree节点的Id,和value的值
    function zTreeOnClick(event, treeId, treeNode, clickFlag) {
        var treeValue = treeNode.id + "," + treeNode.name;
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = treeObj.getCheckedNodes();
        console.info(nodes);


        alert(treeValue);
        /*alert(treeNode.id + "," + treeNode.name);*/
    };
</script>

<div>
    <ul id="treeDemo" class="ztree"></ul>
</div>
</HTML>
