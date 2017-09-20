<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>节假日高亮显示万年历</title>
<link href="chat/theme.min.css" type="text/css" rel="stylesheet" />
<link href="chat/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<!--
//用table 模拟出日期的效果
//格式
//      xxxx年xx月xx日  (选择的日期,默认为当天)  日期要有5-6排，连接上月下月。当选择上下月中的日期时，跳到上月或下月中
//星期一,星期二,星期三,星期四,星期五,星期六,星期七  
//day1  day2 day3 day4  day5  day6  day7
//day1  day2 day3 day4  day5  day6  day7
//day1  day2 day3 day4  day5  day6  day7
//day1  day2 day3 day4  day5  day6  day7
//day1  day2 day3 day4  day5  day6  day7
//day1  day2 day3 day4  day5  day6  day7
-->
<div class="aboluo-w-700">
<div class="aboluo-leftdiv">
<div class="aboluo-tools">
<div class="aboluo-calendar-select-year"></div>
<div class="aboluo-calendar-month">
<a class="aboluo-month-a-perv" href="javascript:;">&lt; </a>
<a class="aboluo-month-a-next" href="javascript:;"> &gt;</a>
</div>
<input type="button" class="aboluo-toToday" value="返回今天" />
</div>
<div class="aboluo-rilidiv">
<table class="aboluo-rilitable" cellspacing="0" cellpadding="0" >
<thead class="aboluo-rilithead">
	<tr>
		<td>一</td>
		<td>二</td>
		<td>三</td>
		<td>四</td>
		<td>五</td>
		<td style="color:red;">六</td>
		<td style="color:red;">日</td>
	</tr>
</thead>
</table>
</div>
</div>
<div class="aboluo-rightdiv">
<p class="aboluo-xssj"><p>
<p class="aboluo-currday"></p>
<p class="aboluo-ssjjr"></p>
<p class="aboluo-xsmx"></p>
</div>
</div>
<script src="chat/jquery-1.8.3.min.js"></script>
<script src="chat/Calendar.js"></script>

<div style="text-align:center;">

</div>
</body>
</html>
