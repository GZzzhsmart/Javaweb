<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主界面</title>
    <script type="text/javascript">
    	function check(){
    		if(document.form1.yourName.value==""){
    			alert("请输入你的姓名");
    		}else{
    			document.form1.submit();
    		}
    	}
    </script>
  </head>
  <body>
  	<form action="Yansi/TestD.jsp" method="post" name="form1">
  		<p>你的姓名：
  			<input type="text" name="yourName">
  			<input type="button" value="提交" onClick="check()">
  		</p>
  	</form>
  </body>
</html>
