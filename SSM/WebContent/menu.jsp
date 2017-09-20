<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>树形菜单</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
    <script type="text/javascript">
    	var vdepid="depid1";
    	function recedata(){
			if(xmlhttp.status==200){
				if(xmlhttp.readyState==4){
					//responseXML：服务器发送给客户端的xml文件格式的数据
					var data=xmlhttp.responseXML;
					//取数据getElementsByTagName
					var listData = data.getElementsByTagName("member");
					var row="<td>";
					for(var i=0;i<listData.length;i++)
					{
						var studid = listData[i].firstChild.nodeValue;
						row+="&nbsp;"+studid+"<br/>";
					}
					row+="</td>";
					var content = document.getElementById(vdepid);
					//把读取的内容放在id中
					content.innerHTML = row;
					//显示当前点击的id
					document.getElementById(vdepid).style.display='block';
				}
			}
		}
		//获取学生资料
		function getDepId(depid){
			
			var param="depid="+depid;
			var url = "${pageContext.request.contextPath}/menuServlet";
			//隐藏之前显示的id
			document.getElementById(vdepid).style.display='none';
			vdepid = "depid"+depid;
			send('post',url,param,true);
			
		}
    </script>
  </head>
  
  <body>
    <h1 align="center">树形菜单</h1>
    <hr/>
    <table border="0" width="200" bgcolor="pink">
    	<tr height="30" onclick="getDepId('1');"><td>开发部</td></tr>
    	<tr id="depid1" style="display:none" bgcolor="yellow"><td>张三<br/>李四</td></tr>
    	<tr height="30" onclick="getDepId('2');"><td>测试部</td></tr>
    	<tr id="depid2" style="display:none" bgcolor="yellow"><td>张三<br/>李四</td></tr>
    	<tr height="30" onclick="getDepId('3');"><td>行政部</td></tr>
    	<tr id="depid3" style="display:none" bgcolor="yellow"><td>张三<br/>李四</td></tr>
    	<tr height="30" onclick="getDepId('4');"><td>财务部</td></tr>
    	<tr id="depid4" style="display:none" bgcolor="yellow"><td>张三<br/>李四</td></tr>
    </table>
    
    
  </body>
</html>
