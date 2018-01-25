/*
Navicat MySQL Data Transfer

Source Server         : MySQL连接
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : mysqlstudy

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-25 11:23:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `loginAcc` varchar(50) DEFAULT NULL COMMENT '登录账户',
  `loginPassword` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `serverHost` varchar(100) DEFAULT NULL COMMENT '主机IP地址',
  `serverPort` int(11) DEFAULT NULL COMMENT '端口号',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
