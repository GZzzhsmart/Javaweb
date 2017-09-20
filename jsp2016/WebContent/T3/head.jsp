<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
   
  </head>
  
  <body>
   <table align=center width="1000" height="80">
   		<tr>
   			<td align="center">公司首页</td>
   			<td align="center">产品介绍</td>
    		<td align="center">软件下载</td>
    		<td align="center">成功案例</td>
    		<td align="center">技术支持</td>
    		<td align="center">售后服务</td>
    		<td align="center">联系我们</td>
    		<td align="center">网站地图</td>
    		<td align="center">技术论坛</td>
    		<td align="center">方案下载</td>
   		</tr>
   		<tr>
   			<td colspan="10">
   				恭喜您，注册成功，您的账号是：<%=request.getParameter("username") %>,<%=request.getParameter("password") %>,请妥善保管
   			</td>
   		</tr>
   </table>
   	<hr color="red"/>
  </body>
</html>
