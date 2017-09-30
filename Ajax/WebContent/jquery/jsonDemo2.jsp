<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JSON格式传递数据</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.1.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#btnJson").bind("click",function(){
    			var url = "${pageContext.request.contextPath}/jsonServlet";
    			$.post(
					url,
					{},
					function(data){
						var arr = data;
						var trs = "";
						for(var i=0;i<arr.length;i++){
							trs+="<tr><td>"+arr[i].id+"</td><td>"+arr[i].studno+"</td><td>"+arr[i].studname+"</td><td>"+arr[i].classname+"</td></tr>";
						}
						/*
							val():对表单控件设值或者取值
							text():对非表单标签设值或取值(字符串)
							html():会对字符串中的HTML标签解析，然后再显示
						*/
						$("#studList").html(trs);
					},
					"json"		
    			);
    		});
    	});
    </script>

  </head>
  
  <body>
    <h1 align="center">JSON格式传递数据</h1>
    <hr/>
    <p id="p1">接收JSON数据</p>
    <input type="button" id="btnJson" value="获取JSON数据">
    
    <table border="1" align="center" cellpadding="3" cellspacing="1" width="500">
    	<thead>
    		<tr>
    			<th>序号</th>
    			<th>学号</th>
    			<th>姓名</th>
    			<th>班级</th>
    		</tr>
    	</thead>
    	<tbody id="studList">
    	
    	</tbody>
    </table>
  </body>
</html>
