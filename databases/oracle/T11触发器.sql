select * from student;
--查询今天是星期几
select to_char(sysdate,'dy')from dual;

--创建触发器
create or replace trigger tr_updateStud
before insert or update or delete on student
begin
     if to_char(sysdate,'dy','nls_date_language=american')='tue' then       
         raise_application_error(-20000,'周二不能更新学生数据');
         dbms_output.put_line('周二不能更新学生数据');
     end if;
end tr_updateStud;

--删除触发器
drop trigger tr_updateStud;

update student set age=23 where id=1009;
delete student where id='1001';

select to_char(sysdate,'dy','nls_date_language=american') from dual;

-------------------------------------
--创建触发器禁止在休息日改变雇员的信息
create or replace trigger tri_emp_weekend
before insert or update or delete on emp
begin
     if to_char(sysdate,'dy','nls_date_language=american') in ('sat','sun');
        then
        raise_application_error(-20000,'不能再周末修改雇员的信息');
     end if;
end tri_emp_weekend;

drop trigger tri_emp_weekend;


---------------------------------------
--为emp表创建一个触发器，当执行插入操作时，统计操作后员工人数；当执行更新工资操作时，统计更新后员工平均工资；
--当执行删除操作时，统计删除后各个部门的人数

create or replace trigger trg_emp_dml
after insert or update or delete on emp
declare
     v_count number,
     v_sal number(6,2);
begin
     if inserting then 
         select count(*)into v_count from emp;
         dbms_output.put_line(v_count);
     elsif updating then 
         select avg(sal) into v_sal from emp;
         dbms_output.put_line(v_sal);
     else 
         for v_dept in(select deptno,count(*)num from emp group by deptno);
         loop
             dbms_output.put_line(v_dept.deptno||''||v_dept.num);
         end loop;
      end if;
end trg_emp_dml;


drop trigger trg_emp_dml;


-------------------------------------
select * from course;



create or replace trigger tr_test
after insert or update on course
for each row
begin
    if inserting then
       dbms_output.put_line('新增内容记录前:课程编号='||:old.courseid||',课程名称：'||:old.coursename);
       dbms_output.put_line('新增内容记录后:课程编号='||:new.courseid||',课程名称：'||:new.coursename);
    elsif updating then
       dbms_output.put_line('修改内容记录前:课程编号='||:old.courseid||',课程名称：'||:old.coursename);
       dbms_output.put_line('修改内容记录后:课程编号='||:new.courseid||',课程名称：'||:new.coursename);
    elsif deleting then
       dbms_output.put_line('删除内容记录前:课程编号='||:old.courseid||',课程名称：'||:old.coursename);
       dbms_output.put_line('删除内容记录后:课程编号='||:new.courseid||',课程名称：'||:new.coursename);
    end if;
end tr_test;

select * from course order by courseid;
insert into course values(6,'xml');
update course set coursename='mysql' where courseid=6;
delete course where courseid=6;

drop trigger tr_test;


--控制修改某列的值必须符合一定条件
--控制修改员工工资时，修改后的工资必须必修改前的要高
create or replace trigger tri_updateEmpSal
before update of sal on emp
for each row
begin
    if :old.sal>:new.sal then
       raise_application_error(-20001,'员工工资必须比修改之前的更高');
    end if;
end tri_updateEmpSal;

select * from emp;


update emp set sal = 899 where empno=7369;

--删除
drop trigger tri_updateEmpSal;

------------------------------------------------
create table syslog
(
     username varchar(20),
     logtime date     
);

drop table syslog;

select * from syslog;

create or replace trigger tri_login
after logon on database
begin
     insert into syslog values(user,sysdate);
end tri_login;

drop trigger tri_login;


----------------------------

create table createObjectRec
(
    user_id varchar2(30),
    object_type varchar2(20),
    object_name varchar2(30),
    object_owner varchar2(30),
    creation_date date
);

select * from createObjectRec;
drop table createObjectRec;

-----------------------------------
create or replace trigger tri_createObjectLog
after create or drop on database
begin
      insert into createObjectRec values(ora_login_user,ora_dict_obj_type,ora_dict_obj_name,ora_dict_obj_owner,sysdate);
end tri_createObjectLog;

--------------------------------------------

create table test22(id number(8) not null primary key,name varchar2(30));

select * from createObjectRec;
drop table test22;


--------------------------------

create or replace procedure pro_test222
as
begin
       dbms_output.put_line('创建存储过程');
end pro_test222;


-------------------------------------------
create or replace package pkg_sharePool
as
       v_num number;
end pkg_sharePool;

select count(*) from emp group by deptno;
select * from emp where deptno=30;

drop trigger pkg_sharePool;

--行级的触发器，获取部门编号
create or replace trigger tri_deptno
before insert or update on emp
for each row
begin
    pkg_sharePool.v_num := :new.deptno;
end;

drop trigger pkg_sharePool;

----------------------------------
create or replace trigger tri_addEmp
after insert or update on emp
declare 
      v_total number(2);
begin
      select count(*) into v_total from emp where deptno=pkg_sharePool.v_num;
      if v_total>=8 then
         raise_application_error(-20001,'部门人数不能超过8人');
      end if;
end tri_addEmp;


drop trigger tri_addEmp;

insert into emp values(1,'张三','developer',7698,sysdate,8000,0,30);
insert into emp values(2,'小丽','developer',7698,sysdate,8000,0,30);
insert into emp values(3,'李四','developer',7698,sysdate,8000,0,30);
insert into emp values(4,'王五','developer',7698,sysdate,8000,0,30);
select * from emp where deptno=30;
delete emp where empno=1;

/*
       1.触发器中不能使用事务处理语句；
       2.不能读取或者修改变异表中主键，外键，唯一约束字段的值，如果需要必须定义全局的包变量，通过行级触发器保存到变量中；
       3.触发器中不能声明，读取long,long raw类型字段的值；
       4.触发器的大小不能超过32K；
*/
--禁用触发器
alter trigger tri_addEmp disable;
--激活触发器
alter trigger tri_addEmp enable;
--激活所有触发器
alter table emp enable all triggers;
--禁用所有触发器
alter table emp disable all triggers;
--重新编译
alter trigger tri_addEmp compile;
--查看触发器源码
select * from user_triggers;



