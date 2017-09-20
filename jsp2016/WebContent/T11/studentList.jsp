<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生列表</title>
    
  </head>
  
  <body>
    <h1 align="center">学生列表</h1>
    <hr/>
    <c:if test="${msg!=null}">
   		<script type="text/javascript">
   			alert("${msg}");
   		</script>
    </c:if>
    <table border="0" width="1000" cellpadding="1" cellspacing="1" align="center" bgcolor="pink">
    	<tr height="40">
    		<td>用户ID</td>
  			<td>手机号</td>
  			<td>姓名</td>
  			<td>性别</td>
  			<td>家庭住址</td>
  			<td>邮箱</td>
  			<td>用户注册时间</td>
  			<td>所在省份</td>
  			<td>所在城市</td>
  			<td>操作</td>
    	</tr>
    	<c:forEach items="${studentList}" var="d">
    		<tr height="40">
    			<td>${d.userId }</td>
    			<td>${d.mobile }</td>
    			<td>${d.username }</td>
    			<td>
					<c:if test="${d.sex==0}">
						男
					</c:if>
					<c:if test="${d.sex==1 }">
						女
					</c:if>
  				</td>
  				<td>${ d.homeaddress }</td>
	  			<td>${ d.email  }</td>
	  			<td>${ d.registerdate }</td>
	  			<td>
	  				<c:if test="${ d.provinceId==1 }">北京市</c:if>
	  				<c:if test="${ d.provinceId==2 }">天津市</c:if>
	  				<c:if test="${ d.provinceId==3 }">河北省</c:if>
	  				<c:if test="${ d.provinceId==4 }">山西省</c:if>
	  				<c:if test="${ d.provinceId==14 }">江西省</c:if>
	  			</td>
	  			<td>
	  				<c:if test="${ d.cityId==1 }">石景山区</c:if><c:if test="${ d.cityId==2 }">海淀区</c:if>
	  				<c:if test="${ d.cityId==17 }">东丽区</c:if><c:if test="${ d.cityId==18 }">西青区</c:if>
	  				<c:if test="${ d.cityId==32 }">石家庄市</c:if><c:if test="${ d.cityId==33 }">邯郸市</c:if>
	  				<c:if test="${ d.cityId==43 }">大同市</c:if><c:if test="${ d.cityId==44 }">太原市</c:if>
	  				<c:if test="${ d.cityId==165 }">南昌市</c:if><c:if test="${ d.cityId==170 }">赣州市</c:if>
	  			</td>
	  			<td>
		  			<a href="<%=basePath %>studentServlet?action=add">新增</a>
	  				<a href="<%=basePath%>studentServlet?action=update&studentID=${d.userId }">修改</a>
	  				<a href="<%=basePath%>studentServlet?action=del&studentID=${d.userId }" 
	  				onclick="javascript:if(confirm('删除确认')){ return true; }else{ return false; }">删除</a>
  					<a href="<%=basePath%>T11/modifypwd1.jsp?studentId=${d.userId }">修改密码</a>
					<a href="<%=basePath%>studentServlet?action=initpwd&studentId=${d.userId }">初始化密码</a>
  				</td>
    		</tr>
    	</c:forEach>
    </table>
     <table align="center" border="0" cellpadding="1" cellspacing="1" width="500">
        <tr>
        	<td>总记录数:${pager.recordCount}</td>
        	<td>页码:${pager.currentPage}/${pager.pageCount}</td>
        	<td><a href="<%=basePath%>studentServlet?action=list&currentPage=1&opr=first">首页</a></td>
        	<td><a href="<%=basePath%>studentServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a></td>
        	<td><a href="<%=basePath%>studentServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a></td>
        	<td><a href="<%=basePath%>studentServlet?action=list&currentPage=${pager.pageCount}&opr=last">末页</a></td>
        </tr>
        </table>
  </body>
</html>
