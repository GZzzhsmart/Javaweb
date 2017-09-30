<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="<%=path%>/css/amazeui.min.css">
<link rel="stylesheet" href="<%=path%>/css/amazeui.css">
<script src="<%=path%>/js/jquery.min.js"></script>
<script src="<%=path%>/js/amazeui.min.js"></script>
<script>
    var path = '${ctx}';
</script>