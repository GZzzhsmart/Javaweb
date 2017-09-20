<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    
    <title>第一个动态页面</title>
	
  </head>
  
  <body>
  <%
  	/*
  		include指令：
  			1.包含的文件类型：jsp,html,文本，java程序段。
  			2.把包含的内容原样拷贝到指令所在的地方；
			3.file属性的值不能是变量URL，后不能加任何参数。
			4.所指的路径必须是相对于此JSP的网页的路径。
			5.文件中要避免有<html></html><body></body>
		jsp:include动作元素
			1.元素允许你包含动态和静态文件。
			2.指令能自行判断被包含的文件是动态还是静态文件。
			3.若是静态文件，内容直接加到JSP网页中
			4.若是动态文件，被包含的文件也会被JSP引擎编译执行。
			5.page的值是一个URL（页面名称）
			6.可以传参数
				<jsp:param name="变量名称" value="变量的值"/>
			7.flush=(true|false)属性：如果所包含的页面内容发送变化时，自动更新到当前页面
				flush="false"默认值，不会自动刷新
				flush="true"自动刷新
			

  	*/
  
   %>
 	  <!-- @ include file="T3/head.html" % -->
	  <jsp:include page="T3/head.jsp" flush="true">
	  	<jsp:param name="username" value="admin"/>
	  	<jsp:param name="password" value="1234"/>
	  </jsp:include>
    <h1>九九乘法表</h1>
    <%
    	int i,j;
    	for(i=1;i<=9;i++){
    		for(j=1;j<=i;j++){
    			out.print(i+"*"+j+"="+(i*j) +"&nbsp;&nbsp;&nbsp;&nbsp;");
    		}
    		out.println("<br/>");
    	}
    
     %>
     <hr color="red">
     <%
     	out.print("<p style='color:red;font-size:16pt;'>你好，世界！");
     	java.util.Date date = new java.util.Date();
     	out.print(date.toLocaleString());
     	out.print("</p>");
      %>
      <hr color="cyan">
      <%
      	out.print("你好，欢迎光临<br>");
      	out.print("现在时间:"+ new java.util.Date().toLocaleString());
       %>
      
  </body>
</html>
