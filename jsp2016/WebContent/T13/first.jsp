<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
jsp1
</title>
</head>
<body bgcolor="#ffffff">
<h1>
 µœ÷URL÷ÿ–¥
</h1>
<%
String str=request.getParameter("test");
if(str!=null){
byte[] by=str.getBytes("utf-8");
String ss=new String(by,"utf-8");
 str=ss;
out.println(str);
}
%>
<form action="/jsp2016/UrlServlet">
<input type="text"  value="" name="test"/>
<input type="submit" value="ok"/>
</form>
</body>
</html>
