<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<form action="<%=path %>/upload/up" method="post" enctype="multipart/form-data">
    <input type="file" name="file" label="请选择文件"/>
    <input type="submit" />
</form>
</body>
</html>
