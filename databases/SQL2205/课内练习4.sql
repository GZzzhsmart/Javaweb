--批处理结束
use Test
select * from grade where gradename='宏图1601班'
go

--T_SQL中的注释
--单行注释
select * from grade where gradename='宏图1601班';

use Test
select * from grade where gradename='宏图1601班';/*这是注释*/
--@@ERROR返回上一条语句执行的错误信息，0表示没有错误
select @@error
--数据库系统的版本@@servion
select @@version;
--查询上一条语句执行的记录数@@rowcount
select * from stud;
select @@rowcount;
--获取数据库的服务器名称
select @@servername;
--获取语言
select @@language;
--服务名称
select @@servicename;
--连接的最大个数
select @@max_connections

--打印九九乘法表
print space(30)+ '九九乘法表'
declare @i int,@j int,@string varchar(1000)
	set @i=1
while @i<=9
	begin 
		set @j=1;
		set @string=''
while @j<=@i
	begin 
		select @string=@string+convert(varchar(10),@j)+'*'+convert(varchar(10),@i)+'='+convert(varchar(20),@i*@j)+space(2) 
		set @j=@j+1--增量运算
	end
		print @string
		set @i=@i+1
	end


declare @i int,@j int,@sum int
	set @i=1;
	set @j=1;
	set @sum=1;
		while @i<=9
		begin
			set @j=1
			while(@j<=@i)
			begin
				set @sum=@i*@j;
				print cast(@j as varchar(2)) + '*' + cast(@i as varchar(2))+'='+convert(varchar(2),@sum);
				set @j=@j+1;
			end
			set @i=@i+1;
		end	



--水仙花数
declare @num int ,@ge int ,@shi int ,@bai int 
set @num=100
while @num<1000
	begin 
		set @bai=@num/100
		set @shi=@num/10%10
		set @ge=@num%10
		if(@bai*@bai*@bai+@shi*@shi*@shi+@ge*@ge*@ge=@num)
		print @num
		set @num=@num+1
	end	



--完数
print '完数如下'
declare @a int,@i int,@j int
	set @i=6
	set @a=0
	while @i<1000
		begin
			set @a=0
			set @j=2
			while @j<=@i
				begin
					if(@i%@j=0)
					set @a=@a+(@i/@j)
					set @j=@j+1
				end
				if(@i=@a)
				print @i
				set @i=@i+1
		end
			print '输出完毕'




--当相加的数字大于500时自动停止
declare @sum int,@i int
	set @i=0
	set @sum=0
	while @sum<=500
	begin
		set @sum=@sum+@i
		set @i=@i+1
	end
		print @sum



--1到100哪些数可以被3和7整除

declare @num int ,@i int
	set @i=1
	while @i<=100
		begin
			if(@i%3=0 and @i%7=0)
				begin
					print @i
				end	
			set @i=@i+1 --增量表达式
		end

--使用swtich case 来判断现在是上午，下午，晚上

declare @time int,@fen int,@miao int
	set @time=(select datepart(hh,getdate()));--时
	set @fen=(select datepart(mi,getdate()));--分
	set @miao=(select datepart(second,getdate()));--秒
		begin
			print case 
			when @time>0 and @time<=12 then  '现在是中午时间   '+convert(varchar(30),@time)+':'+convert(varchar(10),@fen)+':'+convert(varchar(10),@miao)
			when @time>12 and @time<=18 then '现在是下午时间   '+convert(varchar(30),@time)+':'+convert(varchar(10),@fen)+':'+convert(varchar(10),@miao)
			when @time>18 and @time<=24 then '现在是晚上时间   '+convert(varchar(30),@time)+':'+convert(varchar(10),@fen)+':'+convert(varchar(10),@miao)
		end
end



--打印菱形
print '15行的菱形'
declare @a int,@b int
	set @a=1 set @b=15
	if(@b%2!=1)
		print '数字必须都是奇数'
	else
	while(@a<=@b)
		begin
			if(@a%2=1)
				print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
				set @a=@a+1
		end
			set @a=@a-2
			while (@a<=@b)
		begin
			if(@a%2=1)
				print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
				set @a=@a-1    
			if (@a<0)
				break
		end





--打印梯形
declare @a int,@b int
set @a=7 set @b=21
if(@a%2=1)
	while(@a<@b)
	begin
		print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
		set @a=@a+2
	end





--打印正方形
declare @a int
declare @b int
declare @c nvarchar(100)
	set @a=1
	set @b=1
	set @c=''
	while (@a<=8)
	begin
	   while (@b<15)
			begin 
				set @c=@c+'*'
				set @b=@b+1
			end
				print @c 
				set @a=@a+1
	end



--打印直角三角形
declare @a int 
	set @a=1
	while(@a<11)
	begin
		print replace(space(@a),' ','*')
		set @a=@a+1
	end



--打印圆形
declare @a int,@b int
set @a=9 set @b=13

while (@a<=@b)
begin
if(@a%2=1)
print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
set @a=@a+1
end
set @a=@a-1
begin
print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
end
while (@a<=@b)
begin
if(@a%2=1)
print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
set @a=@a-1
if(@a<10)
break
end
set @a=@a-2
begin
print space((@b-@a)/2)+replace(space(@a),' ','*')+space((@b-@a)/2)
end




--求a,b,c三个数的最大值
declare  @a int,@b int,@c int,@max  int
set @a=1 set @b=2 set @c=3 
if  @a>@b               
   set  @max=@a
else
   set  @max=@b
if  @max<@c
   set  @max=@c      
print   @max



--求1到100之间的素数
declare @i int ,@j int ,@num int 
	set @i=1
	set @num=0
	while @i<100
		begin 
			set @num=0
			set @j=2
			while @j<@i
				begin 
					if(@i%@j=0)
						set @num=1
						set @j=@j+1
				end 
					if(@num=0)
						print @i
					set @num=0
					set @i=@i+1
		end


--百元百鸡

declare @i int
declare @j int
declare @k int
set @i=1
while @i<=(100/5)
 begin
   set @j=1
   while @j<=(100/3)
    begin
      set @k=100-@i-@j
       if @i*5+@j*3+(@k/3.0)=100 --这个位置的3.0不能换成3,否则结果会出错
         begin
           print '公鸡:'+cast(@i as varchar)+' 母鸡:'+cast(@j as varchar)+' 小鸡:'+cast(@k as varchar)
         end
         set @j=@j+1
     end
    set @i=@i+1
  end



--选择语句的使用
--if..else语句的使用
declare  @i int;
	set @i=2
	if @i=1
begin
	goto x
end
else
begin
	print '不能查询'
end
x:print'查询成功'


begin
	declare @cnt int;
	set @cnt =(select count(*) from stud where age<18);
	if @cnt>0
	begin
		print '有未成年人'
	end
else
	begin
		print '没有未成年人'
	end
end;


--while语句的使用
declare @i int
	set @i=1;
	while @i<1
begin
	print @i;
	set @i=@i+1
end
print '@i'



--循环语句的使用
begin
	declare @i int;
	set @i=0;
	while @i<10
		begin
			print @i;
			set @i=@i+1;
		end;
end;



--1加到100的值

begin
	declare @i int,@sum int;
	set @i=1;
	set @sum=0;
	while @i<=100
		begin 
		  set @sum=@sum+@i;
		  set @i=@i+1;
		end;
	print @sum;
	print '1+2+3....+100的和='+cast(@sum as varchar(100));
end;	 





select * from stud;
--case语句
select studname,case age
	when 19 then '19'
	when 21 then '21'
	end 
	as 年龄
from stud;

select * from grade;

select gradeid,
sum(case when sex='男' then num else 0 end) as M,
sum(case when sex='女' then num else 0 end) as F
from grade
group by gradeid

select * from stud;

--while中使用continue
while(select avg(age) from stud)<25
begin 
	update stud set age=age+1
	if(select max(age) from stud)>20
		 break
	else 
		begin
			continue
			print '已经到了'--说明在continue后面的语句不会被执行
		end
end

--goto的使用
declare @a int
	set @a=100
	goto mylab
	set @a=200
	mylab: set @a=@a/10
	print @a


--when的使用
declare @t tinyint
	set @t=20;
	print case
		when @t>=7 and @t<11 then '上午'
		when @t>=11 and @t<13 then '中午'
		when @t>=13 and @t<17 then '下午'
	else '晚上'
end
waitfor time '10:10';
select * from stud --等到这个时间执行
waitfor delay '4:10';--延迟4个小时执行
select * from stud ;

delete from stud where studid=1006;


waitfor delay '00:00:10'--延迟10秒钟执行
insert into stud values(1006,'小智','男','362426199601160013',1,21);
waitfor time '15:25:00'--到指定的时间执行该语句



--try...catch异常处理和事务处理
begin try
	begin tran
		insert into stud(studid,studname,sex,cardid,classid,age) values(1006,'小智','男','362426199501160013',1,22);
		commit tran
		print 'commited'
	end try
	begin catch
		rollback
		print 'rollback'
	end catch


begin try
	begin transaction 
	insert into stud values(1006,'小智','男','362426199501160013',1,22);
	insert into stud values(1007,'小美','女','362426199701160013',1,21);
	commit transaction
end try
begin catch
	--回滚事务
	rollback
	print '新增失败'
end catch

select * from stud;
