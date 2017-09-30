<%@ page language="java" pageEncoding="gb2312"%>
<%@page import="com.ht.dwr.StudentVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>学生列表</title>
<script language="javascript" src="dwr/interface/JDate.js"></script>
<script language="javascript" src="dwr/interface/StudentDAO.js"></script>
<script language="javascript" src='dwr/engine.js'></script>
<script language="javascript" src='dwr/util.js'></script>
  </head>
<script language="javascript">
	var popUpWin;
	function popUpWindow(URLStr, left, top, width, height)
	{
	  if(popUpWin)
	  {
	    if(!popUpWin.closed) popUpWin.close();
	  }
	  popUpWin = open(URLStr, 'popUpWin', 'toolbar=no,location=no,directories=no,status=no,menub ar=no,scrollbar=no,resizable=no,copyhistory=yes,width='+width+',height='+height+',left='+left+', top='+top+',screenX='+left+',screenY='+top+'');
	}
	
	
	function doTest() {
	    //JDate.toString(load);
		StudentDAO.findAllStudent(load)
	}

	function load(data) {	
		//data得到的是一个用户数组，里面存放的是一个用户对象(StudentVo)
		var tab = document.getElementById("tab");
		for(i = 0;i<data.length;i++){
			var row = tab.insertRow();
			
			var cell = row.insertCell();
			cell.innerHTML=data[i].id;
			
			var cell = row.insertCell();
			cell.innerHTML = data[i].stuName;
			
			var cell = row.insertCell();
			cell.innerHTML = data[i].stuNo;
			
			var cell = row.insertCell();
			cell.innerHTML = data[i].teamId;
			
			var cell = row.insertCell();
			cell.innerHTML = "<a href=\"javascript:popUpWindow('editStudent.jsp?studentId="+data[i].id+"',200,200,400,200);\" >修改</a>";
			
			var cell = row.insertCell();
			cell.innerHTML = "<a href=\"javascript:deleteStu('"+data[i].id+"')\" >删除</a>";
		}
	}
	
	//清空table的tr
	function clearTab(){
		var t = tab.rows.length;
		for(i = 1;i<t;i++){	
			tab.deleteRow(tab.rows[1].rowIndex);
		}
		return true;
	}
	
	//删除学生
	function deleteStu(studentId){
		StudentDAO.delStudent(studentId,function(result){
			if(result){
				alert("删除成功！！！");
				 document.location.reload();
			}
			else{
				alert("删除失败");
			}
		});
	}

</script>
  <%
    	StudentVo student = (StudentVo)request.getAttribute("student");
  %>
  <body onload="doTest();">
  <h1 align="center">学生列表</h1>
  <hr/>
  <a href="javascript:popUpWindow('addStudent.jsp',200,200,400,200);">添加学生</a>
    <form action="" method="post" >
      <table border="0" id="tab">
        <tr>
          <td>编号</td>
          <td>学生名称</td>
          <td>学生学号</td>
          <td>学生班级</td>
          <td colspan="2">操作</td>
        </tr>
      </table>
     </form>
  </body>
</html>
