<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="T7.StudentBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>投票系统</title>
	<script type="text/javascript">
    	function checkAll(){
            var curCheckBox = document.all("studentname");
            for(i = 0; i < curCheckBox.length; i++){
                curCheckBox.item(i).checked = true;
            }
        }
       
    </script>
  </head>
  <body>
  <%
  		List<StudentBean>  list = (List<StudentBean>)request.getAttribute("studentList");
  		StudentBean bean = null;
  %>
    <h1 align="center"><font color="red">请选择你心目中的优秀学员</font></h1>
    <form name="form1" action="<%=basePath %>StudentServlet?order=save" method="post">
    	<table border="0" align="center">
    		<tr height="40"><td align="center"><input type="reset" name="allexit" value=" 全 不 选 "></td><td align="center"><input type="button" name="allsave" value="全 都 选"  onclick="checkAll();"></td></tr>
    			<%
    				for(int i=0;i<list.size();i++){
    					bean = list.get(i);
    			%>
    		<tr height="40">
    			<td colspan="2">
    				<input type="checkbox" value="<%=bean.getStudentinf() %>" name="studentname">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=bean.getStudentinf() %>
    			</td>
    		</tr>
    			<%
    				}
    			%>
    		
    		<tr height="40"><td align="center"><input type="submit" name="save" value=" 投 票 " ></td><td align="center"><a href="T7sj/studentadd.jsp"> 新 增 学 员 </a></td></tr>
    	</table>
    </form>
  </body>
</html>
