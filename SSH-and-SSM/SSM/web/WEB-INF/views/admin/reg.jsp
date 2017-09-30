<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>SpringMVC返回json格式的数据</title>
</head>
<body>
<form id="admin_reg">
    <input type="text" name="phone" />
    <input type="password" name="password" />
    <input type="button" value="注册" onclick="reg();"/>
</form>
</body>
<script src="<%=path %>/js/jquery.min.js"></script>
<script>
    function reg() {
        $.post("<%=path %>/admin/reg1",
            $("#admin_reg").serialize(),
            function (data) {
                if (data.result === "success") {
                    window.location.href = "";
                } else {
                    alert("fail!");
                }
            },
            "json"
        );
    }
</script>
</html>
