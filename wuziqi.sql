/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : wuziqi

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-06-18 23:22:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '1', 'admin', '2016-12-22 15:46:10', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('16', '2', 'youke', '2016-12-22 15:52:39', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('17', '1', 'admin', '2016-12-22 15:58:26', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('18', '2', 'youke', '2016-12-22 15:59:11', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('19', '2', 'youke', '2016-12-22 15:59:11', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('20', '1', 'admin', '2016-12-22 16:00:03', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('21', '1', 'admin', '2016-12-22 16:01:42', '更新', '更新用户头像', '127.0.0.1');
INSERT INTO `log` VALUES ('22', '1', 'admin', '2016-12-22 16:02:22', '更新', '更新用户头像', '127.0.0.1');
INSERT INTO `log` VALUES ('23', '2', 'youke', '2016-12-22 16:07:33', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('24', '2', 'youke', '2016-12-22 16:08:00', '更新', '更新用户头像', '127.0.0.1');
INSERT INTO `log` VALUES ('25', '1', 'admin', '2016-12-23 09:50:52', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('26', '1', 'admin', '2016-12-23 09:52:32', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('27', '1', 'admin', '2016-12-23 09:53:50', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('28', '1', 'admin', '2016-12-23 09:58:08', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('29', '1', 'admin', '2016-12-23 11:09:27', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('30', '1', 'admin', '2017-06-16 09:30:16', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('31', '1', 'admin', '2017-06-16 10:21:58', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('32', '1', 'admin', '2017-06-16 14:07:11', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('33', '1', 'admin', '2017-06-16 14:57:49', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('34', '1', 'admin', '2017-06-16 15:51:47', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('35', '1', 'admin', '2017-06-17 10:49:30', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('36', '1', 'admin', '2017-06-17 11:47:12', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('37', '1', 'admin', '2017-06-17 12:49:06', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('38', '1', 'admin', '2017-06-17 23:53:16', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('39', '1', 'admin', '2017-06-18 00:48:55', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('40', '1', 'admin', '2017-06-18 15:56:43', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('41', '1', 'admin', '2017-06-18 21:39:01', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('42', '1', 'admin', '2017-06-18 22:07:32', '登陆', '用户登陆', '127.0.0.1');
INSERT INTO `log` VALUES ('43', '1', 'admin', '2017-06-18 22:51:33', '登陆', '用户登陆', '127.0.0.1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `userid` int(255) unsigned zerofill NOT NULL,
  `admin` bit(1) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `profilehead` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `registertime` datetime DEFAULT NULL,
  `lastlogintime` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', '', 'admin', '963lkq', '123', '怎么是问号', '1', '21', 'upload/admin/admin.jpg', '666', '2016-12-01 16:24:25', '2017-06-18 22:51:33', '');
INSERT INTO `user` VALUES ('2', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000012', '\0', 'youke', '123', null, '哈哈', '2', '23', 'upload/youke/youke.jpg', '卡卡', '2016-12-13 16:25:33', '2016-12-22 16:07:33', '');

-- ----------------------------
-- Table structure for usersetting
-- ----------------------------
DROP TABLE IF EXISTS `usersetting`;
CREATE TABLE `usersetting` (
  `_id` int(255) NOT NULL AUTO_INCREMENT,
  `userid` int(255) NOT NULL,
  `pagesize` int(11) DEFAULT NULL,
  `show_onlinecounts` bit(1) DEFAULT NULL,
  `friendtips` bit(1) DEFAULT NULL,
  `showmyinfo` bit(1) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usersetting
-- ----------------------------

-- ----------------------------
-- View structure for hello
-- ----------------------------
DROP VIEW IF EXISTS `hello`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `hello` AS select concat(rtrim(username),'(',rtrim(password),')') as users from user order by id ;
