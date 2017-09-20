<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>mybatis用户列表</title>
<SCRIPT type="text/javascript" src="/baiDu/js/jquery-1.11.2.min.js"></SCRIPT>
<style type="text/css">
td {
	text-align: center;
}

div {
	height: 1.5em;
}
</style>

</head>
<body>
	<table border="1" width="700" align="center">
		<tr>
			<th>ID</th>
			<th>登录名称</th>
			<th>密码</th>
			<th>管理员名称</th>
			<th>权限</th>
			<th>性别</th>
			<th>生日</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${ulist}" var="d">
			<tr>
				<td>${d.userid}</td>
				<td>${d.loginname}</td>
				<td>${d.loginpass}</td>
				<td>${d.username}</td>
				<td><c:choose>
						<c:when test="${d.upower == 99  }">
	   					管理员
	   				</c:when>
						<c:otherwise>
	   					普通用户
	   				</c:otherwise>
					</c:choose></td>
				<td><c:choose>
						<c:when test="${d.sex == 1}">男
						</c:when>
						<c:when test="${d.sex == 2 }">
						女
						</c:when>
						<c:otherwise>
							保密
						</c:otherwise>
					</c:choose></td>
				<td>${d.birthday }</td>
				<td>
					<!-- 用超链接传值方式把userid的值传给控制层 --> <a
					href="<%=path %>/uc/uid?userid=${d.userid }">修改</a>&nbsp; <a
					href="<%=path%>/uc/delete/${d.userid}"
					onclick="javascript:if(confirm('确认删除')){return true;}else{return false;}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>