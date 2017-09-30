select * from stu;

create table stu
(
  stuId varchar(40) primary key not null,
  stuName varchar(20) ,
  stuAge int,
  stuMajor varchar(20),
  birthday datetime 
);

select * from t_admin;

create table t_admin(
  id INT PRIMARY KEY auto_increment,
  phone VARCHAR(11),
  password VARCHAR(50),
  gender tinyint,
  address VARCHAR(200)
) ENGINE = InnoDB DEFAULT charset utf8;

create table t_user(
  id int primary key auto_increment,
  name varchar(20),
  password varchar(50)
) ENGINE = InnoDB DEFAULT charset utf8;

create table t_product(
  id int primary key auto_increment,
  title varchar(50),
  price decimal
) ENGINE = InnoDB DEFAULT charset utf8;

create table t_order(
 id int primary key auto_increment,
 user_id int,
 order_time datetime
) ENGINE = InnoDB DEFAULT charset utf8;

create table t_order_item(
  id int primary key auto_increment,
  order_id int,
  product_id int,
  quantity int,
  unit_price decimal,
  total_cost decimal
) ENGINE = InnoDB DEFAULT charset utf8;


create table t_player(
  id int primary key auto_increment,
  realname varchar(10),
  gendr tinyint
) ENGINE = InnoDB DEFAULT charset utf8;

create table t_hero(
  id int primary key auto_increment,
  name varchar(10)
) ENGINE = InnoDB DEFAULT charset utf8;

create table t_player_hero(
  id int PRIMARY key auto_increment,
  player_id int,
  hero_id int
) ENGINE = InnoDB DEFAULT charset utf8;

create table t_prop(
  id int primary key auto_increment,
  name varchar(10),
  price decimal
) ENGINE = InnoDB DEFAULT charset utf8;

create table t_trade(
  id int primary key auto_increment,
  player_id int,
  trade_time datetime,
  spent decimal
) ENGINE = InnoDB DEFAULT charset utf8;

create table t_trade_item(
  id int primary key auto_increment,
  trade_id int,
  prop_id int,
  quantity int
) ENGINE = InnoDB DEFAULT charset utf8;


#王者农药
#1、玩家系统
#2、会员系统
#3、道具系统
#4、交易系统
#5、积分系统
#6、健康系统
#7、举报系统

#玩家表
create table user
(
   userid int primary key auto_increment,
   username varchar(20) not null,
   password varchar(20),
   email varchar(20) not null,
   phone varchar(11),
   heroid int,
   propid int
)ENGINE = InnoDB DEFAULT charset utf8;
#英雄表（玩家选择英雄）
create table hero
(
  heroid int primary key auto_increment,
  heroname varchar(20)
)ENGINE = InnoDB DEFAULT charset utf8;
#道具表（玩家购买道具）
create table prop
(
  propid int primary key auto_increment,
  prorname varchar(20),
  price int
)ENGINE = InnoDB DEFAULT charset utf8;
#交易表（玩家购买记录）
create table deal
(
  deal_id int primary key auto_increment,
  userid int,
  created_time datetime
)ENGINE = InnoDB DEFAULT charset utf8;



