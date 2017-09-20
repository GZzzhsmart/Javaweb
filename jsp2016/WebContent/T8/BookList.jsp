<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="T8.TushuVo"%>
<%@page import="T8.PageObject"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>书籍清单</title>
	
  </head>
  
  <body background="images/013.gif">
  	<h1 align="center">胡歌图书列表</h1>
  	<hr/>
  	<form name="form1" action="" method="post">
  		 <div style="text-align:center;"><a href="<%=basePath %>T8/bookAdd.jsp">添置书籍</a></div>
   		 <table align="center" border="0" width="800" cellspacing="1" cellpadding="1">
   		 	<thead>
   		 		<th>编号</th>
   		 		<th>作者</th>
   		 		<th>标题</th>
   		 		<th>出版社</th>
   		 		<th>出版时间</th>
   		 		<th>价格</th>
   		 		<th>操作</th>
   		 	</thead>
   		 	<% 
   		 	List<TushuVo> booklist=(List<TushuVo>)request.getAttribute("tushuList");
   		 	PageObject pager = (PageObject)request.getAttribute("pager");
   		 	TushuVo books=null;
   		 		for(int i=0;i<booklist.size();i++){
   		 			books = booklist.get(i);
   		 		%>
   		 		<tr>
   		 			<td><%=books.getBookid() %></td>
   		 			<td><%=books.getBookzuozhe() %></td>
   		 			<td><%=books.getBiaoti() %></td>
   		 			<td><%=books.getChuban() %></td>
   		 			<td><%=books.getShijian() %></td>
   		 			<td><%=books.getJiage() %></td>
   		 			<td>
   		 			<a href="<%=basePath %>BookServlet?action=buy&bookId=<%=books.getBookid() %>">购买</a>
   		 			<a href="<%=basePath %>BookServlet?action=update&bookId=<%=books.getBookid() %>">修改</a>
   		 			<a href="<%=basePath %>BookServlet?action=del&bookId=<%=books.getBookid()%>" 
   		 			onclick="javascript:if(confirm('确认删除')){return true; }else{return false; } ">删除</a>
   		 			</td>
   		 		</tr>
   		 			<% 
   		 		}
   		 		%>	
   		 </table>
   		 <table align="center" border="0" cellpadding="1" cellspacing="1" width="500">
			  <tr>
	  			<td>总记录数：<%=pager.getRecordCount() %></td>
        		<td>总页数：<%=pager.getPageCount() %></td>
        		<td>当前页：<%=pager.getCurrentPage() %></td>
        		<td><a href="<%=basePath %>BookServlet?action=list&currentPage=1&opr=first">首页</a></td>
        		<td><a href="<%=basePath %>BookServlet?action=list&currentPage=<%=pager.getCurrentPage() %>&opr=piror">上一页</a></td>
        		<td><a href="<%=basePath %>BookServlet?action=list&currentPage=<%=pager.getCurrentPage() %>&opr=next">下一页</a></td>
        		<td><a href="<%=basePath %>BookServlet?action=list&currentPage=<%=pager.getPageCount() %>&opr=last">末页</a></td>
			  </tr>	 	
   		 </table>
    </form>
  </body>
</html>
