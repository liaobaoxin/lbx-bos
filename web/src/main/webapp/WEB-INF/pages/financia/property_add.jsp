<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加业务受理单</title>
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
	$(function(){
		$("body").css({visibility:"visible"});
		
		// 对save按钮条件 点击事件
		$('#save').click(function(){
			// 对form 进行校验
			if($('#noticebillForm').form('validate')){
				$('#noticebillForm').submit();
			}
		});
	});
</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<div region="north" style="height:31px;overflow:hidden;" split="false"
		border="false">
		<div class="datagrid-toolbar">
			<a id="save" icon="icon-save" href="#" class="easyui-linkbutton"
				plain="true">保存</a>
			<%--<a id="edit" icon="icon-edit" href="${pageContext.request.contextPath }/page_qupai_noticebill.action" class="easyui-linkbutton"
				plain="true">工单操作</a>	--%>
		</div>
	</div>
	<div region="center" style="overflow:auto;padding:5px;" border="false">
		<form id="noticebillForm" action="${pageContext.request.contextPath }/property/add" method="post">
			<table class="table-edit" width="95%" align="center">
				<tr class="title">
					<td colspan="4">用户信息</td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><input type="text" class="easyui-validatebox" name="name"
						required="true" /></td>
					<td>编号:</td>
					<td><input type="text" class="easyui-validatebox"  name="number"
						required="true" /></td>
				</tr>
				<tr>
					<td>电话:</td>
					<td><input type="text" class="easyui-validatebox" name="telphone"
						required="true" /></td>
					<td>性别:</td>
					<td><input type="text" class="easyui-validatebox" name="sex"
						required="true" /></td>
				</tr>
				<tr class="title">
					<td colspan="4">个人信息</td>
				</tr>
				<tr>
					<td>学历:</td>
					<td><input type="text" class="easyui-validatebox" name="education"
						required="true" /></td>
					<td>年龄:</td>
					<td><input type="text" class="easyui-numberbox" name="age"
						required="true" /></td>
				</tr>
				<tr>
					<td>工作年龄:</td>
					<td><input type="text" class="easyui-numberbox" name="workage"
						required="true" /></td>
					<td>薪水:</td>
					<td><input type="text" class="easyui-validatebox" name="sala"
						required="true" /></td>
				</tr>
				<tr>
					<td>地址</td>
					<td colspan="3"><input type="text" class="easyui-validatebox" name="addr"
						required="true" size="144"/></td>
				</tr>
				<tr>
					<td>上家单位:</td>
					<td><input type="text" class="easyui-validatebox" name="homeunit"
						required="true" /></td>
					<td>入职时间:</td>
					<td><input type="text" class="easyui-datebox" name="timeofentry"
						data-options="required:true, editable:false" /></td>
				</tr>
				<tr>
					<td>备注:</td>
					<td colspan="3"><textarea rows="5" cols="80" type="text" class="easyui-validatebox" name="remarks"
						required="true" ></textarea></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>