<%@ page contentType="text/html;charset=utf-8"%>


<html>
  <head>
  
  </head>
  
  <body>
  	<%
  		String s = request.getParameter("n");
  		if(s==null){
  			s="0";
  		}
  		try{
  			int n = Integer.parseInt(s);
  			long t=0;
  			for(int i=1;i<=n;i++)
  				t+=i;
  				out.println("1-"+n+"的累和是：<br>"+t);
  		}catch(NumberFormatException e){
  			out.println("<br>请输入数字");
  		}
  	 %>
  </body>
</html>
