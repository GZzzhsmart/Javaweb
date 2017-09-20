<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>学生资料</title>
  </head>
  
  <body>
    <h1 align="center">学生资料列表</h1>
    <hr/>
    <h3 align="center"><a href="studAdd.jsp"><font size="5" color="cyan">新增学生</font></a></h3>
    <br/>
    <table width="600" align="center" border="1">
    	<thead>
    		<tr height="30">
    			<th>学号</th>
    			<th>姓名</th>
    			<th>性别</th>
    			<th>身份证号</th>
    			<th>班级编号</th>
    			<th>年龄</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<s:iterator value="#request.studentList" var="d">
    		<tr height="30">
    			<td align="center">${d.studid }</td>
    			<td align="center">${d.studname }</td>
    			<td align="center">${d.sex }</td>
    			<td align="center">${d.cardid }</td>
    			<td align="center">${d.classid }</td>
    			<td align="center">${d.age }</td>
    			<td align="center"><a href="<%=basePath %>studAction!update.action?studid=${d.studid }">修改</a>
    			&nbsp;&nbsp;&nbsp;<a href="<%=basePath %>studAction!del.action?studid=${d.studid }" onclick="javascript:if(confirm('确定删除？')){return true;}else{return false;}">删除</a></td>
    		</tr>
    	</s:iterator>
    	<tr>
		<td colspan="9" align="center">
			<span class="current">总记录数&nbsp;&nbsp;${pager.pagebarsum }</span>
			<span class="current">页码&nbsp;&nbsp;${pager.currentpage }/${pager.sumpage }页</span>
			<a href="<%=basePath %>studAction!list.action?currentpage=1&handle=firstpage">首   页</a>
			<a href="<%=basePath %>studAction!list.action?currentpage=${pager.currentpage }&handle=uppage">上一页</a>
			<a href="<%=basePath %>studAction!list.action?currentpage=${pager.currentpage }&handle=downpage" >下一页</a>
			<a href="<%=basePath %>studAction!list.action?currentpage=${pager.sumpage }&handle=lastpage">尾  页</a> 
		</td>
     </tr>
    </table>
  </body>
</html>
