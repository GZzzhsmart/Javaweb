---------------------------------课堂练习--------------------------------------------

--存储过程
--创建一个简单的存储过程
create proc chaxunacc
	@cardid varchar(20) 
as
    select * from account where cardid=@cardid
--执行存储过程
exec chaxunacc @cardid=100001
exec chaxunacc 4200

--删除存储过程
drop proc chaxunacc;

--创建一个简单的不带参数的存储过程
select * from stud;
create procedure up_findstud
as
	select * from stud
--执行存储过程的办法
execute up_findstud;
exec up_findstud;
up_findstud;

--带参数的存储过程
create proc up_findstudbyclassid
	--定义参数,多个参数之间用逗号分隔
	@classid int,
	@sex varchar(2)
as
	if @sex =''
	begin
		select * from stud where classid=@classid
	end
	else 
	begin
		select * from stud where classid=@classid  and sex=@sex
	end

up_findstudbyclassid 1,'男'
up_findstudbyclassid @classid=1,@sex='男'

--修改存储过程通过encryption关键字,对存储过程的源代码进行加密
alter proc up_findstudbyclassid
	@classid int,
	@sex varchar(2)
	with encryption
as
	if @sex=''
	begin
		select * from stud where classid=@classid 
	end
	else
	begin
		select * from stud where classid=@classid and sex=@sex
	end
--删除存储过程
drop proc up_findstudbyclassid

--存储过程返回游标
create proc getAllstud
	--游标变量，输出参数
	@myCursor cursor varying output
as
	set @myCursor=cursor forward_only static for select * from stud
	open @myCursor
go
--执行存储过程
declare @myCur cursor;
	exec getAllstud @myCursor=@myCur output
	fetch next from @myCur
	while @@fetch_status=0
	begin
		fetch next from @myCur
	end	
	close @myCur
	deallocate @myCur

create proc getAllStud1
as
	declare  myCursor cursor forward_only static for select * from stud
	open myCursor
	fetch next from myCursor 
	while @@fetch_status=0
	begin
		fetch next from myCursor 
	end
	close myCursor
	deallocate myCursor
go

getAllStud1

--错误处理
select * from sys.messages where message_id=208;

raiserror('where there is will,there is way',16,1);

--添加错误信息到messages表中
/*
	sp_addmessage存储过程添加错误信息
	1.添加错误消息的id必须从50001开始；
	2.添加错误信息时必须先添加英文版的错误信息，再添加中文版的错误信息；
	3.在程序中需要报错的地方用raiserror函数调用该id报错
*/
use master
EXEC sp_addmessage 50001, 16, 
   N'Percentage expects a value between 20 and 100. 
   Please reexecute with a more appropriate value.','us_english'

EXEC sp_addmessage 50001, 16, 
   N'Percentage expects a value between 20 and 100. 
   请确保百分比在20到100之间',null,false,'replace'

select * from sys.messages where message_id=50001;
--调用raiserror函数报错
raiserror(50001,16,1);



-------------------------------课内练习--------------------------------------------------------------


--这个存储过程的作用，如果存在相同用户名的记录，就打印已存在，否则执行插入操作
create proc weihuacc
	@cardid varchar(20),
	@money float
as
    declare @count int
	set @count=0
	select @count=count(*) from account where money=@money
	if @count>=0
		print '已存在相同的用户'
	else
		insert into account values(@cardid,@money)
go
--执行存储过程
exec weihuacc @cardid=100003,@money=6000

--删除存储过程
drop proc weihuacc

--编写一个存储过程，计算某个月有多少天
create proc monthdays
	@month int,
	@days int output
as
	if @month%2=1
	begin
		set @days=31
		print '这个月有31天'
	end
	else if @month=2
	begin
		set @days=28
		print '这个月有28天'
	end
	else 
	begin
		set @days=30
		print '这个月有30天'
	end
go
declare @days int
exec monthdays 2,@days output
--删除存储过程
drop proc monthdays


--编写存储过程，判断是否为闰年
CREATE PROC MONTHDAYS 
	@YEAR INT OUTPUT,@MONTH INT OUTPUT,@DAYS INT OUTPUT
AS
	--闰年年份
	IF(@YEAR%4=0 OR @YEAR%400=0)
	BEGIN
		IF @MONTH%2=1
			SET @DAYS=31
		ELSE IF @MONTH=2
			SET @DAYS=29
		ELSE
			SET @DAYS=30
		PRINT CONVERT(VARCHAR(10),@YEAR)+'年是闰年,所以'+CONVERT(VARCHAR(10),@MONTH)+'月有'+CONVERT(VARCHAR(10),@DAYS)+'天'
	END 
	--平年年份
	ELSE
		BEGIN
			IF @MONTH%2=1
				SET @DAYS=31
			ELSE IF @MONTH=2
				SET @DAYS=28
			ELSE
				SET @DAYS=30
			PRINT CONVERT(VARCHAR(10),@YEAR)+'年不是闰年,所以'+CONVERT(VARCHAR(10),@MONTH)+'月只有'+CONVERT(VARCHAR(10),@DAYS)+'天'
		END 
GO
DECLARE @YEAR INT ,@DAYS INT,@MONTH INT
EXEC MONTHDAYS 2017,2,@DAYS OUTPUT
DROP PROC MONTHDAYS--删除存储过程


--判断1900到现在有多少个闰年
DECLARE @YEARSUM INT ,@YEAR VARCHAR(20),@I INT,@STR VARCHAR(1000)
	SET @YEARSUM=1900
	SET @I=0
	SET @STR=''
	WHILE @YEARSUM<(SELECT DATEPART(YY,GETDATE()))
	BEGIN
		IF(@YEARSUM%4=0 OR @YEARSUM%400=0)
			BEGIN
				SET @I=@I+1
				SET @STR=@STR+SPACE(4)+CONVERT(VARCHAR(10),@YEARSUM)
				IF(@I%10=0)
				BEGIN
					PRINT @STR
					SET @STR=''
				END
			END
			SET @YEARSUM=@YEARSUM+1
	END
			PRINT '1900年到现在共有'+CONVERT(VARCHAR(10),@I)+'个闰年'
			

--查询任何一年的任何一个月的天数
create function sumday(@year int,@month int)
returns int
as
begin
	declare @day int
	set @day=(datepart(dd,dateadd(dd,-1,dateadd(mm,@month,dateadd(yy,(@year-1900),0)))))
	return @day
end
--下面是调用示例：
select dbo.sumday(2017,3) '该月有'

--删除标量值函数
drop function sumday



-----------------------------------上机文档作业----------------------------------------------

create table employ
(
	empid int identity(1,1) primary key not null,
	empname varchar(20) not null,
	sex varchar(4) not null,
	salary decimal(18,2) not null,
	joindate datetime
)

insert into employ values('John','男',4000,getdate());
insert into employ values('Tom','男',1800,getdate());
insert into employ values('John','女',2400,getdate());
insert into employ values('Petter','男',2200,getdate());
insert into employ values('Carter','女',2100,getdate());
insert into employ values('John','男',2500,getdate());
select * from employ;
---编写一个给所有员工加薪10%的过程，这之后，如果已经雇佣该雇员超过60个月，则给他额外加薪2000
create proc SalaryAdd
as
	update employ set salary=salary*(1+0.1)

	declare @empid int, @joindate datetime
	declare @cur cursor
	set @cur=cursor forward_only static for
		select empid, joindate from employ
	open @cur
	declare @i int
	set @i=0
	while @i<@@cursor_rows
	begin
		fetch next from @cur into @empid, @joindate
		if datediff(month, @joindate, getdate())>60
			update employ set salary=(salary+2000) where empid=@empid
		set @i=@i+1
	end
	close @cur
go

exec SalaryAdd
--删除存储过程
drop proc salaryadd;



----写一个自动编号的存储过程，如:200408010001

create table orderss(orderid varchar(12) primary key)

select * from orderss;



create procedure up_orderid2
as
	declare @str varchar(12)
	declare @cnt int
	select @str=convert(varchar(8),getdate(),112);
	select @cnt = count(*)+1 from orderss where orderid like @str+'%'
	if @cnt<10
	begin
		set @str = @str + '000'+ convert(varchar(1),@cnt)
	end
	else if @cnt<100 and @cnt>=10
	begin
		set @str = @str + '00'+ convert(varchar(2),@cnt)
	end
	else if @cnt<1000 and @cnt>=100
	begin
		set @str = @str + '0'+ convert(varchar(3),@cnt)
	end
	else
	begin
		set @str = @str + convert(varchar(4),@cnt)
	end
	insert into orderss values(@str);
	select @str
go
up_orderid2
select * from orderss;
select replicate('1',4);


alter proc up_orderid2
	@str varchar(12) output
as
	declare @cnt int
	select @str=convert(varchar(8),getdate(),112);
	select @cnt = count(*)+1 from orderss where orderid like @str+'%'
	if @cnt<10
	begin
		set @str = @str + '000'+ convert(varchar(1),@cnt)
	end
	else if @cnt<100 and @cnt>=10
	begin
		set @str = @str + '00'+ convert(varchar(2),@cnt)
	end
	else if @cnt<1000 and @cnt>=100
	begin
		set @str = @str + '0'+ convert(varchar(3),@cnt)
	end
	else
	begin
		set @str = @str + convert(varchar(4),@cnt)
	end
	insert into orderss values(@str);
go

declare @orderid varchar(12)
exec up_orderid2 @orderid output
select @orderid
select * from orderss;





--创建带有默认值的存储过程
select * from account;

create proc WeiHuAcc2
	@usr varchar(20),
	@pwd varchar(4),
	@balance decimal(18, 2)=1500
as
	declare @count int
	set @count=0
	select @count=count(*) from account where username=@usr
	if @count>=1
		print '已存在相同的用户'
	else
		insert into account values(@usr, @pwd, @balance)
go

exec WeiHuAcc2 @usr='王五', @pwd='1234'

--通过用户名查找密码的存储过程
create procedure FindAccPwd
	@usr varchar(20),
	@pwd varchar(4) output
as
	select @pwd=password from account where username=@usr
go
drop procedure FindAccPwd
--执行带有返回参数的存储过程
declare @pwd varchar(4)
exec FindAccPwd '李四', @pwd output
print @pwd
 

--创建一个返回游标的存储过程
create procedure FindAllAcc
	@cur cursor varying output
as
	set @cur=cursor forward_only static for select * from account
	open @cur
go

--执行返回游标的存储过程
declare @mycur cursor
	exec FindAllAcc @cur=@mycur output
	declare @i int
	set @i=0
	while @i<@@cursor_rows
	begin
		declare @usr varchar(20),@pwd varchar(4),@balance decimal(18,2)
		fetch next from @mycur into @usr,@pwd,@balance
		print '用户名：'+@usr+'密码：'+@pwd+'余额：'+convert(varchar(12),@balance)
		set @i=@i+1
	end
close @mycur
deallocate @mycur

--重新编译存储过程
exec sp_recompile FindAllAcc


--修改存储过程
alter procedure FindAllAcc
	@cur cursor varying output
as
	set @cur=cursor forward_only static for select * from account
	open @cur
go

--删除存储过程
drop procedure FindAllAcc



--编写一个过程，往Emp表插入员工，如果存在同名的员工，则修改
use 练习
go
CREATE TABLE [dbo].[Emp](
	[empid] [int] IDENTITY(1,1) NOT NULL,
	[empName] [varchar](10) NULL,
	[sex] [char](10) NULL,
	[salary] [decimal](18, 2) NULL,
	[joindate] [datetime] NULL
) ON [PRIMARY]

select * from emp;

insert into emp values('张三','男',3500,getdate());
insert into emp values('李四','男',4600,getdate());
insert into emp values('小露','女',4000,getdate());

create procedure up_emp
	@ename varchar(20),
	@sex char(1),
	@sal decimal(18,2),
	@jdate datetime
as
	insert into emp values(@ename,@sex,@sal,@jdate)
go


--调用存储过程
execute up_emp 
execute up_emp 'zhang','F',1200,'2007-10-10'

--修改存储过程

drop procedure up_emp
GO
create procedure up_emp 
	@name nvarchar(20),
	@sex char(1),
	@sal decimal(18,2),
	@jdate datetime,
	@outname varchar(20) output
as 
select @outname =empname from Emp where empname =@name

if @outname is not NULL 
	print '该用户已经存在'
else
	insert into emp values(@name,@sex,@sal,@jdate)
select * from emp;

--调用存储过程
declare @name varchar(20)
execute up_emp 'dd','F',1200,'2007-10-10',@name output
print @name






/*
	已知表数据：
	姓名  金额   日期 

	张三  100   1998/4/8 
	张三  10    1998/7/4 
	里斯  20.5  1999/8/9 
	张三  10    1999/8/7 
	王五  30.5  1998/1/1 
	刘二  22.5  2000/8/4 
	里斯  30    2001/8/9 
	赵毅  2     2002/8/4 
	王五  14    2000/2/21 
	张三  52    1999/12/9 
	王八  33    2005/8/9 
	刘二  20    2007/8/9
	张三  100	2007/10/21

*/

CREATE TABLE MONEYS(
	EMPID INT IDENTITY(1,1) PRIMARY KEY,
	EMPNAME VARCHAR(20) NOT NULL,
	SALARY INT NOT NULL,
	EMPTIME VARCHAR(30) NOT NULL
)
DROP TABLE MONEYS
SELECT * FROM MONEYS
INSERT INTO MONEYS VALUES('张三',100,'1998/7/4')
INSERT INTO MONEYS VALUES('里斯',205,'1999/8/9')
INSERT INTO MONEYS VALUES('张三',100,'1999/8/7')
INSERT INTO MONEYS VALUES('王五',305,'1998/1/1')
INSERT INTO MONEYS VALUES('刘二',225,'2000/8/4')
INSERT INTO MONEYS VALUES('里斯',300,'2001/8/9')
INSERT INTO MONEYS VALUES('赵毅',200,'2002/8/4')
INSERT INTO MONEYS VALUES('王五',170,'2000/2/21')
INSERT INTO MONEYS VALUES('张三',500,'1999/12/9')
INSERT INTO MONEYS VALUES('王八',360,'2005/8/9')
INSERT INTO MONEYS VALUES('刘二',200,'2007/8/9')
INSERT INTO MONEYS VALUES('张三',150,'2007/10/21')
/*
	编写存储过程，统计所有人每一年的总金额，如：
	姓名	1998年总金额	1999年总金额	。。。	2007年总金额
	张三	10				62						100
	里斯	。。。。。。
	。。。。。(所有员工信息)

*/
SELECT * FROM MONEYS WHERE EMPNAME='张三'
SELECT DISTINCT(EMPNAME) FROM MONEYS
--使用存储过程
CREATE PROC UP_EMP 
AS 
	DECLARE @CURSOR_EMP CURSOR,@EMPNAME VARCHAR(30),@YEAR INT,@SUM VARCHAR(1000),@SUM1 VARCHAR(1000),@MAXYEAR INT,@MINYEAR INT,@I INT,@STRING VARCHAR(1000),@NUM INT
		SET @CURSOR_EMP=CURSOR FOR SELECT DISTINCT(EMPNAME) FROM MONEYS
		SET @YEAR=(SELECT LEFT(MIN(EMPTIME),4) FROM MONEYS)
		SET @SUM=''
		SET @SUM1=''
		SET @I=0
		SET @STRING='姓名'+SPACE(6)
		SET @MAXYEAR=(SELECT LEFT(MAX(EMPTIME),4) FROM MONEYS)
		SET @MINYEAR=(SELECT LEFT(MIN(EMPTIME),4) FROM MONEYS)
		OPEN @CURSOR_EMP
		FETCH NEXT FROM @CURSOR_EMP INTO @EMPNAME
		WHILE @I<=(@MAXYEAR-@MINYEAR)
		BEGIN
			SET @STRING=@STRING+CONVERT(VARCHAR(10),(@MINYEAR+@I))+'总额'+SPACE(6)
			SET @I=@I+1
		END
		PRINT @STRING
		WHILE @@FETCH_STATUS=0
		BEGIN
			SET @YEAR=@MINYEAR
			WHILE @YEAR<=@MAXYEAR
			BEGIN
				SET @SUM1=@SUM1+SPACE(11)+CONVERT(VARCHAR(30),ISNULL(CONVERT(VARCHAR(30),(SELECT SUM(SALARY) FROM MONEYS WHERE EMPNAME=@EMPNAME AND (SUBSTRING(EMPTIME,1,4)=@YEAR))),0.0))
				SET @YEAR=@YEAR+1
			END
			SET @SUM=''
			SET @SUM=@EMPNAME
			PRINT ''
			PRINT @SUM+@SUM1
			SET @SUM1=''
			FETCH NEXT FROM @CURSOR_EMP INTO @EMPNAME 
		END
--查询存储过程
EXEC UP_EMP
--删除存储过程
DROP PROC UP_EMP



















