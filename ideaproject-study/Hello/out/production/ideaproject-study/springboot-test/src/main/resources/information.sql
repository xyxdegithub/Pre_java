/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : information

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 08/07/2021 23:02:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for toudangbiao
-- ----------------------------
DROP TABLE IF EXISTS `toudangbiao`;
CREATE TABLE `toudangbiao`  (
  `id` int(11) NOT NULL,
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `collegeId` int(255) NOT NULL,
  `collegeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` int(255) NULL DEFAULT NULL,
  `rank` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`collegeId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of toudangbiao
-- ----------------------------
INSERT INTO `toudangbiao` VALUES (1, '文史', 3, '中国人民公安大学', 586, 2267);
INSERT INTO `toudangbiao` VALUES (2, '文史', 4, '北京师范大学★', 618, 331);
INSERT INTO `toudangbiao` VALUES (3, '文史', 7, '北京体育大学▲', 583, 2627);
INSERT INTO `toudangbiao` VALUES (4, '文史', 43, '天津师范大学', 573, 4197);
INSERT INTO `toudangbiao` VALUES (5, '文史', 74, '河北师范大学', 560, 6822);
INSERT INTO `toudangbiao` VALUES (6, '文史', 191, '大连海事大学▲', 585, 2414);
INSERT INTO `toudangbiao` VALUES (7, '文史', 221, '东北师范大学▲', 592, 1702);
INSERT INTO `toudangbiao` VALUES (8, '文史', 241, '哈尔滨师范大学', 560, 6926);
INSERT INTO `toudangbiao` VALUES (9, '文史', 282, '华东师范大学★', 612, 499);
INSERT INTO `toudangbiao` VALUES (10, '文史', 311, '南京师范大学▲', 595, 1463);
INSERT INTO `toudangbiao` VALUES (11, '文史', 351, '浙江师范大学', 578, 3363);
INSERT INTO `toudangbiao` VALUES (12, '文史', 381, '安徽师范大学', 564, 5923);
INSERT INTO `toudangbiao` VALUES (13, '文史', 421, '福建师范大学', 565, 5681);
INSERT INTO `toudangbiao` VALUES (14, '文史', 461, '山东师范大学', 565, 5740);
INSERT INTO `toudangbiao` VALUES (15, '文史', 501, '河南师范大学', 560, 6955);
INSERT INTO `toudangbiao` VALUES (16, '文史', 541, '华中师范大学▲', 595, 1474);
INSERT INTO `toudangbiao` VALUES (17, '文史', 602, '湖南师范大学▲', 592, 1671);
INSERT INTO `toudangbiao` VALUES (18, '文史', 662, '华南师范大学▲', 595, 1469);
INSERT INTO `toudangbiao` VALUES (19, '文史', 668, '北京师范大学(珠海校区)★', 597, 1278);
INSERT INTO `toudangbiao` VALUES (20, '文史', 751, '海南师范大学', 561, 6747);
INSERT INTO `toudangbiao` VALUES (21, '文史', 771, '重庆师范大学', 567, 5352);
INSERT INTO `toudangbiao` VALUES (22, '文史', 772, '西南大学▲', 594, 1499);
INSERT INTO `toudangbiao` VALUES (23, '文史', 775, '西南大学(荣昌校区)▲', 579, 3215);
INSERT INTO `toudangbiao` VALUES (24, '文史', 791, '四川师范大学', 569, 5030);
INSERT INTO `toudangbiao` VALUES (25, '文史', 921, '西北师范大学', 562, 6542);
INSERT INTO `toudangbiao` VALUES (26, '文史', 981, '新疆师范大学', 547, 10974);
INSERT INTO `toudangbiao` VALUES (27, '文史', 1001, '中央民族大学★', 601, 1036);
INSERT INTO `toudangbiao` VALUES (28, '文史', 1002, '华北电力大学(北京)▲', 590, 1910);
INSERT INTO `toudangbiao` VALUES (29, '文史', 1003, '北京大学★', 644, 24);
INSERT INTO `toudangbiao` VALUES (30, '文史', 1005, '中国人民大学★', 632, 92);
INSERT INTO `toudangbiao` VALUES (31, '文史', 1006, '清华大学★', 649, 13);
INSERT INTO `toudangbiao` VALUES (32, '文史', 1007, '北京交通大学▲', 600, 1083);
INSERT INTO `toudangbiao` VALUES (33, '文史', 1008, '北京科技大学▲', 597, 1319);
INSERT INTO `toudangbiao` VALUES (34, '文史', 1009, '北京化工大学▲', 589, 2022);
INSERT INTO `toudangbiao` VALUES (35, '文史', 1010, '北京邮电大学▲', 596, 1343);
INSERT INTO `toudangbiao` VALUES (36, '文史', 1012, '北京林业大学▲', 590, 1827);
INSERT INTO `toudangbiao` VALUES (37, '文史', 1013, '北京中医药大学▲', 602, 977);
INSERT INTO `toudangbiao` VALUES (38, '文史', 1014, '北京语言大学', 590, 1844);
INSERT INTO `toudangbiao` VALUES (39, '文史', 1015, '中国传媒大学▲', 609, 624);
INSERT INTO `toudangbiao` VALUES (40, '文史', 1016, '中央财经大学▲', 610, 597);
INSERT INTO `toudangbiao` VALUES (41, '文史', 1017, '对外经济贸易大学▲', 612, 485);
INSERT INTO `toudangbiao` VALUES (42, '文史', 1018, '中国政法大学▲', 614, 435);
INSERT INTO `toudangbiao` VALUES (43, '文史', 1019, '中国矿业大学(北京)▲', 588, 2098);
INSERT INTO `toudangbiao` VALUES (44, '文史', 1020, '中国石油大学(北京)▲', 588, 2111);
INSERT INTO `toudangbiao` VALUES (45, '文史', 1023, '北京理工大学★', 606, 739);
INSERT INTO `toudangbiao` VALUES (46, '文史', 1025, '北京第二外国语学院', 588, 2090);
INSERT INTO `toudangbiao` VALUES (47, '文史', 1027, '北京外国语大学▲', 610, 587);
INSERT INTO `toudangbiao` VALUES (48, '文史', 1029, '中国社会科学院大学', 604, 838);
INSERT INTO `toudangbiao` VALUES (49, '文史', 1041, '南开大学★', 614, 428);
INSERT INTO `toudangbiao` VALUES (50, '文史', 1047, '天津财经大学', 571, 4652);
INSERT INTO `toudangbiao` VALUES (51, '文史', 1071, '石家庄铁道大学', 560, 6859);
INSERT INTO `toudangbiao` VALUES (52, '文史', 1072, '华北电力大学(保定)▲', 580, 3108);
INSERT INTO `toudangbiao` VALUES (53, '文史', 1073, '燕山大学', 567, 5290);
INSERT INTO `toudangbiao` VALUES (54, '文史', 1191, '东北财经大学', 592, 1678);
INSERT INTO `toudangbiao` VALUES (55, '文史', 1196, '东北大学★', 593, 1568);
INSERT INTO `toudangbiao` VALUES (56, '文史', 1198, '辽宁大学▲', 587, 2208);
INSERT INTO `toudangbiao` VALUES (57, '文史', 1221, '吉林大学★', 599, 1139);
INSERT INTO `toudangbiao` VALUES (58, '文史', 1222, '延边大学▲', 568, 5090);
INSERT INTO `toudangbiao` VALUES (59, '文史', 1223, '长春理工大学', 557, 7815);
INSERT INTO `toudangbiao` VALUES (60, '文史', 1243, '东北农业大学▲', 570, 4793);
INSERT INTO `toudangbiao` VALUES (61, '文史', 1244, '哈尔滨医科大学', 559, 7107);
INSERT INTO `toudangbiao` VALUES (62, '文史', 1245, '东北石油大学', 552, 9303);
INSERT INTO `toudangbiao` VALUES (63, '文史', 1246, '东北林业大学▲', 570, 4718);
INSERT INTO `toudangbiao` VALUES (64, '文史', 1247, '黑龙江中医药大学', 562, 6362);
INSERT INTO `toudangbiao` VALUES (65, '文史', 1281, '复旦大学★', 634, 71);
INSERT INTO `toudangbiao` VALUES (66, '文史', 1282, '同济大学★', 613, 451);
INSERT INTO `toudangbiao` VALUES (67, '文史', 1283, '上海交通大学★', 631, 99);
INSERT INTO `toudangbiao` VALUES (68, '文史', 1286, '上海外国语大学▲', 610, 561);
INSERT INTO `toudangbiao` VALUES (69, '文史', 1287, '上海财经大学▲', 618, 321);
INSERT INTO `toudangbiao` VALUES (70, '文史', 1289, '华东政法大学', 601, 1027);
INSERT INTO `toudangbiao` VALUES (71, '文史', 1290, '上海大学▲', 598, 1219);
INSERT INTO `toudangbiao` VALUES (72, '文史', 1291, '上海对外经贸大学', 590, 1859);
INSERT INTO `toudangbiao` VALUES (73, '文史', 1294, '上海理工大学', 577, 3540);
INSERT INTO `toudangbiao` VALUES (74, '文史', 1310, '中国人民大学(苏州校区)★', 606, 730);
INSERT INTO `toudangbiao` VALUES (75, '文史', 1311, '南京大学★', 628, 127);
INSERT INTO `toudangbiao` VALUES (76, '文史', 1313, '中国矿业大学▲', 586, 2341);
INSERT INTO `toudangbiao` VALUES (77, '文史', 1314, '河海大学▲', 593, 1636);
INSERT INTO `toudangbiao` VALUES (78, '文史', 1316, '中国药科大学▲', 588, 2128);
INSERT INTO `toudangbiao` VALUES (79, '文史', 1318, '南京航空航天大学▲', 594, 1520);
INSERT INTO `toudangbiao` VALUES (80, '文史', 1319, '苏州大学▲', 600, 1076);
INSERT INTO `toudangbiao` VALUES (81, '文史', 1321, '江南大学▲', 592, 1721);
INSERT INTO `toudangbiao` VALUES (82, '文史', 1322, '江苏大学', 580, 3139);
INSERT INTO `toudangbiao` VALUES (83, '文史', 1323, '扬州大学', 581, 2990);
INSERT INTO `toudangbiao` VALUES (84, '文史', 1324, '江苏科技大学', 569, 5036);
INSERT INTO `toudangbiao` VALUES (85, '文史', 1325, '西交利物浦大学', 557, 7873);
INSERT INTO `toudangbiao` VALUES (86, '文史', 1351, '浙江大学★', 627, 133);
INSERT INTO `toudangbiao` VALUES (87, '文史', 1354, '浙江理工大学', 575, 3960);
INSERT INTO `toudangbiao` VALUES (88, '文史', 1356, '浙江工商大学', 587, 2233);
INSERT INTO `toudangbiao` VALUES (89, '文史', 1357, '宁波诺丁汉大学', 557, 7867);
INSERT INTO `toudangbiao` VALUES (90, '文史', 1381, '合肥工业大学▲', 575, 3793);
INSERT INTO `toudangbiao` VALUES (91, '文史', 1383, '安徽大学▲', 587, 2145);
INSERT INTO `toudangbiao` VALUES (92, '文史', 1384, '合肥工业大学(宣城校区)▲', 573, 4295);
INSERT INTO `toudangbiao` VALUES (93, '文史', 1421, '厦门大学★', 614, 421);
INSERT INTO `toudangbiao` VALUES (94, '文史', 1422, '福州大学▲', 591, 1734);
INSERT INTO `toudangbiao` VALUES (95, '文史', 1461, '山东大学★', 603, 890);
INSERT INTO `toudangbiao` VALUES (96, '文史', 1462, '中国海洋大学★', 597, 1283);
INSERT INTO `toudangbiao` VALUES (97, '文史', 1464, '山东大学威海分校★', 598, 1239);
INSERT INTO `toudangbiao` VALUES (98, '文史', 1501, '郑州大学▲', 589, 1952);
INSERT INTO `toudangbiao` VALUES (99, '文史', 1502, '河南大学', 572, 4486);
INSERT INTO `toudangbiao` VALUES (100, '文史', 1541, '华中农业大学▲', 588, 2110);
INSERT INTO `toudangbiao` VALUES (101, '文史', 1542, '武汉大学★', 621, 266);
INSERT INTO `toudangbiao` VALUES (102, '文史', 1543, '中南财经政法大学▲', 601, 1031);
INSERT INTO `toudangbiao` VALUES (103, '文史', 1544, '华中科技大学★', 608, 656);
INSERT INTO `toudangbiao` VALUES (104, '文史', 1545, '武汉理工大学▲', 590, 1912);
INSERT INTO `toudangbiao` VALUES (105, '文史', 1546, '中国地质大学(武汉)▲', 590, 1875);
INSERT INTO `toudangbiao` VALUES (106, '文史', 1548, '武汉科技大学', 570, 4751);
INSERT INTO `toudangbiao` VALUES (107, '文史', 1601, '湖南大学★', 604, 851);
INSERT INTO `toudangbiao` VALUES (108, '文史', 1602, '中南大学★', 603, 906);
INSERT INTO `toudangbiao` VALUES (109, '文史', 1603, '湘潭大学', 571, 4571);
INSERT INTO `toudangbiao` VALUES (110, '文史', 1661, '中山大学★', 616, 362);
INSERT INTO `toudangbiao` VALUES (111, '文史', 1662, '华南理工大学★', 605, 799);
INSERT INTO `toudangbiao` VALUES (112, '文史', 1663, '华南农业大学', 577, 3487);
INSERT INTO `toudangbiao` VALUES (113, '文史', 1664, '暨南大学▲', 598, 1208);
INSERT INTO `toudangbiao` VALUES (114, '文史', 1665, '广州中医药大学', 577, 3611);
INSERT INTO `toudangbiao` VALUES (115, '文史', 1666, '汕头大学', 583, 2697);
INSERT INTO `toudangbiao` VALUES (116, '文史', 1667, '广东外语外贸大学', 591, 1799);
INSERT INTO `toudangbiao` VALUES (117, '文史', 1668, '深圳大学', 597, 1318);
INSERT INTO `toudangbiao` VALUES (118, '文史', 1669, '南方医科大学', 571, 4623);
INSERT INTO `toudangbiao` VALUES (119, '文史', 1721, '广西大学▲', 574, 4110);
INSERT INTO `toudangbiao` VALUES (120, '文史', 1751, '海南大学▲', 576, 3660);
INSERT INTO `toudangbiao` VALUES (121, '文史', 1771, '重庆大学★', 603, 924);
INSERT INTO `toudangbiao` VALUES (122, '文史', 1772, '西南政法大学', 599, 1151);
INSERT INTO `toudangbiao` VALUES (123, '文史', 1791, '西南交通大学▲', 591, 1785);
INSERT INTO `toudangbiao` VALUES (124, '文史', 1792, '电子科技大学★', 599, 1170);
INSERT INTO `toudangbiao` VALUES (125, '文史', 1793, '西南财经大学▲', 598, 1222);
INSERT INTO `toudangbiao` VALUES (126, '文史', 1794, '四川大学★', 611, 545);
INSERT INTO `toudangbiao` VALUES (127, '文史', 1831, '贵州大学▲', 571, 4525);
INSERT INTO `toudangbiao` VALUES (128, '文史', 1851, '云南大学▲', 587, 2222);
INSERT INTO `toudangbiao` VALUES (129, '文史', 1872, '西北农林科技大学★', 590, 1922);
INSERT INTO `toudangbiao` VALUES (130, '文史', 1873, '西安交通大学★', 607, 707);
INSERT INTO `toudangbiao` VALUES (131, '文史', 1874, '西北大学▲', 590, 1888);
INSERT INTO `toudangbiao` VALUES (132, '文史', 1877, '西北工业大学★', 595, 1432);
INSERT INTO `toudangbiao` VALUES (133, '文史', 1878, '长安大学▲', 585, 2394);
INSERT INTO `toudangbiao` VALUES (134, '文史', 1921, '兰州大学★', 594, 1517);
INSERT INTO `toudangbiao` VALUES (135, '文史', 1961, '宁夏大学▲', 567, 5475);
INSERT INTO `toudangbiao` VALUES (136, '文史', 1982, '石河子大学▲', 555, 8372);
INSERT INTO `toudangbiao` VALUES (137, '文史', 1983, '中国石油大学(北京)克拉玛依校区▲', 561, 6649);
INSERT INTO `toudangbiao` VALUES (138, '文史', 2004, '北京印刷学院', 566, 5578);
INSERT INTO `toudangbiao` VALUES (139, '文史', 2007, '北京物资学院', 563, 6182);
INSERT INTO `toudangbiao` VALUES (140, '文史', 2008, '北京信息科技大学', 567, 5317);
INSERT INTO `toudangbiao` VALUES (141, '文史', 2010, '首都经济贸易大学', 592, 1696);
INSERT INTO `toudangbiao` VALUES (142, '文史', 2011, '北京工商大学', 574, 4093);
INSERT INTO `toudangbiao` VALUES (143, '文史', 2016, '北京联合大学', 569, 4947);
INSERT INTO `toudangbiao` VALUES (144, '文史', 2020, '首都师范大学', 593, 1613);
INSERT INTO `toudangbiao` VALUES (145, '文史', 2041, '天津工业大学', 563, 6148);
INSERT INTO `toudangbiao` VALUES (146, '文史', 2042, '天津科技大学', 566, 5499);
INSERT INTO `toudangbiao` VALUES (147, '文史', 2045, '天津外国语大学', 577, 3590);
INSERT INTO `toudangbiao` VALUES (148, '文史', 2046, '天津商业大学', 565, 5784);
INSERT INTO `toudangbiao` VALUES (149, '文史', 2047, '天津中医药大学', 562, 6387);
INSERT INTO `toudangbiao` VALUES (150, '文史', 2049, '中国民航大学', 566, 5518);
INSERT INTO `toudangbiao` VALUES (151, '文史', 2071, '河北大学', 567, 5344);
INSERT INTO `toudangbiao` VALUES (152, '文史', 2073, '华北理工大学', 554, 8606);
INSERT INTO `toudangbiao` VALUES (153, '文史', 2131, '山西大学', 564, 5913);
INSERT INTO `toudangbiao` VALUES (154, '文史', 2133, '中北大学', 561, 6776);
INSERT INTO `toudangbiao` VALUES (155, '文史', 2137, '山西财经大学', 567, 5480);
INSERT INTO `toudangbiao` VALUES (156, '文史', 2200, '大连外国语大学', 574, 3996);
INSERT INTO `toudangbiao` VALUES (157, '文史', 2243, '黑龙江大学', 561, 6760);
INSERT INTO `toudangbiao` VALUES (158, '文史', 2245, '哈尔滨商业大学', 561, 6577);
INSERT INTO `toudangbiao` VALUES (159, '文史', 2281, '上海师范大学', 581, 2911);
INSERT INTO `toudangbiao` VALUES (160, '文史', 2283, '上海电力大学', 569, 4969);
INSERT INTO `toudangbiao` VALUES (161, '文史', 2284, '上海应用技术大学', 568, 5255);
INSERT INTO `toudangbiao` VALUES (162, '文史', 2285, '上海海事大学', 585, 2419);
INSERT INTO `toudangbiao` VALUES (163, '文史', 2286, '上海海洋大学', 574, 4143);
INSERT INTO `toudangbiao` VALUES (164, '文史', 2287, '上海工程技术大学', 557, 7866);
INSERT INTO `toudangbiao` VALUES (165, '文史', 2289, '上海第二工业大学', 568, 5203);
INSERT INTO `toudangbiao` VALUES (166, '文史', 2290, '上海立信会计金融学院', 587, 2232);
INSERT INTO `toudangbiao` VALUES (167, '文史', 2292, '上海电机学院', 561, 6789);
INSERT INTO `toudangbiao` VALUES (168, '文史', 2293, '上海政法学院', 584, 2549);
INSERT INTO `toudangbiao` VALUES (169, '文史', 2312, '南京工业大学', 572, 4409);
INSERT INTO `toudangbiao` VALUES (170, '文史', 2313, '常州大学', 567, 5394);
INSERT INTO `toudangbiao` VALUES (171, '文史', 2314, '南京邮电大学', 583, 2734);
INSERT INTO `toudangbiao` VALUES (172, '文史', 2315, '南京林业大学', 573, 4271);
INSERT INTO `toudangbiao` VALUES (173, '文史', 2317, '南京审计大学', 591, 1729);
INSERT INTO `toudangbiao` VALUES (174, '文史', 2319, '南京财经大学', 587, 2240);
INSERT INTO `toudangbiao` VALUES (175, '文史', 2321, '苏州科技大学', 565, 5760);
INSERT INTO `toudangbiao` VALUES (176, '文史', 2330, '南通大学', 560, 6946);
INSERT INTO `toudangbiao` VALUES (177, '文史', 2341, '南京医科大学', 569, 5011);
INSERT INTO `toudangbiao` VALUES (178, '文史', 2355, '浙江农林大学', 565, 5815);
INSERT INTO `toudangbiao` VALUES (179, '文史', 2361, '中国计量大学', 576, 3657);
INSERT INTO `toudangbiao` VALUES (180, '文史', 2365, '浙江科技学院', 562, 6462);
INSERT INTO `toudangbiao` VALUES (181, '文史', 2367, '杭州师范大学', 579, 3160);
INSERT INTO `toudangbiao` VALUES (182, '文史', 2371, '湖州师范学院', 560, 6956);
INSERT INTO `toudangbiao` VALUES (183, '文史', 2375, '浙江财经大学', 584, 2606);
INSERT INTO `toudangbiao` VALUES (184, '文史', 2376, '温州肯恩大学', 549, 10075);
INSERT INTO `toudangbiao` VALUES (185, '文史', 2382, '安徽工业大学', 560, 6867);
INSERT INTO `toudangbiao` VALUES (186, '文史', 2385, '安徽财经大学', 569, 4904);
INSERT INTO `toudangbiao` VALUES (187, '文史', 2421, '闽江学院', 562, 6501);
INSERT INTO `toudangbiao` VALUES (188, '文史', 2427, '集美大学', 581, 3014);
INSERT INTO `toudangbiao` VALUES (189, '文史', 2431, '华侨大学', 576, 3640);
INSERT INTO `toudangbiao` VALUES (190, '文史', 2461, '烟台大学', 567, 5385);
INSERT INTO `toudangbiao` VALUES (191, '文史', 2462, '山东科技大学', 565, 5873);
INSERT INTO `toudangbiao` VALUES (192, '文史', 2463, '青岛大学', 575, 3853);
INSERT INTO `toudangbiao` VALUES (193, '文史', 2468, '济南大学', 569, 4889);
INSERT INTO `toudangbiao` VALUES (194, '文史', 2483, '山东工商学院', 559, 7183);
INSERT INTO `toudangbiao` VALUES (195, '文史', 2489, '曲阜师范大学', 561, 6642);
INSERT INTO `toudangbiao` VALUES (196, '文史', 2504, '河南工业大学', 559, 7346);
INSERT INTO `toudangbiao` VALUES (197, '文史', 2517, '河南财经政法大学', 567, 5464);
INSERT INTO `toudangbiao` VALUES (198, '文史', 2542, '武汉纺织大学', 561, 6654);
INSERT INTO `toudangbiao` VALUES (199, '文史', 2544, '湖北工业大学', 565, 5787);
INSERT INTO `toudangbiao` VALUES (200, '文史', 2546, '湖北大学', 572, 4363);
INSERT INTO `toudangbiao` VALUES (601, '理工', 2875, '西安石油大学', 556, 30499);
INSERT INTO `toudangbiao` VALUES (602, '理工', 2878, '西安外国语大学', 573, 21919);
INSERT INTO `toudangbiao` VALUES (603, '理工', 2879, '西北政法大学', 584, 17368);
INSERT INTO `toudangbiao` VALUES (604, '理工', 2880, '陕西中医药大学', 542, 39060);
INSERT INTO `toudangbiao` VALUES (605, '理工', 2921, '兰州理工大学', 552, 32964);
INSERT INTO `toudangbiao` VALUES (606, '理工', 2925, '兰州交通大学', 546, 36733);
INSERT INTO `toudangbiao` VALUES (607, '理工', 2964, '宁夏医科大学', 571, 22747);
INSERT INTO `toudangbiao` VALUES (608, '理工', 2990, '新疆医科大学', 546, 36677);
INSERT INTO `toudangbiao` VALUES (609, '理工', 4600, '北京化工大学▲', 564, 26528);
INSERT INTO `toudangbiao` VALUES (610, '理工', 4601, '中国农业大学★', 577, 20016);
INSERT INTO `toudangbiao` VALUES (611, '理工', 4602, '中央财经大学▲', 611, 8458);
INSERT INTO `toudangbiao` VALUES (612, '理工', 4603, '北京理工大学★', 608, 9165);
INSERT INTO `toudangbiao` VALUES (613, '理工', 4604, '北京工业大学▲', 591, 14601);
INSERT INTO `toudangbiao` VALUES (614, '理工', 4607, '天津外国语大学', 560, 28661);
INSERT INTO `toudangbiao` VALUES (615, '理工', 4608, '天津中医药大学', 535, 43925);
INSERT INTO `toudangbiao` VALUES (616, '理工', 4616, '大连理工大学★', 615, 7312);
INSERT INTO `toudangbiao` VALUES (617, '理工', 4621, '吉林大学★', 605, 10017);
INSERT INTO `toudangbiao` VALUES (618, '理工', 4629, '同济大学★', 648, 1694);
INSERT INTO `toudangbiao` VALUES (619, '理工', 4634, '上海大学▲', 579, 19450);
INSERT INTO `toudangbiao` VALUES (620, '理工', 4639, '上海应用技术大学', 543, 38563);
INSERT INTO `toudangbiao` VALUES (621, '理工', 4642, '河海大学▲', 561, 27764);
INSERT INTO `toudangbiao` VALUES (622, '理工', 4643, '南京理工大学▲', 546, 36386);
INSERT INTO `toudangbiao` VALUES (623, '理工', 4646, '宁波大学', 553, 32118);
INSERT INTO `toudangbiao` VALUES (624, '理工', 4650, '浙江大学医学院★', 630, 4101);
INSERT INTO `toudangbiao` VALUES (625, '理工', 4658, '福建师范大学', 548, 35457);
INSERT INTO `toudangbiao` VALUES (626, '理工', 4665, '中国海洋大学★', 586, 16410);
INSERT INTO `toudangbiao` VALUES (627, '理工', 4672, '武汉理工大学▲', 593, 13873);
INSERT INTO `toudangbiao` VALUES (628, '理工', 4680, '长沙理工大学', 561, 27913);
INSERT INTO `toudangbiao` VALUES (629, '理工', 4686, '暨南大学▲', 591, 14387);
INSERT INTO `toudangbiao` VALUES (630, '理工', 4695, '海南师范大学', 546, 36687);
INSERT INTO `toudangbiao` VALUES (631, '理工', 4696, '海南大学▲', 558, 29661);
INSERT INTO `toudangbiao` VALUES (632, '理工', 4698, '重庆师范大学', 539, 41185);
INSERT INTO `toudangbiao` VALUES (633, '理工', 4699, '重庆邮电大学', 563, 26876);
INSERT INTO `toudangbiao` VALUES (634, '理工', 4700, '重庆交通大学', 540, 40292);
INSERT INTO `toudangbiao` VALUES (635, '理工', 4701, '重庆医科大学', 582, 18118);
INSERT INTO `toudangbiao` VALUES (636, '理工', 4704, '电子科技大学(沙河校区)★', 617, 6994);
INSERT INTO `toudangbiao` VALUES (637, '理工', 4708, '陕西科技大学', 546, 36632);
INSERT INTO `toudangbiao` VALUES (638, '理工', 4709, '西北工业大学★', 598, 12033);
INSERT INTO `toudangbiao` VALUES (639, '理工', 4710, '长安大学▲', 561, 27977);
INSERT INTO `toudangbiao` VALUES (640, '理工', 4713, '浙江大学★', 624, 5250);
INSERT INTO `toudangbiao` VALUES (641, '理工', 4800, '山东大学★', 561, 27933);
INSERT INTO `toudangbiao` VALUES (642, '理工', 4801, '武汉大学★', 593, 13749);
INSERT INTO `toudangbiao` VALUES (643, '理工', 4802, '中山大学★', 600, 11490);
INSERT INTO `toudangbiao` VALUES (644, '理工', 4804, '武汉大学★', 627, 4616);
INSERT INTO `toudangbiao` VALUES (645, '理工', 4806, '南开大学★', 640, 2558);
INSERT INTO `toudangbiao` VALUES (646, '理工', 4807, '华中科技大学★', 616, 7043);
INSERT INTO `toudangbiao` VALUES (647, '理工', 4808, '中山大学★', 612, 8184);
INSERT INTO `toudangbiao` VALUES (648, '理工', 4900, '南京理工大学▲', 592, 14328);
INSERT INTO `toudangbiao` VALUES (649, '理工', 5281, '上海健康医学院', 568, 24435);
INSERT INTO `toudangbiao` VALUES (650, '理工', 8001, '江西师范大学', 568, 24309);
INSERT INTO `toudangbiao` VALUES (651, '理工', 8031, '江西师范大学', 548, 35304);
INSERT INTO `toudangbiao` VALUES (652, '理工', 8101, '南昌大学▲', 584, 17061);
INSERT INTO `toudangbiao` VALUES (653, '理工', 8102, '江西财经大学', 573, 21800);
INSERT INTO `toudangbiao` VALUES (654, '理工', 8161, '南昌大学▲', 587, 15856);
INSERT INTO `toudangbiao` VALUES (655, '理工', 8201, '江西农业大学', 535, 43925);
INSERT INTO `toudangbiao` VALUES (656, '理工', 8202, '华东交通大学', 560, 28460);
INSERT INTO `toudangbiao` VALUES (657, '理工', 8203, '江西理工大学', 536, 42863);
INSERT INTO `toudangbiao` VALUES (658, '理工', 8204, '东华理工大学', 537, 42248);
INSERT INTO `toudangbiao` VALUES (659, '理工', 8205, '南昌航空大学', 552, 32759);
INSERT INTO `toudangbiao` VALUES (660, '理工', 8206, '景德镇陶瓷大学', 535, 43925);
INSERT INTO `toudangbiao` VALUES (661, '理工', 8208, '江西中医药大学', 535, 43925);
INSERT INTO `toudangbiao` VALUES (662, '理工', 8209, '赣南医学院', 552, 32949);
INSERT INTO `toudangbiao` VALUES (663, '理工', 8210, '赣南师范大学', 539, 40652);
INSERT INTO `toudangbiao` VALUES (664, '理工', 8211, '江西科技师范大学', 537, 42507);
INSERT INTO `toudangbiao` VALUES (665, '理工', 8216, '井冈山大学', 539, 41177);
INSERT INTO `toudangbiao` VALUES (666, '理工', 8218, '南昌工程学院', 535, 43925);
INSERT INTO `toudangbiao` VALUES (667, '理工', 8221, '南昌航空大学', 539, 40842);
INSERT INTO `toudangbiao` VALUES (668, '理工', 8263, '华东交通大学', 535, 43925);
INSERT INTO `toudangbiao` VALUES (669, '理工', 9600, '江西师范大学(地方专项计划)', 562, 27442);
INSERT INTO `toudangbiao` VALUES (670, '理工', 9601, '南昌大学(地方专项计划)▲', 579, 19230);
INSERT INTO `toudangbiao` VALUES (671, '理工', 9602, '江西财经大学(地方专项计划)', 570, 23512);
INSERT INTO `toudangbiao` VALUES (672, '理工', 9618, '南昌工程学院(地方专项计划)', 535, 43925);
INSERT INTO `toudangbiao` VALUES (673, '理工', 9621, '江西农业大学(地方专项计划)', 536, 42998);
INSERT INTO `toudangbiao` VALUES (674, '理工', 9622, '华东交通大学(地方专项计划)', 558, 29425);
INSERT INTO `toudangbiao` VALUES (675, '理工', 9623, '江西理工大学(地方专项计划)', 538, 41800);
INSERT INTO `toudangbiao` VALUES (676, '理工', 9625, '南昌航空大学(地方专项计划)', 552, 32700);
INSERT INTO `toudangbiao` VALUES (677, '理工', 9626, '景德镇陶瓷大学(地方专项计划)', 535, 43925);
INSERT INTO `toudangbiao` VALUES (678, '理工', 9630, '赣南师范大学(地方专项计划)', 536, 42865);
INSERT INTO `toudangbiao` VALUES (679, '理工', 9650, '江西师范大学(苏区专项计划)', 566, 25546);
INSERT INTO `toudangbiao` VALUES (680, '理工', 9651, '南昌大学(苏区专项计划)▲', 581, 18496);
INSERT INTO `toudangbiao` VALUES (681, '理工', 9652, '华东交通大学(苏区专项计划)', 558, 29333);
INSERT INTO `toudangbiao` VALUES (682, '理工', 9653, '江西理工大学(苏区专项计划)', 538, 41725);
INSERT INTO `toudangbiao` VALUES (683, '理工', 9655, '南昌航空大学(苏区专项计划)', 552, 32935);
INSERT INTO `toudangbiao` VALUES (684, '理工', 9658, '江西中医药大学(苏区专项计划)', 544, 37870);
INSERT INTO `toudangbiao` VALUES (685, '理工', 9659, '赣南医学院(苏区专项计划)', 549, 34970);
INSERT INTO `toudangbiao` VALUES (686, '理工', 9660, '赣南师范大学(苏区专项计划)', 538, 41847);
INSERT INTO `toudangbiao` VALUES (687, '理工', 9661, '江西农业大学(苏区专项计划)', 535, 43925);
INSERT INTO `toudangbiao` VALUES (688, '理工', 9662, '江西科技师范大学(苏区专项计划)', 535, 43503);
INSERT INTO `toudangbiao` VALUES (689, '理工', 9664, '东华理工大学(苏区专项计划)', 535, 43714);
INSERT INTO `toudangbiao` VALUES (690, '理工', 9666, '井冈山大学(苏区专项计划)', 535, 43925);
INSERT INTO `toudangbiao` VALUES (691, '理工', 9668, '南昌工程学院(苏区专项计划)', 535, 43925);
INSERT INTO `toudangbiao` VALUES (692, '理工', 9672, '江西财经大学(苏区专项计划)', 577, 20211);

SET FOREIGN_KEY_CHECKS = 1;
