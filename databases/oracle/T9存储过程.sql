--创建存储过程
create or replace procedure proc_emp is
begin
    dbms_output.put_line('Hello World!');
end;
--执行存储过程
begin
    proc_emp();
end;

call proc_emp();
--删除存储过程
drop procedure proc_emp;



create or replace procedure p_stud(
       v_date out varchar2
)
is 
begin
      select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss day') into v_date from dual;
      dbms_output.put_line('用户新增成功！');
end p_stud;


declare v_date varchar2(50);
begin 
    p_stud(v_date);
    dbms_output.put_line('用户新增成功！' || v_date);
end;


--创建存储过程
create or replace procedure pro_test
is
begin
       declare
          v_studname student.name%type;
          v_cardno student.cardno%type;
       begin
          select name,cardno into v_studname,v_cardno from student where id=1001;
          dbms_output.put_line('存储过程执行成功');
          dbms_output.put_line('id=1001的学生，name：'||v_studname||',cardno：'||v_cardno);
       end;
end pro_test;

--执行存储过程
begin
    pro_test();
end;
--删除存储过程
drop procedure pro_test;


/*
    带参数的存储过程
    in 输入参数
    out 输出参数
    in out 输入输出参数
*/
select * from score;

create or replace procedure pro_studscore(studid in varchar2,studscore out number)
as
begin
       select sum(score) into studscore from score where id=studid;
       dbms_output.put_line('id='||studid||'的总分为:'||studscore);
end pro_studscore;
--执行
declare
    studid varchar2(12):=&studid;
    studscore number(5,2);
begin
    pro_studscore(studid,studscore);
    dbms_output.put_line('studscore='||studscore);
end;
--删除
drop procedure pro_studscore;


--统计1601班指定课程的平均分

create or replace procedure pro_ClassAvgScore(v_classid number,v_courseid number,v_avgscore out number)
as
begin
       declare 
          v_classname varchar(50);       
          v_coursename varchar(50);
       begin
          select classname into v_classname from class where classid=v_classid;
          select coursename into v_coursename from course where courseid=v_courseid;
          select avg(score) into v_avgscore from score where courseid=v_courseid and id in (select id from student where classid=v_classid);
          dbms_output.put_line(v_classname||'的'||v_coursename ||'平均分是:' ||v_avgscore );
       end;
end pro_ClassAvgScore;

select * from class;
select * from score;
select * from course;
--执行
declare
    v_classid number(5) :=&classid;
    v_courseid number(5) := &courseid;
    v_avgscore number(5,2);
begin
     pro_ClassAvgScore(v_classid,v_courseid,v_avgscore);
     dbms_output.put_line('平均分是:'||v_avgscore);
end;
--删除
drop procedure pro_classavgscore;





--存储过程与游标，循环语句，条件控制语句的结合应用

create or replace procedure pro_ModifyScore(classid number)
as
begin
       declare
          v_courseid course.courseid%TYPE;
          cursor c_course is select courseid from course;
       begin
          open c_course;
          loop
               fetch c_course into v_courseid;
               exit when c_course%NOTFOUND;
               if v_courseid=1 then
                  update score set score=score-5 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=2 then
                 update score set score=score-10 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=3 then
                  update score set score=score-15 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=4 then
                  update score set score=score+5 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=5 then
                   update score set score=score+10 where courseid=v_courseid and  id in(select id from student where classid=classid);
               end if;
               commit;               
          end loop;
          close c_course;
       end;
end pro_ModifyScore;
--执行
declare 
       v_classid number(5) :=&classid;
begin
    pro_ModifyScore(v_classid);   
end;

--删除
drop procedure pro_ModifyScore;

select * from score where id in(select id from student where classid=1) order by id;


select * from student;
select * from score;
select * from course;


--异常与事务处理
--新增一个学生资料，同时往成绩表里面新增5条记录
create or replace procedure pro_AddStud
(
       sid varchar,
       sname varchar,
       age int,
       cid int,
       sex varchar,
       cardno varchar,
       major varchar,
       nation varchar,
       sdate date
)
as
begin
       declare 
             v_courseid int;
             cursor c_course is select courseid from course;
       begin
             insert into student values(sid,sname,age,cid,sex,cardno,major,nation,sdate);
             open c_course;
             loop
                  fetch c_course into v_courseid;
                  exit when c_course%notfound;
                  insert into score values(sid,v_courseid,dbms_random.value*100);
             end loop;
             close c_course;
             commit;
             exception
                 when dup_val_on_index then
                      rollback;
                      dbms_output.put_line('唯一索引重复错误');
                 when others then
                      rollback;
           
       end;
end pro_AddStud;
--随机函数
select * from student;
select dbms_random.value from dual;
declare
       sid varchar(12) :='1009';
       sname varchar(20) :='小智';
       age int :=21;
       cid int :=1;
       sex varchar(2) :='男';
       cardno varchar(18) :='362426199705130352';
       major varchar(30) :='软件技术';
       nation varchar(20) :='汉族';
       sdate date :=sysdate;
begin
    pro_AddStud(sid,sname,age,cid,sex,cardno,major,nation,sdate);
end;
--删除
drop procedure pro_AddStud;

select * from class;
select * from student;
select * from score where id=1009;




