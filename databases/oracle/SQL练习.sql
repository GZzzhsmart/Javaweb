--学生表
create table student(
  sno varchar2(10) primary key,
  sname varchar2(20),
  sage number(2),
  ssex varchar2(5)
);
--教师表
create table teacher(
  tno varchar2(10) primary key,
  tname varchar2(20)
);
--课程表
create table course(
  cno varchar2(10),
  cname varchar2(20),
  tno varchar2(20),
  constraint pk_course primary key (cno,tno)
);
--成绩表
create table sc(
  sno varchar2(10),
  cno varchar2(10),
  score number(4,2),
  constraint pk_sc primary key (sno,cno)
);

insert into student values ('s001','张三',23,'男');
insert into student values ('s002','李四',23,'男');
insert into student values ('s003','吴鹏',25,'男');
insert into student values ('s004','琴沁',20,'女');
insert into student values ('s005','王丽',20,'女');
insert into student values ('s006','李波',21,'男');
insert into student values ('s007','刘玉',21,'男');
insert into student values ('s008','萧蓉',21,'女');
insert into student values ('s009','陈萧晓',23,'女');
insert into student values ('s010','陈美',22,'女');
commit;

insert into teacher values ('t001', '刘阳');
insert into teacher values ('t002', '谌燕');
insert into teacher values ('t003', '胡明星');
commit;

insert into course values ('c001','J2SE','t002');
insert into course values ('c002','Java Web','t002');
insert into course values ('c003','SSH','t001');
insert into course values ('c004','Oracle','t001');
insert into course values ('c005','SQL SERVER 2005','t003');
insert into course values ('c006','C#','t003');
insert into course values ('c007','JavaScript','t002');
insert into course values ('c008','DIV+CSS','t001');
insert into course values ('c009','PHP','t003');
insert into course values ('c010','EJB3.0','t002');
commit;

insert into sc values ('s001','c001',78.9);
insert into sc values ('s002','c001',80.9);
insert into sc values ('s003','c001',81.9);
insert into sc values ('s004','c001',60.9);
insert into sc values ('s001','c002',82.9);
insert into sc values ('s002','c002',72.9);
insert into sc values ('s003','c002',81.9);
insert into sc values ('s001','c003','59');
commit;



select * from student;
select * from sc;
select * from course;
select * from teacher;


--1、查询“c001”课程比“c002”课程成绩高的所有学生的学号；
select a.* from (select * from sc a where a.cno='c001')a,(select * from sc b where b.cno='c002')b 
where a.sno=b.sno and a.score>b.score;

select * from sc a where a.cno='c001' and  exists(select * from sc b where b.cno='c002' 
and a.score>b.score and a.sno = b.sno);
--2、查询平均成绩大于60 分的同学的学号和平均成绩；
select sno,avg(score) from sc group by sno having avg(score)>60;
--3、查询所有同学的学号、姓名、选课数、总成绩；
select a.*,s.sname from (select sno,sum(score),count(cno) from sc group by sno) a ,student s 
where a.sno=s.sno;
--4、查询姓“刘”的老师的个数；
select count(*) from teacher where tname like'刘%';
--5、查询没学过“谌燕”老师课的同学的学号、姓名；
select * from student st where st.sno not in (select distinct sno from sc s join course c on s.cno=c.cno 
join teacher t on c.tno=t.tno where tname='谌燕');
--6、查询学过“c001”并且也学过编号“c002”课程的同学的学号、姓名；
select st.* from sc a join sc b on a.sno=b.sno join student st on st.sno=a.sno where a.cno='c001' 
and b.cno='c002' and st.sno=a.sno;
--7、查询学过“谌燕”老师所教的所有课的同学的学号、姓名；
select st.* from student st join sc s on st.sno=s.sno join course c on s.cno=c.cno
join teacher t on c.tno=t.tno where t.tname='谌燕';
--8、查询课程编号“c002”的成绩比课程编号“c001”课程低的所有同学的学号、姓名；
select * from student st join sc a on st.sno=a.sno
join sc b on st.sno=b.sno where a.cno='c002' and b.cno='c001' and a.score<b.score;
--9、查询所有课程成绩小于60 分的同学的学号、姓名；
select st.*,s.score from student st join sc s on st.sno=s.sno
join course c on s.cno=c.cno where s.score<60;
--10、查询没有学全所有课的同学的学号、姓名；
select * from student where sno in (select sno from(select stu.sno,c.cno from student stu cross join course c 
minus select sno,cno from sc));
--11、查询至少有一门课与学号为“s001”的同学所学相同的同学的学号和姓名；
select st.* from student st,(select distinct a.sno from(select * from sc)a,(select * from sc where sc.sno='s001')b
where a.cno=b.cno)h where st.sno=h.sno and st.sno<>'s001';
--12、查询至少学过学号为“s001”同学所有一门课的其他同学学号和姓名；
select * from sc left join student st on st.sno=sc.sno where sc.sno<>'s001'
and sc.cno in (select cno from sc where sno='s001');
--13、把“SC”表中“谌燕”老师教的课的成绩都更改为此课程的平均成绩；
update sc c set score=(select avg(c.score) from course a,teacher b 
where a.tno=b.tno and b.tname='谌燕'
and a.cno=c.cno group by c.cno)where cno in(select
cno from course a,teacher b where a.tno=b.tno and b.tname='谌燕');
--14、查询和“s001”号的同学学习的课程完全相同的其他同学学号和姓名；
select * from sc where sno<>'s001' minus (select * from sc minus select * from
 sc where sno='s001');
--15、删除学习“谌燕”老师课的SC 表记录；
delete from sc where sc.cno in (select cno from course c left join teacher t on c.tno=t.tno 
where t.tname='谌燕');
--16、向SC 表中插入一些记录，这些记录要求符合以下条件：没有上过编号“c002”课程的同学学号、“c002”号课的平均成绩；
insert into sc(sno,cno,score) select distinct st.sno,sc.cno,(select avg(score) from sc where cno='c002')
from student st,sc where not exists(select * from sc where cno='c002' and sc.sno=st.sno)and sc.cno='c002';
--17、查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分
select cno,max(score),min(score) from sc group by cno;
--18、按各科平均成绩从低到高和及格率的百分数从高到低顺序
select cno,avg(score),sum(case when score>=60 then 1 else 0 end)/count(*) as 及格率
from sc group by cno
order by avg(score)
--19、查询不同老师所教不同课程平均分从高到低显示
select max(t.tno),max(t.tname),max(c.cno),max(c.cname),c.cno,avg(score) from sc , course c,teacher t
where sc.cno=c.cno and c.tno=t.tno
group by c.cno
order by avg(score) desc;
--20、统计列印各科成绩,各分数段人数:课程ID,课程名称,[100-85],[85-70],[70-60],[ <60]
select sc.cno,c.cname,
sum(case when score between 85 and 100 then 1 else 0 end) AS "[100-85]",
sum(case when score between 70 and 85 then 1 else 0 end) AS "[85-70]",
sum(case when score between 60 and 70 then 1 else 0 end) AS "[70-60]",
sum(case when score <60 then 1 else 0 end) AS "[<60]"
from sc,course c
where sc.cno=c.cno
group by sc.cno ,c.cname;
--21、查询各科成绩前三名的记录:(不考虑成绩并列情况)
select * from
(select sno,cno,score,row_number()over(partition by cno order by score desc) rn from sc)
where rn<4;
--22、查询每门课程被选修的学生数
select cno,count(sno)from sc group by cno;
--23、查询出只选修了一门课程的全部学生的学号和姓名
select sc.sno,st.sname,count(cno) from student st
left join sc
on sc.sno=st.sno
group by st.sname,sc.sno having count(cno)=1;
--24、查询男生、女生人数
select ssex,count(*) from student group by ssex;
--25、查询姓“张”的学生名单
select * from student where sname like '张%';
--26、查询同名同性学生名单，并统计同名人数
select sname,count(*) from student group by sname having count(*)>1;
--27、1981 年出生的学生名单(注：Student 表中Sage 列的类型是number)
select sno,sname,sage,ssex from student t where to_char(sysdate,'yyyy')-sage=1988;
--28、查询每门课程的平均成绩，结果按平均成绩升序排列，平均成绩相同时，按课程号降序排列
select cno,avg(score) from sc group by cno order by avg(score)asc,cno desc;
--29、查询平均成绩大于85 的所有学生的学号、姓名和平均成绩
select st.sno,st.sname,avg(score) from student st left join sc on sc.sno=st.sno
group by st.sno,st.sname having avg(score)>85;
--30、查询课程名称为“数据库”，且分数低于60 的学生姓名和分数
select sname,score from student st,sc,course c
where st.sno=sc.sno and sc.cno=c.cno and c.cname='Oracle' and sc.score<60;
--31、查询所有学生的选课情况；
select st.sno,st.sname,c.cname from student st,sc,course c
where sc.sno=st.sno and sc.cno=c.cno;
--32、查询任何一门课程成绩在70 分以上的姓名、课程名称和分数；
select st.sname,c.cname,sc.score from student st,sc,course c
where sc.sno=st.sno and sc.cno=c.cno and sc.score>70;
--33、查询不及格的课程，并按课程号从大到小排列
select sc.sno,c.cname,sc.score from sc,course c
where sc.cno=c.cno and sc.score<60 order by sc.cno desc;
--34、查询课程编号为c001 且课程成绩在80 分以上的学生的学号和姓名；
select st.sno,st.sname,sc.score from sc,student st
where sc.sno=st.sno and cno='c001' and score>80;
--35、求选了课程的学生人数
select count(distinct sno) from sc;
--36、查询选修“谌燕”老师所授课程的学生中，成绩最高的学生姓名及其成绩
select st.sname,score from student st,sc ,course c,teacher t
where
st.sno=sc.sno and sc.cno=c.cno and c.tno=t.tno
and t.tname='谌燕' and sc.score=
(select max(score)from sc where sc.cno=c.cno);
--37、查询各个课程及相应的选修人数
select cno,count(sno) from sc group by cno;
--38、查询不同课程成绩相同的学生的学号、课程号、学生成绩
select a.* from sc a,sc b where a.score=b.score and a.cno<>b.cno;
--39、查询每门功课成绩最好的前两名
select * from (
select sno,cno,score,row_number()over(partition by cno order by score desc) my_rn from sc t
)where my_rn<=2;
--40、统计每门课程的学生选修人数（超过10 人的课程才统计）。要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列
select cno,count(sno) from sc group by cno
having count(sno)>10
order by count(sno) desc,cno asc;
--41、检索至少选修两门课程的学生学号
select sno from sc group by sno having count(cno)>1;
--42、查询全部学生都选修的课程的课程号和课程名
select cno,cname from course c
where c.cno in
(select cno from sc group by cno);
--43、查询没学过“谌燕”老师讲授的任一门课程的学生姓名
select st.sname from student st
where st.sno not in
(select distinct sc.sno from sc,course c,teacher t
where sc.cno=c.cno and c.tno=t.tno and t.tname='谌燕');
--44、查询两门以上不及格课程的同学的学号及其平均成绩
select sno,avg(score)from sc
where sno in
(select sno from sc where sc.score<60
group by sno having count(sno)>1
) group by sno;
--45、检索“c004”课程分数小于60，按分数降序排列的同学学号
select sno from sc where cno='c004' and score<90 order by score desc;
--46、删除“s002”同学的“c001”课程的成绩
delete from sc where sno='s002' and cno='c001';
select * from sc;
