<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.CityVo"%>
<%@page import="base.IBaseDAO"%>
<%@page import="base.BaseDAOImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生注册界面</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.password.value==""){
    			alert("请输入密码");
    			form1.password.focus();
    			return false;
    		}
    		if(form1.username.value==""){
    			alert("请输入姓名");
    			form1.username.focus();
    			return false;
    		}
    		if(form1.homeaddr.value==""){
    			alert("请输入家庭地址");
    			
    		}
    		if(form1.email.value==""){
    			alert("请输入邮箱地址");
    			form1.email.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
  	<h1 align="center"><font color="#ff3300">学生注册界面</font></h1>
  	<form name="form1" action="studentServlet?action=addSave" method="post" onsubmit="return check();"> 
  	 	<table align="center" width="420" cellspacing="1" cellpadding="1" bgcolor="pink">
  			<tr height="40">
  				<td align="right">手机号：</td>
  				<td><input type="text" name="phone" ></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">密码：</td>
  				<td><input type="password" name="password" ></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">用户姓名：</td>
  				<td><input type="text" name="username" ></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">性别：</td>
  				<td>
  					<input type="radio" name="sex" value="0">男
  					<input type="radio" name="sex" value="1">女
  				</td>	
  			</tr>
  			<tr height="40">
  				<td align="right">家庭住址：</td>
  				<td><input type="text" name="homeaddr" ></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">邮箱：</td>
  				<td><input type="text" name="email" ></td>	
  			</tr>
  			<tr height="40">
			<td align="right">省份名称：</td>
				<td>
				<select name="province" style="width:155px">
					<option value="1">北京</option>
  					<option value="2">天津</option>
  					<option value="3">河北省</option>
  					<option value="4">山西省</option>
  					<option value="14">江西省</option>
				</select>
				</td>
			<td>&nbsp;</td>
		</tr>
  		<tr height="40">
			<td align="right">城市名称：</td>
			<td>
				<select name="city" style="width:155px">
					<option value="1">石景山区</option>
  						<option value="2">海淀区</option>
  						<option value="17">东丽区</option>
  						<option value="18">西青区</option>
  						<option value="32">石家庄市</option>
  						<option value="33">邯郸市</option>
  						<option value="43">大同市</option>
  						<option value="44">太原市</option>
  						<option value="165">南昌市</option>
  						<option value="170">赣州市</option>
				</select>
			</td>
			<td>&nbsp;</td>
		</tr>
	  		<tr>
	  			<td colspan="2" align="center"><input type="submit" value=" 注 册 ">&nbsp;
	  			&nbsp;&nbsp;&nbsp;<input type="reset" value=" 清 空 "></td>
	  		</tr>
  		</table>
  	</form>
   	
  </body>
</html>
