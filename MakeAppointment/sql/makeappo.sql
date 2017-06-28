/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : makeappo

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-09-13 16:17:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `appo_admin`
-- ----------------------------
DROP TABLE IF EXISTS `appo_admin`;
CREATE TABLE `appo_admin` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  `pwd` varchar(20) default NULL,
  `level` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appo_admin
-- ----------------------------
INSERT INTO `appo_admin` VALUES ('1', '2', '2', null);
INSERT INTO `appo_admin` VALUES ('2', '2', '2', null);
INSERT INTO `appo_admin` VALUES ('3', '3', '3', null);
INSERT INTO `appo_admin` VALUES ('4', '4', '6', null);
INSERT INTO `appo_admin` VALUES ('5', 'tianlixin', '123456', null);

-- ----------------------------
-- Table structure for `appo_appointment`
-- ----------------------------
DROP TABLE IF EXISTS `appo_appointment`;
CREATE TABLE `appo_appointment` (
  `id` int(4) NOT NULL auto_increment,
  `time` varchar(20) default NULL,
  `describe` varchar(100) default NULL,
  `userId` int(4) default NULL,
  `deptId` int(4) default NULL,
  `docId` int(4) default NULL,
  `state` varchar(10) default NULL,
  `remark` varchar(100) default NULL,
  `money` int(4) default NULL,
  `payway` varchar(10) default NULL,
  `diagTime` varchar(20) default NULL,
  `diagInfo` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appo_appointment
-- ----------------------------

-- ----------------------------
-- Table structure for `appo_dept`
-- ----------------------------
DROP TABLE IF EXISTS `appo_dept`;
CREATE TABLE `appo_dept` (
  `id` int(10) NOT NULL auto_increment,
  `style` varchar(20) default NULL,
  `name` varchar(30) default NULL,
  `information` varchar(500) default NULL,
  `flag` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appo_dept
-- ----------------------------
INSERT INTO `appo_dept` VALUES ('1', '一级科室', '内科', null, '0');
INSERT INTO `appo_dept` VALUES ('2', '一级科室', '外科', null, '0');
INSERT INTO `appo_dept` VALUES ('3', '一级科室', '著名专家门诊', null, '0');
INSERT INTO `appo_dept` VALUES ('4', '一级科室', '特需门诊', null, '0');
INSERT INTO `appo_dept` VALUES ('5', '一级科室', '妇科', null, '0');
INSERT INTO `appo_dept` VALUES ('6', '一级科室', '五官', null, '0');
INSERT INTO `appo_dept` VALUES ('7', '一级科室', '儿科', null, '0');
INSERT INTO `appo_dept` VALUES ('8', '一级科室', '其他', null, '0');

-- ----------------------------
-- Table structure for `appo_doctor`
-- ----------------------------
DROP TABLE IF EXISTS `appo_doctor`;
CREATE TABLE `appo_doctor` (
  `id` int(4) NOT NULL auto_increment,
  `deptId` int(10) default NULL,
  `name` varchar(30) default NULL,
  `education` varchar(20) default NULL,
  `title` varchar(20) default NULL,
  `stopTime` varchar(10) default NULL,
  `startTime` varchar(10) default NULL,
  `ableAppoNum` int(4) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appo_doctor
-- ----------------------------
INSERT INTO `appo_doctor` VALUES ('1', '23', '00', '223', '0', null, null, null);

-- ----------------------------
-- Table structure for `appo_registration`
-- ----------------------------
DROP TABLE IF EXISTS `appo_registration`;
CREATE TABLE `appo_registration` (
  `id` int(10) NOT NULL auto_increment,
  `appointmentId` int(10) default NULL,
  `money` int(4) default NULL,
  `payway` varchar(10) default NULL,
  `time` varchar(20) default NULL,
  `diagnosis` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appo_registration
-- ----------------------------

-- ----------------------------
-- Table structure for `appo_source`
-- ----------------------------
DROP TABLE IF EXISTS `appo_source`;
CREATE TABLE `appo_source` (
  `id` int(10) NOT NULL auto_increment,
  `docId` int(4) default NULL,
  `time` varchar(20) default NULL,
  `total` int(4) default NULL,
  `remain` int(4) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appo_source
-- ----------------------------

-- ----------------------------
-- Table structure for `appo_stop`
-- ----------------------------
DROP TABLE IF EXISTS `appo_stop`;
CREATE TABLE `appo_stop` (
  `id` int(10) NOT NULL auto_increment,
  `docId` int(4) default NULL,
  `stopTime` varchar(20) default NULL,
  `stopDaynum` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appo_stop
-- ----------------------------

-- ----------------------------
-- Table structure for `appo_user`
-- ----------------------------
DROP TABLE IF EXISTS `appo_user`;
CREATE TABLE `appo_user` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `userName` varchar(20) default NULL,
  `userPwd` varchar(20) default NULL,
  `age` int(4) default NULL,
  `telephone` varchar(30) default NULL,
  `sex` varchar(10) default NULL,
  `describe` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appo_user
-- ----------------------------
INSERT INTO `appo_user` VALUES ('1', '1', null, null, '1', '1', '1', '1');
