<%@ page contentType="text/html; charset=utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
   String name = request.getParameter("username");
   String[] dongwu = request.getParameterValues("dongwu");

   if(name==null){
            out.println("请输入姓名并选择你喜欢的动物");
%><br>
<br>
	<form method="post" action="ex4_5.jsp">
		<p>你的姓名：<input type="text"  name="username" size="20"><br></p>
		<p>你喜欢的动物：<br>
		<input type="checkbox" name="dongwu" value="dog" checked>dog<br>
		<input type="checkbox" name="dongwu" value="cat" >cat<br>
		<input type="checkbox" name="dongwu" value="monkey" >monkey<br>
		
		<input type="submit"  value="确定">
	</form>
<%
    }
else{
        byte b1[]=name.getBytes("GBK");
         name =new String(b1);
         out.println("hello");
         out.println(name);
         out.println(",  你喜欢的小动物是 ：");
		 if(dongwu!=null){
			for(int i=0;i<dongwu.length; i++){
			   out.println(dongwu[i]);
			 } 
		 }
    }
%>