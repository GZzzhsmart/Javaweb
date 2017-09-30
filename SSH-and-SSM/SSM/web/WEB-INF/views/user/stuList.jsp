<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<title>学生信息管理</title>
	<link rel="stylesheet"  href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<link rel="stylesheet"  href="${pageContext.request.contextPath }/css/jquery.bootgrid.min.css">
	<link rel="stylesheet"  href="${pageContext.request.contextPath }/css/bootstrapValidator.css">
	<link rel="stylesheet"  href="${pageContext.request.contextPath }/css/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet"  href="${pageContext.request.contextPath }/css/bootstrap-responsive.min.css">
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">学生信息管理</a>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h2>学生信息</h2>
			<a class="btn btn-primary" href="${pageContext.request.contextPath }/stu/exportStu">导出数据为excel</a>
			<a class="btn btn-primary" href="#" id="add">添加学生</a>
			<div class="btn-group">
				<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					查看接口数据 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath }/stu/stuList?current=1&rowCount=10&sort[sender]=asc&searchPhrase=&id=b0df282a-0d67-40e5-8558-c9e93b7befed" target="_blank">JSON</a></li>
					<li><a href="${pageContext.request.contextPath }/stu/stulistxml?current=1&rowCount=10&sort[sender]=asc&searchPhrase=&id=b0df282a-0d67-40e5-8558-c9e93b7befed" target="_blank">XML</a></li>
				</ul>
			</div>
			<table id="grid-data" class="table table-condensed table-hover table-striped">
				<thead>
				<tr>
					<th data-column-id="stuId"  data-identifier="true" data-type="numeric">编号</th>
					<th data-column-id="stuName">学生姓名</th>
					<th data-column-id="stuAge">学生年龄</th>
					<th data-column-id="stuMajor" data-order="desc">学生专业</th>
					<th data-column-id="birthday">出生日期</th>
					<th data-column-id="commands" data-formatter="commands" data-sortable="false">操作</th>
				</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

<!--修改学生信息-->
<div class="modal fade stumodal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">修改资料</h4>
			</div>
			<form action="${pageContext.request.contextPath }/stu/updateStu" method="post" id="xiugai">
				<div class="modal-body">
					<div class="form-group">
						<label for="stuId2">学生编号</label>
						<input type="text" name="stuId" class="form-control" id="stuId2" readonly="true">
					</div>
					<div class="form-group">
						<label for="stuName2">学生姓名</label>
						<input type="text" name="stuName" class="form-control" id="stuName2">
					</div>
					<div class="form-group">
						<label for="stuAge2">学生年龄</label>
						<input type="text" name="stuAge" class="form-control" id="stuAge2">
					</div>
					<div class="form-group">
						<label for="stuMajor2">学生专业</label>
						<input type="text" name="stuMajor" class="form-control" id="stuMajor2">
					</div>
					<div class="form-group">
						<label for="birthday2">出生日期</label>
						<input type="date" name="birthday" class="form-control" id="birthday2">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">保存</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--新增学生信息-->
<div class="modal fade addmodal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">新增学生</h4>
			</div>
			<form action="${pageContext.request.contextPath }/stu/addStu" method="post" id="modify">
				<div class="modal-body">
					<div class="form-group">
						<label for="stuName1">学生姓名</label>
						<input type="text" name="stuName" class="form-control" id="stuName1">
					</div>
					<div class="form-group">
						<label for="stuAge1">学生年龄</label>
						<input type="text" name="stuAge" class="form-control" id="stuAge1">
					</div>
					<div class="form-group">
						<label for="stuMajor1">学生专业</label>
						<input type="text" name="stuMajor" class="form-control" id="stuMajor1">
					</div>
					<div class="form-group">
						<label for="birthday1">出生日期</label>
						<input type="date" name="birthday" class="form-control" id="birthday1">
					</div>
					<div class="form-group">
						<input type="hidden" name="Id" class="form-control" id="Id">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">新增</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script  type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.3.min.js"></script>
<script  type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script  type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.bootgrid.min.js"></script>
<script  type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap-datetimepicker.min.js"></script>
<script  type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrapValidator.js"></script>
<!--分页-->
<script>
    $(document).ready(function(){
        var grid = $("#grid-data").bootgrid({
            ajax:true,
            post: function ()
            {
                return {
                    id: "b0df282a-0d67-40e5-8558-c9e93b7befed"
                };
            },
            url:"${pageContext.request.contextPath }/stu/stuList",
            formatters: {
                "commands": function(column, row)
                {
                    return "<button type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.stuId + "\">编辑<span class=\"fa fa-pencil\"></span></button> " +
                        "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.stuId + "\">删除<span class=\"fa fa-trash-o\"></span></button>";
                }
            }
        }).on("loaded.rs.jquery.bootgrid", function()
        {
            grid.find(".command-edit").on("click", function(e)
            {
                $(".stumodal").modal();
                $.post("${pageContext.request.contextPath }/stu/getStuInfo",{stuId:$(this).data("row-id")},function(str){
                    $("#stuId2").val(str.stuId);
                    $("#stuName2").val(str.stuName);
                    $("#stuAge2").val(str.stuAge);
                    $("#stuMajor2").val(str.stuMajor);
                    $("#birthday2").val(str.birthday);
                });
            }).end().find(".command-delete").on("click", function(e)
            {
                alert("你确定删除: " + $(this).data("row-id"));
                $.post("${pageContext.request.contextPath }/stu/delStu",{stuId:$(this).data("row-id")},function(){
                    alert("删除成功");
                    $("#grid-data").bootgrid("reload");
                });
            });
        });
    });

    $(document).ready(function(){
        $("#add").click(function(){
            $(".addmodal").modal();
        });
    });
</script>

<script>
    //bootstrap 数据验证
    $(document).ready(function() {
        $('#modify').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                'stuName': {
                    validators: {
                        notEmpty: {
                            message: '学生姓名不能为为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 10,
                            message: '不需要这么长!'
                        }
                    }
                },
                'stuAge': {
                    validators: {
                        notEmpty: {
                            message: '年龄不能为空'
                        },
                        regexp: {
                            regexp: /^\d+$/,
                            message: '请输入数字类型！'
                        }
                    }
                },
                'stuMajor': {
                    validators: {
                        notEmpty: {
                            message: '专业不能为空'
                        }
                    }
                },
                'birthday': {
                    validators: {
                        notEmpty: {
                            message: '出生日期不能为空'
                        }
                    }
                }
            }
        });

        $('#xiugai').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                'stuName': {
                    validators: {
                        notEmpty: {
                            message: '学生姓名不能为为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 10,
                            message: '不需要这么长!'
                        }
                    }
                },
                'stuAge': {
                    validators: {
                        notEmpty: {
                            message: '年龄不能为空'
                        },
                        regexp: {
                            regexp: /^\d+$/,
                            message: '请输入数字类型！'
                        }
                    }
                },
                'stuMajor': {
                    validators: {
                        notEmpty: {
                            message: '专业不能为空'
                        }
                    }
                },
                'birthday': {
                    validators: {
                        notEmpty: {
                            message: '出生日期不能为空'
                        }
                    }
                }
            }
        });
    });
</script>
</body>
</html>