/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-02 18:32:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '��¼���',
  `uid` char(11) NOT NULL COMMENT '�û���ţ��û��ֻ��ţ�',
  `address` varchar(50) NOT NULL COMMENT '��ַ',
  `added` datetime NOT NULL COMMENT '�������/ʱ��',
  `receiver` varchar(30) NOT NULL COMMENT '�ռ��ˣ�������',
  `rphone` char(11) NOT NULL COMMENT '�ռ��˵绰',
  PRIMARY KEY (`rid`),
  KEY `fk_address_user` (`uid`),
  CONSTRAINT `fk_address_user` FOREIGN KEY (`uid`) REFERENCES `t_user` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='�û���ַ��';

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES ('1', '12345678901', '�����к�������������·��18���ж�����B��3¥331��', '2017-06-27 22:50:18', '������', '12345678901');
INSERT INTO `t_address` VALUES ('2', '12345678901', '�����к�������������·��18�������㳡E��10��10017��', '2017-08-15 17:15:37', '���仨', '12345678901');
INSERT INTO `t_address` VALUES ('3', '12345678901', '�Ϻ����������Ͼ���·66��������2Ū6��', '2017-08-15 23:59:36', '�¶���', '12345678801');

-- ----------------------------
-- Table structure for t_banner
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '��¼���',
  `book` char(13) NOT NULL COMMENT 'ͼ�飨ͼ���ţ�',
  PRIMARY KEY (`rid`),
  KEY `fk_banner_book` (`book`),
  CONSTRAINT `fk_banner_book` FOREIGN KEY (`book`) REFERENCES `t_book` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='banner��¼��';

-- ----------------------------
-- Records of t_banner
-- ----------------------------
INSERT INTO `t_banner` VALUES ('5', '9787111526285');
INSERT INTO `t_banner` VALUES ('2', '9787111563891');
INSERT INTO `t_banner` VALUES ('3', '9787111564805');
INSERT INTO `t_banner` VALUES ('4', '9787115353528');
INSERT INTO `t_banner` VALUES ('1', '9787121281556');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `isbn` char(13) NOT NULL COMMENT 'ͼ����',
  `title` varchar(80) NOT NULL COMMENT '���⣨������',
  `author` varchar(80) NOT NULL COMMENT '����',
  `price` double(9,2) NOT NULL COMMENT '�۸�',
  `press` varchar(50) NOT NULL COMMENT '������',
  `edition` int(11) NOT NULL DEFAULT '1' COMMENT '���',
  `published` datetime NOT NULL COMMENT '��������/ʱ��',
  `pages` int(11) NOT NULL DEFAULT '0' COMMENT 'ҳ��',
  `words` int(11) NOT NULL DEFAULT '0' COMMENT '����',
  `packaging` varchar(10) NOT NULL DEFAULT 'ƽװ' COMMENT '��װ',
  `format` varchar(6) NOT NULL DEFAULT '16��' COMMENT '����',
  `form` varchar(10) NOT NULL DEFAULT '����ֽ' COMMENT '��ֽ',
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ͼ����Ϣ��';

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('9787111213826', 'Java���˼��', '[��] ���˶������ߣ������ ��', '86.40', '��е��ҵ������', '4', '2007-06-01 00:00:00', '880', '0', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787111526285', 'Go����������ԣ�Ӣ�İ棩', '[��] ����A.A.��ŵ�� �� ��', '64.70', '��е��ҵ������ ', '1', '2016-01-01 00:00:00', '366', '0', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787111532644', '�ܹ���δ��', '[��] ��L.�����أ�MartinL.Abbott�������˶�T.�������MichaelT.Fisher�� �����±� ��', '81.00', '��е��ҵ������', '1', '2016-04-01 00:00:00', '660', '0', 'ƽװ', '32��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787111545682', 'Linux��ά���ʵ��', '��壬��� ��', '56.50', '��е��ҵ������', '1', '2016-09-01 00:00:00', '325', '0', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787111563891', '����������ܵ�TensorFlowʵ��', '[��] ɽķ���ǲ�������Sam Abrahams���������Ƕ��������ɣ�Danijar Hafner��������ˡ������أ��������˹����Ƥ���� �����ηƣ����� ��', '56.50', '��е��ҵ������', '1', '2017-05-01 00:00:00', '212', '0', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787111564805', '��ҵIT�ܹ�ת��֮��', '�ӻ� ��', '53.80', '��е��ҵ������', '1', '2017-05-01 00:00:00', '229', '0', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787115130228', 'C Primer Plus', '[��] ��������Prata S.�� �������۹����� �� ', '49.80', '�����ʵ������', '5', '2017-06-27 22:44:28', '626', '1298000', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787115335500', '����ǳ��Node.js', '���� ��', '57.30', '�����ʵ������', '1', '2013-12-01 00:00:00', '348', '0', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787115353528', 'Python�����̳�', '[Ų] Magnus Lie Hetland ����˾ά�������ˣ�̷ӱ�� ��', '65.60', '�����ʵ������', '2', '2014-06-01 00:00:00', '470', '727000', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787115386397', 'Spring MVCѧϰָ��', '[��] ���ˣ�Paul Deck�� ���������������� ��', '40.70', '�����ʵ������ ', '1', '2015-05-01 00:00:00', '274', '0', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787115435101', 'Python���ݿ�ѧָ��', 'ӡ�ȣ�Gopi��Subramanian�����������ᰲ �������ӷ磬���� ��', '66.20', '�����ʵ������', '1', '2016-11-01 00:00:00', '380', '0', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787121281556', 'Hadoop 2.X HDFSԴ������', '���� ��', '86.40', '���ӹ�ҵ������', '1', '2016-03-01 00:00:00', '554', '0', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787121291609', 'Go����ѧϰ�ʼ� ', '��ۡ� ��', '73.90', '���ӹ�ҵ������', '1', '2016-07-01 00:00:00', '468', '552000', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787302383666', 'MongoDB�����ݴ���Ȩ��ָ��', '[��] David Hows��Eelco Plugge��Peter Mem ������Ф�� ��', '42.00', '�廪��ѧ������', '2', '2014-11-01 00:00:00', '269', '0', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787302435167', '�����ݼܹ�ʦָ��', '����� ��', '38.30', '�廪��ѧ������', '1', '2016-06-01 00:00:00', '271', '0', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787302459873', '�����ھ���Ԥ�����', '[��] Daniel T.Larose��Chantal D.Larose ��', '84.10', '�廪��ѧ������', '2', '2017-03-01 00:00:00', '725', '1144000', 'ƽװ', '16��', '����ֽ');
INSERT INTO `t_book` VALUES ('9787508344980', 'Head First Java������Java5.0��', '[��] ������Sierra K.����[��] ���ģ�Bates B.�� ��', '53.90', '�й�����������', '2', '2007-02-01 00:00:00', '689', '983000', 'ƽװ', '16��', '����ֽ');

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '��¼���',
  `uid` char(11) NOT NULL COMMENT '�û���ţ��û��ֻ��ţ�',
  `book` char(13) NOT NULL COMMENT 'ͼ�飨ͼ���ţ�',
  `count` int(11) NOT NULL COMMENT '����',
  PRIMARY KEY (`rid`),
  KEY `fk_cart_item_book` (`book`),
  KEY `fk_cart_item_user` (`uid`) USING BTREE,
  CONSTRAINT `fk_cart_item_book` FOREIGN KEY (`book`) REFERENCES `t_book` (`isbn`),
  CONSTRAINT `fk_cart_item_user` FOREIGN KEY (`uid`) REFERENCES `t_user` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='���ﳵ��Ϣ��';

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES ('1', '12345678901', '9787302383666', '3');
INSERT INTO `t_cart` VALUES ('2', '12345678901', '9787111213826', '2');
INSERT INTO `t_cart` VALUES ('3', '12345678901', '9787115130228', '1');

-- ----------------------------
-- Table structure for t_collect
-- ----------------------------
DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '��¼���',
  `uid` char(11) NOT NULL COMMENT '�û���ţ��û��ֻ��ţ�',
  `book` char(13) NOT NULL COMMENT 'ͼ�飨ͼ���ţ�',
  PRIMARY KEY (`rid`),
  KEY `fk_collect_user` (`uid`),
  KEY `fk_collect_book` (`book`),
  CONSTRAINT `fk_collect_book` FOREIGN KEY (`book`) REFERENCES `t_book` (`isbn`),
  CONSTRAINT `fk_collect_user` FOREIGN KEY (`uid`) REFERENCES `t_user` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='�û��ղر�';

-- ----------------------------
-- Records of t_collect
-- ----------------------------
INSERT INTO `t_collect` VALUES ('1', '12345678901', '9787302383666');
INSERT INTO `t_collect` VALUES ('2', '12345678901', '9787115130228');
INSERT INTO `t_collect` VALUES ('3', '12345678901', '9787111532644');
INSERT INTO `t_collect` VALUES ('4', '12345678901', '9787111545682');
INSERT INTO `t_collect` VALUES ('5', '12345678901', '9787115335500');
INSERT INTO `t_collect` VALUES ('6', '12345678901', '9787302435167');

-- ----------------------------
-- Table structure for t_oitem
-- ----------------------------
DROP TABLE IF EXISTS `t_oitem`;
CREATE TABLE `t_oitem` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '��¼���',
  `product` char(13) NOT NULL COMMENT '��Ʒ����Ʒ��ţ�',
  `price` double(9,2) NOT NULL COMMENT '�۸�',
  `count` int(11) NOT NULL COMMENT '����',
  `oid` char(17) NOT NULL COMMENT '�������',
  PRIMARY KEY (`rid`),
  KEY `fk_order_item_order` (`oid`),
  KEY `fk_order_item_book` (`product`),
  CONSTRAINT `fk_order_item_book` FOREIGN KEY (`product`) REFERENCES `t_book` (`isbn`),
  CONSTRAINT `fk_order_item_order` FOREIGN KEY (`oid`) REFERENCES `t_order` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������Ŀ��';

-- ----------------------------
-- Records of t_oitem
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '��¼���',
  `uid` char(11) NOT NULL COMMENT '�û���ţ��û��ֻ��ţ�',
  `oid` char(17) NOT NULL COMMENT '������ţ��ֻ��ź�3λ+yyyyMMddHHmmss��',
  `sta` varchar(10) NOT NULL COMMENT '����״̬�������������У��ѷ������ѽ�����',
  `aid` int(11) DEFAULT NULL COMMENT '�ջ���ַ',
  `payment` double(9,2) DEFAULT NULL COMMENT '֧�����',
  `placed` datetime DEFAULT NULL COMMENT '�µ�ʱ��',
  `receipt` datetime DEFAULT NULL COMMENT '�ӵ�ʱ��',
  `deliver` datetime DEFAULT NULL COMMENT '����ʱ��',
  `handover` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`rid`),
  UNIQUE KEY `uni_order` (`oid`) USING BTREE,
  KEY `fk_order_user` (`uid`),
  KEY `fk_order_address` (`aid`),
  CONSTRAINT `fk_order_address` FOREIGN KEY (`aid`) REFERENCES `t_address` (`rid`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`uid`) REFERENCES `t_user` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������Ϣ��';

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_recommended
-- ----------------------------
DROP TABLE IF EXISTS `t_recommended`;
CREATE TABLE `t_recommended` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '��¼���',
  `book` char(13) NOT NULL COMMENT 'ͼ�飨ͼ���ţ�',
  PRIMARY KEY (`rid`),
  KEY `fk_recommended_book` (`book`),
  CONSTRAINT `fk_recommended_book` FOREIGN KEY (`book`) REFERENCES `t_book` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='��Ʒ�Ƽ���';

-- ----------------------------
-- Records of t_recommended
-- ----------------------------
INSERT INTO `t_recommended` VALUES ('4', '9787111213826');
INSERT INTO `t_recommended` VALUES ('3', '9787111545682');
INSERT INTO `t_recommended` VALUES ('2', '9787115335500');
INSERT INTO `t_recommended` VALUES ('1', '9787302435167');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `phone` char(11) NOT NULL COMMENT '�绰���ֻ��ţ�',
  `uname` varchar(30) NOT NULL COMMENT '�û���',
  `upwd` char(32) NOT NULL DEFAULT '000000' COMMENT '����',
  `email` varchar(30) NOT NULL COMMENT '����',
  `role` int(1) NOT NULL DEFAULT '0' COMMENT '��ɫ��1��ʾ����Ա��',
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���Ϣ��';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('12345678900', 'admin1', '6E51762B8E71243BBDEF2A976E18FC76', 'admin1@abc', '1');
INSERT INTO `t_user` VALUES ('12345678901', 'user01', '4C0B8AB7D60A3EF5D0D0858ABC7F2BDA', 'user01@abc', '0');
INSERT INTO `t_user` VALUES ('12345678902', 'user02', '35F6DD389C1D1B4358C53594C1CF0CC7', 'user02@abc', '0');
