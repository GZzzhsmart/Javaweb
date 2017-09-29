create table 成绩表
(
	oid int identity(1,1) primary key,
	name varchar(20) not null,
	kecheng varchar(20) not null,
	fenshu int 
)
create table 补考成绩表
(
	oid int identity(1,1) primary key,
	name varchar(20) not null,
	kecheng varchar(20) not null,
	fenshu int 
)
truncate table 成绩表;

insert into  成绩表 values('张三','语文',81);
insert into  成绩表 values('张三','数学',59);
insert into  成绩表 values('李四','语文',99);
insert into  成绩表 values('李四','数学',90);
insert into  成绩表 values('王五','语文',56);
insert into  成绩表 values('王五','数学',30);
insert into  成绩表 values('王五','英语',90);


insert into  补考成绩表 values('张三','数学',80);
insert into  补考成绩表 values('王五','语文',88);
insert into  补考成绩表 values('王五','数学',90);

select * from 成绩表

select * from 补考成绩表
--1、	查询成绩表中第4到第6的记录
select top 3 * from 成绩表 where oid not in(select top 3 oid from 成绩表);


--2、	查询成绩表，如果成绩在0-60分之间，显示‘较差’，成绩在60-80分之间，显示‘良好’，成绩在80-100分之间，显示‘优秀’

select oid,name,kecheng,
case fenshu 
	when 90 then '优秀' 
	when 88 then '较差' 
	when 80 then '较差' 
end 
from 补考成绩表


select oid,name,kecheng,
case when fenshu<60  then '较差' 
	 when fenshu>=60 and fenshu<80 then '良好' 
	 when fenshu between 80 and 100 then '优秀' end fenshu
from 成绩表
--4、	假如经常根据课程名称和分数查询，现在发现查询速度很慢，请问应该怎么解决这个问题？请写出实现代码
create index idx_kecheng on 成绩表(kecheng,fenshu);
--5、	统计成绩表的平均分数，如果平均成绩大于80分，那么下调分数，直到平均分数小于80分为止。
while (select avg(fenshu) from 成绩表)>=80
begin
	update 成绩表 set fenshu=fenshu-1
end

while (select avg(fenshu) from 补考成绩表)>80
begin
	update 补考成绩表 set fenshu=fenshu-1
	print 'update'
end

select * from 补考成绩表;
--6、	现在有两个表：一个成绩表，一个补考成绩表，如何把补考成绩更新到成绩表中？
insert into 成绩表 select name,kecheng,fenshu from 补考成绩表

delete 成绩表 where oid>7;

select * from 成绩表
update 成绩表  set fenshu=(select fenshu from 补考成绩表 where kecheng=成绩表.kecheng and name=成绩表.name ) 
where exists (select fenshu from 补考成绩表 where kecheng=成绩表.kecheng and name=成绩表.name)


--7、	查询出上个月的最后一天？
select dateadd(ms,-3,dateadd(mm,datediff(mm,0,getdate()),0));
--8、	查询出今天是星期几？
select datepart(dw,getdate());
select datename(dw,getdate());
--9、	有字符串“hello world！”，请写T-SQL语句，将hello截出，并打印出来。（10分）
select substring('hello world!',1,5);

declare @str varchar(20);
set @str = 'hello world!';
set @str = substring('hello world!',1,5);
print @str





