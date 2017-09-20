<%@ page contentType="text/html;charset=utf-8"%>

<html>
  <head>
    <title>param exemple</title>
  </head>
  
  <body bgcolor="pink"> 
  	<font size=3>加载param.jsp</font>
  	<jsp:include page="param.jsp">
  		<jsp:param name="count" value="3"/>
  	</jsp:include>
  </body>
</html>
