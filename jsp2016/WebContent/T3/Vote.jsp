<%@ page contentType="text/html;charset=utf-8"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
   
  </head>
  	<%! int vote[] = new int[3]; %>
  	<%
	      String cost = request.getParameter("cost");
              synchronized(vote){
		    if(cost!=null){
			    if(cost.compareTo("0")==0)
					 vote[0]++;
			    if(cost.compareTo("1")==0)
					 vote[1]++;
			    if(cost.compareTo("2")==0)
					 vote[2]++;

			}
		}
	%>
  	 <br>
  	 投票结果：<br>
  	 侯选人A  :<%= vote[0] %><br>
	 侯选人B  :<%= vote[1] %><br>
	 侯选人C  :<%= vote[2] %><br>
  <body>
   <form action="Vote.jsp" method="get" >
   <hr color="red"/>
   		<p>投票</p>
   		  <input type="radio" name="cost" value="0" checked>侯选人A<br>
		  <input type="radio" name="cost" value="1" >侯选人B<br>
		  <input type="radio" name="cost" value="2" >侯选人C<br>
		
		
		  <input type="submit" value="提交">
		  <input type="reset" value="清除">
   </form>
  </body>
</html>
