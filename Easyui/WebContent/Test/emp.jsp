<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增员工资料</title>
    <script type="text/javascript" src="<%=basePath %>js/jquery-1.4.1.js"></script>
    <script type="text/javascript">
   		function check(){
   			var empname = document.getElementById("empname");
   			var birthday = document.getElementById("birthday");
   			var major = document.getElementById("major");
   			var school = document.getElementById("school");
   			var degree = document.getElementById("degree");
   			var mobile = document.getElementById("mobile");
   			var username = document.getElementById("username");
   			var passwd = document.getElementById("passwd");
   			var passwd1 = document.getElementById("passwd1");
   			if(form1.empname.value==""){
   				alert("请输入姓名");
   				form1.empname.focus();
   				return false;
   			}
   			if(form1.birthday.value==""){
   				alert("请输入出生日期");
   				form1.birthday.focus();
   				return false;
   			}
   			if(form1.major.value==""){
   				alert("请输入所学专业");
   				form1.major.focus();
   				return false;
   			}
   			if(form1.school.value==""){
   				alert("请输入毕业学校");
   				form1.school.focus();
   				return false;
   			}
   			if(form1.degree.value==""){
   				alert("请输入学历");
   				form1.degree.focus();
   				return false;
   			}
   			if(form1.mobile.value==""){
   				alert("请输入你的电话号码");
   				form1.mobile.focus();
   				return false;
   			}
   			if(form1.username.value==""){
   				alert("请输入你的登录账号");
   				form1.username.focus();
   				return false;
   			}
   			if(form1.passwd.value==""){
   				alert("请输入登录密码");
   				form1.passwd.focus();
   				return false;
   			}
   			if(form1.passwd.value!=form1.passwd1.value){
				alert("登录密码与确认密码不一致，请重新输入");
				form1.passwd.focus();
				return false;
			}
   			return true;
   		}
    </script>
  </head>
  
  <body>
    <h1 align="center">新增员工资料</h1>
    <hr/>
    <s:form action="employeeAction!saveOrUpdate.action" name="form1"  method="post" onsubmit="return check();">
    	<table align="center" border="0">
    		<s:hidden name="emp.empid"></s:hidden>
    		<s:hidden name="acc.empid"></s:hidden>
    		<s:textfield name="emp.empname" id="empname" label="员工姓名"></s:textfield>
    		<s:select name="dep.deptid"  list="#request.depList" listValue="deptname" listKey="deptid"  label="所属部门"/>
    		<s:radio name="emp.sex"  list="#{'男':'男','女':'女'}" listKey="key" listValue="value" value="'男'" label="性别"></s:radio>
    		<s:textfield name="emp.birthday" id="birthday" label="出生日期"></s:textfield>
    		<s:textfield name="emp.school" id="school" label="毕业学校"></s:textfield>
    		<s:textfield name="emp.major" id="major" label="所学专业"></s:textfield>
    		<s:textfield name="emp.degree" id="degree" label="学历"></s:textfield>
    		<s:textfield name="emp.mobile" id="mobile" label="手机号码"></s:textfield>
    		<s:textfield name="acc.username" id="username" label="登录账号"></s:textfield>
    		<s:textfield name="acc.passwd" id="passwd" label="登录密码"></s:textfield>
    		<s:textfield name="acc.passwd1"  id="passwd1" label="确认密码"></s:textfield>
    		<s:radio name="acc.status"  list="#{'启用':'启用','禁用':'禁用'}" listKey="key" listValue="value"  label="状态"></s:radio>
	    	<s:submit align="center"  value=" 保 存 "> </s:submit>
	    </table>
    </s:form>
  </body>
</html>
