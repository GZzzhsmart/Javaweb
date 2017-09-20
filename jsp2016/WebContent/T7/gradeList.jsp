<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.TeacherGradeVo"%>
<%@page import="bean.PageObject1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>讲师等级列表</title>
  </head>
  
  <body>
    <h1 align="center">讲师等级列表</h1>
    <hr/>
	
    <table align="center" border="0" cellpadding="1" cellspacing="1" width="500" bgcolor="cyan">
    	<thead>
    		<th>讲师类别编号</th>
    		<th>讲师列表名称</th>
    		<th>提成比例</th>
    		<th>操作</th>
    	</thead>
    <%
			//获取Servlet中定义的request变量
			List<TeacherGradeVo> gradeList = (List<TeacherGradeVo>)request.getAttribute("teacherList");
    		PageObject1 pager = (PageObject1)request.getAttribute("pager");
   			 int a = gradeList.size();
    		TeacherGradeVo grade=null;
    		for(int i =0;i<a;i++){
    			grade = gradeList.get(i);
			%>
			<tr>
				<td><%=grade.getGradeId() %></td>
				<td><%=grade.getGradeName() %></td>
				<td><%=grade.getGradePercent() %></td>
				<td>
				<a href="<%=basePath%>T7/gradeAdd.jsp">新增</a>
				<a href="<%=basePath%>GradeServlet?action=update&gradeId=<%=grade.getGradeId()%>">修改</a>
				<a href="<%=basePath%>GradeServlet?action=del&gradeId=<%=grade.getGradeId()%>" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}">删除</a>
				</td>
			
			</tr>
			
			<%    		
    		}
     %>
        </table>
        <table align="center" border="0" cellpadding="1" cellspacing="1" width="500">
        	<tr>
        		<td>总记录数：<%=pager.getRecordCount() %></td>
        		<td>总页数：<%=pager.getPageCount() %></td>
        		<td>当前页：<%=pager.getCurrentPage() %></td>
        		<td><a href="<%=basePath %>GradeServlet?action=list&currentPage=1&opr=first">首页</a></td>
        		<td><a href="<%=basePath %>GradeServlet?action=list&currentPage=<%=pager.getCurrentPage() %>&opr=piror">上一页</a></td>
        		<td><a href="<%=basePath %>GradeServlet?action=list&currentPage=<%=pager.getCurrentPage() %>&opr=next">下一页</a></td>
        		<td><a href="<%=basePath %>GradeServlet?action=list&currentPage=<%=pager.getPageCount() %>&opr=last">末页</a></td>
        		
        	</tr>
        </table>
  </body>
</html>
