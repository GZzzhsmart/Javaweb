<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">   
<html>   
<head>   
<meta http-equiv="Content-Type" content="text/html; charset=gbk">   
<title> 导航栏 </title>   
<style type="text/css">   
#menu {width: 100px}   
.has_children{   
    background: #555;   
    color: #fff;   
    cursor: pointer;   
}   
.highlight{   
    color: #fff;   
    background: green;   
}   
div{   
    padding: 0;   
    margin: 20px 0;   
}   
div a{   
    background: #888;   
    display: none;   
    float: left;   
    width: 100px;   
}   
</style>   
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.js"></script>
<script>
	$(function(){   
   	 	$('.has_children').click(function(){  
    	//addClass添加class样式
    	//siblings兄弟节点
        $(this).addClass("highlight").children("a").show().end()
        .siblings().removeClass("highlight").children("a").hide();   
    });   
       
});  
</script>
</head>   
<body>   
    <div id="menu">   
        <div class="has_children">   
            <span>A组</span>   
            <a>南非</a>   
            <a>墨西哥</a>   
            <a>乌拉圭</a>   
            <a>法国</a>   
        </div>   
        <div class="has_children">   
            <span>B组</span>   
            <a>阿根廷</a>   
            <a>尼日利亚</a>   
            <a>韩国</a>   
            <a>希腊</a>   
        </div>   
        <div class="has_children">   
            <span>C组</span>   
            <a>英格兰</a>   
            <a>美国</a>   
            <a>阿尔及利亚</a>   
            <a>斯洛文尼亚</a>   
        </div>   
        <div class="has_children">   
            <span>D组</span>   
            <a>德国</a>   
            <a>澳大利亚</a>   
            <a>塞尔维亚</a>   
            <a>加纳</a>   
        </div>   
    </div>   
</body>   
</html>  
