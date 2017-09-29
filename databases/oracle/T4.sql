--员工表
create table emp
(
       deptno int primary key,
       job varchar2(20) not null,
       sal int not null
)

select * from emp;
insert into emp values(1,'开发部',6000);
insert into emp values(2,'测试部',7000);
insert into emp values(3,'营销部',8000);

--班级表
create table class
(
       classid int primary key not null,
       classname varchar(20)
);

select * from class;
--学生表
create table student
(
       id varchar2(12) not null,
       name varchar2(20) not null,
       age number(3) default 0,
       classid int,
       sex varchar2(2),
       cardno varchar2(18) not null,
       major varchar2(20),
       nation varchar(30),
       time date
)
select * from student;
drop table student;
--增加字段
alter table student add sex varchar2(2);
alter table student add cardno varchar2(18) not null;
alter table student add major varchar2(20);
alter table student add nation varchar(30);
alter table student add time date;
alter table student add aaaa varchar(30);

--删除字段
alter table student drop column aaaa;

--修改字段
alter table student modify major varchar2(30);
--查看表结构
desc student;

--创建主键
alter table student add constraint pk_stud primary key(id);
--唯一约束
alter table student add constraint un_cardno unique(cardno);
--建立外建
alter table student add constraint fk_stud foreign key(classid) references class(classid);

--课程表
create table course
(
       courseid number(2) not null,
       coursename varchar2(30) not null,
       primary key(courseid)
)

select * from course;
--成绩表

create table score
(
       id varchar2(12) not null,
       courseid number(2) not null,
       score number(5,2),
       constraint pk_score primary key (id,courseid)
)

select * from score;

insert into class values(1,'宏图1601班');
insert into class values(2,'宏图1602班');
insert into class values(3,'宏图1603班');
insert into class values(4,'宏图1604班');
select * from class;

insert into course values(1,'html');
insert into course values(2,'sql2005');
insert into course values(3,'java');
insert into course values(4,'jsp');
insert into course values(5,'oracle');
select * from course;

insert into student values(1001,'张三',20,1,'男','123456789012345678','软件技术','汉族',sysdate);
insert into student values(1002,'李四',22,1,'男','123456789012345679','软件技术','汉族',sysdate);
insert into student values(1003,'老王',24,1,'男','123456789012345680','软件技术','汉族',sysdate);
insert into student values(1004,'小丽',18,1,'女','123456789012345681','软件技术','汉族',sysdate);
insert into student values(1005,'李小龙',30,1,'男','123456789012345682','软件技术','汉族',sysdate);
insert into student values(1006,'娜娜',19,1,'女','123456789012345683','软件技术','汉族',sysdate);
insert into student values(1007,'小小',19,4,'女','123456789012345685','软件技术','汉族',sysdate);
select * from student;

select * from score;
insert into score values(1001,1,88);
insert into score values(1001,2,78);
insert into score values(1001,3,68);
insert into score values(1001,4,99);
insert into score values(1001,5,54);
commit;
insert into score values(1002,1,88);
insert into score values(1002,2,78);
insert into score values(1002,3,68);
insert into score values(1002,4,99);
insert into score values(1002,5,54);
insert into score values(1003,1,88);
insert into score values(1003,2,78);
insert into score values(1003,3,68);
insert into score values(1003,4,99);
insert into score values(1003,5,54);
insert into score values(1004,1,88);
insert into score values(1004,2,78);
insert into score values(1004,3,68);
insert into score values(1004,4,99);
insert into score values(1004,5,54);
insert into score values(1005,1,88);
insert into score values(1005,2,78);
insert into score values(1005,3,68);
insert into score values(1005,4,99);
insert into score values(1005,5,54);
insert into score values(1006,1,88);
insert into score values(1006,2,78);
insert into score values(1006,3,68);
insert into score values(1006,4,99);
insert into score values(1006,5,54);

select * from score;
commit;

--内连接
select * from student s inner join class b on s.classid=b.classid;
select s.*,b.classname from student s inner join class b on s.classid=b.classid;
select id,name,age,sex,major,classname  from student s inner join class  b on s.classid=b.classid;

--与内连接等价的语句
select * from student s,class b where s.classid = b.classid;

----外连接
--左连接
select * from student s left join class b on s.classid = b.classid;
--右连接
select * from student s right join class b on s.classid = b.classid;
--完全连接
select * from student s full join class b on s.classid = b.classid;
--交叉连接
select * from student cross join class;

select s.id,s.name,b.classname,k.coursename,c.score from student s
inner join class b on s.classid = b.classid
inner join score c on c.id=s.id
inner join course k on k.courseid=c.courseid
order by s.id,k.courseid;

--子查询
select * from student where classid=(select classid from class where classname='宏图1601班');
select s.id,s.name,
(select score from score where courseid=1 and id=s.id)html,
(select score from score where courseid=2 and id=s.id)sql2005,
(select score from score where courseid=3 and id=s.id)java,
(select score from score where courseid=4 and id=s.id)jsp,
(select score from score where courseid=5 and id=s.id)oracle
from student s;


--条件查询
select * from student;
--更新时间必须使用to_date函数转换格式
update student set time = to_date('2016-06-23','yyyy-mm-dd')where id=1001;
update student set time = to_date('2016-07-23','yyyy-mm-dd')where id=1002;
update student set time = to_date('2016-08-23','yyyy-mm-dd')where id=1003;
update student set time = to_date('2017-06-23','yyyy-mm-dd')where id=1004;
update student set time = to_date('2017-07-23','yyyy-mm-dd')where id=1005;
update student set time = to_date('2017-08-23','yyyy-mm-dd')where id=1006;
update student set time = to_date('2015-08-08','yyyy-mm-dd')where id=1007;
select sysdate from dual;

--between and
select * from student where time between to_date('2016-01-01','yyyy-mm-dd')and to_date('2016-12-31','yyyy-mm-dd');
--in ,not in
select * from student where id not in(1001,1003,1005);
--exists
select * from student s where exists(select * from class where classname='宏图1601班' and s.classid=classid);


--复制表：复制表的结构及数据，但是不会复制表的主键，外键，检查，唯一等约束

select * from student;
--复制学生表的表结构，同时拷贝所有的记录
create table student2 as select * from student;
--复制学生表的部分字段，同时拷贝所有的记录
create table student2 as select id,name ,cardno,major from student;
--复制学生表的表结构，但是不拷贝记录
create table student3 as select * from student where 1=2;
select * from student3;
--批量新增记录
insert into student3 select * from student
insert into student2 select id,name,cardno,major from student
select * from student2
--删除数据
delete student2
truncate table  student2;
alter table student2 add constraint pk_stud2 primary key(id);
--创建用户，用户名lgr,密码lgr;
create user lgr identified by lgr;
--授予lgr用户登录的权限
grant create session to lgr;
--授予lgr具有查询scott用户emp表的权限
 grant select on emp to lgr;
 --撤销用户查询scott.emp表的权限
revoke select on emp from lgr;

select * from dept where loc is not null;

--模糊查询like
select * from student where name like '%小';
select * from student where name like '小%';
select * from student where name like '%小%';
select * from student where name like '小_';

select * from student where cardno like '%8_';
select table_name from user_tables;
select * from EMPLOYEES;


select count(*) from student;
select sum(age),avg(age),max(age),min(age) from student;

select id,sum(score) from score group by id;
select * from emp;
select deptno,job,sum(sal) from emp group by deptno,job;
--Rollup实现	从右往左再聚合
select deptno,job,sum(sal) from emp group by rollup(deptno,job);
--Cube除了形成rollup的结果，还会按相反的方向形成结果
select deptno,job,sum(sal) from emp group by cube(deptno,job);
--group by sets相当于union，把2个独立的group by 语句的结果显示出来;
select deptno,job,mgr,sum(sal) from emp group by grouping sets((deptno,job),(job,mgr)) order by deptno;
--相当于下面2条统计结果的和
select deptno,job,sum(sal) from emp group by deptno,job;
select job,mgr,sum(sal) from emp group by job,mgr ;

--高级子查询，成对比较
--Where字句中的子查询,查询工资比部门平均工资高的员工
Select a.empno,a.ename,a.deptno,a.sal,b.avg_sal
	from emp a, (select deptno,avg(sal) avg_sal from emp
			group by deptno) b
	where a.deptno = b.deptno and a.sal > b.avg_sal
--标量子查询
select empno,ename,sal, (
	case
	when sal>4000 then '白领'
	when sal>2000 then '蓝领'
	else '打工仔'
	end)  工薪阶层
  from emp;

select 学号,姓名,
case 性别
when '男' then '帅哥'
when '女' then '美女'
end 昵称 from 学生表;

--查询员工，按部门名称排序
select empno,ename from emp e order by (select dname from dept d where e.deptno=d.deptno)


--With语句定义一个变量来表示一个语句，通过引用变量来引用子句，实现重用，提高效率,查询部门总工资大于所有部门工资的平均值的部门

with 
dept_costs AS(
   select deptno,sum(sal) as dept_total
   from emp
   group by deptno),
avg_cost AS(
   select sum(dept_total)/count(*) as dept_avg
   from dept_costs)
select * from dept_costs where dept_total>(select dept_avg from avg_cost) order by deptno


--创建视图
create view vstudent as select * from student where age>22;
--使用视图
select * from vstudent;
--修改视图,with check option规定，该视图只能查询年龄大于24的学生资料，只能新增，修改，删除年龄大于24的学生资料
create or replace view vstudent as select * from student where age>24;
with check option;

--只读视图
create or replace view vstudent as select * from student where age<30 with read only;

--删除视图
drop view vstudent;

select * from user_views;
