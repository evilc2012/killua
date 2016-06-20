/*
Navicat MySQL Data Transfer

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for killua_role
-- ----------------------------
DROP TABLE IF EXISTS `killua_role`;
CREATE TABLE `killua_role` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=3

;

-- ----------------------------
-- Records of killua_role
-- ----------------------------
BEGIN;
INSERT INTO `killua_role` VALUES ('1', 'admin'), ('2', 'user');
COMMIT;

-- ----------------------------
-- Table structure for killua_user
-- ----------------------------
DROP TABLE IF EXISTS `killua_user`;
CREATE TABLE `killua_user` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`username`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`realname`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=2

;

-- ----------------------------
-- Records of killua_user
-- ----------------------------
BEGIN;
INSERT INTO `killua_user` VALUES ('1', 'admin', 'admin', '管理员');
COMMIT;

-- ----------------------------
-- Table structure for killua_user_occupy
-- ----------------------------
DROP TABLE IF EXISTS `killua_user_occupy`;
CREATE TABLE `killua_user_occupy` (
`user_id`  int(11) NOT NULL ,
`project`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`machine`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
UNIQUE INDEX `user_occupy_id` (`user_id`, `project`, `machine`) USING BTREE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of killua_user_occupy
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for killua_user_role
-- ----------------------------
DROP TABLE IF EXISTS `killua_user_role`;
CREATE TABLE `killua_user_role` (
`user_id`  int(11) NOT NULL ,
`role_id`  int(11) NOT NULL ,
UNIQUE INDEX `user_role_id` (`user_id`, `role_id`) USING BTREE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of killua_user_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Auto increment value for killua_role
-- ----------------------------
ALTER TABLE `killua_role` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for killua_user
-- ----------------------------
ALTER TABLE `killua_user` AUTO_INCREMENT=2;
