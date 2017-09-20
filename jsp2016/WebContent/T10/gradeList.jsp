<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.TeacherGradeVo"%>
<%@page import="bean.PageObject1"%>
<%@ taglib prefix="s" uri="/demotag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>讲师等级列表</title>
    
  </head>
  
  <body background="images/013.gif">
   	<h1 align="center">讲师等级列表</h1>
   	<hr/>
   	<center>
   		<table border="0" cellpadding="1" cellspacing="1" width="500">
    		<tr>
    			<td><a href="<%=basePath %>GradeServlet?action=init">新增</a></td>
    		</tr>
    	</table>
    	<%
	    		//获取Servlet中定义的request变量
				List<TeacherGradeVo> teacherList = (List<TeacherGradeVo>)request.getAttribute("teacherList");
				PageObject1 pager = (PageObject1)request.getAttribute("pager");
				String updateUrl = basePath+"GradeServlet2";
    	%>
    	 <s:gradeList pager="<%=pager %>" teacherList="<%=teacherList %>" updateUrl="<%=updateUrl %>"></s:gradeList>
   	</center>
  </body>
</html>
