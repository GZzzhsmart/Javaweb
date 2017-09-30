<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生资料列表</title>
    
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajax.js"></script>
	<script type="text/javascript">
		function recedata(){
			if(xmlhttp.status==200){
				if(xmlhttp.readyState==4){
					var data=xmlhttp.responseXML;
					//取数据getElementsByTagName
					var listData = data.getElementsByTagName("student");
					var row="";
					for(var i=0;i<listData.length;i++)
					{
						row+="<tr>";
						//取第一个字段的值
						var studid = listData[i].childNodes[0].firstChild.nodeValue;
						row+="<td>"+studid+"</td>";
						//取第二个字段的值
						var studname = listData[i].childNodes[1].firstChild.nodeValue;
						row+="<td>"+studname+"</td>";
						//取第三个字段的值
						var age = listData[i].childNodes[2].firstChild.nodeValue;
						row+="<td>"+age+"</td>";
						//取第四个字段的值
						var sex = listData[i].childNodes[3].firstChild.nodeValue;
						row+="<td>"+sex+"</td>";
						//取第五个字段的值
						var classname = listData[i].childNodes[4].firstChild.nodeValue;
						row+="<td>"+classname+"</td>";
						row+="</tr>";
					}
					
					var content = document.getElementById("databody");
					//把读取的内容放在id中
					content.innerHTML = row;
				}
			}
		}
		//获取学生资料
		function getStudentData(){
			
			var param="";
			var url = "${pageContext.request.contextPath}/xmlServlet";
			send('post',url,param,true);
		}
	</script>
  </head>
  
  <body>
    <h1 align="center" >学生资料列表</h1>
    <hr/>
    <input type="button" value="获取学生资料" onclick="getStudentData();"><br/>
    <table border="1" align="center" width="600" cellpadding="3" cellspacing="1">
    	<thead>
    		<tr>
    			<th>学号</th>
    			<th>姓名</th>
    			<th>年龄</th>
    			<th>性别</th>
    			<th>班级</th>
    		</tr>
    	</thead>
    	<tbody id="databody"></tbody>
    </table>
  </body>
</html>