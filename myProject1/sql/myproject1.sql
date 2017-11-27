/*
Navicat MySQL Data Transfer

Source Server         : 1204
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : myproject1

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-20 16:48:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `fun`
-- ----------------------------
DROP TABLE IF EXISTS `fun`;
CREATE TABLE `fun` (
`funid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`funname`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`funurl`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`funicon`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`funfathernode`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`funcreate`  date NOT NULL ,
PRIMARY KEY (`funid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of fun
-- ----------------------------
BEGIN;
INSERT INTO `fun` VALUES ('0ed9bf6b70664153b3ee961e4ee2e891', 'Excel导出管理', 'excel/index', 'fa-tag', '0', '2017-10-26'), ('16be08dbc0234635b073227e4cd75bb6', 'Email功能', '', 'fa-envelope-o', '0', '2017-11-03'), ('18bf025b55d54117ba8d7057c12de6b2', '用户管理', 'user/index', 'fa-square-o', '0', '2017-10-13'), ('1ee422696c5f44d2841410ff34c4c28c', 'Email功能', 'email/emailIndex', 'fa-envelope-o', '16be08dbc0234635b073227e4cd75bb6', '2017-11-03'), ('213a0f534c3d4c6bbc2eb2fe7c6aac57', '角色管理', 'role/roleIndex', ' fa-thumbs-o-up', 'a33998a808ab4f91b59aae4c4c804a84', '2017-10-16'), ('289f530528b0421a99965b4be04609c5', '天气测试', 'weather/weatherIndex', 'fa-sun-o', '9b46729d0f9046b48c17f7359d02137d', '2017-11-03'), ('2dc8fa1b1bbd457c891a35d836722b13', '短信测试', 'msg/msgIndex', 'fa-envelope-o', 'b01a522ebe784509b25e0ce760b2874c', '2017-11-03'), ('398058414f364d1a80986a439f94e3ce', '地图显示', '', 'fa-map', '0', '2017-11-03'), ('6cb93bdc072043f99d7117bccb422f9c', 'Redis功能实现', 'redis/redisIndex', 'fa-book', '85167e1a243d4381a98472126599c835', '2017-11-02'), ('80d2aca7b3994362a2bd713dafe1e1dc', '日志管理', 'log/logIndex', 'fa-log', 'f80021b90afb45dd869a33c54efec958', '2017-11-08'), ('85167e1a243d4381a98472126599c835', 'Redis功能', 'redis/redisIndex', 'fa-database', '0', '2017-11-02'), ('97d079ff7c134ad28c0e2dbb1f2f6005', '百度地图显示', 'map/mapIndex', 'fa-map', '398058414f364d1a80986a439f94e3ce', '2017-11-03'), ('9b46729d0f9046b48c17f7359d02137d', '天气测试', '', 'fa-sun-o', '0', '2017-11-03'), ('a33998a808ab4f91b59aae4c4c804a84', '角色管理', 'role/roleIndex', ' fa-tree', '0', '2017-10-16'), ('b01a522ebe784509b25e0ce760b2874c', '短信测试', '', 'fa-envelope-o', '0', '2017-11-03'), ('b28a06bad61945418d7a96f14922b866', 'Excel导出', 'excel/index', ' fa-unlock-alt', '0ed9bf6b70664153b3ee961e4ee2e891', '2017-10-26'), ('b7434786394a4ca190fea6200dbe7f26', '文件上传', 'file/index', 'fa-folder', 'd487ff45cfa6496f9b655777f5584532', '2017-10-26'), ('d487ff45cfa6496f9b655777f5584532', '文件上传', '', 'fa-folder-open', '0', '2017-10-26'), ('f80021b90afb45dd869a33c54efec958', '日志管理', '', 'fa-log', '0', '2017-11-08'), ('f9b38e2449464eb7a3495fb110a17121', '用户管理', 'user/userIndex', 'fa-user', '18bf025b55d54117ba8d7057c12de6b2', '2017-10-13'), ('sdhdjiucjhghgshgdss', '系统功能', 'system/index', ' fa-university', 'skduytud54sads45sd', '2017-10-11'), ('skduytud54sads45sd', '系统管理', '', ' fa-ticket', '0', '2017-10-11');
COMMIT;

-- ----------------------------
-- Table structure for `fun_role`
-- ----------------------------
DROP TABLE IF EXISTS `fun_role`;
CREATE TABLE `fun_role` (
`fun_role_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`roleid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`funid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`funcreate`  datetime NOT NULL ,
PRIMARY KEY (`fun_role_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of fun_role
-- ----------------------------
BEGIN;
INSERT INTO `fun_role` VALUES ('08983779bcc642afa98814b971c101b2', '3a4fd8b821df416e92f94d2127f7aadc', '0ed9bf6b70664153b3ee961e4ee2e891', '2017-11-01 11:47:34'), ('0d838930f7d345048b73f53b78d39ad6', '26620520770a4fcebf2e680b57e90ba0', '213a0f534c3d4c6bbc2eb2fe7c6aac57', '2017-10-26 15:22:13'), ('433d9ca7999e4ed3af4955e6b0a46547', '26620520770a4fcebf2e680b57e90ba0', 'a33998a808ab4f91b59aae4c4c804a84', '2017-10-26 15:22:12'), ('92ed64a683c147779a084285536d94ea', '26620520770a4fcebf2e680b57e90ba0', 'f9b38e2449464eb7a3495fb110a17121', '2017-10-26 15:22:12'), ('aabbccddeeffgg', 'asasassdss', '18bf025b55d54117ba8d7057c12de6b2', '2017-10-26 00:00:00'), ('aabbcceeddffgg', 'asasassdss', 'f9b38e2449464eb7a3495fb110a17121', '2017-10-26 00:00:00'), ('ad08d05141224b11b361212ab424dbd0', '3a4fd8b821df416e92f94d2127f7aadc', 'b28a06bad61945418d7a96f14922b866', '2017-11-01 11:47:35'), ('fe59c75d7a794d43b42d547afd9b77d1', '26620520770a4fcebf2e680b57e90ba0', '18bf025b55d54117ba8d7057c12de6b2', '2017-10-26 15:22:12');
COMMIT;

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
`logid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`logtype`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`logname`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`logcreate`  date NULL DEFAULT NULL ,
`logexception`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`logip`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`logid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of log
-- ----------------------------
BEGIN;
INSERT INTO `log` VALUES ('04c78efae7934002881501b4342c8b0f', 'com.ry.controllers.UserController.index()', '', '2017-11-06', null, '0:0:0:0:0:0:0:1'), ('57a8c70411764cc8ada629325a5b53ff', 'com.ry.controllers.UserController.index()', '', '2017-11-06', null, '0:0:0:0:0:0:0:1'), ('7d6bb1f21255424e9f3acc2a1e073ed3', 'com.ry.controllers.UserController.index()', '', '2017-11-08', null, '0:0:0:0:0:0:0:1'), ('80edbba13a1e4cd6a29eab37ca3ee338', 'com.ry.controllers.UserController.index()', '', '2017-11-09', null, '0:0:0:0:0:0:0:1'), ('881e65eecc744f7084b6e7f47842c631', 'com.ry.controllers.UserController.index()', '', '2017-11-06', null, '0:0:0:0:0:0:0:1'), ('8ac10a3ec4de4bb0835615afbd29f038', 'com.ry.controllers.UserController.index()', '', '2017-11-06', null, '0:0:0:0:0:0:0:1'), ('95e91ef6167c441e827605a7fc97e5ad', 'com.ry.controllers.UserController.index()', '', '2017-11-06', null, '0:0:0:0:0:0:0:1'), ('9aefba6816b244558c2cf59b3d6b82ca', 'com.ry.controllers.UserController.index()', '', '2017-11-09', null, '0:0:0:0:0:0:0:1'), ('9cdc6b14e1514392b6af6144953fded2', 'com.ry.controllers.UserController.index()', '', '2017-11-20', null, '0:0:0:0:0:0:0:1'), ('aaf60e07117c4a088e217cb7e765af43', 'com.ry.controllers.UserController.index()', '', '2017-11-06', null, '0:0:0:0:0:0:0:1'), ('bdae86d446cf4684afd18d7a12d1a7bb', 'com.ry.controllers.UserController.index()', '', '2017-11-06', null, '0:0:0:0:0:0:0:1'), ('d9be11b3b37c4f17bf8ad1242ad63542', 'com.ry.controllers.UserController.index()', '', '2017-11-09', null, '0:0:0:0:0:0:0:1'), ('dd24662246f84f689a09d5d0eaa072af', 'com.ry.controllers.UserController.index()', '', '2017-11-09', null, '0:0:0:0:0:0:0:1'), ('eb8c177778684352ba6ee18a186b48bb', 'com.ry.controllers.UserController.index()', '', '2017-11-20', null, '0:0:0:0:0:0:0:1'), ('ef95622bf76a4ffdb1643c5213b7666a', 'com.ry.controllers.UserController.index()', '', '2017-11-06', null, '0:0:0:0:0:0:0:1');
COMMIT;

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
`roleid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`rolename`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`rolecreate`  datetime NOT NULL ,
`rolestate`  int(11) NOT NULL ,
PRIMARY KEY (`roleid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('26620520770a4fcebf2e680b57e90ba0', '总管理者', '2017-10-26 15:22:12', '1'), ('asasassdss', '管理员', '2017-10-16 00:00:00', '1');
COMMIT;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`userid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`username`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`useraccount`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`usercontact`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`usercreate`  date NOT NULL ,
PRIMARY KEY (`userid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1234567745', 'admin', 'admin', '122110308@qq.com', '13545152390', '2017-10-09'), ('dc169874be29499595a13ffc4499420b', '管理员', '123456', '648517286@qq.com', '13345678900', '2017-11-01'), ('e35b10b2584a41cc9cdbb7d85ccd72e3', 'admin2', '111', '772917198@qq.com', '18163114756', '2017-10-10'), ('fe9f499959bc4366ab2cce576a8a6c6f', '陈曦', '111111', '819413891@qq.com', '13545152390', '2017-10-30');
COMMIT;

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
`user_role_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`userid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`roleid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`user_role_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES ('2944fe6fc46c4ac4a31802bffe3a8416', 'fe9f499959bc4366ab2cce576a8a6c6f', 'asasassdss'), ('70eab1231a534715ad823bdec97d7335', '3f340599d05d44598c95fe43cf1ad5f0', 'asasassdss'), ('bbb9aaa4c1054c2288af8e91c5b2a4d1', 'dc169874be29499595a13ffc4499420b', 'asasassdss'), ('e84aa23df63b4fcf8f1cd8d0f025f7d9', 'fe9f499959bc4366ab2cce576a8a6c6f', '26620520770a4fcebf2e680b57e90ba0'), ('xlxfblgjxszybf', '1234567745', 'asasassdss');
COMMIT;
