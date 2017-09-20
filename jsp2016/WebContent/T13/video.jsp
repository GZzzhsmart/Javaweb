<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传视频课件</title>
    <script type="text/javascript">
    	function check(){
    		var filename = form1.File1.value;
    		if(filename==""){
    			alert("请选择要上传的文件");
    			return false;
    		}
    		//获取点号(.)所在的位置下标;
    		var pos = filename.indexOf('.')+1;
			if(pos>0){
				//获取扩展名
				filename = filename.substring(pos,filename.length);
				if(filename !='avi' && filename !='AVI' && filename !='swf' && filename !='SWF'  && filename !='mp4' && filename !='MP4' && filename !='rm' && filename !='RM'&& filename !='flv' && filename !='FLV' ){
					alert("只支持avi,swf,mp4,rm和flv格式的视频");
					return false;
				}
			}
			return true;
    	}
    </script>
  </head>
  
  <body>
  <c:if test="${msg !=null}">
  	<h2 align="center"><font color="red">${msg }</font></h2>
  	<hr/>
  </c:if>
  <h1 align="center">上传视频课件</h1>
  <hr/>
   <form name="form1" enctype="multipart/form-data" method = "post" action = "VideoServlet" onsubmit="return check();">  
      课程节名称：<input type="text" name="section" />   
      <p>上传文件1:<input type = "file" name = "File1" size = "20" maxlength = "20"><br></p>  
      <input type = "submit" value = "上传">  
    </form>  
  </body>
</html>
