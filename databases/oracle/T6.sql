--查看表空间
select * from v$tablespace;
--查看数据文件
select * from v$datafile;
--查看日志文件
select * from v$logfile;
--查看控制文件
select * from v$controlfile;
--创建永久表空间
create tablespace "USERS02" datafile 'D:\oracle\product\10.2.0\oradata\orcl\users02.DBF' size 5M
reuse autoextend on next 512k maxsize 10M;

--创建临时表空间
create temporary tablespace "TEMP02"
tempfile 'D:\oracle\product\10.2.0\oradata\orcl\TEMP02.DBF' size 5M
extent management local uniform size 1M;
--创建还原表空间
create undo tablespace "UNDO02"
datafile 'D:\oracle\product\10.2.0\oradata\orcl\UNDO02.DBF' size 5M;

--系统表空间，临时表空间，还原表空间不能更改为离线状态

--更改表为离线状态
alter tablespace "USERS02" offline normal;
--更改表为在线状态
alter tablespace "USERS02" online;
--把user01表空间设置为只读状态
alter tablespace "USERS" read only;
--把user01表空间设置为可读写状态
alter tablespace "USERS" read write;

--删除表空间
drop tablespace "TEMP02" including contents;
drop tablespace "USERS02" including contents;
--删除表空间和数据文件
drop tablespace "TEMP02" including contents and datafiles;
--改变数据文件的大小
alter database datafile 'D:\oracle\product\10.2.0\oradata\orcl\USERS02.DBF' resize 5M;
--自动
alter database datafile 'D:\oracle\product\10.2.0\oradata\orcl\USERS02.DBF' autoextend on;
--在表空间添加数据文件
alter tablespace "USERS02" add datafile  'D:\oracle\product\10.2.0\oradata\orcl\USERS03.DBF' size 5M;

--对表空间的数据文件重命名
alter tablespace "USERS02" 
rename datafile  'D:\oracle\product\10.2.0\oradata\orcl\USERS03.DBF' to 'D:\oracle\product\10.2.0\oradata\orcl\USERS04.DBF'
alter tablespace "USERS02" online;

drop tablespace "USERS02" including contents and datafiles;


--创建用户
create user test identified by test 
--修改密码
alter user test identified by test;
--删除用户
drop user test;
--授权
grant create session to test;
grant create user to test with admin option;
grant update(age,sex) on SYS.student to test;
--授与test最高权限
grant dba to test;
--撤销权限
revoke create table from test;
--查看当前用户的角色
select * from user_role_privs;
--查看当前用户的系统权限和表一级的权限
select * from user_sys_privs;
select * from user_tab_privs;

select * from dba_sys_privs;
select * from user_sys_privs;

select * from dba_tablespaces;
select * from dba_data_files;
select * from dba_temp_files;
--查看用户及默认表空间
select * from dba_users;


 alter user test account unlock;

 grant create session to test
 

 grant create table to test;

 grant select any table to test;

 grant insert any table to test;

--陈飞龙
select chr(46018) || chr(47049) || chr(49658) 姓名 from dual;

--曾志湖
select chr(54520) || chr(54974) || chr(47870) 姓名 from dual;





--导入导出数据

--导入sys用户的student，course表数据
exp scott/123456@study tables=(student,course) file=sys_back_tab.dmp
--导入指定的student表数据
imp scott/123456@study file=sys_back_tab.dmp fromuser =sys touser=sys tables=(student) ignore=y;
--导出完整数据库
exp system/123456@study file=study_full.dmp full=y;
--导入完整数据库
imp system/123456@study file=study_full.dmp ignore=y full=y;


select * from student;

select * from class;
insert into class values(5,'宏图16春预科班');
insert into class values(6,'宏图16秋预科班');



