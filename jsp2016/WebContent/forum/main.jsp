<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  	<% 
  		if(session.getAttribute("nickname")==null){
  			response.sendRedirect("Login.jsp");
  		}
  	%>
	<frameset cols="240,*" frameborder="no">
		<frame src="onlineUser.jsp" >
		<frameset rows="115,425,120">
			<frame src="top.jsp" >
			<frame src="chatMsg.jsp">
			<frame src="chat.jsp">
		</frameset>
	</frameset>
 

</html>
