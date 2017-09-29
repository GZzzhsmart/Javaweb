select * from student;
--创建普通视图
create view vstudent as select * from student where age>20;
--创建一个只读视图
create view vstudent as select * from student where age>20 with read only;
--创建一个受检视图
create view vstudent as select * from student where age>20 with check option;
--删除视图
drop view vstudent;

select * from emp;

--distinct过滤重复数据
select distinct name from student;
--分页处理
select rownum,s.* from student s where rownum>5;
select * from (select rownum rn,x.* from student x) s where s.rn>5
--创建或修改视图
create or replace view vstudent 
as 
select id,name,age,classid,sex,major,time from student;
--with read only  不允许修改视图
create or replace view vstudent
as 
select id,name,age,classid,sex,major,time from student
with read only;

--使用视图
select * from vstudent;
update vstudent set age=18 where id=1001;

--with check option 
create or replace view vstudent as 
select id,name,age,classid,sex,major,cardno,time from student where age>20 with check option;

--删除视图
drop view vstudent;

--创建索引
create index index_id on student(id);
--创建唯一索引
create unique index index_cardno on student(cardno);
--创建位图索引
create bitmap index index_sex on student(sex);
--删除索引
drop index index_sex;

--查看系统索引
select * from user_indexes;
select * from user_ind_columns;

/*
       同义词：给对象取别名
       公有同义词：public synonym;由系统管理员创建
       私有同义词：由对象的创建者创建，只能自己使用；
*/


--创建私有同义词
create synonym student for scott.student;
select * from student;
--创建公有的同义词
create public synonym stud for scott.student;
select * from student;

--删除同义词
drop synonym student;
drop public synonym stud;
--查看当前用户的同义词
select * from user_synonyms;
--查看所有的同义词
select * from all_synonyms where synonym_name='stud';
select * from dba_synonyms where synonym_name='stud';

--创建序列
create sequence seq_orderid
increment by 1
start with 10000000
maxvalue 99999999
minvalue 10000000
nocycle 
cache 20
noorder

--使用序列
select seq_orderid.nextval from dual;
select seq_orderid.currval from dual;

--订单表
create table orders
(
  orderid int primary key,
  custid number(8) not null,
  remark varchar2(100)
);
select * from orders;
insert into orders values(seq_orderid.nextval,seq_orderid.nextval,'无说明');

drop table orders;

--查看当前用户所有的序列
select * from user_sequences;

select * from all_sequences;

select * from dba_sequences;

--删除序列
drop sequence seq_orderid;


--创建序列
create sequence seq_id
increment by 1
start with 1
minvalue 1
maxvalue 9999999999
nocycle
cache 20;

--使用序列获取当前值
select seq_id.nextval from dual;
--获取下一个值
select seq_id.currval from dual;

create table major 
(
  majorid number(11) not null,
  majorname varchar2(20) not null,
  constraint pk_majorid
  primary key(majorid)
);

drop table major;
commit;
select * from major;
insert into major values(seq_id.nextval,'软件工程');
insert into major values(seq_id.nextval,'计算机应用');

select * from course;
insert into course values(seq_id.nextval,'struts');
insert into course values(seq_id.nextval,'Hibernate');
insert into course values(seq_id.nextval,'Spring');
insert into course values(seq_id.nextval,'MyBatis');
insert into course values(seq_id.nextval,'json');
insert into course values(seq_id.nextval,'SpringMVC');
insert into course values(seq_id.nextval,'jbpm');
insert into course values(seq_id.nextval,'Ajax');
insert into course values(seq_id.nextval,'jQuery');
insert into course values(seq_id.nextval,'easyUI');
delete course where courseid=7;

--删除序列
drop sequence seq_id;

select * from user_sequences;
select * from all_sequences;

select * from student;
select * from class;


select * from emp;
--查看系统的索引
select * from user_indexes;


