<%@ page contentType="text/html;charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
  </head>
  
  <body>
   <%
   		int i,j;
   		String s = request.getParameter("n");
   		if(s==null){
   			s="0";
   		}
   		try{
   			int n = Integer.parseInt(s);
   			out.println("1-"+n+"之间的素数有:<br>");
   			for(i=1;i<=n;i++){
				for(j=2;j<i;j++)
					if(i%j==0)
						break;
				if(j==i)
				
				out.println(i+",");
			}
			
		}catch(NumberFormatException e){
			out.println("<br>请输入数字");
		}
   		
    %>
  </body>
</html>
