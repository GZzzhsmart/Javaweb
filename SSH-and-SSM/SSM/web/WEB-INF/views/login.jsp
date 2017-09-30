<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="<%=path %>/user/login2" method="post">
        <input type="text" name="name"/>
        <input type="password" name="password"/>
        <input type="submit" value="登录"/>
    </form>
    <a href="<%=path %>/user/del?id=5">删除用户</a>
    <a href="<%=path %>/user/remove/5">删除用户</a>
</body>
</html>
