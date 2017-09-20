<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Basic Pagination - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/demo.css">
<script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>Basic Pagination</h2>
	<p>The user can change page number and page size on page bar.</p>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-panel">
		<div class="easyui-pagination" data-options="total:114"></div>
	</div>
</body>
</html>