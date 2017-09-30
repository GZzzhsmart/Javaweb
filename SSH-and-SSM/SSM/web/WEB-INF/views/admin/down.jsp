<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>图片下载</title>
</head>
<body>
<h1 align="center">文件下载</h1>
<hr/>
<c:forEach items="${fileList}" var="d">
    <img src="uploads/${d}" width="300">
    <a href="uploads/${d}">直接下载</a>&nbsp;&nbsp;
    <a href="<%=path%>/upload/download?filename=${d}">下载</a><br/>
</c:forEach>
</body>
</html>
