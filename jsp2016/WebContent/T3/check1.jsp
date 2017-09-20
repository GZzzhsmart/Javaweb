<%@ page contentType="text/html;charset=utf-8"%>

<html>
  <head>
  <title>登入页面</title>
  </head>
  <body>
   <%
    	request.setCharacterEncoding("utf-8");
    	String name=request.getParameter("name");
    	String password=request.getParameter("password");
    	if(name!=null && password!=null){
    		if(name.equals("admin") && password.equals("1234")){
    			%>
    				<jsp:forward page="success.jsp">
    					<jsp:param name="" value="<%=name %>"/>
    				</jsp:forward>
    			<% 
    		}else{
    			%>
    				<jsp:forward page="failed.jsp">
    					<jsp:param name="" value="<%=name %>"/>
    				</jsp:forward>
    			<% 
    		}
    	}
     %>
  </body>
</html>
