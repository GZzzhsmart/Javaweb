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
<link href="<%=path %>/plugins/highcharts/highcharts.css" rel="stylesheet" />
</head>
<body>
	<div id="pie" style="min-width:400px;height:400px"></div>
</body>
<script src="<%=path%>/plugins/jquery.min.js"></script>
<script src="<%=path%>/plugins/highcharts/highcharts.js"></script>
<script src="<%=path%>/plugins/highcharts/highcharts-zh_CN.js"></script>
<script src="<%=path%>/js/report.js"></script>
</html>