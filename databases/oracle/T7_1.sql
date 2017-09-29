--输入函数
begin
    dbms_output.put_line('Hello World!');
end;
--结构控制语句
declare
    v_str varchar2(50);
    vboolean boolean:=false;
    v_grade number(5,2);
begin
    if vboolean then
      v_str:='条件为真，显示该语句';
      dbms_output.put_line(v_str);
    else
      dbms_output.put_line('条件为假');
    end if;
    
    v_grade:=69;
    if v_grade>=90 then
       dbms_output.put_line('成绩优秀');
    else if v_grade>=80 and v_grade<90 then
       dbms_output.put_line('成绩优良');
    else if v_grade>=60 and v_grade<80 then
       dbms_output.put_line('成绩合格');
    else
       dbms_output.put_line('不及格');
    end if;
end;




--如果温度大于30℃，则显示“温度偏高”,输入并执行以下程序
set serveroutput on;
declare 
  v_temprature number(5):=32;
  v_result boolean:=false;
 begin
  v_result:=v_temprature>30;
    if v_result then
       dbms_output.put_line('温度'|| v_temprature ||'度,偏高');
    end if;
 end;




--根据性别，显示尊称,输入并执行以下程序

 declare
     v_sex varchar2(2);
     v_title varchar2(10);
 begin
     v_sex:='男';
     if v_sex='男' then
        v_title:='先生';
     else
        v_title:='女士'; 
     end if;
     dbms_output.put_line(v_title || '您好！');
 end;
 
 select * from emp;

--使用CASE结构实现职务转换,输入并执行程序
declare 
     v_job varchar2(10);
begin
     select job into v_job from emp where empno=7788;
     case v_job
     when 'PRESIDENT' then
          dbms_output.put_line('雇员职务：总裁');
     when 'MANAGER' then
          dbms_output.put_line('雇员职务：经理');
     when 'SALESMAN' then
          dbms_output.put_line('雇员职务：推销员');
     when 'ANALYST' then
          dbms_output.put_line('雇员职务：系统分析员');
     when 'CLERK' then
          dbms_output.put_line('雇员职务：职员');
     else
          dbms_output.put_line('雇员职务：未知');
     end case;
end;


 declare
     v_job varchar(30);
     v_result varchar(50);
  begin
     select job into v_job from emp where empno=7839;
     v_result := case v_job
          when 'PRESIDENT' then '职务：总裁'
          when 'MANAGER' then '职务：经理'
          when 'SALESMAN' then '职务：销售员'
          when 'CLERK' then '职务：职员'
          else '职务：不知道'
          end;   
    dbms_output.put_line(v_result);            
  end;
  
  
  --loop循环(求1至100的和)
  declare
       v_total number(20):=0;
       v_num number(3):=1;
       begin
           loop
               v_total:=v_total+v_num;
               v_num:=v_num+1;
               --退出条件
               exit when v_num>100;
           end loop;
           dbms_output.put_line('v_total=' || v_total);  
       end;
    
--for 循环（求1至100的和）
declare
      v_total number(20):=0;
      v_num number(3):=1;
      begin
            for v_num in 1..100 loop
                v_total:=v_total+v_num;
            end loop;
            dbms_output.put_line('v_total=' || v_total);
      end;

--打印图形
  declare 
    v_num number(3) :=1;
  begin
    for v_num in 1..8 loop
         dbms_output.put_line(to_char(v_num)||rpad('*',v_num,'*'));
    end loop;
  end;
  
  
--while循环语句
declare
    v_total number(20):=0;
    v_num number(3):=1;
begin
    while v_num<=100 loop
          v_total:=v_total+v_num;
          v_num:=v_num+1;
    end loop;
    dbms_output.put_line('v_total='|| v_total);
end;

--打印九九乘法表
set serveroutput on;

declare
    v_i number(2):=1;
    v_j number(2):=1;
begin
    for v_i in 1..9 loop
        for v_j in 1..v_i loop
            dbms_output.put(v_j||'*'||v_i||'='||(v_i*v_j)||'    ');
        end loop;
        --换行
        dbms_output.new_line(); 
    end loop;
end;

select * from student;

declare 
  --定义普通变量
  v_name varchar(20);
  --定义变量的同时可以给变量赋值
  v_age number(2) :=20;
  --根据表的字段来定义变量，使变量的类型和表中的字段类型对应
  v_studid student.id%TYPE :=1003;
  --定义记录变量，
  r_stud student%ROWTYPE;
  --定义常量
  v_pi CONSTANT NUMBER(6,5) :=3.14159;
  --定义table类型的类型（自定义的数据类型）,动态数组类型
  type table_type is table of varchar(20) index by binary_integer;
  --定义变量
  arr table_type;
begin
  arr(1):='one';
  arr(2):='two';
  arr(3):='three';
  arr(4):='four';
 DBMS_OUTPUT.put_line('arr(2)='||arr(2));
  
 DBMS_OUTPUT.put_line('v_pi='||v_pi);
  v_name := '张三';
  DBMS_OUTPUT.put_line('id='||v_studid||';name='||v_name || ';age'|| v_age);
  --给记录变量赋值
  select * into r_stud from student where id=1007;
  --使用记录变量 
  DBMS_OUTPUT.put_line('id='||r_stud.id||';name='||r_stud.name || ';age'|| r_stud.age);
  --把查询结果保存到变量中
  select id,name,age into v_studid,v_name,v_age from student where id=1002;
  DBMS_OUTPUT.put_line('id='||v_studid||';name='||v_name || ';age'|| v_age);
end; 




--使用case的表达式结构

declare
    v_grade varchar2(10);
    v_result varchar2(10);
    begin
        v_grade:='B';
        v_result:=case v_grade
        when 'A' then '优'
        when 'B' then '良'
        when 'C' then '中'
        when 'D' then '差'
        else '未知'
    end;
    dbms_output.put_line('评价等级:'||v_result);
end;



--使用case的搜索结构
select * from emp;

declare
    v_sal number(5);
begin
    select sal into v_sal from emp where empno=7788;
    case
        when v_sal>=3000 then
             dbms_output.put_line('工资等级：高');
        when v_sal>=1500 then
             dbms_output.put_line('工资等级：中');
        else
             dbms_output.put_line('工资等级：低');
        end case;
end;


--求：1２+3２+5２+...+15２ 的值
declare
    v_total number(5):=0;
    v_count number(5):=1;
begin
    loop
        v_total:=v_total+v_count**2;
        exit when v_count=15;
        v_count:=v_count+2;
    end loop;
    dbms_output.put_line('v_total='||v_total);
end;


