<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>员工资料</title>
      <script type="text/javascript">
        function validate(){
            var page = document.getElementsByName("page")[0].value;
            if(page > <s:property value="#request.pageBean.totalPage"/>){
                alert("你输入的页数大于最大页数，页面将跳转到首页！");
                window.document.location.href = "empAction!list.action";
                return false;
            }
            return true;
        }
    </script>
  </head>
  
  <body>
    <h1 align="center">员工资料列表</h1>
    <hr/>
    <h3 align="center"><a href="${pageContext.request.contextPath }/empAction!init.action"><font size="5" color="cyan">新增员工</font></a></h3>
    <br/>
    <table width="1000" align="center" border="1">
    	<thead>
    		<tr height="30">
    			<th>编号</th>
    			<th>姓名</th>
    			<th>部门</th>
    			<th>性别</th>
    			<th>出生日期</th>
    			<th>毕业学校</th>
    			<th>专业</th>
    			<th>学历</th>
    			<th>号码</th>
    			<th>账号</th>
    			<th>密码</th>
    			<th>状态</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<s:iterator value="#request.empList" var="d" status="st">
    		<tr height="40">
    			<td align="center">${d.empid }</td>
    			<td align="center">${d.empname }</td>
    			<td align="center">${d.dep.deptname}</td>
    			<td align="center">${d.sex }</td>
    			<td align="center"><s:date name="#d.birthday" format="yyyy-MM-dd"/></td>
    			<td align="center">${d.school }</td>
    			<td align="center">${d.major }</td>
    			<td align="center">${d.degree }</td>
    			<td align="center">${d.mobile }</td>
    			<td align="center">${d.account.username }</td>
    			<td align="center">${d.account.passwd }</td>
    			<td align="center">${d.account.status}</td>
    			<td align="center">
	    			<a href="<%=basePath %>empAction!get.action?emp.empid=${d.empid }">修改</a>
	    			&nbsp;&nbsp;&nbsp;
	    			<a href="<%=basePath %>empAction!del.action?emp.empid=${d.empid }" onclick="javascript:if(confirm('确定删除？')){return true;}else{return false;}">删除</a>
    			</td>
    		</tr>
    	</s:iterator>
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
            <a href="empAction!list.action">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="empAction!list.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
        </s:else>
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="empAction!list.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="empAction!list.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
        </s:if>
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
    </center><br>
    <center>
        <form action="empAction!list.action" onsubmit="return validate();">
            <font size="4">跳转至</font>
            <input type="text" size="2" name="page">页
            <input type="submit" value="跳转"><br/>
        </form>
        <s:form theme="simple" name="form1" action="empAction!list.action" method="post">
			<tr>
				<td align="center">姓名：<s:textfield name="emp.empname"/>
		     		<s:submit value="查询"></s:submit>
		     	</td>
	     	</tr>
    	</s:form>
    </center>
     </table>
  </body>
</html>
