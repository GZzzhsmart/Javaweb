<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加书籍</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.zuozhe.value==""){
    			alert("请输入作者的名字");
    			form1.zuozhe.focus();
    			return false;
    		}
    		if(form1.biaoti.value==""){
    			alert("请输入标题");
    			form1.biaoti.focus();
    			return false;
    		}
    		if(form1.chuban.value==""){
    			alert("请输入出版社的名称");
    			form1.chuban.focus();
    			return false;
    		}
    		if(form1.shijian.value==""){
    			alert("请输入出版时间");
    			form1.shijian.focus();
    			return false;
    		}
    		if(form1.jiage.value==""){
    			alert("请输入图书的价格");
    			form1.jiage.focus();
    			return false;
    		}
    		if(isNaN(form1.jiage.value)){
    			alert("请输入正确的价格");
    			form1.jiage.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  <body background="images/011.gif">
    <form name="form1" action="<%=basePath %>BookServlet?action=add"  method="post" onsubmit="return check();">
    	<h1 align="center"><font color="red">书籍批发市场</font></h1>
    	<table align="center" width="360" border="0" cellspacing="1" cellpadding="1" bgcolor="cyan">
    		
    		<tr>
    			<td width="120" align="right">作者：</td>
    			<td><input type="text" name="zuozhe" style="width:150"></td>
    		</tr>
    		<tr>
    			<td width="120" align="right">标题：</td>
    			<td><input type="text" name="biaoti" style="width:150"></td>
    		</tr>
    		<tr>
    			<td width="120" align="right">出版社：</td>
    			<td><input type="text" name="chuban" style="width:150"></td>
    		</tr> 
    		<tr>
    			<td width="120" align="right">出版时间：</td>
    			<td><input type="text" name="shijian" style="width:150"></td>
    		</tr>
    		<tr>
    			<td width="120" align="right">价格：</td>
    			<td><input type="text" name="jiage" style="width:150"></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="center"><input type="submit" value="  添  加  ">
    			<input type="reset" value="  清  空  "></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>

