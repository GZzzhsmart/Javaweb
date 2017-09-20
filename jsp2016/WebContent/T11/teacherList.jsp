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
   
    <title>教师列表</title>
  </head>
  
  <body>
    <h1 align="center">教师列表</h1>
    <hr/>
    <c:if test="${msg!=null}">
   		<script type="text/javascript">
   			alert("${msg}");
   		</script>
    </c:if>
    <table align="center" border="0" cellpadding="1" cellspacing="1" width="1350"height="150" bgcolor="cyan">
    	<thead>
    		<th>教师id</th>
    		<th>教师电话</th>
    		<th>教师姓名</th>
    		<th>性别</th>
    		<th>家庭住址</th>
    		<th>邮箱</th>
    		<th>教师简介</th>
    		<th>教师特长</th>
    		<th>教龄</th>
    		<th>学历</th>
    		<th>头像图片网址</th>
    		<th>银行id</th>
    		<th>银行账户</th>
    		<th>开户人姓名</th>
    		<th>教师分类</th>
    		<th>操作</th>
    	</thead>
   		<c:forEach items="${teacherList}" var="d">
			<tr>
				<td>${d.teacherId }</td>
				<td>${d.teacherMobile }</td>
				
				<td>${d.teacherName }</td>
				<td>
				<c:if test="${d.sex==0}">男</c:if>
				<c:if test="${d.sex==1}">女</c:if>
				</td>
				<td>${d.homeAddress }</td>
				<td>${d.email }</td>
				<td>${d.teacherIntroduce }</td>
				<td>${d.teacherSpecial }</td>
				<td>${d.teacherLength }</td>
				<td>${d.education }</td>
				<td><img src="${d.headpictureUrl }" ></td>
				<td>
					<c:if test="${ d.bankId==1 }">中国银行</c:if>
	  				<c:if test="${ d.bankId==2 }">中国农业银行</c:if>
	  				<c:if test="${ d.bankId==3 }">中国建设银行</c:if>
	  				<c:if test="${ d.bankId==4 }">中国工商银行</c:if>
	  				<c:if test="${ d.bankId==5 }">九江银行</c:if>
	  				<c:if test="${ d.bankId==6 }">交通银行</c:if>
				</td>
				<td>${d.accountNo }</td>
				<td>${d.accountName }</td>
				<td>
					<c:if test="${ d.gradeId==1 }">认证讲师</c:if>
					<c:if test="${ d.gradeId==2 }">中级讲师</c:if>
					<c:if test="${ d.gradeId==3 }">高级讲师</c:if>
					<c:if test="${ d.gradeId==4 }">特级讲师</c:if>
					<c:if test="${ d.gradeId==5 }">金牌讲师</c:if>
				</td>
				<td>
				<a href="<%=basePath%>T11/teacherAdd.jsp">新增</a>
				<a href="<%=basePath%>teacherServlet?action=update&teacherId=${d.teacherId }">修改</a>
				<a href="<%=basePath%>teacherServlet?action=del&teacherId=${d.teacherId }" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}">删除</a>
				<a href="<%=basePath%>T11/modifypwd2.jsp?teacherId=${d.teacherId }">修改密码</a>
				<a href="<%=basePath%>teacherServlet?action=initpwd&teacherId=${d.teacherId }">初始化密码</a>
				</td>
			</tr>
		</c:forEach>
        </table>
        <table align="center" border="0" cellpadding="1" cellspacing="1" width="800">
        <tr>
        	<td>总记录数:${pager.recordCount}</td>
        	<td>页码:${pager.currentPage}/${pager.pageCount}</td>
        	<td><a href="<%=basePath%>teacherServlet?action=list&currentPage=1&opr=first">首页</a></td>
        	<td><a href="<%=basePath%>teacherServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a></td>
        	<td><a href="<%=basePath%>teacherServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a></td>
        	<td><a href="<%=basePath%>teacherServlet?action=list&currentPage=${pager.pageCount}&opr=last">末页</a></td>
        </tr>
        </table>
  </body>
</html>
