/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-02 15:46:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mouyao_test
-- ----------------------------
DROP TABLE IF EXISTS `mouyao_test`;
CREATE TABLE `mouyao_test` (
  `id` varchar(110) DEFAULT NULL,
  `name` varchar(110) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mouyao_test
-- ----------------------------
INSERT INTO `mouyao_test` VALUES ('9', 'mouyao', '6');
INSERT INTO `mouyao_test` VALUES ('9', 'panpan', '6');
INSERT INTO `mouyao_test` VALUES ('1', 'panpan', '6');
INSERT INTO `mouyao_test` VALUES ('6', 'liudehua', '99');
INSERT INTO `mouyao_test` VALUES ('6', 'liudehua', '99');
INSERT INTO `mouyao_test` VALUES ('6', '金盼盼', '99');
