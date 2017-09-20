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
    
    <title>上传文件</title>
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
				if(filename !='jpg' && filename !='JPG' && filename !='jpeg' && filename !='JPEG'  && filename !='gif' && filename !='GIF' && filename !='png' && filename !='PNG'&& filename !='png' && filename !='avi'){
					alert("只支持上传jpg,png,gif图片");
					return false;
				}
			}
			filename = form1.File2.value;
    		pos = filename.indexOf('.')+1;
			if(pos>0){
				//获取扩展名
				filename = filename.substring(pos,filename.length);
				if(filename !='jpg' && filename !='JPG' && filename !='jpeg' && filename !='JPEG'  && filename !='gif' && filename !='GIF' && filename !='png' && filename !='PNG'&& filename !='png' && filename !='avi'){
					alert("只支持上传jpg,png,gif图片");
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
   <form name="form1" enctype="multipart/form-data" method = "post" action = "UploadServlet" onsubmit="return check();">  
      <input type="text" name="userName" />   
      <p>上传文件1:<input type = "file" name = "File1" size = "20" maxlength = "20"><br></p>  
      <p>上传文件2:<input type = "file" name = "File2" size = "20" maxlength = "20"><br></p>  
      <input type = "submit" value = "上传">  
    </form>  
  </body>
</html>
