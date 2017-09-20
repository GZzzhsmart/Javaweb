<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改管理员资料</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.managerAccount.value==""){
    			alert("请输入登录账号");
    			form1.managerAccount.focus();
    			return false;
    		}
    		if(form1.managerName.value==""){
    			alert("请输入登录姓名");
    			form1.managerName.focus();
    			return false;
    		}
    		if(contact.length!=11){
    			alert("请输入11位数字的电话号码");
    			form1.contact.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">修改管理员资料</h1>
    <hr/>
    <form name="form1" action="<%=basePath%>ManagerServlet?action=updateSave" method="post" onsubmit="return check();">
    	<input type="hidden" name="managerId" value="${manager.managerId}">
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="500" bgcolor="pink">
		<tr height="40">
			<td align="right">登录账号：</td>
			<td>
				<input type="text" name="managerAccount" style="width:155px" value="${manager.managerAccount}"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">管理员姓名</td>
			<td><input type="text" name="managerName"  style="width:155px"  value="${manager.managerName}"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">性别</td>
			<td>
			<c:if test="${manager.sex==0}">
				<input type="radio" name="sex" value="0" checked="checked">男
				<input type="radio" name="sex" value="1">女
			</c:if>
			<c:if test="${manager.sex==1}">
				<input type="radio" name="sex" value="0">男
				<input type="radio" name="sex" value="1"  checked="checked">女
			</c:if>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">联系电话</td>
			<td><input type="text" name="contact"  style="width:155px"  value="${manager.contact}"></td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
    </form>
  </body>
</html>
