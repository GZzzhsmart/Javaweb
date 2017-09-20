<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>学生列表</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.1.js"></script>
  </head>
  <body>
    <h1 align="center">学生列表</h1>
    <a href="${pageContext.request.contextPath }/studentadd.jsp">新增学生</a>
    <table border="1" width="800" align="center">
    	<tr height="40">
    		<th>学&nbsp;&nbsp;&nbsp;号</th>
	    	<th>姓&nbsp;&nbsp;&nbsp;名</th>
	    	<th>年&nbsp;&nbsp;&nbsp;龄</th>
	    	<th>性&nbsp;&nbsp;&nbsp;别</th>
	    	<th>爱&nbsp;&nbsp;&nbsp;好</th>
	    	<th>专&nbsp;&nbsp;&nbsp;业</th>
	    	<th>班&nbsp;&nbsp;&nbsp;级</th>
	    	<th>民&nbsp;&nbsp;&nbsp;族</th>
	    	<th>相 关 操 作</th>
    	</tr>
    	<s:iterator var="l" value="#request.studentList">
    		<tr height="40px">
    			<td align="center">${l.sno}</td>
    			<td align="center">${l.studentname}</td>
    			<td align="center">${l.sage}</td>
    			<td align="center">${l.ssex}</td>
    			<td align="center">${l.shobit}</td>
    			<td align="center">${l.szhuanye}</td>
    			<td align="center">${l.classname}</td>
    			<td align="center">${l.nationname}</td>
    			<td align="center">
    				<a href="<%=basePath %>studAction.action?order=delete&sno=${l.sno}">删除</a>
    				<a href="<%=basePath %>studAction.action?order=update&sno=${l.sno}">修改</a>
    			</td>
    		</tr>
    	</s:iterator>
    	<tr >
			<td  colspan="9" align="center">
				<span class="current">总记录数&nbsp;&nbsp;${pager.pagebarsum }</span>
				<span class="current">页码&nbsp;&nbsp;${pager.currentpage }/${pager.sumpage }页</span>
				<a href="<%=basePath %>studAction.action?order=list&currenpage=1&handle=firstpage">首   页</a>
				<a href="<%=basePath %>studAction.action?order=list&currenpage=${pager.currentpage }&handle=uppage">上一页</a>
				<a href="<%=basePath %>studAction.action?order=list&currenpage=${pager.currentpage }&handle=downpage" >下一页</a>
				<a href="<%=basePath %>studAction.action?order=list&currenpage=${pager.sumpage }&handle=lastpage">尾  页</a> 
			</td>
      </tr>
    </table>
  </body>
</html>
