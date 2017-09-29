--oracle常用函数的用法

--(获取当前时间)日期转换为字符串
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss')as nowTime from dual;
--获取时间的年
select to_char(sysdate,'yyyy')as nowYear from dual;
--获取时间的月
select to_char(sysdate,'mm') as nowMonth from dual;
--获取时间的日
select to_char(sysdate,'dd')as nowDay from dual;
--获取时间的时
select to_char(sysdate,'hh24')as nowHour from dual;
--获取时间的分
select to_char(sysdate,'mi')as nowMinute from dual;
--获取时间的秒
select to_char(sysdate,'ss')as nowSecond from dual;


--按年截尾
select TRUNC(TO_DATE('2017-04-13 10：15','yyyy-mm-dd hh:mi'),'yyyy') from dual;
--按月截尾
select TRUNC(TO_DATE('2017-04-13 10:15','yyyy-mm-dd hh:mi'),'mm') from dual;
--按日截尾
select TRUNC(TO_DATE('2017-04-13 10:15','yyyy-mm-dd hh:mi'),'dd') from dual;
--按时截尾
select TRUNC(TO_DATE('2017-04-13 10:15','yyyy-mm-dd hh:mi'),'hh') from dual;
--按分截尾
select TRUNC(TO_DATE('2017-04-13 10:15','yyyy-mm-dd hh:mi'),'mi') from dual;

--求某天是星期几
select to_char(to_date('2017-04-13','yyyy-mm-dd'),'day') from dual;
--星期一      
select to_char(to_date('2017-04-13','yyyy-mm-dd'),'day','NLS_DATE_LANGUAGE = American') from dual;      
--两个日期之间的天数
select floor(sysdate-to_date('20160607','yyyymmdd')) from dual;

--处理月份天数不定的办法
select to_char(add_months(last_day(sysdate) +1, -2), 'yyyymmdd'),last_day(sysdate) from dual;
--找出今年的天数
select add_months(trunc(sysdate,'year'),12)-trunc(sysdate,'year') from dual;
--不同时区的时间处理
select to_char( NEW_TIME( sysdate, 'GMT','EST'), 'dd/mm/yyyy hh:mi:ss') ,sysdate from dual; 
--5秒钟一个间隔,sssss表示5位秒数
select TO_DATE(FLOOR(TO_CHAR(sysdate,'SSSSS')/300) * 300,'SSSSS') ,TO_CHAR(sysdate,'SSSSS') from dual 

--一年的第几天
select to_char(sysdate,'ddd'),sysdate from dual;
--计算小时，分，秒,毫秒
 select      
     Days,      
     A,      
     TRUNC(A*24) Hours,      
     TRUNC(A*24*60 - 60*TRUNC(A*24)) Minutes,      
     TRUNC(A*24*60*60 - 60*TRUNC(A*24*60)) Seconds,      
     TRUNC(A*24*60*60*100 - 100*TRUNC(A*24*60*60)) mSeconds      
    from      
    (      
     select      
     trunc(sysdate) Days,      
     sysdate - trunc(sysdate) A      
     from dual      
   )    
   
--查找月的第一天,最后一天
 SELECT Trunc(Trunc(SYSDATE, 'MONTH') - 1, 'MONTH') First_Day_Last_Month,
   Trunc(SYSDATE, 'MONTH') - 1 / 86400 Last_Day_Last_Month,
   Trunc(SYSDATE, 'MONTH') First_Day_Cur_Month,
   LAST_DAY(Trunc(SYSDATE, 'MONTH')) + 1 - 1 / 86400 Last_Day_Cur_Month
FROM dual;
   
--1.计算时间差
--注:oracle时间差是以天数为单位,所以换算成年月,日
-- 时间差-年
select floor(to_number(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))/365) as spanYears from dual;
--时间差-月
select ceil(months_between(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))) as spanMonths from dual;   
-- 时间差-天     
select floor(to_number(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))) as spanDays from dual;            
-- 时间差-时
select floor(to_number(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))*24) as spanHours from dual;        
--时间差-分
select floor(to_number(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))*24*60) as spanMinutes from dual;    
--时间差-秒
select floor(to_number(sysdate-to_date('2007-11-02 15:55:03','yyyy-mm-dd hh24:mi:ss'))*24*60*60) as spanSeconds from dual; 

--2.更新时间
--注:oracle时间加减是以天数为单位,设改变量为n,所以换算成年月,日
-- 改变时间-年
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),to_char(sysdate+n*365,'yyyy-mm-dd hh24:mi:ss') as newTime from dual;     
--改变时间-月  
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),add_months(sysdate,n) as newTime from dual;                     
--改变时间-日            
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),to_char(sysdate+n,'yyyy-mm-dd hh24:mi:ss') as newTime from dual;       
-- 改变时间-时     
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),to_char(sysdate+n/24,'yyyy-mm-dd hh24:mi:ss') as newTime from dual;      
-- 改变时间-分  
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),to_char(sysdate+n/24/60,'yyyy-mm-dd hh24:mi:ss') as newTime from dual;     
--改变时间-秒
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),to_char(sysdate+n/24/60/60,'yyyy-mm-dd hh24:mi:ss') as newTime from dual;   

----字符函数的用法啊

--字符串的截取
select substr('abcdefg',1,3) from dual;
--查找子串的位置
select instr('abcdefg','fg') from dual;
--字符串连接
select 'hello' || 'hello world' from dual;

--返回字母的ASCII值
select ascii('a') from dual;
--返回ASCII值对应的字母
select chr(122) from dual;
--计算字符串的长度
select length('abcdefg') from dual;

----数字函数
--取整函数(ceil 向上取整,floor向下取整)
select ceil(66.6)N1,floor(66.6)N2 from dual;
--取幂(power) 和 求平方根(sqrt)
select power(3,2) N1,sqrt(9) N2 from dual;
--求余
select mod(9,5) from dual;



