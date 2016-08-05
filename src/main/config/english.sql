/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : english

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-08-05 14:56:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `message` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'I am 我我我...');
INSERT INTO `user` VALUES ('3', 'I am 我我我...');
INSERT INTO `user` VALUES ('4', 'I am 我我我...');
INSERT INTO `user` VALUES ('5', 'I am 我我我...');
INSERT INTO `user` VALUES ('6', 'I am 我我我...');
INSERT INTO `user` VALUES ('7', 'I am 我我我...');
INSERT INTO `user` VALUES ('8', 'I am 我我我...');
INSERT INTO `user` VALUES ('9', 'I am 我我我...');
INSERT INTO `user` VALUES ('10', 'I am 我我我...');
INSERT INTO `user` VALUES ('11', 'I am 我我我...');
INSERT INTO `user` VALUES ('12', 'I am 我我我...');
INSERT INTO `user` VALUES ('13', 'I am 我我我...');
INSERT INTO `user` VALUES ('14', 'I am 我我我...');
INSERT INTO `user` VALUES ('15', 'I am 我我我...');
INSERT INTO `user` VALUES ('16', 'I am 我我我...');
INSERT INTO `user` VALUES ('17', 'I am 我我我...');
INSERT INTO `user` VALUES ('18', 'I am 我我我...');
INSERT INTO `user` VALUES ('19', 'I am 我我我...');
INSERT INTO `user` VALUES ('20', 'I am 我我我...');
INSERT INTO `user` VALUES ('21', 'I am 我我我...');
INSERT INTO `user` VALUES ('22', 'I am 我我我...');
INSERT INTO `user` VALUES ('23', 'I am 我我我...');
INSERT INTO `user` VALUES ('24', 'I am 我我我...');
INSERT INTO `user` VALUES ('25', 'I am 我我我...');
INSERT INTO `user` VALUES ('26', 'I am 我我我...');
INSERT INTO `user` VALUES ('27', 'I am 我我我...');
