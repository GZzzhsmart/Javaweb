<%@ page contentType="text/html;charset=utf-8"%>

<html>
  <head>
    
    <title>登录界面</title>
	
  </head>
  <body> 
  	<% 
  		String name = request.getParameter("name"); 
  		String password = request.getParameter("password"); 
  		 
  		if(name!=null&&password!=null){ 
  			//成功跳转到成功页面 
  			if(name.equals("admin")&&password.equals("1234")){ 
  				%>
  				<jsp:forward page="success.jsp">
  					<jsp:param name="" value="<%=name %>"/>
  				</jsp:forward>
  				
  				<% 
  			}
  		}
  	 %>
  	 <jsp:forward page="failed.jsp">
  	 	<jsp:param name="" value="<%=name %>"/>
  	 </jsp:forward>
  </body>
</html>
