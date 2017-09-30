<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>自动刷新界面</title>
    
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
    <script type="text/javascript">
    	var vdepid="depid1";
    	function recedata(){
			if(xmlhttp.status==200){
				if(xmlhttp.readyState==4){
					var data=xmlhttp.responseXML;
					var listData = data.getElementsByTagName("member");
					var row="";
					for(var i=0;i<listData.length;i++)
					{
						var studid = listData[i].firstChild.nodeValue;
						row+="<li>"+studid+"</li>";
					}
					var content = document.getElementById("msg");
					content.innerHTML = row;
				}
			}
		}
		
		function refresh(){
			var param="";
			var url = "${pageContext.request.contextPath}/refreshServlet";
			send('post',url,param,true);
		}
		setInterval("refresh()",1000);
    </script>

  </head>
  
  <body>
    <h1 align="center">自动刷新界面</h1>
    <hr/>
    <ul id="msg">
    	<li>张三</li>
    	<li>李四</li>
    </ul>
  </body>
</html>
