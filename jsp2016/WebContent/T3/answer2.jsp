<%@ page contentType="text/html;charset=utf-8"%>

<html>
  <head>
  
  </head>
  
  <body>
   <%
   		String s = request.getParameter("n");
   		if(s==null){
   			s="1";
   		}
   		try{
   			int n = Integer.parseInt(s);
   			double t=1;
   			for(int i=1;i<=n;i++)
   			t*=i;
   			out.println(n+"的介乘是:<br>"+t);
   		}catch(NumberFormatException e){
   			out.println("<br>请输入数字");
   		}
    %>
  </body>
</html>
