<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Ajax函数的使用</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/prototype.js"></script>
	<script type="text/javascript">
		function getMembers(depart){
			if(depart!="null"){
			 	var url = "/Ajax/T3/select.jsp";
			 	var params = 'depart='+depart;
			 	var myAjax = new Ajax.Request(
			 		url, 
					{
						method: 'get', 
						parameters: params, 
						onComplete: showMembers
					}
			 	);
			}
		}	
		function showMembers(originalRequest){
			var membersData = originalRequest.responseXML.getElementsByTagName("member");
			var mdisplay = '';
			for(var i=0;i<membersData.length;i++){
				mdisplay += '&nbsp;&nbsp;&nbsp;';
				mdisplay += membersData[i].childNodes[1].firstChild.nodeValue;
				mdisplay += '<br>';
			}
			$(dep).parentNode.style.display='block';
			$(dep).innerHTML=mdisplay;
		}
		function hideMenu(){
		if(!dep) return ;
		if($(dep).parentNode.style.display=='none'){
			$(dep).parentNode.style.display='block';
		}else if($(dep).parentNode.style.display='block'){
			$(dep).parentNode.style.display='none';
			$(dep).innerHTML='&nbsp;';
			return ;
		}
	}
	</script>
	
  </head>
  
  <body>
    <h1 align="center">Ajax函数的使用</h1>
    <hr/>
    <table width="500" border="0" cellpadding="0" cellspacing="0">
    	<tr>
    		<td height="20"><a href="javascript:void(0)" onclick="getMembers('d1')">部门1</a></td>
    	</tr>
    	<tr style="display:none">
    		<td height="20" id="d1">&nbsp;</td>
    	</tr>
    	<tr>
    		<td height="20"><a href="javascript:void(0)" onclick="getMembers('d2')">部门2</a></td>
    	</tr>
    	<tr style="display:none">
    		<td height="20" id="d2">&nbsp;</td>
    	</tr>
    	<tr>
    		<td height="20"><a href="javascript:void(0)" onclick="getMembers('d2')">部门3</a></td>
    	</tr>
    	<tr style="display:none">
    		<td height="20" id="d3">&nbsp;</td>
    	</tr>
    	<tr>
    		<td height="20"><a href="javascript:void(0)" onclick="getMembers('d2')">部门4</a></td>
    	</tr>
    	<tr style="display:none">
    		<td height="20" id="d4">&nbsp;</td>
    	</tr>
    </table>
  </body>
</html>
