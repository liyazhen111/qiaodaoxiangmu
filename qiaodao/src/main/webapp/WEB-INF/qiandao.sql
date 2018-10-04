/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : qiandao

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-09-29 17:01:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qiandao
-- ----------------------------
DROP TABLE IF EXISTS `qiandao`;
CREATE TABLE `qiandao` (
  `flag` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `begantime` datetime NOT NULL,
  `uname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qiandao
-- ----------------------------
INSERT INTO `qiandao` VALUES ('1', '1', '2018-09-29 11:13:29', '123');
INSERT INTO `qiandao` VALUES ('2', '23', '2018-09-29 15:57:11', '123');
INSERT INTO `qiandao` VALUES ('2', '24', '2018-09-29 16:09:41', '333');
INSERT INTO `qiandao` VALUES ('2', '25', '2018-09-29 16:22:59', '333');
INSERT INTO `qiandao` VALUES ('2', '26', '2018-09-29 16:25:33', '333');
INSERT INTO `qiandao` VALUES ('2', '27', '2018-09-29 16:30:31', '333');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '123', '111');
INSERT INTO `user` VALUES ('2', '333', '123', '小伟');
INSERT INTO `user` VALUES ('3', '444', '123', '小伟');
INSERT INTO `user` VALUES ('4', '1234', '123', '小伟');
INSERT INTO `user` VALUES ('5', '123434', '123', '小伟');
INSERT INTO `user` VALUES ('6', '12343', '123', '小伟');
INSERT INTO `user` VALUES ('7', '12343', '123', '小伟');
