<%@ page contentType="text/html;charset=GBK" %>
<%
	request.setCharacterEncoding("GBK");
	String pName = request.getParameter("Name");
	String pLove = request.getParameter("Love");
	// 得到所有的cookie
	Cookie cookies[] = request.getCookies();
	// 如果是上一步提交过来的，则更新cookie的值
	if(pName != null) {
		Cookie c = new Cookie("Name",pName);
		c.setMaxAge(30);
		  // cookie 的有效期为 30 秒
		response.addCookie(c);
	}
	else if(cookies != null) { 
	   // 如果已经设置了cookie ， 则得到它的值，并保存到变量pName中
	   for(int i=0; i<cookies.length; i++) {
		  if(cookies[i].getName().equals("Name")){
			   pName = cookies[i].getValue();
		  }
	   }
	}
	if(pLove != null){
		Cookie c = new Cookie("Love", pLove);
		c.setMaxAge(30);       // cookie 的有效期为 30 秒
		response.addCookie(c);
	}else if(cookies != null){  // 如果已经设置了cookie ， 则得到它的值，并保存到变量pLove中
		for(int i=0; i<cookies.length; i++) {
		   if(cookies[i].getName().equals("Love")){
				pLove = cookies[i].getValue();
		   }
		}
	}
%>
<html>
<head>
    <title>测试cookie</title>
</head>
<body bgcolor="#FFFFFF">
    <h2 align="center"> 利用 cookies对象把数据记录在浏览器</h2>
<form action="Cookies.jsp" method="post">
    <p>姓名：
	   <input type="text" size="20" name="Name" value="<% if(pName != null) out.println(pName); %>">
	</p>
    <p>兴趣：
	   <input type="text" size="20" name="Love" value="<% if(pLove != null) out.println(pLove); %>">
	</p>
	<p><input type="submit" value="保 存"> </p>
</form>
</body>
</html>
