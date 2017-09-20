<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="T11.ValueBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<title>猜数字游戏</title>
  <body>
    <jsp:useBean id="bean" class="T11.ValueBean" scope="session"/>
    <h1>猜数字游戏</h1>
    <form  name="form1" method="post">
    	请输入数字(1~100):<input type="text" name="number" size="5"/>
    	 <input type="submit" name="submit" value="确定"/>
    </form>
    <form name="form2" method="post">
    	<input type="hidden" name="reset" value="reset">
    	<input type="submit" name="submit" value="新游戏"/>
    </form>
    
    <c:if test="${not empty param.reset}">
    	<%bean.reset(); %>
    </c:if>
    
    <h2>
    	<c:if test="${not empty param.number}"> 
    		<c:if test="${param.number lt bean.value}">
    			小了！
    			<%bean.inc(); %>
    			已经猜了${bean.count }次了！
    		</c:if>
    		<c:if test="${param.number gt bean.value}">
    			大了！
    			<%bean.inc(); %>
    			 已经猜了${bean.count }次了！
    		</c:if>
    		<c:if test="${param.number eq bean.value}">
    			<font color="red">${bean.value }恭喜你，猜对了!</font>
    			<%bean.inc(); %>
    			已经猜了${bean.count }次了！
    		</c:if>
    	</c:if>
    </h2>
  </body>
</html>
