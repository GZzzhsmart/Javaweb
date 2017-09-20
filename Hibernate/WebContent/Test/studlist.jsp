<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>学生资料</title>
      <script type="text/javascript">
        function validate(){
            var page = document.getElementsByName("page")[0].value;
            if(page > <s:property value="#request.pageBean.totalPage"/>)
            {
                alert("你输入的页数大于最大页数，页面将跳转到首页！");
                window.document.location.href = "stuAction!list.action";
                return false;
            }
            return true;
        }
    </script>
  </head>
  
  <body>
    <h1 align="center">学生资料列表</h1>
    <hr/>
    <h3 align="center"><a href="${pageContext.request.contextPath }/Test/studAdd.jsp"><font size="5" color="cyan">新增学生</font></a></h3>
    <br/>
    <table width="600" align="center" border="1">
    	<thead>
    		<tr height="30">
    			<th>学号</th>
    			<th>姓名</th>
    			<th>性别</th>
    			<th>年龄</th>
    			<th>身份证号</th>
    			<th>班级编号</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<s:iterator value="#request.pageBean.list" var="d">
    		<tr height="30">
    			<td align="center">${d.studid }</td>
    			<td align="center">${d.studname }</td>
    			<td align="center">${d.sex }</td>
    			<td align="center">${d.age }</td>
    			<td align="center">${d.cardid }</td>
    			<td align="center">${d.classid }</td>
    			<td align="center"><a href="<%=basePath %>stuAction!update.action?studid=${d.studid }">修改</a>
    			&nbsp;&nbsp;&nbsp;<a href="<%=basePath %>stuAction!del.action?studid=${d.studid }" onclick="javascript:if(confirm('确定删除？')){return true;}else{return false;}">删除</a></td>
    		</tr>
    	</s:iterator>
    	</table>
    	<br/>
    <!--  
     <tr>
		<td colspan="9" align="center">
			<span class="current">总记录数&nbsp;&nbsp;${pager.pagebarsum }</span>
			<span class="current">页码&nbsp;&nbsp;${pager.currentpage }/${pager.sumpage }页</span>
			<a href="<%=basePath %>stuAction!list.action?currentpage=1&handle=firstpage">首   页</a>
			<a href="<%=basePath %>stuAction!list.action?currentpage=${pager.currentpage }&handle=uppage">上一页</a>
			<a href="<%=basePath %>stuAction!list.action?currentpage=${pager.currentpage }&handle=downpage" >下一页</a>
			<a href="<%=basePath %>stuAction!list.action?currentpage=${pager.sumpage }&handle=lastpage">尾  页</a> 
		</td>
     </tr>
     -->
    	<table width="600" align="center">
	    	<tr height="40">
		    	<td align="center">
		        	<font size="5">共<font color="red"><s:property value="#request.pageBean.totalPage"/></font>页 </font>
		        </td>
		        <td align="center">
		        	<font size="5">共<font color="red"><s:property value="#request.pageBean.allRows"/></font>条记录</font>
		        </td>
	        </tr>
       	</table>
    	<table width="600" align="center">
     <center>
        <s:if test="#request.pageBean.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>
        <s:else>
            <a href="stuAction!list.action">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="stuAction!list.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
        </s:else>
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="stuAction!list.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="stuAction!list.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
        </s:if>
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
    </center><br>
    <center>
        <form action="stuAction!list.action" onsubmit="return validate();">
            <font size="4">跳转至</font>
            <input type="text" size="2" name="page">页
            <input type="submit" value="跳转">
        </form>
    </center>
     </table>
  </body>
</html>
