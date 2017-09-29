create table account(
	id int identity(1, 1) primary key,
	cardid varchar(20),
	money float check(money>=0)
);

select * from account;

insert into account values('100001',4000);
insert into account values('100002',6000);
insert into account values('100004',8000);
insert into account values('100005',10000);

--事务

begin
	begin tran;
	declare @errorsum int;
	set @errorsum=0;
	update account set money=money+200 where cardid='100001';
	update account set money=money-200 where cardid='100002';
	set @errorsum=@errorsum+@@error;

    if @errorsum>0
		begin
			print '转账失败';
			rollback tran;
		end
	else
		begin
			print '转账成功';
			commit tran;
		end
end;

create table zhanghu
(
	id int identity(1, 1) primary key,
	kahao varchar(20),
	yue decimal(12, 2)
)

select *from zhanghu;

alter table zhanghu add constraint dayu_zero check(yue>=0);


insert into zhanghu(kahao,yue) values('100000001', 2000);
insert into zhanghu(kahao, yue) values('100000002', 0);

--转账操作在同一个事务中处理
begin tran
	declare @errorsum int
	set @errorsum=0
	update zhanghu set yue=yue-2500 where kahao='100000001'
	set @errorsum=@errorsum+@@error
	update zhanghu set yue=yue+2500 where kahao='100000002'
	set @errorsum=@errorsum+@@error

	print '查看转账结果'
	if @errorsum>0
	begin
		print '转账失败'
		rollback tran
	end
	else
	begin
		print '转账成功'
		commit tran
	end

--设置保存点
begin transaction
	update zhanghu set yue=yue-1000 where kahao='100000001'
	save tran bcd1
	update zhanghu set yue=yue+500 where kahao='100000002'
	save tran bcd2
	rollback transaction bcd1
	commit transaction
end

--解除死锁
set deadlock_priority normal

set lock_timeout 18000

--设置事务的隔离级别
set tran isolation level read committed

select datepart(weekday,getdate()),datename(weekday,getdate())
set datefirst 1
select '星期'+case  when cast(datepart(dw,getdate()) as char(1))= 7 then '天' else cast(datepart(dw,getdate()) as char(1)) end


--异常处理和事务处理
--事务处理，要么都成功，要么都失败
select * from stud;

begin try
	begin transaction
	insert into stud values(1007,'王麻子','男','123456789123456794',4,17);
	insert into stud values(1008,'小美','女','123456789123456795',4,18);
	--提交事务
	commit transaction
end try
begin catch
	--回滚事务
	rollback
	print '新增失败'
end catch


create table test
(
	age int not null,--年龄
	major varchar(10) not null,--特点 
	sex varchar(4) not null,--性别
	hobit varchar(10) not null,--爱好
	money int not null--金额
)

select * from test;

--(使用try catch回滚)
begin try
	begin transaction
	insert into test values(16,'aa','女','aa',2000);
	insert into test values(17,'aa','女','aa',2000);
	save transaction save1 --设置保存点
	insert into test values(16,'aa','女','aa',2000);
	insert into test values(18,'aa','女','aa',2000);
	commit transaction
	end try
	begin catch
		rollback transaction save1--回滚到保存点
	end catch

--(使用错误号@@error进行回滚)
begin transaction
	declare @err int;
	set @err=0;
	insert into test values(16,'aa','女','aa',2000);
	set @err=@err+@@error
	insert into test values(17,'aa','女','aa',2000);
	set @err=@err+@@error
	save transaction save1--设置保存点
	insert into test values(16,'aa','女','aa',2000);
	set @err=@err+@@error
	insert into test values(18,'aa','女','aa',2000);
	set @err=@err+@@error
	commit transaction 
	if @err>0
	begin
		print '失败'
		rollback transaction save1
	end

	begin transaction
	insert into test values(40,'ww','男','daf',4000);
	save transaction mysave
	delete from test where age=40
	select * from test
	rollback transaction mysave
	commit transaction
	go
	select * from test
	go


select * from test;

--------------------------------------------------------------------------------------
create table salarymoney(
	moneyname varchar(10) primary key ,
	salary int not null

)
truncate table salarymoney
insert into salarymoney values('张三',10000)
insert into salarymoney values('李四',10000)
delete salarymoney
select * from salarymoney
select @@rowcount



--转账事务
begin tran
		declare @error int,@num int,@num2 int
		set @error=0
		set @num=0
		set @num2=0
		update salarymoney set salary=salary-1000 where moneyname='张三'
		set @num=@num+@@rowcount
		update salarymoney set salary=salary+1000 where moneyname='李四'
		set @num2=@num2+@@rowcount
		if(@error!=0)
		begin
			if(@num=0)
				begin
					print '交易失败,你的余额不足，或者是你的昵称有误！'
					rollback tran
				end
			else if(@num2=0)
				begin
					print '交易失败,收款方昵称有误！无法转账！'
					rollback tran
				end
			print '交易失败'
			rollback tran
		end
		else if(@error=0)
		begin
			if(@num=0)
				begin
					print '交易失败,你的余额不足，或者是你的昵称有误！'
					rollback tran
				end
			else if(@num2=0)
				begin
					print '交易失败,收款方昵称有误！无法转账！'
					rollback tran
				end
			else
				begin
					print '交易成功'
					commit tran
				end
		end

select *from salarymoney;
select * from stud;


--------------------------------上机文档课外练习--------------------------------------------------


--转账事务处理

create table account
(
	username varchar(10) not null,--用户名
	password int not null,--密码
	balance decimal(18,2) default 0 --
)
create table book
(
	bookid int identity(1,1) primary key,--编号
	bookname varchar(20) not null,--书名
	authorname varchar(20) not null,--作者
	price float not null,--价格
	discount float not null,--折扣
	inventory int default '0'     --存货
)
create table orders
(
	orderid  int identity(1,1) primary key,--购买编号
	customername varchar(20) not null,--姓名
	createdate datetime,--创建时间
	status varchar(2) check(status='c' or status='p')--状态
)
create table orderitem
(
	itemid int identity(1,1) primary key,
	orderid int not null ,
	bookid int not null,
	quantity int not null default '0',--数量
	price float not null --价格
)
drop table book
drop table orders
drop table orderitem
drop table account
insert into account values('张三',1234,1000.50)
insert into account values('李四',6666,260.20)
-------------------------------------------------
insert into book values('java','吴文虎',100.00,0.85,10)
insert into book values('jsp','谭浩强',80.00,0.75,1)
insert into book values('数据结构','吴文虎',30.00,0.75,5)
-----------------------------------------------------
insert into  orders values('李三',getdate(),'c')
insert into  orders values('清华it',getdate(),'p')
insert into  orders values('王五',getdate(),'p')
----------------------------------------------------
select * from account
select * from orderitem
select * from orders
select * from book

delete orderitem
delete book
delete  orders
/*
	假设李四要购买2本java、2本jsp，写一段代码保存该订单，参考步骤如下：
	1.启动事务
	2.保存订单记录
	3.保存订单项记录
	4.从客户的帐户中扣除所购买商品的金额，若金额不够，撤销前两步的操作
	5.扣除图书库存，若库存不够，撤销前面三步的操作
	6.提交事务
*/
begin tran
	declare @money float,@sumcount int,@sumcount1 int,@sumerror int;
	set @money=(select balance from account where username='李四');
	set @sumcount=(select inventory from book where bookname='jsp');
	set @sumcount1=(select inventory from book where bookname='java');
	set @sumerror=@sumerror+@@error
	save tran save1;
	--加入订单项
	insert into orders values('李四',getdate(),'p');
	insert into orders values('李四',getdate(),'p');
	save tran save2;
	--加入订单
	insert into orderitem values(1,1,2,100.00)
	insert into orderitem values(2,2,2,80.00)
	save tran save3;
	if(@money<360)
	begin
		print '余额不足，交易失败！'
		--回到保存点
		rollback tran save2;
	end
	if(@sumcount<2 or @sumcount1<2)
	begin
		print '库存不够，交易失败！'
		--回到保存点
		rollback tran save1;
	end
	else
	begin
		update book set inventory=inventory-2 where bookname in('jsp','java')--减少库存
		update account set balance=balance-360 where username='李四'--减去购买金额
		print '交易成功！'
		commit tran
	end	
	






