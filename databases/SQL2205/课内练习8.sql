--------------------------------课堂练习--------------------------------------------------------

--创建DDL触发器
create trigger DDLTrigger
	on database
for
	drop_table,alter_table,create_table
as
	print '不能再test中删除，修改，新增任何表'
	rollback transaction
go

--删除DDL触发器
drop trigger DDLTrigger on database


--创建一个DML Insert 触发器
create trigger InsertTrigger
	on account
for
	insert
as
	if(select balance from inserted)<0
	begin
		print '操作失败'
		rollback transaction
	end
go

--删除DWL触发器
drop trigger InsertTrigger


select * from stud;
select * from course;
select * from inserted;

--选课表
select * from selectCourse

create table selectCourse
(
	selectCourseId int identity(1,1) primary key,
	studid int not null,
	courseid int not null
)

--在学生表中创建触发器,往学生表中新增记录时会触发

create trigger studAdd on stud for insert
as
	declare @studid int,@courseid int;
	--从inserted表中获取新增的学生编号
	select @studid=studid from inserted;
	declare cur cursor for select courseid from course;
	open cur;
	fetch next from cur into @courseid;
	while @@fetch_status=0
	begin
		insert into selectCourse values(@studid,@courseid);
		fetch next from cur into @courseid;
	end
	close cur;
	deallocate cur;
go

select * from stud;
select * from selectCourse;
insert into stud values(1007,'小美','女','362426199801170013',1,23);


--删除学生资料的触发器，当执行删除学生表记录时，选课表中该学生的选课记录全部删除

create trigger studDel on stud for delete
as
	declare @studid int
	select @studid=studid from deleted
	if @studid=1007
	begin
		rollback transaction
		print '不能删除学号为1007的学生的信息'
	end
	else
	begin
		delete selectCourse where @studid=studid
	end
go

select * from stud;
select * from selectCourse;
delete selectCourse where studid=1008;
insert into stud values(1008,'老王','男','362426197801170013',1,40);


--修改学生资料时，不允许修改身份证号码
--update函数判断指定的字段的值是否被修改，如果被修改返回真，否则返回假

create trigger studUpdate on stud with encryption for update
as
	--update函数只能在触发器中使用
	if update(cardid)
	begin
		rollback transaction
		print '学生的身份证信息不允许修改'
	end
	else
	begin
		print '修改学生资料信息成功'	
	end
go

select * from stud;

update stud set age=22 where studid=1001;
update stud set cardid=362426199801160013 where studid=1001;

--触发器尽量少用，以免出现死循环
--删除触发器
drop trigger studUpdate;

select * from sys.triggers;
select * from sys.trigger_events;

--启用(enable)或者禁用触发器(disable)
disable trigger all on stud;
enable trigger all on stud;
disable trigger studAdd on stud;



-----------------------上机文档练习---------------------------------------

select * from salarymoney;

insert into salarymoney values('王五',800);
insert into salarymoney values('老张',500);

--使用触发器
create trigger salary on salarymoney
	for insert
as
	if(select salary from inserted)<1000
	begin
		print '工资不能低于1000'
		rollback transaction --回滚，撤销插入操作
	end
	else
		print '插入成功'
	
drop trigger salary
insert into salarymoney values('小美',1000);


--修改触发器
alter trigger salary on salarymoney
	for insert,update
as
	if(select salary from inserted)<1000 
	begin
		print '工资不能低于1000'
		rollback transaction
	end
	else if(select salary from inserted)>10000
	begin
		print '工资不能高于10000'
		rollback transaction
	end
	else
		print '插入成功'

select * from salarymoney;
insert into salarymoney values('老李',800);

--创建员工表
create table yuangong
(
	deptid int,
	name varchar(20)
)
select * from yuangong;

insert into yuangong values(1,'张三');
insert into yuangong values(2,'李四');
insert into yuangong values(3,'王麻子');

create trigger deletedept on yuangong
for
	delete 
as
	declare @deptid int
	set @deptid=(select deptid from deleted)
	if(select count(*) from yuangong where deptid=@deptid)>0
	begin
		print '该部门下还有员工'
		rollback transaction
	end
go

drop trigger deletedept
delete from yuangong where deptid=2


select * from account;

--在存储过程中抛出是捕获异常

create proc InsertAccount
	@usr varchar(20),
	@pwd varchar(6),
	@balance decimal(12, 2)
as
	begin try
		if @balance<0
			raiserror('账户金额不能是负数', 16,  1)
		else
			insert into account values(@usr, @pwd, @balance)
	end try
	begin catch
		declare @errMessage varchar(200)
		declare @errSeverity int
		declare @errState int

		select @errMessage=error_message(), @errSeverity=error_severity(), @errState=error_state()
			
		print '抛出异常信息：'+@errMessage
	end catch
go

--删除存储过程
drop procedure InsertAccount;
--执行存储过程
exec InsertAccount '赵六', '1234',1200

select * from classes;
select * from stud;
alter table classes add studCnt int;

--1.触发器实现有学生的班级不能删除
create trigger delclass on classes for delete
as
	if (select count(*) from stud where classid=(select classid from deleted))>0
	begin
		print '该班有学生，不能删除'
		rollback transaction
	end
	else
		print '删除成功'
go

drop trigger delClass;

delete classes where classid=4;

--2.触发器实现当插入、删除学生时修改班级表中对应班级的人数
create trigger studAdd on stud for insert,delete
as
	declare @classid int
	set @classid=0
	select @classid=classid from inserted
	if @classid>0
	begin
		declare cur cursor for select classid from inserted
		open cur
		fetch next from cur into @classid
		while @@fetch_status=0
		begin
			update classes set studcnt=studcnt+1 where classid=@classid
			fetch next from cur into @classid
		end	
		close cur
		deallocate cur
	end
	if @classid<=0
	begin
		declare cur cursor for select classid from deleted
		open cur
		fetch next from cur into @classid
		while @@fetch_status=0
		begin
			update classes set studcnt=studcnt-1 where classid=@classid
			fetch next from cur into @classid
		end
		close cur
		deallocate cur
	end
go

select * from classes;
select *  from stud order by classid;
select * from stud2;
insert into stud2 values(1003,'小丽','女','123456789123456791',2,18);
insert into stud2 values(1004,'黄蓉','女','123456789123456792',3,18);

insert into stud select * from stud2;


delete stud2 where sex='男'

drop trigger studAdd

------------------------------上机文档课堂练习---------------------------------


--1.创建insert触发器,如果员工名重复，则不能插入
select * from employ;

--方法一
create trigger tg_insertemp on employ for insert
as
	declare @empname varchar(20)
	select @empname=empname from inserted
	if (select count(*) from employ where empname=@empname)!=1
	begin
		print '该昵称已存在！'
		rollback transaction
	end
	else
	begin
		print '插入成功！'
	end

--方法二
select * from employ;

create trigger empAdd on employ for insert
as
	if (select count(*) from employ where empname in(select empname from inserted))>1
	begin
		print '员工姓名不能相同，新增失败'
		rollback transaction
	end
go


drop trigger empAdd 
insert into employ values('Smith','男',1000,getdate(),'在职')
delete employ
update employ set joindate='2010-01-1'


--2.创建update触发器,如果员工入职超过30个月，工资不能低于2000
select * from employ;
--第一种方法
create trigger tg_updatemoney on employ for update 
as 
	declare @time varchar(20),@name varchar(20),@salary int 
	select @name=empname,@salary=salary from inserted
	set @time=(select joindate from employ where empname=@name)
	if(datediff(mm,@time,getdate())>30)
	begin
		if(@salary<2000)
		begin
			print '工作30月以上的月薪不能低于2000'
			rollback transaction
		end
		else
			print '修改成功！'
	end
	else
		print '修改成功'	
go



drop trigger tg_updatemoney

--第二种方法
select * from employ;

drop trigger empUpdate

create trigger empUpdate on employ for update
as
	declare @empid int,@salary decimal(18,2),@joindate datetime
	declare cur cursor for select empid,salary,joindate from inserted
	open cur 
	fetch next from cur into @empid,@salary,@joindate
	while @@fetch_status=0
	begin
		if datediff(month,@joindate,getdate())>30 or @salary<2000
		begin
			print '超过30个月的员工工资不能低于2000，修改失败'
			rollback transaction
		end
		fetch next from cur into @empid,@salary,@joindate
	end
	close cur
	deallocate cur
go

update employ set salary=2640 where empid=3
update employ set joindate='2008-3-4' where empid=3


--3.员工表中创建delete触发器，未离职的员工不能删除
select * from employ;

alter table employ add status varchar(10)
update employ set status='在职'
update employ set status='离职' where empid=16;

create trigger empDelete on employ for delete
as
	declare @empid int,@status varchar(10)
	declare cur cursor for select empid,status from deleted
	open cur 
	fetch next from cur into @empid,@status
	while @@fetch_status=0
	begin
		if @status!='离职'
		begin
			print '只有离职员工才能删除'
			rollback transaction
		end
		fetch next from cur into @empid,@status
	end
	close cur
	deallocate cur
go


select * from employ;
delete employ where empid=1;
delete employ where empid=16;
drop trigger empDelete


------------------------------------上机文档课外练习--------------------------------------------------
--商品表
create table product(
	proid int identity(1,1) primary key ,
	proname varchar(20) not null,
	price float not null,
	num int not null	
)
insert into product values('java试卷','100',10)
insert into product values('jsp试卷','70',12)
insert into product values('sql试卷','80',13)
--订单表
create table orders(
	orderid int identity(1,1) primary key,
	ordername varchar(30) not null,
	ordertel varchar(30) not null,
	ordermoney float not null 
)
drop table orders
insert into orders values('张三','123456789',1000)
insert into orders values('李四','123456783',1000)
insert into orders values('张三','123456781',1000)
insert into orders values('张三','123456782',1000)
go
--订单详情表
create table orderitems(
	id int identity(1,1) primary key ,
	orderid int foreign key  references orders(orderid) ,
	proid int  foreign key  references product(proid),
	ordernum int not null,
	price float not null,
	ordermoney float not null
	
)
drop table orderitems
select * from product;
select * from orders;
select * from orderitems;

/*
	商品表（product）：有主键、商品名称、商品价格、库存字段
	订单表（orders)：有主键、订单号、客户名、客户电话、订单总金额字段
	订单项（orderitems）：有主键、订单id、商品id、定购数量、定购价格、金额
	金额=定购数量*定购价格
	订单总金额为该订单下的所有订单项的金额的和
	使用触发器实现，但添加、删除订单项或修改订单的项数量时，通过触发器修改订单总金额
*/


create trigger addmoney on orderitems for insert,update,delete
as
	declare @price float,@summoney float,@ordernum int,@proid int,@orderid int,@name varchar(20),@tel varchar(30),@i int
	select @proid=proid from inserted
	select @i=id from deleted
	if(@i!=0 and @proid='')
	begin
		--该操作为删除
		print '删除操作'
		select @price=price,@summoney=ordermoney,@ordernum=ordernum,@proid=proid,@orderid=orderid from deleted
		update orders set ordermoney=isnull((ordermoney-@summoney),0) where orderid=@orderid
	end	
	else if(@proid!='')
	begin
		print '新增或修改操作'
		select @price=price,@summoney=ordermoney,@ordernum=ordernum,@proid=proid,@orderid=orderid from inserted
		set @name=(select ordername from orders where orderid=@orderid)
		set @tel=(select ordertel from orders where orderid=@orderid)
		if(update(ordernum))
		begin
			update orderitems set ordernum=@ordernum,ordermoney=(@ordernum*(select price from orderitems where orderid=@orderid and proid=@proid))  where orderid=@orderid and proid=@proid
			update orders set ordermoney=(select ordermoney from orderitems  where orderid=@orderid and proid=@proid ) where orderid=@orderid
		end
		else 
		begin
			insert into orderitems values(@proid,@orderid,@ordernum,@price,@summoney)
			update orders set ordermoney=(select ordermoney from orderitems where proid=@proid) where orderid=@orderid
		end
	end
	else
	begin
		print '该订单不存在！'
		rollback tran
	end
insert into orderitems values(4,3,10,80,600)
update orderitems set ordernum=3 where proid=3
delete orderitems where orderid=1
select * from product;
select * from orders;
select * from  orderitems;
drop trigger addmoney;







--------------------------------------上机文档课堂讲解------------------------------------------


/*
6.2.	有三个表：
商品表（Product）：有主键、商品名称、商品价格、库存字段
订单表（Orders)：有主键、订单号、客户名、客户电话、订单总金额字段
订单项（OrderItems）：有主键、订单ID、商品ID、定购数量、定购价格、金额
金额=定购数量*定购价格
订单总金额为该订单下的所有订单项的金额的和

*/

--商品表
create table Product1
(
	prodid varchar(20) not null primary key,
	prodname varchar(30),
	price decimal(18,2), 
	storeCount int
);
--订单表
create table Orders2
(
	orderid varchar(12) primary key,
	custname varchar(20),
	totalMoney decimal(18,2)
);
--订单项
create table OrderItem
(
	itemsid int identity(1,1) primary key,
	orderid varchar(12),prodid varchar(20),
	ordercount int,
	orderprice decimal(18,2),
	totalMoney decimal(18,2)
);

select * from Product1;
select * from Orders2;
select * from OrderItem;
insert into product1 values('P1001','酸枣糕',28.5,100);
insert into product1 values('P1002','赣南脐橙',60,100);
insert into product1 values('P1003','石城白莲',33,100);

truncate table orders2
truncate table orderitem

insert into orders2 values('201703170001','张三',0);
insert into orderitem values('201703170001','P1001',8,28.5,8*28.5);
insert into orderitem values('201703170001','P1002',8,60,8*60);
insert into orderitem values('201703170001','P1003',8,33,8*3)


update orderitem set ordercount=7;
delete orderitem where  itemsid=4;

create trigger calcMoney on OrderItem for insert,update,delete
as
	declare @orderid varchar(12)
	select @orderid=orderid from inserted
	if @orderid is null or @orderid=''
	begin
		select @orderid=orderid from deleted
	end
	select @orderid
	declare @prodid varchar(20),@ordercount int,@orderprice decimal(18,2),@totalmoney decimal(18,2)
	set @totalmoney=0
	declare cur cursor for select prodid,ordercount,orderprice from orderitem where orderid=@orderid
	open cur
	fetch next from cur into @prodid,@ordercount,@orderprice
	while @@fetch_status=0
	begin
		set @totalmoney = @totalmoney + @ordercount*@orderprice
		update orderitem set totalmoney = @ordercount*@orderprice where current of cur
		fetch next from cur into @prodid,@ordercount,@orderprice
	end
	--更新订单表的总金额
	update Orders2 set totalmoney =@totalmoney where orderid=@orderid
	close cur
	deallocate cur
go

