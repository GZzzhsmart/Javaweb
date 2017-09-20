<%@ page contentType="text/html;charset=utf-8"%>

<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  <title>include example</title>
  </head>
  
  <body> 
   <form action="answer.jsp" method="post">
   		请选择你要执行的程序：<br>
   		<input type="radio" name="pg" value="1">程序1：求n的累和<br>
   		<input type="radio" name="pg" value="2">程序2：求n的阶乘<br>
   		<input type="radio" name="pg" value="3">程序3：求1~n之间的素数<br>
   		<input type="text" name="n"><input type="submit" value="确定">
   </form>
  </body>
  <%
	String s=request.getParameter("pg");
	if(s==null)
	s="1";
	int pg=Integer.parseInt(s);
	switch(pg){
	case 1:{
%>
	<jsp:include page="answer1.jsp"/>
<%
	  break;
    }
    case 2:{
%>
     <jsp:include page="answer2.jsp"/>
<%
	break;
}
    case 3:{
%>
     <jsp:include page="answer3.jsp"/>
<%
	 break;}
    }
%>
</html>
