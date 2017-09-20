<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Struts标签的使用</title>
	
  </head>
  
  <body>
    <h1 align="center">Struts标签使用</h1>
    <hr/>
    <s:bean name="com.ht.vo.EmpVo" var="emp">
    	<s:param name="empNo" value="'ht0001'"/>
    	<s:param name="empName" value="'张三'"/>
    	<s:param name="age" value="75"/>
    	<s:param name="jobDate" value="'2016-12-31'"/>
    	<s:param name="cardNo" value="'123456789012345678'"/>
    	<s:param name="email" value="'1729340612@qq.com'"/>
    	<s:param name="remark" value="'Java开发工程师'"/>
    	<s:param name="sex" value="1"/>
    </s:bean>
    <h2>bean,property,date,if等标签的使用</h2>
    编号：<s:property value="#emp.empNo"/><br/>
    姓名：<s:property value="#emp.empName"/><br/>
    年龄：
    <s:if test="#emp.age<16">未成年人</s:if>
	<s:elseif test="#emp.age<40">成年人</s:elseif>
	<s:elseif test="#emp.age<60">壮年</s:elseif>
	<s:else>老年人</s:else><br/>
	入职日期：<s:date name="#emp.jobDate" format="yyyy-MM-dd"/><br/>
	身份证号：${emp.cardNo }<br/>
	邮箱地址：${emp.email }<br/>
	个人说明：${emp.remark }<br/>
	性别：<s:if test="#emp.sex==1">男</s:if><s:else>女</s:else><br/>
  	<h2>iterator标签的使用</h2>
    <hr/>
    <table>
    	<s:iterator begin="1" end="9" var="d" step="1" status="st">
    		<s:if test="#st.even">
    			<tr bgcolor="pink"><td width="50">${st.index+1 }</td>
    		</s:if>
    		<s:else>
    			<tr bgcolor="green"><td width="50">${st.index+1 }</td>
    		</s:else>
    		<s:iterator begin="1" end="#d" var="dd">
    			<td width="100">${d}*${dd}=${d*dd}</td>
    		</s:iterator>
    	</s:iterator>
    </table>
  </body>
</html>
