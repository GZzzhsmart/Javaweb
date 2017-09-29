create database Test
go 
use Test 
go 
--班级表
create table classes
(
	classid int identity(1,1) primary key,--班级编号
	classname varchar(30) not null--班级名称
)
go
--学生表
create table stud
(
	studid int not null,--学生编号
	studname varchar(20) not null,--学生姓名
	sex varchar(4) not null,--性别
	cardid varchar(18),--身份证号码
	classid int not null--班级编号
	age int not null--年龄
)
alter table stud add constraint pk_stud primary key(studid);
alter table stud add constraint ck_sex check(sex='男' or sex='女');
alter table stud add constraint fk_stud_class foreign key(classid) references classes(classid);
alter table stud add constraint uq_cardid unique(cardid);
alter table stud add age int not null

select * from course
select * from score
--课程表
go
create table course
(
	courseid int identity(1,1) primary key,--课程id
	coursename varchar(30) not null,--课程名称
	credit int--学分
)
--成绩表
go 
create table score
(
	studid int not null,--学生编号
	courseid int not null,--课程id
	scores decimal(18,2)--成绩
)
go

--创建组合键
alter table score add constraint pk_score primary key(studid,courseid);
alter table score add constraint fk_stud_score foreign key(studid) references stud(studid);
alter table score add constraint fk_score_course foreign key(courseid) references course(courseid);


select * from classes;

insert into classes values('1601班');
insert into classes values('1602班');
insert into classes values('1603班');
insert into classes values('1604班');
insert into classes values('1501班');
insert into classes values('1502班');

select * from stud;

insert into stud values(1001,'张三','男','362426199801160013',1,19);
insert into stud values(1002,'李四','男','362426199601160013',1,21);
insert into stud values(1003,'王五','男','362426199501160013',1,22);
insert into stud values(1004,'小露','女','362426199701160013',1,20);
insert into stud values(1005,'小芳','女','362426199401160013',1,23);

select * from course;

insert into course values('html',2);
insert into course values('C语言',4);
insert into course values('SQL2005',2);
insert into course values('java',12);
insert into course values('javascript',4);
insert into course values('jsp',12);
insert into course values('SQL2000',6);
insert into course values('Ajax',4);
insert into course values('jQuery',8);
insert into course values('MyBatis',4);

--查询1601班的学生信息

--子查询
select * from stud where classid in(select classid from classes where classname='1601班');
--多表连接 
select s.* from stud s,classes c where s.classid=c.classid and c.classname='1601班'
--内连接
select s.*from stud s inner join classes c on s.classid=c.classid where classname='1601班'
--左连接
select s.* from stud s left join classes c on s.classid=c.classid where classname='1601班'
select s.* from stud s left join classes c on s.classid=c.classid
--右连接
select s.* from stud s right join classes c on s.classid = c.classid where classname='1601班'
select s.* from stud s right join classes c on s.classid=c.classid 
--完全连接
select s.* from stud s full join classes c on s.classid=c.classid
--交叉连接
select s.* from stud s cross join classes c

insert into score values(1001,1,60);
insert into score values(1001,2,80);
insert into score values(1001,3,90);
insert into score values(1001,4,70);
insert into score values(1001,5,90);
insert into score values(1001,6,55);
insert into score values(1001,7,43);
insert into score values(1001,8,60);
insert into score values(1001,9,95);
insert into score values(1001,10,63);

insert into score values(1002,1,60);
insert into score values(1002,2,80);
insert into score values(1002,3,90);
insert into score values(1002,4,70);
insert into score values(1002,5,66);
insert into score values(1002,6,55);
insert into score values(1002,7,43);
insert into score values(1002,8,66);
insert into score values(1002,9,59);
insert into score values(1002,10,89);

insert into score values(1003,1,60);
insert into score values(1003,2,80);
insert into score values(1003,3,90);
insert into score values(1003,4,70);
insert into score values(1003,5,66);
insert into score values(1003,6,55);
insert into score values(1003,7,90);
insert into score values(1003,8,70);
insert into score values(1003,9,66);
insert into score values(1003,10,55);

insert into score values(1004,1,90);
insert into score values(1004,2,80);
insert into score values(1004,3,90);
insert into score values(1004,4,70);
insert into score values(1004,5,66);
insert into score values(1004,6,55);
insert into score values(1004,7,43);
insert into score values(1004,8,60);
insert into score values(1004,9,67);
insert into score values(1004,10,78);

insert into score values(1005,1,80);
insert into score values(1005,2,80);
insert into score values(1005,3,90);
insert into score values(1005,4,70);
insert into score values(1005,5,66);
insert into score values(1005,6,55);
insert into score values(1005,7,43);
insert into score values(1005,8,90);
insert into score values(1005,9,70);
insert into score values(1005,10,66);



select * from score;

--查询学生的所有创建，显示学号，姓名，课程名称，成绩
select s.studid,s.studname,c.coursename,ss.scores from score ss
inner join stud s on ss.studid=s.studid
inner join course c on c.courseid=ss.courseid

--查询总分
select ss.studid '学号',s.studname '姓名',sum(ss.scores) '总分' from score ss
inner join stud s on s.studid=ss.studid 
where s.classid=1 
group by ss.studid,s.studname having sum(ss.scores)>=400
order by 总分

select * from course;

--用一条记录显示每个学生的所有成绩
select studid,studname,
isnull((select scores from score where courseid=1 and studid=s.studid),0) 'html' ,
isnull((select scores from score where courseid=2 and studid=s.studid),0) 'C语言' ,
isnull((select scores from score where courseid=3 and studid=s.studid),0) 'SQL2005' ,
isnull((select scores from score where courseid=4 and studid=s.studid),0) 'java' ,
isnull((select scores from score where courseid=5 and studid=s.studid),0) 'javascript' ,
isnull((select scores from score where courseid=6 and studid=s.studid),0) 'jsp' ,
isnull((select scores from score where courseid=7 and studid=s.studid),0) 'SQL2000',
isnull((select scores from score where courseid=8 and studid=s.studid),0) 'Ajax',
isnull((select scores from score where courseid=9 and studid=s.studid),0) 'jQuery',
isnull((select scores from score where courseid=10 and studid=s.studid),0) 'MyBatis'
from stud s;

--查询所有学生应该参加考试的人数
select studid,studname,coursename from stud cross join course c;

--未参加考试的学生
select * from stud s where not exists (select * from score where s.studid=studid);

--参加考试的学生
select * from stud s where exists (select * from score where s.studid=studid);

--联合查询
select * into a from score where studid=1001;
select * into b from score where studid=1002;
select * into c from score where studid in(1002,1003);


--联合查询:表结构必须一致,字段列表数据必须一致
select * from a 
union 
select * from b
union 
select * from c;

--过滤重复数据distinct
--列出了参加考试的学生学号
select distinct studid from score;
select distinct age from stud;
select distinct sex from stud;
select distinct classid from stud;

--computer by 显示摘要信息,进行分类的统计
select courseid,scores from score order by courseid compute sum(scores) by courseid;

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

--查询和张三在同一个班级的同学
--子查询
select * from student where classno=(select classno from student where stuname='张三');
--连接查询
select s.* from student s inner join (select classno from student where stuname='张三') b on s.classno=b.classno;
--查询张三的C语言成绩
--子查询
select score as C语言成绩 from studentcourse where stuno=(select stuno from student where stuname='张三')and cno=(select cno from courses where cname='C语言');
--连接查询
select sc.score as C语言分数 from student s left join studentcourse sc on s.stuno = sc.stuno
	left join courses c on sc.cno=c.cno
where s.stuname='张三' and c.cname='C语言'
--修改张三的C语言成绩为85
update studentcourse set score=85 where 
stuno=(select stuno from student where stuname='张三') 
and cno=(select cno from courses where cname='C语言')
--删除张三的HTML成绩
delete from studentcourse where 
stuno=(select stuno from student where stuname='张三') 
and cno=(select cno from courses where cname='HTML')

--查询C语言的最高成绩
--子查询
select max(score) from studentcourse where 
cno=(select cno from courses where cname='C语言')
--连接查询
select c.cname,cnno,max(sc.score) from  studentcourse sc 
	left join course c on sc.cno=c.cno
group by c.cno,c.cname
having c.cname='C语言'

--查询C语言成绩最高的学生的基本信息
--子查询
select * from student where stuno in(
select stuno from studentcourse where 
score=(select max(score) from studentcourse where cno=(select cno from course where cname='C语言')) 
and cno=(select cno from courses where cname='C语言'))
