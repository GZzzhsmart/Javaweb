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
   
    <title>管理员列表</title>
  </head>
  
  <body>
    <h1 align="center">管理员列表</h1>
    <hr/>
    <c:if test="${msg!=null}">
   		<script type="text/javascript">
   			alert("${msg}");
   		</script>
    </c:if>
    <table align="center" border="0" cellpadding="1" cellspacing="1" width="800" bgcolor="cyan">
    	<thead>
    		<th>管理员编号</th>
    		<th>登录账号</th>
    		<th>管理员姓名</th>
    		<th>性别</th>
    		<th>联系电话</th>
    		<th>状态</th>
    		<th>操作</th>
    	</thead>
   		<c:forEach items="${managerList}" var="d">
			<tr>
				<td>${d.managerId }</td>
				<td>${d.managerAccount }</td>
				<td>${d.managerName }</td>
				<td>
				<c:if test="${d.sex==0}">男</c:if>
				<c:if test="${d.sex==1}">女</c:if>
				</td>
				<td>${d.contact }</td>
				<td>
				<c:if test="${d.status==1}">启用</c:if>
				<c:if test="${d.status==0}">禁用</c:if>
				</td>
				<td>
				<a href="<%=basePath%>T11/managerAdd.jsp">新增</a>
				<a href="<%=basePath%>ManagerServlet?action=update&managerId=${d.managerId }">修改</a>
				<a href="<%=basePath%>ManagerServlet?action=del&managerId=${d.managerId }" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}">删除</a>
				<a href="<%=basePath%>T11/modifyPwd.jsp?managerId=${d.managerId }">修改密码</a>
				<a href="<%=basePath%>ManagerServlet?action=initpwd&managerId=${d.managerId }">初始化密码</a>
				<c:if test="${d.status==1}">
					<a href="<%=basePath%>ManagerServlet?action=status&status=0&managerId=${d.managerId }">禁用</a>
				</c:if>
				<c:if test="${d.status==0}">
				<a href="<%=basePath%>ManagerServlet?action=status&status=1&managerId=${d.managerId }">启用</a>
				</c:if>
				</td>
			</tr>
		</c:forEach>
        </table>
        <table align="center" border="0" cellpadding="1" cellspacing="1" width="500">
        <tr>
        	<td>总记录数:${pager.recordCount}</td>
        	<td>页码:${pager.currentPage}/${pager.pageCount}</td>
        	<td><a href="<%=basePath%>ManagerServlet?action=list&currentPage=1&opr=first">首页</a></td>
        	<td><a href="<%=basePath%>ManagerServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a></td>
        	<td><a href="<%=basePath%>ManagerServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a></td>
        	<td><a href="<%=basePath%>ManagerServlet?action=list&currentPage=${pager.pageCount}&opr=last">末页</a></td>
        </tr>
        </table>
  </body>
</html>
