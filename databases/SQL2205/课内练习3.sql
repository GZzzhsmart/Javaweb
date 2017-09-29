--视图的创建和查询
create table class
(
	classno int not null,
	classname varchar(20)
)
create table student
(
	stuno int not null,
	stuname varchar(10) not null,
	classno int not null,
	sex varchar(4) ,
	age int
)
drop table student
create table courses
(
	cno int not null,
	cname varchar(20) not null
)
create table studentcourse
(
	stuno int not null,
	cno int,
	score int
)
SELECT * FROM CLASS;

insert into class values(200801,'ST0801');
insert into class values(200802,'ST0802');
insert into class values(200803,'ST0803');

select * from student;

insert into student values(20080801,'张三',200801,'男',19);
insert into student values(20080802,'李四',200801,'男',18);
insert into student values(20080201,'王五',200802,'男',20);

select * from courses;

insert into courses values(201,'C语言');
insert into courses values(202,'java');
insert into courses values(203,'jsp');

select * from studentcourse;

insert into studentcourse values(20080101,201,71);
insert into studentcourse values(20080102,201,80);
insert into studentcourse values(20080101,202,65);
insert into studentcourse values(20080102,202,56);
insert into studentcourse values(20080101,203,45);


--查看是否含有索引
sp_helpindex studentcourse;
--判断视图是否存在，存在则删除
if exists(select * from sysobjects where name='v_studentscore' and type='v')begin drop view v_studentscore end 
--查询学生的姓名，学号，成绩,课程名称
select s.studid,studname,coursename,scores from stud s 
inner join score ss on s.studid=ss.studid
inner join course c on ss.courseid=c.courseid;

select * from stud;
select * from classes;
select * from course;
select * from score;

--创建视图
create view vstudentscore as 
select s.studid,studname,coursename,scores from stud s
inner join score ss on s.studid=ss.studid
inner join course c on ss.courseid=c.courseid where scores>=80;


create view vscore as 
select studid,courseid,scores from score 
where scores>=80;

--修改视图
alter view vstudentscore as 
select s.studid,studname,coursename,scores from stud s
inner join score ss on s.studid=ss.studid
inner join course c on ss.courseid=c.courseid where scores>=60;

select * from vstudentscore
select * from score;
--删除视图
drop view vstudentscore;
drop view vscore;

--使用视图,把视图名称当前数据表使用
--视图可以屏蔽列
--视图可以屏蔽行
--视图不能包含order by子句
--视图中不能使用distinct，compute,compute by,union语句
select * from vstudentscore

--创建视图
create view vscore as 
select c.courseid,coursename,credit from course c
inner join score s on s.courseid=c.courseid
select * from vscore;
select * from course;

--修改视图
alter view vscore as 
select * from score where scores>=60 with check option;

--删除视图
drop view vscore;

--用存储过程创建登录
sp_addlogin 'zzh','1234';
--用存储过程删除登录
sp_droplogin 'zzh'
--给角色添加用户
sp_addsrvrolemember

--用命令创建登录名称
create login zzh with password='1234';
--用命令删除登录名称
drop login zzh;

--创建用户（一个登录名称对应一个用户）
create user zzh for login zzh;

--给用户相应的授权
grant select on stud(studid,studname) to zzh;
grant select on stud to zzh;
grant insert on stud to zzh;
grant delete on stud to zzh;
grant update on stud to zzh;

--取消授权
revoke delete on stud from zzh;
revoke select on stud from zzh;
revoke insert on stud from zzh;
revoke update on stud from zzh;

