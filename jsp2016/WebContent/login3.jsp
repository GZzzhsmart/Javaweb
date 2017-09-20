<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    
    <title>软件使用意见反馈</title>
   <script type="text/javascript">
   	function check(){
   		if(form1.username.value==""){
    		alert("请输入用户名称");
    		form1.username.focus();
    		return false;
    	}
    	if(form1.email.value==""){
    		alert("请输入邮箱地址");
    		form1.email.focus();
    		return false;
    	}
    	if(telephone.length!=11){
    		alert("请输入11位数的电话号码");
    		form1.telephone.focus();
    		return false;
    	}
    	if(form1.remark.value==""){
    		alert("请打上您的备注");
    		form1.remark.focus();
    		return false;
    	}
    	return true;
   	}
   </script>
  </head>
  <body>
    <h1 align="center">软件使用意见反馈</h1>
    <form action="./loginServlet1" name="form1" method="post" onsubmit="return check();">
   	<table  align="center" border="1" width="400" height="300">
   		<tr bgcolor="cyan">
   			<td align="center">姓名：</td><td><input type="text" name="username"></td>
   		</tr>
   		<tr bgcolor="pink">
   			<td align="center">E-mail:</td><td><input type="text" name="email"><br></td>
   		</tr>
   		<tr bgcolor="cyan">
   			<td align="center">电话</td><td><input type="text" name="telephone"><br></td>
   		</tr>
   		<tr bgcolor="pink">
   			<td align="center">软件</td><td>
   			<select name="soft">
	   			<option value="红蜘蛛">红蜘蛛</option>
	   			<option value="飞鸽">飞鸽</option>
	   			<option value="SQLserver">SQLserver</option>
	   			<option value="photoshop">photoshop</option>
	   			<option value="Eclipse">Eclipse</option>
	   			<option value="Editplus">Editplus</option>
   			</select></td>
   		</tr>
   		<tr bgcolor="yellow">
   			<td align="center">操作系统</td><td>
   			<select name="system">
	   			<option value="windows">window</option>
	   			<option value="unix">unix</option>
	   			<option value="linux">linux</option>
	   			<option value="Mac os">Mac os</option>
   			</select></td>
   		</tr>
   		<tr height="40" bgcolor="coffee">
			<td align="center" width="100">备注</td>
			<td colspan="3">
				<textarea name="remark" id="remark" style="width:200px;height:100px">
				</textarea>
			</td>
		</tr>
   		<tr bgcolor="pink">
   			<td align="center" colspan="2">
   				<input type="submit" name="submit" value=" 确 认 ">
   			</td>
   		</tr>
   	</table>
   	</form>
  </body>
</html>
