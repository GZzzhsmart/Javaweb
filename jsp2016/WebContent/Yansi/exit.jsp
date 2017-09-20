<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	//删除username变量
	session.removeAttribute("username");
	//销毁session对象，所有变量全部失效
	session.invalidate();
 %>
 <script type="text/javascript">
 	//关闭游览器
 	//window.close();
 	//没有框架集的情况下关闭窗口
	window.open("","_self").close();
	//有框架集的情况下关闭窗口
	//window.open("about:blank","_top").close()
	//window.open("","_top").close()
</script>
