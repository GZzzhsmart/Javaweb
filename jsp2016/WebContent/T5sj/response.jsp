<%@ page language="java" contentType="text/html;charset=utf-8"%>
<html>
  <head>
    <title>response.jsp</title>
  </head>
  <body>
  	<%
  		Cookie cookies[] = request.getCookies();
  		if(cookies==null){
  			out.println("没有cookie");
  		}else{
  			for(int i=0;i<cookies.length;i++){
  				if(cookies[i].getName().equals("name")){
  					out.println(cookies[i].getValue());
  				}
  			}
  		}
  	 %>
  </body>
</html>
