----日期函数
select getdate()
--本月的第一天
select dateadd(mm,datediff(mm,0,getdate()),0);
--本周的星期一
select dateadd(wk,datediff(wk,0,getdate()),0);
--一年的第一天
select dateadd(yy,datediff(yy,0,getdate()),0);
--季度的第一天
select dateadd(qq,datediff(qq,0,getdate()),0);
--上个月的最后一天
select dateadd(ms,-3,dateadd(mm,datediff(mm,0,getdate()),0)) 上个月的最后一天;
--去年的最后一天
select dateadd(ms,-3,dateadd(yy,datediff(yy,0,getdate()),0));
--本月的最后一天
select dateadd(ms,-3,dateadd(mm,datediff(m,0,getdate())+1,0));
--本月的第一个星期一
select dateadd(wk,datediff(wk,0,dateadd(dd,6-datepart(day,getdate()),getdate())),0) 本月的第一个星期一;
--本年的最后一天
select dateadd(ms,-3,dateadd(yy,datediff(yy,0,getdate())+1,0));
--1、年有多少天
select datediff(dd,dateadd(yy,datediff(yy,0,getdate()),0),dateadd(yy,datediff(yy,0,getdate())+1,0))  '2017年的天数'
--2、年第一个月有多少天
select datediff(dd,dateadd(mm,datediff(mm,0,getdate()),0),dateadd(mm,datediff(mm,0,getdate())+1,0))  '2017年的第一个月的天数'
--3、年第二个月有多少天
select datediff(dd,dateadd(mm,datediff(mm,0,getdate())-1,0),dateadd(mm,datediff(mm,0,getdate()),0))  '2017年的第二个月的天数'
--4、年第一个季度有多少天
select datediff(dd,dateadd(qq,datediff(qq,0,getdate()),0),dateadd(qq,datediff(qq,0,getdate())+1,0))  '2017年的第一个季度的天数'
--5、年第二个季度有多少天
select datediff(dd,dateadd(qq,datediff(qq,0,getdate())+1,0),dateadd(qq,datediff(qq,0,getdate())+2,0))  '2017年的第二个季度的天数'
select dateadd(qq,datediff(qq,0,getdate())+1,0)
--6、年第三个季度有多少天
select datediff(dd,dateadd(qq,datediff(qq,0,getdate())+2,0),dateadd(qq,datediff(qq,0,getdate())+3,0))  '2017年的第三个季度的天数'
--7、年第四个季度有多少天
select datediff(dd,dateadd(qq,datediff(qq,0,getdate())+3,0),dateadd(qq,datediff(qq,0,getdate())+4,0))  '2017年的第四个季度的天数'
--8、年上半年有多少天
select datediff(dd,dateadd(qq,datediff(qq,0,getdate()),0),dateadd(qq,datediff(qq,0,getdate())+2,0))  '2017年的上半年的天数'
select dateadd(qq,datediff(qq,0,getdate()),0)
--9、年下半年有多少天
select datediff(dd,dateadd(qq,datediff(qq,0,getdate())+2,0),dateadd(qq,datediff(qq,0,getdate())+4,0))  '2017年的下半年的天数'
--10、年月日星期几
select datename(dw,117) '1900年月日的星期'
select convert(varchar(30),getdate(),111)
--11、2017年6月1日星期几
select datename(dw,dateadd(mm,datediff(mm,0,getdate())+3,0)) '2017年月日的星期'
--12、查询今天是星期几
select datepart(weekday,getdate()),datename(weekday,getdate());

select 'hello world', left('hello world',5)
Select datename(dw,getdate())
--获取系统的当前时间
select  getdate();
--dateadd日期加减处理
select  dateadd(dd,10,getdate()) 加10天,dateadd(mm,10,getdate()) 加10个月,dateadd(hour,1000,getdate()) 加1000个小时
select  dateadd(minute,888,getdate()) 加888分钟,dateadd(qq,-10,getdate()) 减10个季度
--datepart获取日期的一部分
select getdate(),datepart(year,getdate()),datepart(mm,getdate()),datepart(dd,getdate()),datepart(hh,getdate()),datepart(mi,getdate()),datepart(qq,getdate());
--datediff2个日期之间进行比较
select getdate() 系统时间,'2017-2-5' 日期,datediff(mm,'2017-2-5',getdate()) 相差的月份,datediff(dd,'2017-2-5',getdate()) 相差的日期
--显示当年年的1月1号,0代表1900年0时0分0秒
select dateadd(year,datediff(year,0,getdate()),0) 本年的1月1号;

--当前年份第二季度第一天是星期几
select  datepart(dw,dateadd(qq,1,dateadd(year,datediff(year,0,getdate()),0)));
select year(getdate()),month(getdate()),day(getdate());

----数学函数
select pi() 圆周率,power(3,3) 三的立方,sin(pi()/2) sin90度,log(10),log10(10);
--rand返回0~1之间的随机数
select rand()
--round求精度，保留小数点后3位，四舍五入原则
select round(pi(),3);
--ceiling返回大于该数的最小整数,floor返回小于该数的最大整数,sign信号函数
select ceiling(10.8),ceiling(-10.8),floor(10.33),sign(10),sign(0),sign(-11);
--degrees返回以弧度对应角的度数
select degrees(pi()/2) 返回弧度对应的角度,radians(60) 返回角度对应的弧度
--sqrt平方根
select sqrt(9) 平方根,square(8) 平方
--字符串函数的使用
--小写转换为大写，大写转换为小写
select UPPER('abcd') 小写转换为大写,LOWER('ABCD') 大写转换为小写
select ascii('A') 把字符转换为ascii,char('97') 把ascii码转换为字符
select 'administrator',left('administrator',5) 取前5个字符,right('administrator',5) 取后5个字符,substring('administrator',2,6) 从第二个字符开始取6个字符
select 'administrator',charindex('s','administrator',1) 返回字符在字符串中的索引,charindex('a','administrator',1),charindex('a','administrator',2)
select difference('a','aaaba');
select len('admin') 字符串长度,reverse('admin') 字符串反转,replace('   admin  ',' ','#') 把空格替换为#,replace('   admin  ',' ','') 把空格删除
select ltrim('   admin   ') 删除左边开头的空格,rtrim('   admin       ') 删除右边的空格,ltrim(rtrim('    admin    ')) 删除两头的空格


create table employee
(
	depart_time varchar(10),--部门
	work_no varchar(6),--工号
	salary int--工资
)
select * from employee;

insert into employee values('财务部',200001,2000);
insert into employee values('财务部',200002,2500);
insert into employee values('财务部',200004,2500);
insert into employee values('发展部',300002,2000);
insert into employee values('发展部',300009,1800);
insert into employee values('发展部',300014,2000);
insert into employee values('综合部',400001,1800);
insert into employee values('综合部',400005,2000);
insert into employee values('综合部',400009,2500);
insert into employee values('技术部',500008,2500);
insert into employee values('技术部',500099,1800);
insert into employee values('技术部',500102,2700);
--按工资从低到高进行排序
select  row_number() over(order by salary)as id,dense_rank()over(order by salary desc)as 工资排名1,rank() 
over(order by salary desc)as 工资排名2,*from employee;
--分部门按工资从低到高进行排序
select row_number() over(partition by depart_time order by salary)as 工资排名,*from employee;

create table money
(
	work_no varchar(6),--编号
	money_type varchar(10),--金钱类型
	num int --总数
)
select * from money;

insert into money values('100001','HKD',100);
insert into money values('100001','HKD',200);
insert into money values('100001','USD',300);
insert into money values('200020','HKD',50);
insert into money values('200020','RMB',5000);
insert into money values('200020','USD',500);

insert into money values('400078','HKD',80);
insert into money values('400078','HKD',90);
insert into money values('400078','RMB',800);
insert into money values('400078','RMB',900);
insert into money values('400078','USD',90);
insert into money values('400078','USD',800);

--统计每个员工不同币种的金额
--sql2000写法
select work_no,
sum(case when money_type='HKD' then num else 0 end)as '港币',
sum(case when money_type='USD' then num else 0 end)as '美元',
sum(case when money_type='RMB' then num else 0 end)as '人民币'
from money group by work_no;
--sql2005写法
select  work_no,[HKD]as 港币,[USD]as 美元,[RMB]as 人民币 from money pivot(sum(num)for money_type in([HKD],[USD],[RMB]))as pvt;
--索引(聚集索引，非聚集索引)
select * from sysindexes;

----创建索引
create table [dbo].[emp]
(
	[empid][int] identity(1,1) not null,
	[empName][varchar](10) null,
	[sex][varchar](2) null,
	[salary] decimal(18,2) null,
	[joindate][datetime] null
)
drop table emp;
select * from emp;
insert into emp select empname,sex,salary,joindate from emp ;
insert into emp values('曾志湖','男','10000',getdate());
insert into emp values('赖勇建','男','7400',getdate());
insert into emp values('伍群斌','男','7100',getdate());
insert into emp values('邱智才','男','6700',getdate());
insert into emp values('吴宗杰','男','7600',getdate());
insert into emp values('刘书华','男','8400',getdate());
insert into emp values('张磊','男','7800',getdate());
insert into emp values('陈飞龙','男','9500',getdate());
insert into emp values('小芳','女','5600',getdate());
insert into emp values('小露','女','9000',getdate());

--创建一个唯一聚集索引
create unique clustered index index_empid on Emp(empid)
--执行查询验证是否使用了索引
go
set showplan_text on
go 
select * from emp where salary>3000
go
set showplan_text off
go
--查看表的索引
sp_helpindex stud;
sp_helpindex score;
sp_helpindex emp;
--指定索引的参数
create unique clustered index index_empid on emp(empid) with pad_index,fillfactor=10,ignore_dup_key,drop_existing,statistics_norecompute on [primary]
--创建一个复合索引
create index index_id_name on emp(empid,empname) with pad_index,fillfactor=50 on [primary]
--执行索引，并验证是否使用了索引
go
set showplan_text on
go 
select * from emp where empid>10 and empName='曾志湖'
go
set showplan_text off
go
--删除索引
--主键不一定是聚集索引，但是聚集索引一定是主键
drop index emp.index_empid;
drop index index_id_name on emp;
create table grade
(
	gradeid int identity(1,1) primary key,--班级编号
	gradeName varchar(30) not null,--班级名称
	username varchar(20) not null,--用户名
	sex varchar(4) not null,--性别
	age int --年龄
)
select * into new from grade;
select * from grade;
drop table grade;
select * from grade;
sp_helpindex grade;


insert into grade values('宏图1601班','曾志湖','男',20);
insert into grade values('宏图1601班','赖勇建','男',20);
insert into grade values('宏图1601班','伍群斌','男',20);
insert into grade values('宏图1601班','邱智才','男',20);
insert into grade values('宏图1601班','陈飞龙','男',20);
insert into grade values('宏图1601班','刘书华','男',20);
insert into grade values('宏图1601班','吴宗杰','男',20);
insert into grade values('宏图1601班','谭芳芳','女',20);
insert into grade values('宏图1601班','张磊','男',20);
insert into grade values('宏图1601班','温宁宁','男',20);
insert into grade values('宏图1601班','张芳芃','男',20);
insert into grade values('宏图1601班','蒙航','男',20);
insert into grade values('宏图1601班','钟桑扬','男',20);
insert into grade values('宏图1601班','余鹏','男',20);
insert into grade values('宏图1601班','王日高','男',20);
insert into grade values('宏图1601班','李宏','男',20);
insert into grade values('宏图1601班','杨熙鹏','男',20);
insert into grade values('宏图1601班','谢山林','男',20);
insert into grade values('宏图1601班','赖林晖','男',20);
insert into grade values('宏图1601班','邓桂珍','女',20);
insert into grade values('宏图1601班','乐荣萍','女',20);
insert into grade values('宏图1601班','黄政','男',20);
insert into grade values('宏图1601班','谢学培','男',20);
insert into grade values('宏图1601班','陈桢','男',20);



insert into grade select gradeid,gradename,username,sex,age from grade;

declare @time datetime 
select @time=getdate()
select * from grade where gradename='曾志湖'
select getdate()-@time
--创建一个复合索引
create index index_gradename on grade(gradeid,gradename) with pad_index,fillfactor=50 on [primary]

sp_helpindex grade;
--创建一个唯一聚集索引
create  index index_gradename on grade(gradename)
drop index index_gradename on grade;
--创建一个复合索引
create index index_gradeid on grade(gradeid,gradename) with pad_index,fillfactor=50 on [primary]
--执行索引，并验证是否使用了索引
--清除系统日志
dump transaction test with no_log;
delete new

select * from score;
select top 3 * from score where studid  not in(select   top 3   studid  from score order by studid )
