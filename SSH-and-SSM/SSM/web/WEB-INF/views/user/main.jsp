<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>mybatis列表</title>
    <link rel="stylesheet" href="<%=path%>/css/pintuer.css">
    <link rel="stylesheet" href="<%=path%>/css/admin.css">
    <script type="text/javascript" src="<%=path%>/js/jquery2.js"></script>
    <script type="text/javascript" src="<%=path%>/js/pintuer.js"></script>
</head>

<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="javascript:void(0);" style="float:right; display:none;">添加字段</a>
        </div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li><a class="button border-main icon-plus-square-o" href="<%=path%>/uc/add"> 新增用户</a></li>
                <li>
                    <form name="hf" action="" method="post">
                        <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
                        <input type="submit" class="button border-main icon-search" value=" 搜 索 ">
                    </form>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th>编号</th>
                <th>登录名称</th>
                <th>密码</th>
                <th>管理员名称</th>
                <th>权限</th>
                <th>性别</th>
                <th>生日</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${ulist}" var="d">
                <tr>
                    <td style="text-align:left; padding-left:20px;">${d.userid }</td>
                    <td>${d.loginname}</td>
                    <td>${d.loginpass}</td>
                    <td>${d.username}</td>
                    <td>
                        <c:choose>
                            <c:when test="${d.upower == 99  }">
                                管理员
                            </c:when>
                            <c:otherwise>
                                普通用户
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${d.sex == 1}">男
                            </c:when>
                            <c:when test="${d.sex == 2 }">
                                女
                            </c:when>
                            <c:otherwise>
                                保密
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${d.birthday }</td>
                    <td>
                        <div class="button-group">
                            <a class="button border-main" href="<%=path%>/uc/uid?userid=${d.userid}"><span
                                    class="icon-edit">
          </span> 修改</a>
                            <a class="button border-red" href="<%=path%>/uc/delete/${d.userid}"
                               onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}"><span
                                    class="icon-trash-o">
          </span> 删除</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>