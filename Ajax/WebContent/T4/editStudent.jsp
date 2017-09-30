<%@ page language="java" pageEncoding="gb2312"%>

  <head>
    <title>修改学生资料</title>
    <script type="javascript" src="dwr/interface/TeamDAO.js"></script>
	<script type="javascript" src="dwr/interface/StudentDAO.js"></script>
	<script type="javascript" src='dwr/engine.js'></script>
	<script type="javascript" src='dwr/util.js'></script>
  </head>
  <script>
  		function toEdit(){
  			StudentDAO.findStudentById("${param.studentId}",function(result){
  				document.frm.id.value = result.id;
  				document.frm.stuName.value = result.stuName;
  				document.frm.stuNo.value = result.stuNo
  				document.frm.teamId.value= result.teamId;
  			});
  		}
  		function edit(){
  			var id1 = document.frm.id.value;
  			var stuName1 = document.frm.stuName.value;
  			var stuNo1 = document.frm.stuNo.value;
  			var teamId1 = document.frm.teamId.value;
  			
  			var stu = {id:id1,stuName:stuName1,stuNo:stuNo1,teamId:teamId1};
  			
  			StudentDAO.updateStudent(stu,function(result){
  				if(result){
  					alert("修改成功！！");
  					window.opener.document.location.reload();
  					close();
  				}
  				else{
  					alert("修改失败！！");
  				}
  			});
  		}
  		
  		function initTeamList(){		
		TeamDAO.findAllTeam(function(data){
			var teamId = document.getElementById("teamId");
			teamId.length = 0;
			for(var i = 0;i<data.length;i++){
				teamId.add(document.createElement("option"));
				teamId.options[i].value=data[i].id;
				teamId.options[i].text=data[i].teamName;
			}
		});
	}
  </script>
  <body onload="toEdit();initTeamList();">
  	<h1 align="center">修改学生资料</h1>
  	<hr/>
  	<form name="frm">
  		<input type="hidden" name="id">
	    <table>
	    	<tr>
	    		<td>学生性名</td>
	    		<td><input type="text" name="stuName"></td>
	    	</tr>
	    	<tr>
	    		<td>学生学号</td>
	    		<td><input type="text" name="stuNo"></td>
	    	</tr>
	    	<tr>
	    		<td>班级</td>
	    		<td> 
	    			<select name=teamId id="teamId">
	    				<option value="1">1601班</option>
				    	<option value="2">1602班</option>
				    	<option value="3">1603班</option>
				    	<option value="4">1604班</option>
    				</select>
    			</td>
	    	</tr>
	    	<tr>
	    		<td><center><input type="button" name="but" value="修改" onclick="edit();"></center></td>
	    	</tr>
	    </table>
	 </form>
  </body>
