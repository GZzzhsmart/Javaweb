<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="bean.CityVo"%>
<%@page import="bean.PageObject"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>城市列表</title>
  </head>
  <body>
    <h1 align="center">城市资料列表</h1>
    <hr/>
		
    <table align="center" border="0" cellpadding="1" cellspacing="1" width="500" bgcolor="cyan">
    	<thead>
    		<th>城市编号</th>
    		<th>省份名称</th>
    		<th>城市名称</th>
    		<th>操作</th>
    	</thead>
    <c:forEach items="${cityList}" var="d">
			<tr>
				<td>${d.cityId }</td>
				<td>${d.provinceName }</td>
				<td>${d.cityName }</td>
				<td>
				<a href="<%=basePath%>T7/cityAdd.jsp">新增</a>
				<a href="<%=basePath%>CityServlet?action=update&cityId=${d.cityId }">修改</a>
				<a href="<%=basePath%>CityServlet?action=del&cityId=${d.cityId }" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}">删除</a>
				</td>
			</tr>
		</c:forEach>
			
        </table>
        <table align="center" border="0" cellpadding="1" cellspacing="1" width="500">
        	 <tr>
        	<td>总记录数:${pager.recordCount}</td>
        	<td>页码:${pager.currentPage}/${pager.pageCount}</td>
        	<td><a href="<%=basePath%>CityServlet?action=list&currentPage=1&opr=first">首页</a></td>
        	<td><a href="<%=basePath%>CityServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a></td>
        	<td><a href="<%=basePath%>CityServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a></td>
        	<td><a href="<%=basePath%>CityServlet?action=list&currentPage=${pager.pageCount}&opr=last">末页</a></td>
        </tr>
        </table>
  </body>
</html>
