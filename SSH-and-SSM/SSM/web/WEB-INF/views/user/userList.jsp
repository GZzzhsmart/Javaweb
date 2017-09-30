<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <title>玩家信息管理</title>
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
                        <a class="navbar-brand" href="#">玩家信息管理</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h2>玩家信息</h2>
            <a class="btn btn-primary" href="${pageContext.request.contextPath }/users/exportStu">导出数据为excel</a>
            <a class="btn btn-primary" href="#" id="add">新增玩家</a>
            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    查看接口数据 <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath }/users/userList?current=1&rowCount=10&sort[sender]=asc&searchPhrase=&id=b0df282a-0d67-40e5-8558-c9e93b7befed" target="_blank">JSON</a></li>
                    <li><a href="${pageContext.request.contextPath }/users/userlistxml?current=1&rowCount=10&sort[sender]=asc&searchPhrase=&id=b0df282a-0d67-40e5-8558-c9e93b7befed" target="_blank">XML</a></li>
                </ul>
            </div>
            <table id="grid-data" class="table table-condensed table-hover table-striped">
                <thead>
                <tr>
                    <th data-column-id="userid"  data-identifier="true" data-type="numeric">编号</th>
                    <th data-column-id="username">玩家姓名</th>
                    <th data-column-id="email">邮箱</th>
                    <th data-column-id="phone">手机号码</th>
                    <th data-column-id="heroname">英雄名称</th>
                    <th data-column-id="propname">道具名称</th>
                    <th data-column-id="created_time">购买时间</th>
                    <th data-column-id="commands" data-formatter="commands" data-sortable="false">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>

<!--修改玩家信息-->
<div class="modal fade stumodal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改资料</h4>
            </div>
            <form action="${pageContext.request.contextPath }/users/updateuser" method="post" id="xiugai">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="userid2">玩家编号</label>
                        <input type="text" name="userid" class="form-control" id="userid2" readonly="true">
                    </div>
                    <div class="form-group">
                        <label for="username2">玩家姓名</label>
                        <input type="text" name="username" class="form-control" id="username2">
                    </div>
                    <div class="form-group">
                        <label for="password2">玩家密码</label>
                        <input type="text" name="password" class="form-control" id="password2">
                    </div>
                    <div class="form-group">
                        <label for="email2">邮箱</label>
                        <input type="text" name="email" class="form-control" id="email2">
                    </div>
                    <div class="form-group">
                        <label for="phone2">手机号码</label>
                        <input type="text" name="phone2" class="form-control" id="phone2">
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
                <h4 class="modal-title">新增玩家</h4>
            </div>
            <form action="${pageContext.request.contextPath }/users/adduser" method="post" id="modify">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="username1">玩家姓名</label>
                        <input type="text" name="username" class="form-control" id="username1">
                    </div>
                    <div class="form-group">
                        <label for="password1">玩家密码</label>
                        <input type="text" name="password" class="form-control" id="password1">
                    </div>
                    <div class="form-group">
                        <label for="email1">玩家邮箱</label>
                        <input type="text" name="email" class="form-control" id="email1">
                    </div>
                    <div class="form-group">
                        <label for="phone1">手机号码</label>
                        <input type="text" name="phone" class="form-control" id="phone1">
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
            url:"${pageContext.request.contextPath }/users/userList",
            formatters: {
                "commands": function(column, row)
                {
                    return "<button type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.userid + "\">编辑<span class=\"fa fa-pencil\"></span></button> " +
                        "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.userid + "\">删除<span class=\"fa fa-trash-o\"></span></button>";
                }
            }
        }).on("loaded.rs.jquery.bootgrid", function()
        {
            grid.find(".command-edit").on("click", function(e)
            {
                $(".stumodal").modal();
                $.post("${pageContext.request.contextPath }/users/getuserInfo",{userid:$(this).data("row-id")},function(str){
                    $("#userid2").val(str.userid);
                    $("#username2").val(str.username);
                    $("#password2").val(str.password);
                    $("#email2").val(str.email);
                    $("#phone2").val(str.phone);

                });
            }).end().find(".command-delete").on("click", function(e)
            {
                alert("你确定删除: " + $(this).data("row-id"));
                $.post("${pageContext.request.contextPath }/users/delUser",{userid:$(this).data("row-id")},function(){
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