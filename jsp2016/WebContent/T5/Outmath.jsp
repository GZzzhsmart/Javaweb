<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>jsp简单例题之九九乘法表</title>
  </head>
  
  <body bgcolor="white">
  	<%
  		String str,str1;
  	 %>
  	 <br/>
  	 <%
  	 	str="";
  	 	for(int i=1;i<10;i++){
  	 		for(int j=1;j<=i;j++){
  	 			str1 = i+"*"+j+"="+i*j;
  	 			if(j==i){
  	 				str = str1 + "<br/>";
  	 			}else{
  	 				str = str1 +"|";
  	 			}
  	 			out.println(str);
  	 		}
  	 		out.println("<br/>");
  	 	}
  	  %>
  </body>
</html>
