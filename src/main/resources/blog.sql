/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-11-11 15:48:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` char(30) DEFAULT NULL COMMENT '文章标题',
  `content` text COMMENT '文章内容',
  `creat_date` int(11) DEFAULT NULL COMMENT '创建时间',
  `user_id` int(11) DEFAULT NULL COMMENT '作者ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '11', '11', '1475230775', '1');
INSERT INTO `article` VALUES ('2', '322', '22', '1475230784', '1');

-- ----------------------------
-- Table structure for b_blog
-- ----------------------------
DROP TABLE IF EXISTS `b_blog`;
CREATE TABLE `b_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `des` varchar(500) DEFAULT NULL COMMENT '简介',
  `context` longtext COMMENT '内容',
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '作者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='博客表';

-- ----------------------------
-- Records of b_blog
-- ----------------------------
INSERT INTO `b_blog` VALUES ('1', '9.24小韩要闻5', '小韩关于调戏妹子的几点问题5', '问题1：。。。。。。问题2.。。。。。', '4');

-- ----------------------------
-- Table structure for b_role
-- ----------------------------
DROP TABLE IF EXISTS `b_role`;
CREATE TABLE `b_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of b_role
-- ----------------------------

-- ----------------------------
-- Table structure for b_user
-- ----------------------------
DROP TABLE IF EXISTS `b_user`;
CREATE TABLE `b_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `level` int(10) DEFAULT NULL COMMENT '等级',
  `des` varchar(200) DEFAULT NULL COMMENT '简介',
  `tel` varchar(200) DEFAULT NULL COMMENT '电话',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of b_user
-- ----------------------------
INSERT INTO `b_user` VALUES ('1', 'aa', '1', '2', '2', '21', '1123');
INSERT INTO `b_user` VALUES ('3', '张磊', '123123', '1', '中国好声音第四季张磊', null, '浙江杭州');

-- ----------------------------
-- Table structure for b_user_blog
-- ----------------------------
DROP TABLE IF EXISTS `b_user_blog`;
CREATE TABLE `b_user_blog` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userId` int(20) DEFAULT NULL,
  `roleId` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-博客对应表';

-- ----------------------------
-- Records of b_user_blog
-- ----------------------------

-- ----------------------------
-- Table structure for b_user_role
-- ----------------------------
DROP TABLE IF EXISTS `b_user_role`;
CREATE TABLE `b_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色对应表';

-- ----------------------------
-- Records of b_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(10) DEFAULT NULL COMMENT '管理员用户名',
  `password` char(32) DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123');
