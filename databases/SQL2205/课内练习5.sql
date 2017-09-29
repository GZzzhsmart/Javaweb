----使用游标的基本步骤

--创建游标
select * from stud;
declare stud_cursor cursor dynamic for select studid,studname,sex,cardid,classid,age from stud;
--打开游标
open stud_cursor;
--从游标中抓取数据
fetch next from stud_cursor;
--关闭游标
close stud_cursor;
--删除游标
deallocate stud_cursor;

--使用游标
begin 
	declare @studid int,@studname varchar(20),@sex varchar(4),@cardid varchar(18),@classid int,@age int
	declare stud_cursor cursor dynamic for select studid,studname,sex,cardid,classid,age from stud;
	--打开游标
	open stud_cursor;
	
	fetch next from stud_cursor into @studid,@studname,@sex,@cardid,@classid,@age;
	print 'studid:'+ltrim(str(@studid))+' studname:'+@studname+'sex:'+@sex+'cardid:'+@cardid+'classid:'+ltrim(str(@classid))+'age:'+ltrim(str(@age));
	while @@fetch_status=0
		begin
			fetch next from stud_cursor into @studid,@studname,@sex,@cardid,@classid,@age;
			print 'studid:'+ltrim(str(@studid))+' studname:'+@studname+'sex:'+@sex+'cardid:'+@cardid+'classid:'+ltrim(str(@classid))+'age:'+ltrim(str(@age));
		end
	--关闭游标
	close stud_cursor;
	--删除游标
	deallocate stud_cursor;
end


--只进游标
declare stud_cursor cursor for select * from stud--只进游标，只能用fetch next进行操作
open stud_cursor--打开游标
fetch next from stud_cursor 
while @@fetch_status=0
begin 
	fetch next from stud_cursor
end
close stud_cursor

--静态游标
select * from stud;

declare stud_cursor cursor static for select * from stud--静态游标
open stud_cursor
fetch last from stud_cursor--读取最后一条
insert into stud values('1007','小美','女','362426198901160013',1,28)--新增一条记录
fetch last from stud_cursor--无法获取新增的这条记录
close stud_cursor;

--动态游标

declare stud_cursor cursor dynamic for select * from stud--动态游标
open stud_cursor
	fetch last from stud_cursor--获取最后一条记录
		insert into stud values('1007','小美','女','362426198901160013',1,28)
	fetch last from stud_cursor--可以获取新增加的这条记录
close stud_cursor;

--键集游标
select * from stud;

declare stud_cursor cursor keyset for select * from stud
open stud_cursor
fetch last from stud_cursor
	insert into stud values('1007','小美','女','362426198901160013',1,28)
fetch last from stud_cursor--无法获取新增加的这条记录
fetch absolute 2 from stud_cursor
update stud set sex='男' where current of stud_cursor
fetch absolute 2 from stud_cursor--可以反映更新的这条记录
close stud_cursor;




--创建一个工资表,插入十条记录，然后利用游标来修改工资的值
--工资低于2000的，增加800
--工资在2000—3000的，增加500
--工资在3000—4000的，增加200
--工资高于4000的，减少100
create table pay
(
	userid int identity(1,1) primary key,
	username varchar(20) not null,
	pay int not null
)

select * from pay;

insert into pay values('曾志湖',10000);
insert into pay values('赖勇建',7000);
insert into pay values('伍群斌',6500);
insert into pay values('邱智才',6000);
insert into pay values('谭芳芳',6400);
insert into pay values('陈飞龙',9500);
insert into pay values('张磊',7000);
insert into pay values('吴宗杰',8500);
insert into pay values('刘书华',8100);
insert into pay values('陈露',9800);


--创建游标
declare pay_cursor cursor dynamic for select userid,username,pay from pay;
--打开游标
open pay_cursor;
--从游标中抓取数据
fetch next from pay_cursor;
--关闭游标
close pay_cursor;
--删除游标
deallocate pay_cursor;





select *from pay;
--修改工资
declare pay_cursor Cursor for select userid,pay from pay 
declare @userid int,@pay int
open pay_cursor --打开游标
fetch next from pay_cursor into @userid,@pay
while @@fetch_status=0
begin
	if(@pay<2000)
	begin
		update pay set pay=(select pay from pay where userid=@userid)+800 where  current of pay_cursor
	end
	else if(@pay<3000 and @pay>2000)
	begin
		update pay set pay=(select pay from pay where userid=@userid)+500 where  current of pay_cursor
	end
	else if(@pay<4000 and @pay>3000)
	begin
		update pay set pay=(select pay from pay where userid=@userid)+200 where  current of pay_cursor
	end
	else if(@pay>4000)
	begin
		update pay set pay=(select pay from pay where userid=@userid)-100 where  current of pay_cursor
	end
	fetch next from pay_cursor into @userid,@pay
end
close pay_cursor--关闭游标
--删除游标
deallocate pay_cursor





--使用游标查询grade表
select * from grade;

begin
	declare @gradeid int,@gradeName varchar(30),@username varchar(20),@sex varchar(4),@age int
	declare grade_cursor cursor dynamic for select gradeid,gradeName,username,sex,age from grade;
	open grade_cursor
	fetch next from grade_cursor into @gradeid,@gradeName,@username,@sex,@age;
	
	print 'gradeid:'+ltrim(str(@gradeid))+'gradeName:'+@gradeName+'username:'+@username+'sex:'+@sex+'age:'+ltrim(str(@age));
	while @@fetch_status=0
		begin
			fetch next from grade_cursor into @gradeid,@gradeName,@username,@sex,@age;
			print 'gradeid:'+ltrim(str(@gradeid))+'gradeName:'+@gradeName+'username:'+@username+'sex:'+@sex+'age:'+ltrim(str(@age));
		end
	close grade_cursor;
	deallocate grade_cursor;
end

--操作class表
select * from class;

begin
	declare class_cursor cursor for select classno,classname from class
	declare @classno int,@classname varchar(20)
	open class_cursor
	fetch next from class_cursor into @classno,@classname
	print 'classno:'+ltrim(str(@classno))+'classname:'+@classname
	while @@fetch_status=0
		begin
			fetch next from class_cursor into @classno,@classname
			print 'classno:'+ltrim(str(@classno))+'classname:'+@classname
		end
		close class_cursor
		deallocate class_cursor
end

--使用游标操作emp表
select * from emp;
begin
	declare emp_cursor cursor for select empid,empname,sex,salary from emp;
	declare @empid int,@empname varchar(10),@sex varchar(4),@salary int;
	open emp_cursor;
	fetch next from emp_cursor into @empid,@empname,@sex,@salary;
	print 'empid:'+ltrim(str(@empid))+'empname:'+@empname+'sex:'+@sex+'salary:'+ltrim(str(@salary))
	while @@fetch_status=0
		begin
			fetch next from emp_cursor into @empid,@empname,@sex,@salary
			print 'empid:'+ltrim(str(@empid))+'empname:'+@empname+'sex:'+@sex+'salary:'+ltrim(str(@salary))
		end
		close emp_cursor;
		deallocate emp_cursor;
end;

select * from pay;
--使用游标操作pay表
begin
	declare @userid int,@username varchar(20),@pay int;
	declare pay_cursor cursor dynamic for select userid,username,pay from pay;
	open pay_cursor;
	fetch next from pay_cursor into @userid,@username,@pay;

	print 'userid:'+ltrim(str(@userid))+'username:'+@username+'pay:'+ltrim(str(@pay));
	while @@fetch_status=0
		begin
			fetch next from pay_cursor into @userid,@username,@pay;
			print 'userid:'+ltrim(str(@userid))+'username:'+@username+'pay:'+ltrim(str(@pay));
		end
		close pay_cursor;
		deallocate pay_cursor;
end;

select * from score;

select avg(scores) from score;

select @@rowcount
select * from employee;
--修改各部门的工资,工资低于2000的，增加800,工资在2000—3000的，增加500
--创建游标
declare employee_cursor cursor for select work_no,salary from employee
declare @work_no varchar(6),@salary int;
--打开游标
open employee_cursor;
fetch next from employee_cursor into @work_no,@salary;
while @@fetch_status=0
begin
	if(@salary<2000)
	begin
		update employee set salary=(select salary from employee where @work_no=work_no)+800 where current of employee_cursor
	end
	else if(@salary>2000 and @salary<3000)
	begin
		update employee set salary=(select salary from employee where @work_no=work_no)+500 where current of employee_cursor
	end
	fetch next from employee_cursor into @work_no,@salary
end
--关闭游标
close employee_cursor;
--删除游标
deallocate employee_cursor;




--修改学生表的年龄
select * from stud;
declare stud_cursor cursor for select studid,studname,sex,cardid,classid,age from stud;
declare @studid int,@studname varchar(20),@sex varchar(4),@cardid varchar(18),@classid int,@age int;
open stud_cursor;
fetch next from stud_cursor into @studid,@studname,@sex,@cardid,@classid,@age;
while @@fetch_status=0
begin
	if @age=20
	begin
		update stud set age=21 where current of stud_cursor
	end
	else if(@age=28)
	begin
		update stud set age=25 where current of stud_cursor
	end
	fetch next from stud_cursor into @studid,@studname,@sex,@cardid,@classid,@age;
end
close stud_cursor;
deallocate stud_cursor;


select * from emp;
create table emp
(
	empid int identity(1,1) primary key,
	empName varchar(10) not null,
	sex varchar(4) not null,
	salary int not null
)

insert into emp values('John','M',100);
insert into emp values('Tom','M',55);
insert into emp values('Eff','F',200);
--循环将所有员工的工资涨10%，直到最高工资是最低工资的两倍为止

declare @max int,@min int,@sum int
	set @max=(select max(salary) from emp);
	set @min=(select min(salary) from emp);
	while @min<@max
	begin
		if(@max=(@min*2))
		begin
			print '循环终止最高工资为：'+convert(varchar(30),@max)+'最低工资为：'+convert(varchar(30),@min)
			break;
		end
		else if(@max!=(@min*2))
		begin
			update emp set salary=(select salary from emp where empid=1)*(1.1) where empid=1;
			update emp set salary=(select salary from emp where empid=2)*(1.1) where empid=2;
			update emp set salary=(select salary from emp where empid=3)*(1.1) where empid=3;
		end
		set @max=(select max(salary) from emp);
		set @min=(select min(salary) from emp);
		print @max;
		print @min;
		print @sum;
	end


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
select datename(dw,0) '1900年月日的星期'
select convert(varchar(30),getdate(),103)
--11、2017年6月1日星期几
select datename(dw,dateadd(mm,datediff(mm,0,getdate())+3,0)) '2017年月日的星期'
--12、查询今天是星期几
select datepart(weekday,getdate()),datename(weekday,getdate());
--13、判断今年是否为闰年
select  case  day(dateadd(mm,  2,  dateadd(ms,-3,dateadd(yy,  datediff(yy,0,getdate()),  0))))  when  28  then  '平年'  else  '闰年'  end  '是否为闰年'


declare @year int,@day int
	set @year=(select datename(yy,getdate())-1)--这里可以加减操作，现在是在减号后面改变参数值就可以
	set @day=(select datediff(dd,dateadd(mm,1,dateadd(yy,(@year-1900),0)),dateadd(mm,2,dateadd(yy,(@year-1900),0))))
	while 1<2--死循环
		begin
			if(@year%4=0 or @year%400=0)
				begin
					print convert(varchar(10),@year)+'的2月有'+convert(varchar(10),@day)+'天，所以'+convert(varchar(10),@year)+'年是闰年';
					break;
				end
			else
				begin
					print convert(varchar(10),@year)+'的2月有'+convert(varchar(10),@day)+'天，所以'+convert(varchar(10),@year)+'年不是闰年';
					break;
				end
		end
