<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'onlineUser.jsp' starting page</title>
    <meta http-equiv="refresh" content="3">
    
  </head>
  
  <body bgcolor="#118899">
  <h4><%=session.getAttribute("nickname") %></h4>
  <hr/>
  <ul>
  <%
  	//1.获取application中allUser变量的值
  	Hashtable<String,String> ht_allUser = (Hashtable<String,String>)application.getAttribute("allUser");
  	if(ht_allUser !=null){
  		Set set = ht_allUser.keySet();
  		Iterator<String> it = set.iterator();
  		String key="";
  		while(it.hasNext()){
  			key = it.next();
  			//把自己排除在列表之外
  			if(!key.equals(session.getAttribute("nickname"))){
  			%>
  				<li><font color="pink"><b><%=key%></b></font></li>
  			<%
  			}
  		}
  	}
  	
   %>
   </ul>
  </body>
</html>
