--使用游标修改学生成绩
--成绩表
select * from score;
update score set score=100;
--课程表
select * from course;
--学生表
select * from student;

declare 
     v_courseid course.courseid%type;
     v_score score.score%type;
     v_name student.name%type;
     v_id student.id%type;
     cursor v_cursor is select c.id,c.score,c.courseid,s.name from score c inner join student s on c.id=s.id;      
begin
       open v_cursor;
       loop
              fetch v_cursor into v_id,v_score,v_courseid,v_name;
              exit when v_cursor%notfound;
              dbms_output.put_line('修改之前成绩为：id='||v_id||',name='||v_name||',score='||v_score);             
              if v_courseid=1 then
                 v_score := v_score+5;
                 update score set score=v_score where courseid=v_courseid and id=v_id ;
              elsif v_courseid=2 then
                     v_score := v_score+10;
                    update score set score=v_score where courseid=v_courseid and id=v_id ;
              elsif v_courseid=3 then
                     v_score := v_score+15;
                    update score set score=v_score where courseid=v_courseid and id=v_id ;
              elsif v_courseid=4 then
                     v_score := v_score-5;
                    update score set score=v_score where courseid=v_courseid and id=v_id ;
              elsif v_courseid=5 then
                     v_score := v_score-10;
                    update score set score=v_score where courseid=v_courseid and id=v_id ;
              end if; 
              commit;
              dbms_output.put_line('修改之后成绩为：id='||v_id||',name='||v_name||',score='||v_score);             
       end loop;
       close v_cursor;
end;


--------------------------------------------------------------------------------------------------------------

--使用存储过程修改学生的成绩
select * from score order by id;
select * from course;
select * from student;
update score set score=100;


create or replace procedure pro_updatescore(classid number)
as
begin
       declare
          v_courseid course.courseid%type;
          cursor c_cursor is select courseid from course;
       begin
          open c_cursor;
          loop
               fetch c_cursor into v_courseid;
               exit when c_cursor%notfound;
               if v_courseid=1 then
                 update score set score=score+5 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=2 then
                 update score set score=score+10 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=3 then
                 update score set score=score+15 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=4 then
                 update score set score=score-5 where courseid=v_courseid and  id in(select id from student where classid=classid);
               elsif v_courseid=5 then
                 update score set score=score-10 where courseid=v_courseid and  id in(select id from student where classid=classid);
               end if;
               commit; 
          end loop;
          close c_cursor;
       end;
end pro_updatescore;

--执行存储过程
declare 
    v_classid number(5) :=&classid;
begin
    pro_updatescore(v_classid);   
end;

--删除存储过程
drop procedure pro_updatescore;




-----------------------------------------------------------------------------------------------------------

--异常事务处理
select * from student;

select * from score;

create or replace procedure pro_add
(
       sid varchar,
       sname varchar,
       age int,
       classid int,
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
             cursor c_cursor is select courseid from course;
       begin
             insert into student values(sid,sname,age,classid,sex,cardno,major,nation,sdate);
             open c_cursor;
             loop
                  fetch c_cursor into v_courseid;
                  exit when c_cursor%notfound;
                  insert into score values(sid,v_courseid,dbms_random.value*100);
             end loop;
             close c_cursor;
             commit;
             exception
                 when dup_val_on_index then
                      rollback;
                      dbms_output.put_line('唯一索引重复错误');
                 when others then
                      rollback;
       end;
end pro_add;

--执行存储过程
declare
       sid varchar(12) :='1010';
       sname varchar(20) :='小美';
       age int :=48;
       classid int :=1;
       sex varchar(2) :='女';
       cardno varchar(18) :='362426199705130321';
       major varchar(30) :='软件技术';
       nation varchar(20) :='汉族';
       sdate date :=sysdate;
begin
       pro_add(sid,sname,age,classid,sex,cardno,major,nation,sdate);
end;

--删除存储过程
drop procedure pro_add;
