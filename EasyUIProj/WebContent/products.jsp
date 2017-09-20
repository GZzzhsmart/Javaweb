<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="<%=path %>/easyui/themes/icon.css" />
	<link rel="stylesheet" href="<%=path %>/css/main.css" />
</head>
<body>
	<table id="userList" class="easyui-datagrid"
		data-options="
			toolbar:'#tb',
			rownumbers:true,
			border:false,
			singleSelect:true,
			pagination:true,
			pageSize:20,
			url:'<%=path %>/user/user',
			method:'get'">
		<thead>
			<tr>
				<th data-options="field:'id',width:80,checkbox:true">编号</th>
				<th data-options="field:'name',width:100">名称</th>
				<th data-options="field:'price',width:80,align:'right'">原价</th>
				<th data-options="field:'salePrice',width:250">销售价</th>
				<th data-options="field:'quantity',width:80,align:'right'">数量</th>
				<th data-options="field:'stockTime',width:250" formatter="formatDate">入库时间</th>
				<th data-options="field:'des',width:250">描述</th>
				<th data-options="field:'valid',width:100">是否可用</th>
			</tr>
		</thead>
	</table>
</body>
<script src="<%=path %>/js/jquery.min.js"></script>
<script src="<%=path %>/easyui/jquery.easyui.min.js"></script>
<script src="<%=path %>/easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="<%=path %>/js/main.js"></script>
</html>