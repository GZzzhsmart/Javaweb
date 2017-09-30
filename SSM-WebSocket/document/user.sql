#创建用户表
CREATE TABLE users(
  id INT NOT NULL PRIMARY KEY auto_increment comment'用户id',
  name VARCHAR(100) comment'用户名',
  password VARCHAR(100) comment'用户密码'
)ENGINE = innoDB CHARSET = utf8;
