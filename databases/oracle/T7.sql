--ASCII :返回与指定的字符对应的十进制数;
select ascii('a'),ascii('A'),ascii('1') from dual;
--chr函数：给出整数,返回对应的字符;
--陈飞龙
select chr(46018) || chr(47049) || chr(49658) 姓名 from dual;

--曾志湖
select chr(54520) || chr(54974) || chr(47870) 姓名 from dual;

select asciistr('陈飞龙 hello') from dual;


--concat连接2个字符串
select concat('0796-','88888888')||'转18720865791' 曾总 from dual;
--initcap:返回字符串并将字符串的第一个字母变为大写; 
select initcap('smith') upp from dual;

--INSTR(C1,C2,I,J) 
/*
  在一个字符串中搜索指定的字符,返回发现指定的字符的位置; 
  C1 被搜索的字符串 
  C2 希望搜索的字符串 
  I 搜索的开始位置,默认为1 
  J 出现的位置,默认为1 
*/

select instr('oracle traning','ra',1,2) instring from dual;

--ABS :返回指定值的绝对值 
select abs(-1) from dual;

--REPLACE('string','s1','s2') string 希望被替换的字符或变量  s1 被替换的字符串 s2 要替换的字符串 
select replace('he love you','he','I') from dual;

--获取系统时间
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') from dual;

--lower函数：把字符串全部转换为小写字母；
--upper函数：把字符串全部转换为大写字母；
select lower('ADMINabde'), upper('admininstrATOR') from dual;


--确保字符串为10位，如果长度不足，在字符串的右边用*号补足10位;
select rpad('AAAAA','10','*'),lpad(rpad('AAAAA','10','*'),18,'#') from dual;



----数学函数
--abs去绝对值
select abs(-1),abs(100) from dual;
--三角函数sin,cos
select sin(3.14/2),cos(3.14)from dual;
--CEIL :返回大于或等于给出数字的最小整数
select ceil(8.19),ceil(-99.9) from dual;
--FLOOR:对给定的数字取整数
select floor(3.1415926),floor(0.999999999) from dual;

--LN 返回一个e位低数的数字的对数值

select ln(1),ln(2),ln(2.7182818) from dual;

--LOG(n1,n2) 返回一个以n1为底n2的对数
select log(10,100),log(2,16) from dual;
--mod取模
select mod(8,10),power(2,10) from dual;


--round :按照指定的精度进行舍入 
--trunc:按照指定精度处理
select round(55.5),round(-55.4),trunc(55.51234,2),trunc(-55.5678,-1) from dual;
--日期函数
--add_months :增加或减去月份 
--to_date函数：按照指定的格式把字符串转换为日期数据
select to_char(add_months(to_date('199912','yyyymm'),2),'yyyymm') from dual;
--add_months函数：增加或者减少月份
select to_char(add_months(to_date('1999-12-1','yyyy-mm-dd'),3),'yyyy-mon-day') from dual;

select to_char(add_months(sysdate,3),'yyyy-mm-dd') ,to_char(add_months(sysdate,-2),'yyyy-mm-dd') from dual;

--last_day :返回日期的最后一天 
select to_char(sysdate,'yyyy.mm.dd'),to_char((sysdate)+1,'yyyy.mm.dd') from dual;
--返回当前月份的最后一天
select last_day(sysdate),last_day(to_date('2017-2-1','yyyy-mm-dd')) from dual;
--months_between(date2,date1) :给出date2-date1的月份 
select months_between('19-12月-1999','19-3月-1999') mon_between from dual;

select trunc(months_between(sysdate,to_date('2008-1-1','yyyy-mm-dd'))) mon_between from dual;
--new_time(date,'this','that') :给出在this时区=other时区的日期和时间 
select to_char(sysdate,'yyyy.mm.dd hh24:mi:ss') bj_time,to_char(new_time(sysdate,'PDT','GMT'),'yyyy.mm.dd hh24:mi:ss') los_angles from dual;
--next_day(date,'day') :给出日期date和星期x之后计算下一个星期的日期 ,星期是从一1-7的数字，1代表星期天
select next_day(sysdate,'星期五') next_day from dual;
select next_day(sysdate,7) next_day from dual;
select next_day(sysdate,11) next_day from dual;--错误，只能是1-7或者星期天-星期六之间的数字

--日期转换为字符串
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as nowtime from dual;
--获取时间的年份
select to_char(sysdate,'yyyy')as nowyear from dual;
--获取时间的月
select to_char(sysdate,'mm')as nowMonth from dual;
--获取时间的日        
select to_char(sysdate,'dd')as nowDay from dual;  
--获取时间的时    
select to_char(sysdate,'hh24')as nowHour from dual;    
--获取时间的分
select to_char(sysdate,'mi')as nowMinute from dual;      
--获取时间的秒
select to_char(sysdate,'ss')as nowSecond from dual;   
--获取一年中的第几天
select to_char(sysdate,'ddd')as nowday from dual;

select to_date('2017-04-19 15:40:01','yyyy-mm-dd hh24:mi:ss') from dual;

--floor：两个日期之间的的天数
select floor(sysdate-to_date('2016-06-07',' yyyy-mm-dd')) from dual;


----语法：CONVERT( char, dest_char_set [ ,source_char_set] );　
--char的参数是要转换的值。它可以是任何的数据类型CHAR ， VARCHAR2 ， NCHAR ， NVARCHAR2 ， CLOB或NCLOB 。　
--dest_char_set参数是char转换的字符集的名称。
--source_char_set参数是char是存储在数据库中的字符集，其中的名称。.默认值是数据库的字符集。

select convert('中文','us7ascii','zhs16cgb231280') "conversion" from dual;

select convert('Ä Ê Í Ó Ø A B C D E ', 'US7ASCII', 'WE8ISO8859P1')from dual;
select convert('struts','we8hp','f7dec') "conversion" from dual;



--hextoraw 将一个十六进制构成的字符串转换为二进制
--rawtohex 将一个二进制构成的字符串转换为十六进制
select hextoraw('f0f'),rawtohex('135') from dual;

select hextoraw('abcdef') from dual;

--将字符串中的单字节字符转化为多字节字符
select length('高'),to_multi_byte('高') from dual;

--to_number 将给出的字符转换为数字 
select to_number('1999')+1000 year from dual;
--decode 相当于if ...elseif...elseif
select sid,serial#,username,command,decode(command,  0,'none', 2,'insert',  3, 'select',  6,'update',  7,'delete',  8,'drop',  'other') cmd 
from v$session where type!='background';
select sid,serial#,username,command from v$session where type!='background';


--empty_blob()和empty_clob() 这两个函数都是用来对大数据类型字段进行初始化操作的函数
--greatest 返回一组表达式中的最大值,即比较字符的编码大小. 
select greatest('AA','AB','AC','XY','WY') from dual;
--least 返回一组表达式中的最小值,即比较字符的编码大小. 
select least('AA','AB','AC','XY','WY') from dual;
--uid 返回标识当前用户的唯一整数 
--show user 
 
select username,user_id from dba_users where user_id=uid;
--user 返回当前用户的名字 
select user from dual;
--userenv 返回当前用户环境的信息,opt可以是: ENTRYID,SESSIONID,TERMINAL,ISDBA,LABLE,LANGUAGE,CLIENT_INFO,LANG,VSIZE 
--ISDBA 查看当前用户是否是DBA如果是则返回true

select userenv('SESSIONID'),userenv('ISDBA'),userenv('LANGUAGE'),VSIZE(user),userenv('ENTRYID'),userenv('lang') from dual;
select length('高'), vsize('高') from dual;

avg(distinct|all) 
--all表示对所有的值求平均值,distinct只对不同的值求平均值

select * from student;

--创建存储过程
create or replace procedure student_proc as p_name varchar2(20)
begin 
	select sname into p_name from student where sno=1001
	dbms_output.put_line(p_name)
end;

--调用存储过程
call student_proc();
--删除存储过程
drop procedure student_proc;



