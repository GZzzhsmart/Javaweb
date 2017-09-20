<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
   
    <title>员工列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css">
	<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath }/js/pintuer.js"></script>
	<script type="text/javascript">
        function check(){
        	var empname = document.getElementById("empname");
        	if(form1.empname.value==""){
        		alert("请输入员工姓名");
        		form1.empname.focus();
        		return false;
        	}
        	return true;
        }
	</script>
  </head>
  
  <body>
   
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 员工列表</strong> <a href="javascript:void(0);" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="${pageContext.request.contextPath }/employeeAction!init.action"> 新增员工</a> </li>
        <li>
          <s:form theme="simple" name="form1" action="employeeAction!list.action" method="post" onsubmit="return check();">
          	<input type="text" placeholder="请输入搜索关键字" id="empname" name="emp.empname" class="input" style="width:250px; line-height:17px;display:inline-block" />
          	<input type="submit" class="button border-main icon-search" value=" 搜 索 ">
         </s:form>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
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
      <s:iterator value="#request.empList" var="d">
        <tr>
            <td style="text-align:left; padding-left:20px;">${d.empid }</td>
            <td style="text-align:left; padding-left:20px;">${d.empname }</td>
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
          <td>
          <div class="button-group"> 
          <a class="button border-main" href="<%=basePath %>employeeAction!update.action?emp.empid=${d.empid }"><span class="icon-edit">
          </span> 修改</a> 
          <a class="button border-red" href="<%=basePath %>employeeAction!del.action?emp.empid=${d.empid }" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}"><span class="icon-trash-o">
          </span> 删除</a> 
          </div>
          </td>
        </tr>
   	</s:iterator>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <span >总记录数<s:property value="#request.pageBean.allRows"/></span>
		<span >共<s:property value="#request.pageBean.totalPage"/>页</span>
		<a href="employeeAction!list.action">首页</a>
        <a href="employeeAction!list.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a> 
        <a href="employeeAction!list.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
        <a href="employeeAction!list.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a> 
        </div>
        </td>
      </tr>
    </table>
  </div>
</body>
</html>