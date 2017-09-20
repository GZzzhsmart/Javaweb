<%@page contentType="text/html;charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
    String sage = request.getParameter("age");
    String sname=request.getParameter("username");
    if(sname==null){
         out.println("请输入用户名并选择年龄段");
%>
<br>
	<form method="post" action="ex4_4.jsp">
		<p>你的姓名：<input type="text"  name="username" size="20"><br></p>
		<p>你的年龄：<br>
		<input type="radio" name="age" value="小于20岁" checked><20<br>
		<input type="radio" name="age" value="小于30岁" ><30<br>
		<input type="radio" name="age" value="小于40岁" ><40<br>
		<input type="radio" name="age" value="大于40岁" >other<br>

		<input type="submit"  value="确定">
	</form>
<%
    }
  else{
         byte b1[]=sname.getBytes("GBK");
         sname =new String(b1);
         byte b2[]=sage.getBytes("GBK");
         sage =new String(b2);
         out.println("hello");
         out.println(sname);
         out.println("， 你");
         out.println(sage);

    }
%>
		