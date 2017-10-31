/*
Navicat MySQL Data Transfer

Source Server         : 3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : online_examination_web

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-23 17:14:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_examinations
-- ----------------------------
DROP TABLE IF EXISTS `tb_examinations`;
CREATE TABLE `tb_examinations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `score` int(3) DEFAULT NULL,
  `questions` varchar(255) DEFAULT NULL,
  `answers` varchar(255) DEFAULT NULL,
  `start_examination_time` datetime DEFAULT NULL,
  `end_examination_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `examinations_student_id_unique` (`student_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_examinations
-- ----------------------------
INSERT INTO `tb_examinations` VALUES ('1', null, null, null, null, null, '2017-08-01 10:03:25');
INSERT INTO `tb_examinations` VALUES ('2', null, null, null, null, null, '2017-08-01 10:25:05');
INSERT INTO `tb_examinations` VALUES ('3', null, null, null, null, null, '2017-08-01 10:29:11');

-- ----------------------------
-- Table structure for tb_examinee
-- ----------------------------
DROP TABLE IF EXISTS `tb_examinee`;
CREATE TABLE `tb_examinee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `_class` int(11) DEFAULT NULL,
  `avater` varchar(100) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `tel` varchar(12) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `school` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `examinee_student_id_unique` (`student_id`) USING BTREE,
  KEY `examinee_name_normal` (`name`) USING BTREE,
  KEY `examinee_class_normal` (`_class`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_examinee
-- ----------------------------
INSERT INTO `tb_examinee` VALUES ('1', '原兴华', '123456', '1316040239', '13160402', '1502174245541.jpg', null, '18776665645', '汉族', '175', '60', '桂林电子科技大学', '男');
INSERT INTO `tb_examinee` VALUES ('2', '江菁淇', '123456', '14053612', '1312', '1502175322193.jpg', null, '15777587660', '汉族', '160', '50', '大力大学', '男');

-- ----------------------------
-- Table structure for tb_questions_option
-- ----------------------------
DROP TABLE IF EXISTS `tb_questions_option`;
CREATE TABLE `tb_questions_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) DEFAULT NULL,
  `answer` varchar(2) DEFAULT NULL,
  `create_person` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `questions_create_person_unique` (`create_person`) USING BTREE,
  KEY `questions_qustion_normal` (`question`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_questions_option
-- ----------------------------
INSERT INTO `tb_questions_option` VALUES ('1', null, null, null, '2017-08-01 10:39:35');
INSERT INTO `tb_questions_option` VALUES ('2', null, null, null, '2017-08-01 10:40:14');

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `position` varchar(10) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `sex` varchar(2) DEFAULT '男',
  `avater` varchar(100) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `weight` double(5,0) DEFAULT NULL,
  `school` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_name_normal` (`name`) USING BTREE,
  KEY `teacher_position_normal` (`position`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES ('24', '22', '222', '222', '2017-08-23 20:34:49', null, '男', null, null, null, null, null);
INSERT INTO `tb_teacher` VALUES ('25', 'admin', 'admin', null, '2017-08-22 18:44:13', null, '男', null, null, null, null, null);
