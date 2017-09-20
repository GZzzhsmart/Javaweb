<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    	String path = request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
    <title>BootstrapValidator 验证</title>

    <link rel="stylesheet" href="<%=path %>/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=path %>/css/bootstrapValidator.css"/>

    <script type="text/javascript" src="<%=path %>/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/bootstrapValidator.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <!-- form: -->
            <section>
                <div class="page-header">
                    <h1>Bootstrap 合法性验证</h1>
                </div>

                <div class="col-lg-8 col-lg-offset-2">
                    <form id="defaultForm" method="post" action="<%=path %>/loginSuccess.jsp" class="form-horizontal">
                        <fieldset>
                            <legend>Not Empty validator</legend>

                            <div class="form-group">
                                <label class="col-lg-3 control-label">用户名</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" id="username" name="username" />
                                </div>
                            </div>
							
							<div class="form-group">
                                <label class="col-lg-3 control-label">年龄</label>
                                <div class="col-lg-3">
                                    <input type="text" class="form-control" id="ages" name="ages" />
                                </div>
                            </div>
                            
							<div class="form-group">
                                <label class="col-lg-3 control-label">密码</label>
                                <div class="col-lg-5">
                                    <input type="password" class="form-control" id="password" name="password" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-3 control-label">确认密码</label>
                                <div class="col-lg-5">
                                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" />
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-lg-3 control-label">国家</label>
                                <div class="col-lg-5">
                                    <select class="form-control" name="country">
                                        <option value="">-- 选择一个国家 --</option>
                                        <option value="fr">法国</option>
                                        <option value="de">德国</option>
                                        <option value="it">意大利</option>
                                        <option value="jp">日本</option>
                                        <option value="ru">苏联</option>
                                        <option value="gb">英国</option>
                                        <option value="us">美国</option>
                                    </select>
                                </div>
                            </div>
							
							 <div class="form-group">
                                <label class="col-lg-3 control-label">邮箱地址</label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" id="email" name="email" />
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-lg-5 col-lg-offset-3">
                                    <div class="checkbox">
                                        <input type="checkbox" name="acceptTerms" /> 接受用户条款
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-group">
	                            <div class="col-lg-9 col-lg-offset-3">
	                                <button type="submit" class="btn btn-primary">提交</button>
	                            </div>
                        	</div>
                        </fieldset>
                    </form>
                </div>
            </section>
        </div>
    </div>

<script type="text/javascript">
$(document).ready(function() {
    $('#defaultForm').bootstrapValidator({
        message: '所有的值不能为空',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                message: '用户名不能为空',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '用户名长度必须是6~30之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '用户名只能输入数字和文字，不能输入符号'
                    }
                }
            },
            country: {
                validators: {
                    notEmpty: {
                        message: '国家不能为空'
                    }
                }
            },
            acceptTerms: {
                validators: {
                    notEmpty: {
                        message: '你必须接受用户条款'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '邮箱地址不能为空'
                    },
                    emailAddress: {
                        message: '你必须输入正确的邮箱格式'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'confirmPassword',
                        message: '密码和确认密码不一致'
                    }
                }
            },
            confirmPassword: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'password',
                        message: '密码和确认密码不一致'
                    }
                }
            },
            ages: {
                validators: {
                    lessThan: {
                        value: 100,
                        inclusive: true,
                        message: '年龄不能超过一百岁'
                    },
                    greaterThan: {
                        value: 10,
                        inclusive: false,
                        message: '年龄最少要大于10岁'
                    }
                }
            }
        }
    });
});
</script>
</body>
</html>