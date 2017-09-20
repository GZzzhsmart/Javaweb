<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.CityVo"%>
<%@page import="bean.PageObject"%>
<%@ taglib prefix="s"  uri="/demotag"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>城市列表</title>
  </head>
  
  <body background="images/013.gif">
    <h1 align="center">城市列表</h1>
    <hr/>
    <center>
    	<table border="0" cellpadding="1" cellspacing="1" width="500">
    		<tr>
    			<td><a href="<%=basePath %>CityServlet?action=init">新增</a></td>
    		</tr>
    	</table>
    	<%
    		//获取Servlet中定义的request变量
    		List<CityVo> cityList = (List<CityVo>)request.getAttribute("cityList");
    		PageObject pager = (PageObject)request.getAttribute("pager");
    		String updateUrl = basePath+"CityServlet2";
    	 %>
    	 <s:cityList pager="<%=pager %>" updateUrl="<%=updateUrl %>" cityList="<%=cityList %>"></s:cityList>
    </center>
  </body>
</html>
