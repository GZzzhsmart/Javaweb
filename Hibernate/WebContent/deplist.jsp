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
    <title>部门资料列表</title>
    <script type="text/javascript" src="js/jquery-1.4.1.js"></script>
	<script type="text/javascript">
		function showEmp(depid){
			var empTbl = $("#empTable");
			var url="depAction!empList.action";
			$.post(
				url,
				{
					"dep.deptid":depid
				},
				function(data){
					var trs = "";
					for(var i =0;i< data.length;i++){
						trs += "<tr>";
						trs += "<td>"+data[i].empid+"</td>";
						trs += "<td>"+data[i].empname+"</td>";
						trs += "<td>"+data[i].sex+"</td>";
						trs += "<td>"+data[i].school+"</td>";
						trs += "<td>"+data[i].major+"</td>";
						trs += "<td>"+data[i].degree+"</td>";
						trs += "<td>"+data[i].mobile+"</td>";
						trs += "</tr>";
					}
					$("#empData").html(trs);
					$("#empTable").css("visibility","visible");
				},
				"json"
			);
			
			
			
		}
	</script>
  </head>
  
  <body>
    <h1 align="center">部门资料列表</h1>
    <hr/>
    <table align="center" border="1" cellpadding="3" cellspacing="1" width="1100" >
    	<thead>
    		<tr>
    			<th>部门编号</th>
    			<th>部门名称</th>
    			<th>父部门名称</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<tbody>
    		<s:iterator value="#request.depList" var="d" status="st">
    		<tr>
    			<s:if test="%{#st.odd}">
    				<tr bgcolor="pink">
    			</s:if>
    			<s:else>
    				<tr bgcolor="lightblue">
    			</s:else>
    			<td>${d.deptid }</td>
    			<td><a href="javascript:void(0);" onclick="showEmp('${d.deptid}')">${d.deptname }</a></td>
    			<td>${d.dep.deptname}</td>
    			<td><a href="depAction!update.action?newDep.deptid=${d.deptid}">修改</a>||<a href="depAction!del.action?newDep.deptid=${d.deptid}" onclick="return confirm('删除确认');">删除</a></td>
    		</tr>
    		
    		</s:iterator>
    	</tbody>
    </table>
    <table align="center" border="1" cellpadding="3" cellspacing="1" width="1100" id="empTable" style="visibility:hidden">
    	<thead>
    		<tr>
    			<th>员工编号</th>
    			<th>员工姓名</th>
    			<th>性别</th>
    			<th>毕业学校</th>
    			<th>专业</th>
    			<th>学历</th>
    			<th>手机号码</th>
    		</tr>
    	</thead>
    	<tbody id="empData">
    	</tbody>
   	</table>
  </body>
</html>