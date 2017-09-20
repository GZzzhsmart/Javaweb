<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>wxpay.jsp</title>
  </head>
  
  <body>
     	<%
  		//读取cookie变量的值
  		Cookie cookies[]=request.getCookies();
  		String yhbhs = "";
  		String uid="";
  		if(cookies!=null){
  			for(int i=0;i<cookies.length;i++){
  				Cookie c = cookies[i];
  				if(c.getName().equals("yhbhs")){
  					yhbhs=URLDecoder.decode(c.getValue());//获取cookie的值
  					uid = yhbhs.substring(0,8);
  					break;
  				}
  			}
  		}
  		
  	 %>
  	 <script type="text/javascript">
  	 	function test(obj){
  	 		form1.yhbh.value=obj.value;  	 	
  	 	}
  	 </script>
  	<form name="form1" action="wxpaySave.jsp">
  		<input type="text" name="yhbh" id="yhbh" value="<%=uid %>" style="width:150px">
  		<select name="hybhs" onchange="test(this);" style="width:150px">
  		<%
  			while(yhbhs!=null && !yhbhs.equals("")){
  				uid = yhbhs.substring(0,8);
  				yhbhs = yhbhs.substring(8);
  				%>
  				<option value="<%=uid%>"><%=uid%></option>
  				<%
  			}
  		 %>
  		</select>
  		<br/>
  		<input type="submit" value="查询">
  		
  	</form>

  </body>
</html>
