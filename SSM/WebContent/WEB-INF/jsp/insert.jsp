<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    String path=request.getContextPath();
    	
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
<script type="text/javascript">
	function returncheck(){
		var loginname=document.getElementById("loginname").value;
		var loginpass=document.getElementById("loginpass").value;
		var username=document.getElementById("username").value;
		var upower=document.getElementById("upower").value;
		var birthday=document.getElementById("birthday").value;
		if(loginname == ""){
			alert("请输入登录名称");
			return false;
		}
		if(loginpass ==""){
			alert("请输入密码");
			return false;
		}
		if(username ==""){
			alert("请输入用户名");
			return false;
		}
		if(upower ==-1){
			alert("请选择权限");
			return false;
		}
		
		if(birthday ==""){
			alert("请输入生日");
			return false;
		}
		return true;
	}
</script>
</head>
	<body>
		<FORM action="<%=path %>/uc/toadd" method="post" onsubmit="return returncheck();">
			<table  width="1000" border="1">
				<tr>
					<th>登录名</th>
					<th>密码</th>
					<th>用户名</th>
					<th>权限</th>
					<th>生日</th>
					<th>性别</th>
				</tr>
				<tr>
  			<td><input type="text" id="loginname" name="loginname"/></td>
	    	<td><input type="text" id="loginpass" name="loginpass"/></td>
	    	<td><input type="text" id="username" name="username"/></td>	    	
	    	<td>
	    		<select id="upower" name="upower" >
	    			<option value="-1">=请选择=</option>
    				<option value="99">管理员</option>
    				<option value="1">普通用户</option>
    			</select>
   			</td>	  		   
	   		<td><input type="text" id="birthday" name="birthday"></td>			   		
	    	<td>性别：
	   			男<input type="radio" name="sex" value="1">
	    		女<input type="radio" name="sex" value="2">
	    		保密<input type="radio" name="sex" value="3" checked="checked">
	        </td>	
	   	</tr>
				
			</table>
			<input type="submit" value="提交"/>
			 ${message}<br/>
			 &nbsp;&nbsp;<a href="<%=path %>/uc/user">返回</a>
		</form>
	</body>
</html>