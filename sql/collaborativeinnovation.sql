/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : collaborativeinnovation

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-06 19:55:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `summary` varchar(300) DEFAULT NULL,
  `content` longtext,
  `pageview` int(11) DEFAULT NULL,
  `reviewcount` int(11) DEFAULT NULL,
  `publishtime` datetime DEFAULT NULL,
  `articletypeid` int(11) DEFAULT NULL,
  `author` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`articleid`),
  KEY `FKoxinmlayadxeb1p9hv0rsjom2` (`articletypeid`),
  KEY `FKm11912mnyrhmj05gu02p0kbmx` (`author`),
  CONSTRAINT `FKm11912mnyrhmj05gu02p0kbmx` FOREIGN KEY (`author`) REFERENCES `cuser` (`username`),
  CONSTRAINT `FKoxinmlayadxeb1p9hv0rsjom2` FOREIGN KEY (`articletypeid`) REFERENCES `articletype` (`articletypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '标题一', '摘要一', '内容一', '27', '2', '2018-05-04 17:56:13', '1', 'user01');
INSERT INTO `article` VALUES ('2', '标题二', '摘要二', '内容二', '24', '1', '2018-05-15 17:58:06', '2', 'user01');
INSERT INTO `article` VALUES ('3', '标题三', '摘要三', '内容三', '21', '0', '2018-05-15 17:58:06', '3', 'user01');
INSERT INTO `article` VALUES ('4', '标题四', '摘要四', '内容四', '20', '0', '2018-05-04 17:58:06', '4', 'user01');
INSERT INTO `article` VALUES ('5', '标题五', '摘要五', '内容五', '16', '0', '2018-05-01 17:50:06', '2', 'user01');

-- ----------------------------
-- Table structure for articletype
-- ----------------------------
DROP TABLE IF EXISTS `articletype`;
CREATE TABLE `articletype` (
  `articletypeid` int(11) NOT NULL,
  `articletypename` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`articletypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of articletype
-- ----------------------------
INSERT INTO `articletype` VALUES ('1', '分类一');
INSERT INTO `articletype` VALUES ('2', '分类二');
INSERT INTO `articletype` VALUES ('3', '分类三');
INSERT INTO `articletype` VALUES ('4', '分类四');

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `username` varchar(255) DEFAULT NULL,
  `articleid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorite
-- ----------------------------

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `replyid` int(11) NOT NULL AUTO_INCREMENT,
  `replycontent` longtext,
  `replytime` datetime DEFAULT NULL,
  `username` varchar(16) DEFAULT NULL,
  `articleid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`replyid`),
  KEY `FKp9b339rq1vtd9sfau6fawfti0` (`username`),
  CONSTRAINT `FKp9b339rq1vtd9sfau6fawfti0` FOREIGN KEY (`username`) REFERENCES `cuser` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '回复内容1', '2018-05-04 11:33:09', 'user02', '1');
INSERT INTO `reply` VALUES ('2', '回复内容2', '2018-05-06 11:25:23', 'user03', '1');
INSERT INTO `reply` VALUES ('5', 'fsdfsd', '2018-05-06 13:23:25', 'user04', '2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL,
  `rolename` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0', 'admin');
INSERT INTO `role` VALUES ('1', 'enterprise');
INSERT INTO `role` VALUES ('2', 'cuser');

-- ----------------------------
-- Table structure for cuser
-- ----------------------------
DROP TABLE IF EXISTS `cuser`;
CREATE TABLE `cuser` (
  `username` varchar(16) NOT NULL,
  `realname` varchar(16) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `FK2ovmsl4hvm5vu1w8i308r5j6w` (`roleid`),
  CONSTRAINT `FK2ovmsl4hvm5vu1w8i308r5j6w` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cuser
-- ----------------------------
INSERT INTO `cuser` VALUES ('admin', '超级管理员', '4b252ef32f83fdec9ce52366a161dbc0', '15077774211@163.com', '15077774211', '0');
INSERT INTO `cuser` VALUES ('user01', '用户01', '49f6d5be62046cf3e51170919f2d70c9', '15077774211@163.com', '15077774211', '2');
INSERT INTO `cuser` VALUES ('user02', '用户02', '7f28e2ed9df802758e8f6b807f8da650', '15077774211@163.com', '15077774211', '2');
INSERT INTO `cuser` VALUES ('user03', '用户03', '19600ae3bc8f5a7770694bdcaaaab011', '15077774211@163.com', '15077774211', '2');
INSERT INTO `cuser` VALUES ('user04', '用户04', '1c812393603cb13aad9c104de9ace093', '15077774211@163.com', '15077774211', '2');
