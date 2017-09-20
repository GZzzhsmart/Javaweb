<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增银行资料</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.bankName.value==""){
    			alert("请输入银行名称");
    			form1.bankName.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">新增银行资料</h1>
    <hr/>
    <form name="form1" action="<%=basePath%>bankServlet?action=add" method="post" onsubmit="return check();">
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="500" bgcolor="cyan">
		<tr height="40">
			<td align="right">银行名称：</td>
			<td>
				<input type="text" name="bankName" style="width:155px"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
    </form>
  </body>
</html>
