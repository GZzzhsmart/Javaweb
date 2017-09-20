<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增管理员资料</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.managerAccount.value==""){
    			alert("请输入登录账号");
    			form1.managerAccount.focus();
    			return false;
    		}
    		if(form1.managerPassword.value==""){
    			alert("请输入登录密码");
    			form1.managerPassword.focus();
    			return false;
    		}
    		if(form1.managerPassword.value!=form1.managerPassword1.value){
    			alert("登录密码与确认密码不一致");
    			form1.managerPassword1.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">新增管理员资料</h1>
    <hr/>
    <form name="form1" action="<%=basePath%>ManagerServlet?action=add" method="post" onsubmit="return check();">
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="500" color="cyan">
		<tr height="40">
			<td align="right">登录账号：</td>
			<td>
				<input type="text" name="managerAccount" style="width:155px"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">登录密码</td>
			<td><input type="password" name="managerPassword"  style="width:155px"></td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">确认密码</td>
			<td><input type="password" name="managerPassword1"  style="width:155px"></td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">管理员姓名</td>
			<td><input type="text" name="managerName"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">性别</td>
			<td>
			<input type="radio" name="sex" value="0" checked="checked">男
			<input type="radio" name="sex" value="1">女
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">联系电话</td>
			<td><input type="text" name="contact"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
    </form>
  </body>
</html>
