<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>班级资料列表</title>
     <script type="text/javascript">
        function validate(){
            var page = document.getElementsByName("page")[0].value;
            if(page > <s:property value="#request.pageBean.totalPage"/>){
                alert("你输入的页数大于最大页数，页面将跳转到首页！");
                window.document.location.href = "classAction!list.action";
                return false;
            }
            return true;
        }
    </script>
  </head>
  
  <body>
    <h1 align="center">班级资料列表</h1>
    <hr/>
    <h3 align="center"><a href="${pageContext.request.contextPath }/classAction!init.action"><font size="5" color="cyan">新增班级</font></a></h3>
    <br/>
    <table align="center" border="1" cellpadding="3" cellspacing="1" width="500" >
    	<thead>
    		<tr>
    			<th>班级编号</th>
    			<th>班级名称</th>
    			<th>所属专业</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<tbody>
    		<s:iterator value="#request.clsList" var="d" status="st">
    		<tr height="40">
    			<td>${d.classid }</td>
    			<td>${d.classname }</td>
    			<td>${d.major.majorname}</td>
    			<td><a href="classAction!update.action?clazz.classid=${d.classid}">修改</a>&nbsp;&nbsp;<a href="classAction!del.action?clazz.classid=${d.classid}" onclick="return confirm('删除确认');">删除</a></td>
    		</tr>
    		</s:iterator>
    	</tbody>
    </table>
    <br/>
    	<table width="400" align="center">
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
            <a href="classAction!list.action">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="classAction!list.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
        </s:else>
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="classAction!list.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="classAction!list.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
        </s:if>
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
    </center><br>
    <center>
        <form action="classAction!list.action" onsubmit="return validate();">
            <font size="4">跳转至</font>
            <input type="text" size="2" name="page">页
            <input type="submit" value="跳转"><br/>
        </form>
    </center>
     </table>
  </body>
</html>