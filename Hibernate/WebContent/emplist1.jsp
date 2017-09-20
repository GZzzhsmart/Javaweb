<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>员工资料</title>
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/jquery-easyui-1.3.0/themes/default/easyui.css">
	 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/jquery-easyui-1.3.0/themes/icon.css">
	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.3.0/jquery-1.7.2.min.js"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.3.0/jquery.easyui.min.js"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.3.0/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript">
			$(function(){
				var d = new Date();
				var year = d.getFullYear();
				var month = d.getMonth()+1;
				var day = d.getDate();
				year = year+"-"+month;
				 $("#sdate1").datebox("setValue",year+"-"+day);
				 $("#edate1").datebox("setValue",year+"-30");
				 
			})
			function test(){
				var sd = $("#sdate1").datebox("getValue") +" 00:00:00";
				var ed = $("#edate1").datebox("getValue") +" 23:59:59";
				$("#sdate").val(sd);
				$("#edate").val(ed);
				return true;
			}
			
		</script>
  </head>
  
  <body>
    <h1 align="center">员工资料列表</h1>
    <hr/>
   <table align="center" border="0" cellpadding="0" cellspacing="0" width="1100" >
	    <s:form  theme="simple" name="form1" id="form1" action="empAction!listByDetach.action" method="post" onsubmit="return test();">
	    <s:hidden name="sdate" id="sdate"></s:hidden>
	    <s:hidden name="edate" id="edate"></s:hidden>
		<tr>
			<td>姓名：<s:textfield name="emp.empname" />
			登录名称:<s:textfield name="acc.username"/>
			生日:<s:textfield name="sdate1" id="sdate1" cssClass="easyui-datebox"/>到
			<s:textfield name="edate1" id="edate1" cssClass="easyui-datebox"/>
	     		<s:submit value="查询"></s:submit>
	     	</td>
     	</tr>
    	</s:form>
     	<tr>
     		<td align="left"><a href="empAction!init.action">新增</a></td>
     	</tr>
     </table>
    <table width="1000" align="center" border="1">
    	<thead>
    		<tr height="30">
    			<th>编号</th>
    			<th>姓名</th>
    			<th>部门</th>
    			<th>性别</th>
    			<th>出生日期</th>
    			<th>毕业学校</th>
    			<th>专业</th>
    			<th>学历</th>
    			<th>号码</th>
    			<th>账号</th>
    			<th>密码</th>
    			<th>状态</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<s:iterator value="#request.empList" var="d" status="st">
    		<tr height="40">
    			<td align="center">${d.empid }</td>
    			<td align="center">${d.empname }</td>
    			<td align="center">${d.dep.deptname}</td>
    			<td align="center">${d.sex }</td>
    			<td align="center"><s:date name="#d.birthday" format="yyyy-MM-dd"/></td>
    			<td align="center">${d.school }</td>
    			<td align="center">${d.major }</td>
    			<td align="center">${d.degree }</td>
    			<td align="center">${d.mobile }</td>
    			<td align="center">${d.account.username }</td>
    			<td align="center">${d.account.passwd }</td>
    			<td align="center">${d.account.status}</td>
    			<td align="center">
	    			<a href="<%=basePath %>empAction!get.action?emp.empid=${d.empid }">修改</a>
	    			&nbsp;&nbsp;&nbsp;
	    			<a href="<%=basePath %>empAction!del.action?emp.empid=${d.empid }" onclick="javascript:if(confirm('确定删除？')){return true;}else{return false;}">删除</a>
    			</td>
    		</tr>
    	</s:iterator>
    </table>
     <table width="800" align="center"  border="0" cellpadding="3" cellspacing="1">
     	<tr>
     		<td><a href="empAction!listByDetach.action?pager.currentPage=1&pager.opr=first">首页</a></td>
     		<td><a href="empAction!listByDetach.action?pager.currentPage=${pager.currentPage}&pager.opr=piror">上一页</a></td>
     		<td><a href="empAction!listByDetach.action?pager.currentPage=${pager.currentPage}&pager.opr=next">下一页</a></td>
     		<td><a href="empAction!listByDetach.action?pager.currentPage=${pager.pageCount}&pager.opr=last">末页</a></td>
     	</tr>
     </table>
  </body>
</html>
