<%@ page contentType="text/html;charset=utf-8"%>

<html>
  <head>
  
    <title>验证登录</title>
  </head>
  <body>
    <%
    	request.setCharacterEncoding("utf-8");
    	String name=request.getParameter("username");
    	String password=request.getParameter("password");
    	if(name!=null && password!=null){
    		if(name.equals("admin") && password.equals("1234")){
    			%>
    				<jsp:forward page="table.jsp">
    					<jsp:param name="" value="<%=name %>"/>
    				</jsp:forward>
    			<% 
    		}else{
    			%>
    				<jsp:forward page="login1.jsp">
    					<jsp:param name="" value="<%=name %>"/>
    				</jsp:forward>
    			<% 
    		}
    	}
     %>
  </body>
</html>
