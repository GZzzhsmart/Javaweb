<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Easyui实现增删改查</title>
<link rel="stylesheet" href="<%=path%>/easyui/themes/default/easyui.css" />
<link rel="stylesheet" href="<%=path%>/easyui/themes/icon.css" />
<link rel="stylesheet" href="<%=path%>/css/main.css" />
</head>
<body>
	<table id="list" class="easyui-datagrid"
		data-options="
			toolbar:'#tb',
			rownumbers:true,
			border:false,
			singleSelect:true,
			pagination:true,
			pageSize:20,
			url:'<%=path%>/ptype/pager',
			method:'get'">
		<thead>
			<tr>
				<th data-options="field:'id',width:80,checkbox:true">编号</th>
				<th data-options="field:'name',width:100">名称</th>
				<th data-options="field:'des',width:250">描述</th>
				<th data-options="field:'valid',width:100" formatter="formatValid">是否可用</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="height: auto">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-add" onclick="openWin('addWin');">添加</a> <a
			href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-edit" onclick="openEditWin('editWin')">修改</a> <a
			href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-remove" onclick="active();">激活</a> <a
			href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-remove" onclick="inactive();">冻结</a>
	</div>

	<div id="addWin" class="easyui-window normal_win"
		data-options="title:'添加商品类型', closed:true">
		<form id="addForm">
			<table>
				<tr>
					<td>名称</td>
					<td><input class="easyui-textbox easyui-validatebox"
						data-options="prompt:'请输入名称',
						required:true,
						novalidate:true"
						name="productType.name" /></td>
				</tr>
				<tr>
					<td>描述</td>
					<td><input class="easyui-textbox"
						data-options="prompt:'请输入描述',multiline:true"
						name="productType.des" /></td>
				</tr>
				<tr>
					<td><a class="easyui-linkbutton" onclick="addProductType();">确认</a></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="editWin" class="easyui-window normal_win"
		data-options="title:'编辑商品类型', closed:true">
		<form id="editForm">
			<input type="hidden" name="id" /> <input type="hidden" name="valid"
				id="valid" />
			<table>
				<tr>
					<td>名称</td>
					<td><input class="easyui-textbox easyui-validatebox"
						data-options="prompt:'请输入名称',
						required:true,
						novalidate:true"
						name="name" /></td>
				</tr>
				<tr>
					<td>描述</td>
					<td><input class="easyui-textbox"
						data-options="prompt:'请输入描述',multiline:true" name="des" /></td>
				</tr>
				<tr>
					<td><a class="easyui-linkbutton"
						onclick="updateProductType();">确认</a></td>
				</tr>
			</table>
		</form>
	</div>

</body>
<script src="<%=path%>/js/jquery.min.js"></script>
<script src="<%=path%>/easyui/jquery.easyui.min.js"></script>
<script src="<%=path%>/easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="<%=path%>/js/main.js"></script>
<script src="<%=path%>/js/product-type.js"></script>

<script>
	$(function() {
		setPagination("list");
	});
</script>

</html>