<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户资料列表</title>
  </head>
  
  <body>
    <h1 align="center">用户资料列表</h1>
    <hr/>
	
	<c:if test="${msg!=null}">
   		<script type="text/javascript">
   			alert("${msg}");
   		</script>
    </c:if>
    <table align="center" border="1" cellpadding="1" cellspacing="1" width="1100" bgcolor="yellow">
    	<thead>
    		<th>用户id</th>
    		<th>姓名</th>
    		<th>手机号码</th>
    		<th>性别</th>
    		<th>省份</th>
    		<th>城市</th>
    		<th>用户类别</th>
    		<th>邮箱地址</th>
    		<th>注册日期</th>
    		<th>家庭地址</th>
    		<th>操作</th>
    	</thead>
   		<c:forEach items="${userList}" var="d">
			<tr>
				<td>${d.userid }</td>
				<td>${d.userName }</td>
				<td>${d.mobile }</td>
				<td>
				<c:if test="${d.sex==0}">男</c:if>
				<c:if test="${d.sex==1}">女</c:if>
				</td>
				<td>${d.provinceName }</td>
				<td>${d.cityName }</td>
				<td>
				<c:if test="${d.userType==1}">学生</c:if>
				<c:if test="${d.userType==2}">讲师</c:if>
				</td>
				<td>${d.email }</td>
				<td>${d.registerDate }</td>
				<td>${d.homeAddress }</td>
				<td>
				<a href="<%=basePath%>usersServlet?action=init">新增</a>
				<a href="<%=basePath%>usersServlet?action=update&userid=${d.userid }">修改</a>
				<a href="<%=basePath%>usersServlet?action=del&userid=${d.userid }" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}">删除</a>
				<a href="<%=basePath%>T11/modifyPwd3.jsp?userid=${d.userid }">修改密码</a>
				<a href="<%=basePath%>usersServlet?action=initpwd&userid=${d.userid }">初始化密码</a>
				</td>
			</tr>
		</c:forEach>
        </table>
        <table align="center" border="0" cellpadding="1" cellspacing="1" width="1000">
        <tr>
        	<td>总记录数:${pager.recordCount}</td>
        	<td>页码:${pager.currentPage}/${pager.pageCount}</td>
        	<td><a href="<%=basePath%>usersServlet?action=list&currentPage=1&opr=first">首页</a></td>
        	<td><a href="<%=basePath%>usersServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a></td>
        	<td><a href="<%=basePath%>usersServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a></td>
        	<td><a href="<%=basePath%>usersServlet?action=list&currentPage=${pager.pageCount}&opr=last">末页</a></td>
        	
        </tr>
        </table>
  </body>
</html>
