select * from student;
select * from score;
select * from course;

select * from student order by id;

--游标的使用步骤：声明游标，打开游标，提取游标，关闭游标
declare
     v_id varchar(20);
     v_name varchar(20);
     cursor c_stud is select id,name from student order by id;
begin
     open c_stud;
     fetch c_stud into v_id,v_name;
     dbms_output.put_line('Id='|| v_id || ';v_name='|| v_name);
     close c_stud;
end;


--定义字段变量
declare
     v_id student.id%type;
     v_name student.name%type;
     cursor c_stud is select id,name from student order by id;
begin
     open c_stud;
     fetch c_stud into v_id,v_name;
     dbms_output.put_line('Id='|| v_id || ';v_name='|| v_name);
     close c_stud;
end;


--定义记录变量

declare 
   v_stud student%ROWTYPE;
    cursor c_stud is select * from student  order by id;
begin
    open c_stud;
    fetch c_stud into v_stud;
    dbms_output.put_line('Id='||v_stud.id||';name='||v_stud.name);
    close c_stud;
end;

--用loop循环读取游标的记录
/*
    %ROWCOUNT    :游标中的记录数
    %FOUND       :要处理的记录是否提取到了，提取到了就返回true;
    %NOTFOUND    :要处理的记录是否提取到了，没有提取到就返回true;
    %ISOPEN      :判断游标是否已经打开
*/

declare 
   v_stud student%ROWTYPE;
    cursor c_stud is select * from student  order by id;
begin
    open c_stud;
    loop
      fetch c_stud into v_stud;
      EXIT WHEN c_stud%NOTFOUND;
      dbms_output.put_line('Id='||v_stud.id||';name='||v_stud.name);
    end loop;
    close c_stud;
end;
---------------------
declare 
   v_stud student%ROWTYPE;
    cursor c_stud is select * from student  order by id;
begin
    open c_stud;
    fetch c_stud into v_stud;
    loop
      EXIT WHEN c_stud%NOTFOUND;
      dbms_output.put_line('Id='||v_stud.id||';name='||v_stud.name);
      fetch c_stud into v_stud;
    end loop;
    close c_stud;
end;


--游标与for循环结合使用
declare
    v_stud student%rowtype;
    cursor c_stud is select * from student order by id;
begin
    for v_stud in c_stud loop
         dbms_output.put_line('Id='||v_stud.id||';name='||v_stud.name);
    end loop;
end;

--游标与while循环结合使用


declare
    v_stud student%rowtype;
    cursor c_stud is select * from student order by id;
    v_num number(2):=&input_rows;
begin
    open c_stud;
    fetch c_stud into v_stud;
    while c_stud%found and c_stud%rowcount<=v_num loop
          dbms_output.put_line('id='||v_stud.id||';name='||v_stud.name);
          fetch c_stud into v_stud;
    end loop;
end;


--定义游标
declare
    v_stud student%rowtype;
begin
    for v_stud in(select * from student order by id) loop
        dbms_output.put_line('id='||v_stud.id||';name='||v_stud.name);
    end loop;
end;

--查询学生的成绩，html+5,sql2005+10,java+15,jsp-5,oracle -10
--成绩表
select * from score;
--课程表
select * from course;
--学生表
select * from student;

declare 
       v_courseid course.courseid%type;
       v_grade score.score%type;
       v_name student.name%type;
       v_studid student.id%type;
       cursor v_score is select c.id,c.score,c.courseid,s.name from score c inner join student s on c.id=s.id;      
begin  
       open v_score;
       loop
              fetch v_score into v_studid,v_grade,v_courseid,v_name;
              exit when v_score%notfound;
              dbms_output.put_line('修改之前：id='||v_studid||',name='||v_name||',score='||v_grade);             
              if v_courseid=1 then
                 v_grade := v_grade+5;
                 update score set score=v_grade where courseid=v_courseid and id=v_studid ;
              elsif v_courseid=2 then
                     v_grade := v_grade+10;
                    update score set score=v_grade where courseid=v_courseid and id=v_studid ;
              elsif v_courseid=3 then
                     v_grade := v_grade+15;
                    update score set score=v_grade where courseid=v_courseid and id=v_studid ;
              elsif v_courseid=4 then
                     v_grade := v_grade-5;
                    update score set score=v_grade where courseid=v_courseid and id=v_studid ;
              elsif v_courseid=5 then
                     v_grade := v_grade-10;
                    update score set score=v_grade where courseid=v_courseid and id=v_studid ;
              end if; 
              commit;
              dbms_output.put_line('修改之后：id='||v_studid||',name='||v_name||',score='||v_grade);             
       end loop;
       close v_score;
end;



declare cursor c_addscore is select * from score for update;
  s_stud c_addscore%rowtype;
begin
  for s_stud in c_addscore loop
		if(s_stud.cno='c001') then
			update score set score=(score+5) where current of c_addscore;
		elsif (s_stud.cno='c002') then
			update score set score=(score+10) where current of c_addscore;
		elsif (s_stud.cno='c003') then
			update score set score=(score+15) where current of c_addscore;
		else 
			update score set score=(score-5) where current of c_addscore;
		end if;
	end loop;
end; 


