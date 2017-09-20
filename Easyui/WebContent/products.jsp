<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Easyui页面布局</title>
<link rel="stylesheet" href="<%=path %>/css/main.css"/>
</head>
<body>
	<div>
		<div class="menu">
			<div id="logo">
				<img alt="logo" src="<%=path%>/images/美女.jpg" style="width:150px;height:80px;"/>
			</div>
		    <div id="nav">
				<ul>
					<li><a href="#">首页</a></li>
					<li><a href="#">推荐</a></li>
					<li><a href="#">全部活动</a></li>
					<li><a href="#">活动</a></li>
				</ul>
			</div>
		</div>
		<p style="clear:both;"></p>
		<div id="ads">广告区</div>
		<div>
			<div class="product">商品1</div>
			<div class="product">商品2</div>
			<div class="product">商品3</div>
			<div class="product">商品4</div>
			<p style="clear:both;"></p>
		</div>
		<div id="footer">Copyright &copy; 宏图软件有限公司</div>
	</div>
</body>
</html>