/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : javaweb

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 08/06/2021 00:43:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publish` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pages` int(10) NULL DEFAULT NULL,
  `price` float(10, 2) NULL DEFAULT NULL,
  `bookcaseid` int(10) NULL DEFAULT NULL,
  `abled` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_ieh6qsxp6q7oydadktc9oc8t2`(`bookcaseid`) USING BTREE,
  CONSTRAINT `FK_ieh6qsxp6q7oydadktc9oc8t2` FOREIGN KEY (`bookcaseid`) REFERENCES `bookcase` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '解忧杂货店', '东野圭吾', '电子工业出版社', 102, 27.30, 9, 0);
INSERT INTO `book` VALUES (2, '追风筝的人', '卡勒德·胡赛尼', '上海人民出版社', 230, 33.50, 3, 0);
INSERT INTO `book` VALUES (3, '人间失格', '太宰治', '作家出版社', 150, 17.30, 1, 1);
INSERT INTO `book` VALUES (4, '这就是二十四节气', '高春香', '电子工业出版社', 220, 59.00, 3, 1);
INSERT INTO `book` VALUES (5, '白夜行', '东野圭吾', '南海出版公司', 300, 27.30, 4, 1);
INSERT INTO `book` VALUES (6, '摆渡人', '克莱儿·麦克福尔', '百花洲文艺出版社', 225, 22.80, 1, 1);
INSERT INTO `book` VALUES (7, '暖暖心绘本', '米拦弗特毕', '湖南少儿出版社', 168, 131.60, 5, 1);
INSERT INTO `book` VALUES (8, '天才在左疯子在右', '高铭', '北京联合出版公司', 330, 27.50, 6, 1);
INSERT INTO `book` VALUES (9, '我们仨', '杨绛', '生活.读书.新知三联书店', 89, 17.20, 7, 1);
INSERT INTO `book` VALUES (10, '活着', '余华', '作家出版社', 100, 100.00, 6, 1);
INSERT INTO `book` VALUES (11, '水浒传', '施耐庵', '三联出版社', 300, 50.00, 1, 1);
INSERT INTO `book` VALUES (12, '三国演义', '罗贯中', '三联出版社', 300, 50.00, 2, 1);
INSERT INTO `book` VALUES (13, '红楼梦', '曹雪芹', '三联出版社', 300, 50.00, 5, 1);
INSERT INTO `book` VALUES (14, '西游记', '吴承恩', '三联出版社', 300, 60.00, 3, 1);

-- ----------------------------
-- Table structure for bookadmin
-- ----------------------------
DROP TABLE IF EXISTS `bookadmin`;
CREATE TABLE `bookadmin`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookadmin
-- ----------------------------
INSERT INTO `bookadmin` VALUES (1, 'admin1', '123123');
INSERT INTO `bookadmin` VALUES (2, 'admin2', '222222');

-- ----------------------------
-- Table structure for bookcase
-- ----------------------------
DROP TABLE IF EXISTS `bookcase`;
CREATE TABLE `bookcase`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookcase
-- ----------------------------
INSERT INTO `bookcase` VALUES (1, '社会');
INSERT INTO `bookcase` VALUES (2, '情感');
INSERT INTO `bookcase` VALUES (3, '国学');
INSERT INTO `bookcase` VALUES (4, '推理');
INSERT INTO `bookcase` VALUES (5, '绘画');
INSERT INTO `bookcase` VALUES (6, '心理学');
INSERT INTO `bookcase` VALUES (7, '传记');
INSERT INTO `bookcase` VALUES (8, '科技');
INSERT INTO `bookcase` VALUES (9, '计算机');
INSERT INTO `bookcase` VALUES (10, '小说');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bookid` int(10) NULL DEFAULT NULL,
  `readerid` int(10) NULL DEFAULT NULL,
  `borrowtime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `returntime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminid` int(10) NULL DEFAULT NULL,
  `state` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (3, 1, 4, '2021-06-06', '2021-08-05', NULL, 0);
INSERT INTO `borrow` VALUES (4, 1, 4, '2021-06-08', '2021-08-07', NULL, 0);

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cardid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES (3, 'zhangsan', '123', '张三', '131', '001', '男');
INSERT INTO `reader` VALUES (4, 'lisi', '123', '李四', '987655123', '002', '男');

-- ----------------------------
-- Table structure for returnbook
-- ----------------------------
DROP TABLE IF EXISTS `returnbook`;
CREATE TABLE `returnbook`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bookid` int(10) NULL DEFAULT NULL,
  `readerid` int(10) NULL DEFAULT NULL,
  `returntime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminid` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of returnbook
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
