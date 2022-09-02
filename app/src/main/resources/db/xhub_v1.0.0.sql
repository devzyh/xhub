/*

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 02/09/2022 14:52:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fav_article
-- ----------------------------
DROP TABLE IF EXISTS `fav_article`;
CREATE TABLE `fav_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '地址',
  `digest` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容摘要',
  `source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '来源平台',
  `created` date NULL DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fav_article
-- ----------------------------
INSERT INTO `fav_article` VALUES (1, '一文带你入门 JMeter 性能测试！\n', 'https://mp.weixin.qq.com/s/RczbJW_1gX_0s1fNs4K1dw', NULL, 'wxmp', '2021-10-26');
INSERT INTO `fav_article` VALUES (2, '读懂Redis源码，我总结了这7点心得', 'https://mp.weixin.qq.com/s/h-OEbiUUmKvUZqxmjfmgtg', NULL, 'wxmp', '2021-09-27');
INSERT INTO `fav_article` VALUES (3, '七步制作精简镜像', 'https://mp.weixin.qq.com/s/cSWHvIntrebJHzC53SM2lg', NULL, 'wxmp', '2021-10-27');
INSERT INTO `fav_article` VALUES (4, 'Spring中涉及的设计模式总结', 'https://mp.weixin.qq.com/s/m1V_FtlwP4cttcqy7sILMw', NULL, 'wxmp', '2021-09-02');
INSERT INTO `fav_article` VALUES (5, '阿里技术人看什么书？这个春节和你共享书单！', 'https://mp.weixin.qq.com/s/mDLZ7luWknk7TvQIQjZbBg', NULL, 'wxmp', '2021-02-12');
INSERT INTO `fav_article` VALUES (6, '武汉有哪些不错的互联网公司？', 'https://mp.weixin.qq.com/s/fhMkMMqTrAe-8Af6Jk4XAg', NULL, 'wxmp', '2021-10-21');
INSERT INTO `fav_article` VALUES (7, '聊聊订单系统的设计？', 'https://mp.weixin.qq.com/s/k8EXOaqjNIvWMgNzI4fJ3g', NULL, 'wxmp', '2021-09-10');
INSERT INTO `fav_article` VALUES (8, '【Gradle教程】Gradle 基础入门', 'https://www.cnblogs.com/hellxz/p/helloworld-gradle.html', NULL, 'cnblogs', '2020-05-30');
INSERT INTO `fav_article` VALUES (9, '算法执行过程可视化网站', 'https://www.cs.usfca.edu/~galles/visualization/Algorithms.html', NULL, 'direct', '2021-11-02');
INSERT INTO `fav_article` VALUES (10, '经典面试题：在浏览器地址栏输入一个 URL 后回车，背后发生了什么', 'https://www.cnblogs.com/cswiki/p/14429730.html', NULL, 'cnblogs', '2021-02-22');
INSERT INTO `fav_article` VALUES (11, '关于 TCP 三次握手和四次挥手，满分回答在此', 'https://mp.weixin.qq.com/s/u56NcMs68sgi6uDpzJ61yw', NULL, 'wxmp', '2021-01-07');
INSERT INTO `fav_article` VALUES (12, '别再恐惧 IP 协议（万字长文 | 多图预警）\n', 'https://mp.weixin.qq.com/s/NO9RDt1A3T1rz-Q4_Y0gPw', NULL, 'wxmp', '2021-01-15');
INSERT INTO `fav_article` VALUES (13, '48 张图 | 手摸手教你微服务的性能监控、压测和调优\n', 'https://www.cnblogs.com/jackson0714/p/performance.html', NULL, 'cnblogs', '2021-03-17');
INSERT INTO `fav_article` VALUES (14, 'Dubbo 与 Spring Cloud 完美结合\n', 'https://www.cnblogs.com/babycomeon/p/11546737.html', NULL, 'cnblogs', '2019-09-19');
INSERT INTO `fav_article` VALUES (15, '在Git的PR(Pull Request)提示冲突无法merge合并的解决方案', 'https://www.cnblogs.com/xxcanghai/p/12160556.html', NULL, 'cnblogs', '2020-01-07');
INSERT INTO `fav_article` VALUES (16, 'Java：CAS(乐观锁)', 'https://www.jianshu.com/p/ae25eb3cfb5d', NULL, 'jianshu', '2018-07-16');
INSERT INTO `fav_article` VALUES (17, 'java多线程高并发', 'https://www.cnblogs.com/sx66/p/12623437.html', NULL, 'cnblogs', '2020-04-02');
INSERT INTO `fav_article` VALUES (18, '2020年最新78道JVM面试题总结（含答案解析和思维导图）', 'https://www.cnblogs.com/zhuifeng523/p/13172080.html', NULL, 'cnblogs', '2020-06-21');
INSERT INTO `fav_article` VALUES (19, 'Ubuntu20.04 apt方式安装MySQL', 'https://blog.csdn.net/lianghecai52171314/article/details/113807099', NULL, 'csdn', '2021-02-14');
INSERT INTO `fav_article` VALUES (20, 'AOP面试造火箭始末', 'https://www.cnblogs.com/xiekun/p/14471595.html', NULL, 'cnblogs', '2021-03-02');
INSERT INTO `fav_article` VALUES (21, 'MySQL Explain详解', 'https://www.cnblogs.com/tufujie/p/9413852.html', NULL, 'cnblogs', '2018-08-03');
INSERT INTO `fav_article` VALUES (22, 'BigDecimal操作', 'https://blog.csdn.net/javaNiuLei12/article/details/54091258', NULL, 'csdn', '2017-01-05');
INSERT INTO `fav_article` VALUES (23, '5分钟让你掌握Vuex，深入浅出', 'https://www.cnblogs.com/maoqian/p/15428820.html', NULL, 'cnblogs', '2021-10-20');
INSERT INTO `fav_article` VALUES (24, '被敖丙用烂的「数据库调优」连招？真香，淦！', 'https://mp.weixin.qq.com/s?__biz=MzAwNDA2OTM1Ng==&mid=2453143331&idx=1&sn=e387e1b1beb4cd516ee2d67ce934115e&scene=21#wechat_redirect', NULL, 'wxmp', '2020-11-17');
INSERT INTO `fav_article` VALUES (25, '为什么IDEA不推荐你使用@Autowired ？', 'https://mp.weixin.qq.com/s/Nu25_5mMtD8nboPj8m7lyA', NULL, 'wxmp', '2021-11-05');
INSERT INTO `fav_article` VALUES (26, 'LocalDateTime, LocalDate, Instant, Long 相互转换', 'https://blog.csdn.net/qq_19266669/article/details/106743102', NULL, 'csdn', '2020-06-14');
INSERT INTO `fav_article` VALUES (27, '英语零基础，有什么自学方法？', 'https://www.zhihu.com/question/36449108/answer/756802719', NULL, 'zhihu', '2019-07-21');
INSERT INTO `fav_article` VALUES (28, 'BBC减肥十律', 'https://zhuanlan.zhihu.com/p/412545357', NULL, 'zhihu', '2019-09-21');
INSERT INTO `fav_article` VALUES (29, '蓝绿部署、金丝雀发布（灰度发布）、AB测试都是啥？', 'https://mp.weixin.qq.com/s/3ux2NTgtnXG34NjT2HNW-A', NULL, 'wxmp', '2021-11-13');
INSERT INTO `fav_article` VALUES (30, 'Spring Boot 2.6之后，动态权限控制终于可以用起来了！', 'https://mp.weixin.qq.com/s/Tki0SWTq37EYXVNtlgYszQ', NULL, 'wxmp', '2021-11-22');
INSERT INTO `fav_article` VALUES (31, '详细介绍mysql索引类型：FULLTEXT、NORMAL、SPATIAL、UNIQUE', 'https://blog.csdn.net/guo_qiangqiang/article/details/88794971', NULL, 'csdn', '2019-03-25');
INSERT INTO `fav_article` VALUES (32, 'MySQL存储引擎', 'https://www.cnblogs.com/birdy-silhouette/p/15066260.html', NULL, 'cnblogs', '2021-07-27');
INSERT INTO `fav_article` VALUES (33, '妙用Java 8中的 Function接口 消灭if...else（非常新颖的写法）', 'https://mp.weixin.qq.com/s/5FmD0PtPsQFPiImMiLC_eg', NULL, 'wxmp', '2021-12-05');
INSERT INTO `fav_article` VALUES (34, 'MySQL慢查询，一口从天而降的锅！', 'https://blog.csdn.net/qq_39390545/article/details/116139445', NULL, 'csdn', '2021-04-25');
INSERT INTO `fav_article` VALUES (35, 'Redis 实现限流的三种方式', 'https://blog.csdn.net/lmx125254/article/details/90700118', NULL, 'csdn', '2019-05-30');
INSERT INTO `fav_article` VALUES (36, '并发模拟的四种方式 + 工具，超级实用！', 'https://mp.weixin.qq.com/s/B5Kx6fKAj_B78mLPMaFZtw', NULL, 'wxmp', '2021-12-17');
INSERT INTO `fav_article` VALUES (37, 'SQL 优化极简法则，还有谁不会？', 'https://mp.weixin.qq.com/s/NS2trUx9nVN5gNquVVbruw', NULL, 'wxmp', '2021-12-14');
INSERT INTO `fav_article` VALUES (38, 'Java位运算符：Java移位运算符、复合位赋值运算符及位逻辑运算符', 'http://c.biancheng.net/view/784.html', NULL, 'direct', '2021-12-25');
INSERT INTO `fav_article` VALUES (39, '作为技术负责人，如何从0搭建公司后端技术栈', 'https://mp.weixin.qq.com/s/v8E4FKu6fIhXb1v_WtlYZw', NULL, 'wxmp', '2022-01-12');
INSERT INTO `fav_article` VALUES (40, 'Spring MVC中处理Request和Response的策略', 'https://mp.weixin.qq.com/s/DQEI0ZTrJuVjjONOzmnLYg', NULL, 'wxmp', '2022-01-12');
INSERT INTO `fav_article` VALUES (41, '一文教会你领域建模', 'https://mp.weixin.qq.com/s/3x4fK7rtA2US9fxoKpoAiA', NULL, 'wxmp', '2021-12-30');
INSERT INTO `fav_article` VALUES (42, '生成订单30分钟未支付，则自动取消，该怎么实现？', 'https://mp.weixin.qq.com/s/QOQhsXWQDqXsWngQUGOk5w', NULL, 'wxmp', '2022-01-25');
INSERT INTO `fav_article` VALUES (43, '几种常见的JVM调优场景（建议收藏）', 'https://mp.weixin.qq.com/s/35uO5VQnDZGVZXWnaUbaqg', NULL, 'wxmp', '2022-01-24');
INSERT INTO `fav_article` VALUES (44, 'git-stash用法小结', 'https://www.cnblogs.com/tocy/p/git-stash-reference.html', NULL, 'cnblogs', '2016-10-31');
INSERT INTO `fav_article` VALUES (45, 'RabbitMQ 如何保证消息不丢失？', 'https://www.cnblogs.com/cnndevelop/p/12091348.html', NULL, 'cnblogs', '2019-12-24');
INSERT INTO `fav_article` VALUES (46, 'Spring OAuth2 开发指南（一）：体系架构和开发概览', 'https://www.jianshu.com/p/45f6d4d0574a', NULL, 'jianshu', '2021-08-09');
INSERT INTO `fav_article` VALUES (47, 'SQL优化万能公式：5 大步骤 + 10 个案例', 'https://mp.weixin.qq.com/s/YAu_DG1YN_7pEizlZCqhew', NULL, 'wxmp', '2022-03-31');
INSERT INTO `fav_article` VALUES (48, '判断时间是否有重叠', 'https://www.cnblogs.com/luyuqiang/p/14990941.html', NULL, 'cnblogs', '2021-07-09');
INSERT INTO `fav_article` VALUES (49, 'MongoDB 4.x 的权限管理说明', 'https://www.jianshu.com/p/e95c22c4ed43', NULL, 'jianshu', '2020-05-23');
INSERT INTO `fav_article` VALUES (50, '秒懂 23 种设计模式！有点污，但真得秒啊...', 'https://mp.weixin.qq.com/s/U3LWho3pGw6PdLdsO51kjg', NULL, 'wxmp', '2022-04-29');
INSERT INTO `fav_article` VALUES (52, 'IntelliJ IDEA 卡成球了？', 'https://mp.weixin.qq.com/s/p2kMAelK43k_u0lygBmTKg', NULL, 'wxmp', '2022-05-10');
INSERT INTO `fav_article` VALUES (53, 'Spring Boot + Redis 搞定搜索栏热搜、不雅文字过滤功能', 'https://mp.weixin.qq.com/s/ibb3tgJ-Dzu4QXMpH44fbA', NULL, 'wxmp', '2022-05-12');
INSERT INTO `fav_article` VALUES (54, 'Spring的@ControllerAdvice注解', 'https://www.cnblogs.com/yanggb/p/10859907.html', NULL, 'cnblogs', '2019-05-15');
INSERT INTO `fav_article` VALUES (55, 'Socket 粘包和分包问题', 'https://www.apifox.cn/help/reference/socket-stick/', NULL, 'direct', '2022-05-17');
INSERT INTO `fav_article` VALUES (56, 'Vditor 一款浏览器端的 Markdown 编辑器，支持所见即所得（富文本）、即时渲染（类似 Typora）和分屏预览模式', 'https://ld246.com/article/1549638745630', NULL, 'direct', '2022-05-21');
INSERT INTO `fav_article` VALUES (57, 'ssh StrictHostKeyChecking', 'https://www.jianshu.com/p/ebcf41c75786', NULL, 'jianshu', '2018-06-29');
INSERT INTO `fav_article` VALUES (58, '提问的艺术', 'http://spring4all.com/forum-post/694', NULL, 'direct', '2022-04-07');
INSERT INTO `fav_article` VALUES (59, '面试官：String长度有限制吗？是多少？', 'https://mp.weixin.qq.com/s/Z4sxQ_Bc3uudAX0ugI3ujw', NULL, 'wxmp', '2022-05-31');
INSERT INTO `fav_article` VALUES (60, 'Linux中几个你不常用，但却很有用的命令', 'https://mp.weixin.qq.com/s/Ic8ltNlEpteFdnnwPSc5kQ', NULL, 'wxmp', '2022-06-07');
INSERT INTO `fav_article` VALUES (61, '用分布式锁来防止库存超卖，但是是每秒上千订单的高并发场景，如何对分布式锁进行高并发优化来应对这个场景？', 'https://blog.csdn.net/u010391342/article/details/84372342', NULL, 'csdn', '2018-11-23');
INSERT INTO `fav_article` VALUES (62, '论微服务架构的核心概念', 'https://github.com/JoeCao/JoeCao.github.io/issues/3', NULL, 'direct', '2017-09-12');
INSERT INTO `fav_article` VALUES (63, 'int(1) 和 int(10) 有什么区别？', 'https://mp.weixin.qq.com/s/7lhleHM74xQyQ--xZZfyMg', NULL, 'wxmp', '2022-06-09');
INSERT INTO `fav_article` VALUES (64, '谈下新手程序员怎样写好复杂业务代码', 'https://blog.csdn.net/icai888/article/details/106159861', NULL, 'csdn', '2020-05-16');
INSERT INTO `fav_article` VALUES (65, '3000 帧动画图解 MySQL 为什么需要 binlog、redo log 和 undo log', 'https://my.oschina.net/u/4893843/blog/5533822', NULL, 'oschina', '2022-05-31');
INSERT INTO `fav_article` VALUES (66, '如何优雅的写 Controller 层代码？', 'https://mp.weixin.qq.com/s/eZS9dQ8I2FWEP6ykeDAHUg', NULL, 'wxmp', '2022-06-23');
INSERT INTO `fav_article` VALUES (67, 'HTTP协议一知半解？这篇帮你全面了解！', 'https://mp.weixin.qq.com/s/Rh5BMzZxIYKsHzt-hliKMw', NULL, 'wxmp', '2022-06-23');
INSERT INTO `fav_article` VALUES (68, 'Redis 如何实现库存扣减操作？', 'https://mp.weixin.qq.com/s/DCP76xENsGzJF7mo1U8tCQ', NULL, 'wxmp', '2022-07-13');
INSERT INTO `fav_article` VALUES (69, '学会 Arthas，让你 3 年经验掌握 5 年功力！', 'https://mp.weixin.qq.com/s/3lJb4vs3pnlyJoVSrl8BhQ', NULL, 'wxmp', '2022-08-02');
INSERT INTO `fav_article` VALUES (70, '使用 DataX 实现 MySQL 数据的高效同步', 'https://mp.weixin.qq.com/s/8lhWKhMk5uczQzudUEt-Xg', NULL, 'wxmp', '2022-07-14');
INSERT INTO `fav_article` VALUES (71, '产品太多了，如何实现一次登录多产品互通？', 'https://mp.weixin.qq.com/s/TBVtYPrbLMJyaUulLSVx9g', NULL, 'wxmp', '2022-08-04');
INSERT INTO `fav_article` VALUES (72, 'Redis为什么这么快？', 'https://mp.weixin.qq.com/s/eSWnwgOF8urqONIbtvxs_Q', NULL, 'wxmp', '2022-08-25');
INSERT INTO `fav_article` VALUES (73, '从 JDK 8 到 JDK 18，Java 垃圾回收的十次进化', 'https://mp.weixin.qq.com/s/0IqNbhcmnOKrNe0gIK7qlQ', NULL, 'wxmp', '2022-08-26');
INSERT INTO `fav_article` VALUES (74, '踩坑了！0作为除数，不一定会抛出异常！', 'https://www.cnblogs.com/thisiswhy/p/16635585.html', NULL, 'cnblogs', '2022-08-29');

-- ----------------------------
-- Table structure for fav_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `fav_article_tag`;
CREATE TABLE `fav_article_tag`  (
  `article_id` int(11) NOT NULL COMMENT '文章ID',
  `tag_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签代码',
  PRIMARY KEY (`article_id`, `tag_code`) USING BTREE,
  INDEX `idx_article_id`(`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章标签表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fav_article_tag
-- ----------------------------
INSERT INTO `fav_article_tag` VALUES (1, 'test');
INSERT INTO `fav_article_tag` VALUES (2, 'redis');
INSERT INTO `fav_article_tag` VALUES (3, 'docker');
INSERT INTO `fav_article_tag` VALUES (4, 'design_pattern');
INSERT INTO `fav_article_tag` VALUES (4, 'spring');
INSERT INTO `fav_article_tag` VALUES (5, 'book');
INSERT INTO `fav_article_tag` VALUES (5, 'java');
INSERT INTO `fav_article_tag` VALUES (6, 'interview');
INSERT INTO `fav_article_tag` VALUES (7, 'funcational_design');
INSERT INTO `fav_article_tag` VALUES (8, 'tool');
INSERT INTO `fav_article_tag` VALUES (9, 'algorithm');
INSERT INTO `fav_article_tag` VALUES (10, 'network');
INSERT INTO `fav_article_tag` VALUES (11, 'network');
INSERT INTO `fav_article_tag` VALUES (12, 'network');
INSERT INTO `fav_article_tag` VALUES (13, 'microservice');
INSERT INTO `fav_article_tag` VALUES (13, 'test');
INSERT INTO `fav_article_tag` VALUES (14, 'dubbo');
INSERT INTO `fav_article_tag` VALUES (14, 'microservice');
INSERT INTO `fav_article_tag` VALUES (15, 'git');
INSERT INTO `fav_article_tag` VALUES (15, 'tool');
INSERT INTO `fav_article_tag` VALUES (16, 'java');
INSERT INTO `fav_article_tag` VALUES (17, 'interview');
INSERT INTO `fav_article_tag` VALUES (17, 'java');
INSERT INTO `fav_article_tag` VALUES (18, 'interview');
INSERT INTO `fav_article_tag` VALUES (18, 'java');
INSERT INTO `fav_article_tag` VALUES (18, 'jvm');
INSERT INTO `fav_article_tag` VALUES (19, 'linux');
INSERT INTO `fav_article_tag` VALUES (19, 'mysql');
INSERT INTO `fav_article_tag` VALUES (20, 'java');
INSERT INTO `fav_article_tag` VALUES (20, 'spring');
INSERT INTO `fav_article_tag` VALUES (21, 'mysql');
INSERT INTO `fav_article_tag` VALUES (22, 'java');
INSERT INTO `fav_article_tag` VALUES (23, 'vue');
INSERT INTO `fav_article_tag` VALUES (24, 'mysql');
INSERT INTO `fav_article_tag` VALUES (25, 'java');
INSERT INTO `fav_article_tag` VALUES (25, 'spring');
INSERT INTO `fav_article_tag` VALUES (26, 'java');
INSERT INTO `fav_article_tag` VALUES (27, 'study_method');
INSERT INTO `fav_article_tag` VALUES (28, 'study_method');
INSERT INTO `fav_article_tag` VALUES (29, 'test');
INSERT INTO `fav_article_tag` VALUES (30, 'java');
INSERT INTO `fav_article_tag` VALUES (30, 'spring');
INSERT INTO `fav_article_tag` VALUES (31, 'mysql');
INSERT INTO `fav_article_tag` VALUES (32, 'mysql');
INSERT INTO `fav_article_tag` VALUES (33, 'java');
INSERT INTO `fav_article_tag` VALUES (34, 'mysql');
INSERT INTO `fav_article_tag` VALUES (35, 'funcational_design');
INSERT INTO `fav_article_tag` VALUES (35, 'java');
INSERT INTO `fav_article_tag` VALUES (35, 'redis');
INSERT INTO `fav_article_tag` VALUES (36, 'test');
INSERT INTO `fav_article_tag` VALUES (37, 'mysql');
INSERT INTO `fav_article_tag` VALUES (38, 'java');
INSERT INTO `fav_article_tag` VALUES (39, 'project_manage');
INSERT INTO `fav_article_tag` VALUES (40, 'java');
INSERT INTO `fav_article_tag` VALUES (40, 'spring');
INSERT INTO `fav_article_tag` VALUES (41, 'project_manage');
INSERT INTO `fav_article_tag` VALUES (42, 'funcational_design');
INSERT INTO `fav_article_tag` VALUES (43, 'java');
INSERT INTO `fav_article_tag` VALUES (43, 'jvm');
INSERT INTO `fav_article_tag` VALUES (44, 'git');
INSERT INTO `fav_article_tag` VALUES (44, 'tool');
INSERT INTO `fav_article_tag` VALUES (45, 'mq');
INSERT INTO `fav_article_tag` VALUES (45, 'rabbitmq');
INSERT INTO `fav_article_tag` VALUES (46, 'java');
INSERT INTO `fav_article_tag` VALUES (46, 'spring');
INSERT INTO `fav_article_tag` VALUES (47, 'mysql');
INSERT INTO `fav_article_tag` VALUES (48, 'funcational_design');
INSERT INTO `fav_article_tag` VALUES (48, 'mysql');
INSERT INTO `fav_article_tag` VALUES (49, 'mongo');
INSERT INTO `fav_article_tag` VALUES (50, 'design_pattern');
INSERT INTO `fav_article_tag` VALUES (52, 'tool');
INSERT INTO `fav_article_tag` VALUES (53, 'java');
INSERT INTO `fav_article_tag` VALUES (53, 'redis');
INSERT INTO `fav_article_tag` VALUES (53, 'spring');
INSERT INTO `fav_article_tag` VALUES (54, 'java');
INSERT INTO `fav_article_tag` VALUES (54, 'spring');
INSERT INTO `fav_article_tag` VALUES (55, 'network');
INSERT INTO `fav_article_tag` VALUES (56, 'web_component');
INSERT INTO `fav_article_tag` VALUES (57, 'linux');
INSERT INTO `fav_article_tag` VALUES (58, 'study_method');
INSERT INTO `fav_article_tag` VALUES (59, 'java');
INSERT INTO `fav_article_tag` VALUES (60, 'linux');
INSERT INTO `fav_article_tag` VALUES (61, 'funcational_design');
INSERT INTO `fav_article_tag` VALUES (61, 'redis');
INSERT INTO `fav_article_tag` VALUES (62, 'microservice');
INSERT INTO `fav_article_tag` VALUES (63, 'mysql');
INSERT INTO `fav_article_tag` VALUES (64, 'funcational_design');
INSERT INTO `fav_article_tag` VALUES (65, 'mysql');
INSERT INTO `fav_article_tag` VALUES (66, 'funcational_design');
INSERT INTO `fav_article_tag` VALUES (66, 'spring');
INSERT INTO `fav_article_tag` VALUES (67, 'network');
INSERT INTO `fav_article_tag` VALUES (68, 'funcational_design');
INSERT INTO `fav_article_tag` VALUES (68, 'redis');
INSERT INTO `fav_article_tag` VALUES (69, 'jvm');
INSERT INTO `fav_article_tag` VALUES (69, 'tool');
INSERT INTO `fav_article_tag` VALUES (70, 'mysql');
INSERT INTO `fav_article_tag` VALUES (70, 'tool');
INSERT INTO `fav_article_tag` VALUES (71, 'funcational_design');
INSERT INTO `fav_article_tag` VALUES (71, 'java');
INSERT INTO `fav_article_tag` VALUES (72, 'redis');
INSERT INTO `fav_article_tag` VALUES (73, 'java');
INSERT INTO `fav_article_tag` VALUES (73, 'jvm');
INSERT INTO `fav_article_tag` VALUES (74, 'java');

-- ----------------------------
-- Table structure for fav_link
-- ----------------------------
DROP TABLE IF EXISTS `fav_link`;
CREATE TABLE `fav_link`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `item` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分组',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `href` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '地址',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图像',
  `seq` int(11) NOT NULL DEFAULT 0 COMMENT '顺序',
  `target` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '_self',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '链接地址' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fav_link
-- ----------------------------
INSERT INTO `fav_link` VALUES (1, 'editor', 'JSON编辑器', '/json', '简单的JSON文本编辑工具，可以对数据进行格式化和反格式化', NULL, 1, '_self');
INSERT INTO `fav_link` VALUES (2, 'editor', 'XML编辑器', '/xml', '简单的XML美化压缩工具', NULL, 2, '_self');
INSERT INTO `fav_link` VALUES (3, 'editor', '文本差异对比', '/diff', '对比两个文本的内容并高亮显示', NULL, 3, '_self');
INSERT INTO `fav_link` VALUES (4, 'editor', 'XSLT测试', '/xslt', 'XML数据样式表功能测试', NULL, 4, '_self');
INSERT INTO `fav_link` VALUES (5, 'editor', '加密解密', '/code', '支持常见的加密与解密技术', NULL, 5, '_self');
INSERT INTO `fav_link` VALUES (6, 'helper', '腾讯翻译君', 'https://fanyi.qq.com/', '全新人工智能翻译， 句子、文章、论文、资料翻译首选', NULL, 1, '_blank');
INSERT INTO `fav_link` VALUES (7, 'helper', '变量命名', 'https://unbug.github.io/codelf/', 'Codelf,变量命名,函数命名,方法命名,变量命名神器,GitHub 分组', NULL, 2, '_blank');
INSERT INTO `fav_link` VALUES (8, 'helper', 'Github代下载', 'https://ghproxy.com/', 'GitHub 文件 , Releases , archive , gist , raw.githubusercontent.com 文件代理加速下载服务', NULL, 3, '_blank');
INSERT INTO `fav_link` VALUES (9, 'helper', '项目文档工具', 'https://docsify.js.org/#/zh-cn/', '一个神奇的文档网站生成器', NULL, 4, '_blank');
INSERT INTO `fav_link` VALUES (10, 'helper', 'IDEA试用', 'https://gitee.com/pengzhile/ide-eval-resetter', 'Jetbrains系列产品重置试用方法', NULL, 5, '_blank');
INSERT INTO `fav_link` VALUES (11, 'helper', 'Git大全', 'https://gitee.com/all-about-git', '最全面的 Git 资源索引以及常用命令教程', NULL, 6, '_blank');
INSERT INTO `fav_link` VALUES (12, 'helper', 'httpbin.org', 'https://httpbin.org', '一个简单的HTPP请求响应网站', NULL, 7, '_blank');
INSERT INTO `fav_link` VALUES (13, 'document', 'Apache项目', 'https://www.apache.org/index.html#projects-list', 'Apache基金会官方项目列表', NULL, 1, '_blank');
INSERT INTO `fav_link` VALUES (14, 'document', 'Java8文档', 'https://docs.oracle.com/javase/8/docs/api/', 'Java8官方文档', NULL, 2, '_blank');
INSERT INTO `fav_link` VALUES (15, 'document', 'Spring文档', 'https://spring.io/projects', 'Spring项目官方文档', NULL, 3, '_blank');
INSERT INTO `fav_link` VALUES (16, 'document', 'Mybatis文档', 'https://mybatis.org/mybatis-3/zh/index.html', 'Mybatis官方中文文档', NULL, 4, '_blank');
INSERT INTO `fav_link` VALUES (17, 'document', 'Java开发手册', 'https://github.com/alibaba/p3c', '阿里巴巴Java开发手册', NULL, 5, '_blank');
INSERT INTO `fav_link` VALUES (18, 'document', 'On Java8', 'https://gitee.com/lingcoder/OnJava8/tree/1ef7ec48e492862300e667e24c245e9b3a5ccd98', '《On Java 8》中文版', NULL, 6, '_blank');
INSERT INTO `fav_link` VALUES (19, 'document', 'Java8特性', 'https://github.com/biezhi/learn-java8', 'Java8 改变了我们思考和编码的方式，在这里你可以学习到 Java8 中的核心特性以及使用场景，跟我学习 Java8，让你的编程更轻松', NULL, 7, '_blank');
INSERT INTO `fav_link` VALUES (20, 'document', 'Docs4dev', 'https://www.docs4dev.com/docs/zh', '开发文档中文版汇总', NULL, 8, '_blank');
INSERT INTO `fav_link` VALUES (21, 'blog', '菜鸟教程', 'https://www.runoob.com', '提供了编程的基础技术教程, 介绍了HTML、CSS、Javascript、Python，Java，Ruby，C，PHP , MySQL等各种编程语言的基础知识', NULL, 1, '_blank');
INSERT INTO `fav_link` VALUES (22, 'blog', '阿里云藏经阁', 'https://developer.aliyun.com/ebook', '汇聚阿里巴巴技术实践精华，涵盖云原生、物联网、大数据、AI 等技术领域，深度分享阿里工程师实战经验，顶级技术内容一手掌握', NULL, 2, '_blank');
INSERT INTO `fav_link` VALUES (23, 'blog', '程序员DD', 'https://blog.didispace.com/', '内容涵盖Java后端技术、Spring Boot、Spring Cloud、微服务架构、运维开发、系统监控等相关的研究与知识分享', NULL, 4, '_blank');
INSERT INTO `fav_link` VALUES (24, 'blog', '酷壳博客', 'https://coolshell.cn/', '享受编程和技术所带来的快乐 – https://coolshell.cn', NULL, 7, '_blank');
INSERT INTO `fav_link` VALUES (25, 'blog', '虫洞栈', 'https://bugstack.cn/', 'bugstack 虫洞栈, 重学Java设计模式, 字节码编程, 中间件, Spring, Java基础, 面经手册', NULL, 3, '_blank');
INSERT INTO `fav_link` VALUES (26, 'blog', '三太子敖丙', 'https://mp.weixin.qq.com/s/2l8iZeTRfMaUOcgtad1wIQ', '渣男两年文章汇总（附硬核面试点脑图）', NULL, 13, '_blank');
INSERT INTO `fav_link` VALUES (27, 'blog', '商城实战项目', 'http://www.macrozheng.com/', 'mall学习教程，架构、业务、技术要点全方位解析', NULL, 14, '_blank');
INSERT INTO `fav_link` VALUES (29, 'friend', 'HMISTER', 'https://blog.hmister.net/', '不想你惊艳我年少时光 只愿你暖我今后岁月', NULL, 2, '_blank');
INSERT INTO `fav_link` VALUES (30, 'editor', 'Cron表达式', '/cron', 'Crontab计划任务表达式在线生成', NULL, 6, '_self');
INSERT INTO `fav_link` VALUES (34, 'helper', 'CrxDL', 'https://crxdl.com/', '下载Chrome扩展插件Crx离线安装包', NULL, 11, '_blank');
INSERT INTO `fav_link` VALUES (35, 'helper', 'SSL/TLS安全评估', 'https://myssl.com/', '您部署的HTTPS网站安全吗', NULL, 9, '_blank');
INSERT INTO `fav_link` VALUES (36, 'blog', 'Javadoop', 'https://javadoop.com/', '来自魔都的程序员，在互联网摸爬滚打了很多年', NULL, 11, '_blank');
INSERT INTO `fav_link` VALUES (38, 'blog', '凤凰架构', 'http://icyfenix.cn/', '构建可靠的大型分布式系统', NULL, 8, '_blank');
INSERT INTO `fav_link` VALUES (39, 'editor', 'Diagram', 'https://app.diagrams.net/', '图表软件和流程图制作工具', NULL, 8, '_blank');
INSERT INTO `fav_link` VALUES (41, 'helper', '程序员做饭指南', 'https://cook.aiurs.co/', '程序员在家做饭方法指南。Programmer\'s guide about how to cook at home (Chinese)', NULL, 10, '_blank');
INSERT INTO `fav_link` VALUES (42, 'blog', 'SpringForAll社区', 'http://spring4all.com/', '专注服务Java和Spring开发者的技术社区', NULL, 12, '_blank');
INSERT INTO `fav_link` VALUES (43, 'blog', 'JavaGuide', 'https://javaguide.cn/', '一份涵盖大部分 Java 程序员所需要掌握的核心知识', NULL, 9, '_blank');
INSERT INTO `fav_link` VALUES (46, 'document', 'Java规范', 'https://docs.oracle.com/javase/specs/index.html', 'Java语言和虚拟机规范', '', 0, '_blank');
INSERT INTO `fav_link` VALUES (47, 'document', 'Arthas文档', 'https://arthas.aliyun.com/doc/quick-start.html', 'Arthas 是Alibaba开源的Java诊断工具，深受开发者喜爱', NULL, 10, '_blank');
INSERT INTO `fav_link` VALUES (48, 'blog', '并发编程网', 'http://ifeve.com/', '让天下没有难学的技术', NULL, 6, '_blank');
INSERT INTO `fav_link` VALUES (49, 'blog', 'Java进阶知识', 'https://doocs.github.io/advanced-java/#/', '本系列知识由 Doocs 技术社区总结发布，内容涵盖高并发、分布式、高可用、微服务、海量数据处理等', '', 10, '_blank');
INSERT INTO `fav_link` VALUES (50, 'editor', 'Unix时间戳', '/unix', 'Unix时间戳在线转换工具', NULL, 7, '_self');
INSERT INTO `fav_link` VALUES (51, 'helper', 'Unicode字符百科', 'https://unicode-table.com/cn/', 'Unicode(万国码、国际码、统一码) 字符搜索Web服务 ', NULL, 8, '_blank');
INSERT INTO `fav_link` VALUES (52, 'helper', 'SVG文件处理', 'https://svgtopng.com/zh/', '软件允许您将SVG文档转换成PNG文档。', NULL, 12, '_blank');
INSERT INTO `fav_link` VALUES (53, 'document', 'OI Wiki', 'https://oi-wiki.org/', '一个免费开放且持续更新的 编程竞赛（competitive programming） 知识整合站点', NULL, 9, '_blank');
INSERT INTO `fav_link` VALUES (54, 'helper', 'Respeed Download', 'https://respeed.chromiumer.com/', '主要用于文件下载加速（国内资源下载可能会更慢）', NULL, 13, '_blank');
INSERT INTO `fav_link` VALUES (55, 'blog', 'Java全栈知识体系', 'https://pdai.tech/', '包含: Java 基础, Java 部分源码, JVM, Spring, 数据库原理, 分布式, 中间件, 开发工具, Git, IDE等', NULL, 5, '_blank');

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`  (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for note_catalog
-- ----------------------------
DROP TABLE IF EXISTS `note_catalog`;
CREATE TABLE `note_catalog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父级ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `rank` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `delete_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记目录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for note_content
-- ----------------------------
DROP TABLE IF EXISTS `note_content`;
CREATE TABLE `note_content`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `catalog_id` int(11) NOT NULL DEFAULT 0 COMMENT '目录',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `rank` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `delete_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_catalog_idx`(`catalog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记内容表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for note_history
-- ----------------------------
DROP TABLE IF EXISTS `note_history`;
CREATE TABLE `note_history`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content_id` int(11) NOT NULL COMMENT '笔记ID',
  `catalog_id` int(11) NULL DEFAULT NULL COMMENT '目录',
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `rank` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_content_id`(`content_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记历史表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for note_share
-- ----------------------------
DROP TABLE IF EXISTS `note_share`;
CREATE TABLE `note_share`  (
  `content_id` int(11) NOT NULL COMMENT '笔记ID',
  `share_secret` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访问密码',
  `share_days` int(11) NULL DEFAULT 0 COMMENT '分享天数',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`content_id`) USING BTREE,
  UNIQUE INDEX `idx_content_id`(`content_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记分享表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `blob_data` blob NULL COMMENT '存放持久化Trigger对象',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'Blob类型的触发器表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `calendar_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '日历名称',
  `calendar` blob NOT NULL COMMENT '存放持久化calendar对象',
  PRIMARY KEY (`sched_name`, `calendar_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日历信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `cron_expression` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'cron表达式',
  `time_zone_id` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '时区',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'Cron类型的触发器表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `entry_id` varchar(95) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度器实例id',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `instance_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度器实例名',
  `fired_time` bigint(13) NOT NULL COMMENT '触发的时间',
  `sched_time` bigint(13) NOT NULL COMMENT '定时器制定的时间',
  `priority` int(11) NOT NULL COMMENT '优先级',
  `state` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态',
  `job_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务组名',
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否并发',
  `requests_recovery` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否接受恢复执行',
  PRIMARY KEY (`sched_name`, `entry_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '已触发的触发器表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `job_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务组名',
  `description` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相关介绍',
  `job_class_name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '执行任务类名称',
  `is_durable` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否持久化',
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否并发',
  `is_update_data` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否更新数据',
  `requests_recovery` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否接受恢复执行',
  `job_data` blob NULL COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '任务详细信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `lock_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '悲观锁名称',
  PRIMARY KEY (`sched_name`, `lock_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '存储的悲观锁信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  PRIMARY KEY (`sched_name`, `trigger_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '暂停的触发器表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `instance_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '实例名称',
  `last_checkin_time` bigint(13) NOT NULL COMMENT '上次检查时间',
  `checkin_interval` bigint(13) NOT NULL COMMENT '检查间隔时间',
  PRIMARY KEY (`sched_name`, `instance_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '调度器状态表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `repeat_count` bigint(7) NOT NULL COMMENT '重复的次数统计',
  `repeat_interval` bigint(12) NOT NULL COMMENT '重复的间隔时间',
  `times_triggered` bigint(10) NOT NULL COMMENT '已经触发的次数',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '简单触发器的信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `str_prop_1` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第一个参数',
  `str_prop_2` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第二个参数',
  `str_prop_3` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第三个参数',
  `int_prop_1` int(11) NULL DEFAULT NULL COMMENT 'int类型的trigger的第一个参数',
  `int_prop_2` int(11) NULL DEFAULT NULL COMMENT 'int类型的trigger的第二个参数',
  `long_prop_1` bigint(20) NULL DEFAULT NULL COMMENT 'long类型的trigger的第一个参数',
  `long_prop_2` bigint(20) NULL DEFAULT NULL COMMENT 'long类型的trigger的第二个参数',
  `dec_prop_1` decimal(13, 4) NULL DEFAULT NULL COMMENT 'decimal类型的trigger的第一个参数',
  `dec_prop_2` decimal(13, 4) NULL DEFAULT NULL COMMENT 'decimal类型的trigger的第二个参数',
  `bool_prop_1` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Boolean类型的trigger的第一个参数',
  `bool_prop_2` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Boolean类型的trigger的第二个参数',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '同步机制的行锁表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '触发器的名字',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '触发器所属组的名字',
  `job_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_job_details表job_name的外键',
  `job_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_job_details表job_group的外键',
  `description` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相关介绍',
  `next_fire_time` bigint(13) NULL DEFAULT NULL COMMENT '上一次触发时间（毫秒）',
  `prev_fire_time` bigint(13) NULL DEFAULT NULL COMMENT '下一次触发时间（默认为-1表示不触发）',
  `priority` int(11) NULL DEFAULT NULL COMMENT '优先级',
  `trigger_state` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '触发器状态',
  `trigger_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '触发器的类型',
  `start_time` bigint(13) NOT NULL COMMENT '开始时间',
  `end_time` bigint(13) NULL DEFAULT NULL COMMENT '结束时间',
  `calendar_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日程表名称',
  `misfire_instr` smallint(2) NULL DEFAULT NULL COMMENT '补偿执行的策略',
  `job_data` blob NULL COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  INDEX `sched_name`(`sched_name`, `job_name`, `job_group`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '触发器详细信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '参数配置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2022-04-22 09:21:16', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2022-04-22 09:21:16', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2022-04-22 09:21:16', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES (4, '账号自助-验证码开关', 'sys.account.captchaOnOff', 'true', 'Y', 'admin', '2022-04-22 09:21:16', '', NULL, '是否开启验证码功能（true开启，false关闭）');
INSERT INTO `sys_config` VALUES (5, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2022-04-22 09:21:16', '', NULL, '是否开启注册用户功能（true开启，false关闭）');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, 0, '0', 'X-Hub', 0, '', '', '', '0', '0', 'admin', '2022-04-22 09:21:16', 'admin', '2022-04-27 23:27:01');
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '技术部门', 1, NULL, NULL, NULL, '0', '0', 'admin', '2022-04-27 23:29:21', '', NULL);
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '市场部门', 2, NULL, NULL, NULL, '0', '0', 'admin', '2022-04-27 23:29:29', '', NULL);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 154 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典数据表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '通知');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '公告');
INSERT INTO `sys_dict_data` VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` VALUES (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` VALUES (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` VALUES (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` VALUES (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` VALUES (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` VALUES (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` VALUES (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` VALUES (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` VALUES (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (100, 0, '软件工具箱', 'title', 'web_site_info', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (107, 0, '数据结构与算法', 'algorithm', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (108, 0, '书籍推荐', 'book', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (109, 0, '设计模式', 'design_pattern', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (110, 0, 'Docker', 'docker', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (111, 0, 'Dubbo', 'dubbo', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (112, 0, '功能设计', 'funcational_design', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (113, 0, 'Git', 'git', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (114, 0, '面试资料\r\n', 'interview', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (115, 0, 'Java', 'java', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (116, 0, 'Java虚拟机', 'jvm', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (117, 0, 'Linux', 'linux', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (118, 0, '微服务治理', 'microservice', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (119, 0, 'MongoDB', 'mongo', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (120, 0, '消息队列', 'mq', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (121, 0, 'MySQL', 'mysql', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (122, 0, '计算机网络', 'network', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (123, 0, '项目管理', 'project_manage', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (124, 0, 'RabbitMQ', 'rabbitmq', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (125, 0, 'Redis', 'redis', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (126, 0, 'Spring', 'spring', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (127, 0, '学习方法', 'study_method', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (128, 0, '测试技术', 'test', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (129, 0, '工具使用', 'tool', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (130, 0, 'Vue.js', 'vue', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (131, 0, '博客园', 'cnblogs', 'web_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (132, 0, 'CSDN博客', 'csdn', 'web_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (133, 0, '直接链接', 'direct', 'web_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (134, 0, '简书', 'jianshu', 'web_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (135, 0, '开源中国', 'oschina', 'web_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (136, 0, '微信公众号', 'wxmp', 'web_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (137, 0, '知乎', 'zhihu', 'web_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (138, 0, 'https://www.cnblogs.com/images/logo.svg', 'cnblogs', 'web_article_source_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (139, 0, 'https://cdn2.pandaimg.com/2022/06/23/62b4006c75918.png', 'csdn', 'web_article_source_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-06-23 13:57:10', NULL);
INSERT INTO `sys_dict_data` VALUES (140, 0, 'https://cdn.icon-icons.com/icons2/1207/PNG/512/1491313930-link_82979.png', 'direct', 'web_article_source_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-08-23 11:20:06', NULL);
INSERT INTO `sys_dict_data` VALUES (141, 0, 'https://www.lgstatic.com/thumbnail_300x300/image1/M00/00/1F/CgYXBlTUWGiAP9kMAAB8zMTX_u0512.png', 'jianshu', 'web_article_source_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (142, 0, 'https://www.oschina.net/img/logo.svg', 'oschina', 'web_article_source_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (143, 0, 'https://open.weixin.qq.com/zh_CN/htmledition/res/assets/res-design-download/icon64_wx_logo.png', 'wxmp', 'web_article_source_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (144, 0, 'https://pic2.zhimg.com/80/v2-f6b1f64a098b891b4ea1e3104b5b71f6_720w.png', 'zhihu', 'web_article_source_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (145, 0, 'https://cdn.icon-icons.com/icons2/1945/PNG/512/iconfinder-blog-4661578_122455.png', 'blog', 'web_link_item_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-08-23 11:21:08', NULL);
INSERT INTO `sys_dict_data` VALUES (146, 0, 'https://cdn.icon-icons.com/icons2/827/PNG/512/document_icon-icons.com_66534.png', 'document', 'web_link_item_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-08-23 11:21:33', NULL);
INSERT INTO `sys_dict_data` VALUES (147, 0, 'https://cdn.icon-icons.com/icons2/841/PNG/512/circle-edit-line_icon-icons.com_66940.png', 'editor', 'web_link_item_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-08-23 11:22:07', NULL);
INSERT INTO `sys_dict_data` VALUES (148, 0, 'https://cdn.icon-icons.com/icons2/70/PNG/512/social_fb_facebook_14206.png', 'friend', 'web_link_item_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-08-23 11:26:11', NULL);
INSERT INTO `sys_dict_data` VALUES (149, 0, 'https://cdn.icon-icons.com/icons2/812/PNG/512/social_facebook_messenger_icon-icons.com_66150.png', 'helper', 'web_link_item_image', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-08-23 11:27:13', NULL);
INSERT INTO `sys_dict_data` VALUES (150, 0, '当前页面', '_self', 'web_open_type', NULL, 'default', 'N', '0', 'admin', '2022-05-08 22:50:40', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (151, 1, '新标签页', '_blank', 'web_open_type', NULL, 'default', 'N', '0', 'admin', '2022-05-08 22:50:53', 'admin', '2022-05-08 22:54:22', NULL);
INSERT INTO `sys_dict_data` VALUES (152, 0, '前端组件', 'web_component', 'web_article_tag', NULL, 'default', 'N', '0', 'admin', '2022-05-21 10:01:43', '', NULL, NULL);

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 106 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典类型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '登录状态列表');
INSERT INTO `sys_dict_type` VALUES (100, '站点基本信息', 'web_site_info', '0', 'admin', '2022-04-26 14:41:01', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (101, '文章标签信息', 'web_article_tag', '0', 'admin', '2022-04-26 14:41:26', 'admin', '2022-04-26 14:42:39', NULL);
INSERT INTO `sys_dict_type` VALUES (102, '文章来源平台', 'web_article_source', '0', 'admin', '2022-04-26 14:41:45', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (103, '来源平台图像', 'web_article_source_image', '0', 'admin', '2022-04-26 14:42:03', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (104, '链接分组图像', 'web_link_item_image', '0', 'admin', '2022-04-26 14:42:23', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (105, '链接打开方式', 'web_open_type', '0', 'admin', '2022-05-08 22:50:23', '', NULL, NULL);

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_job` VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_job` VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2022-04-22 09:21:16', '', NULL, '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由参数',
  `is_frame` int(1) NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int(1) NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2033 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', '2022-04-22 09:21:16', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 2, 'monitor', NULL, '', 1, 0, 'M', '0', '0', '', 'monitor', 'admin', '2022-04-22 09:21:16', '', NULL, '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 3, 'tool', NULL, '', 1, 0, 'M', '0', '0', '', 'development', 'admin', '2022-04-22 09:21:16', 'admin', '2022-08-12 16:04:08', '系统工具目录');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2022-04-22 09:21:16', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2022-04-22 09:21:16', '', NULL, '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2022-04-22 09:21:16', '', NULL, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2022-04-22 09:21:16', '', NULL, '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post', 'admin', '2022-04-22 09:21:16', '', NULL, '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2022-04-22 09:21:16', '', NULL, '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2022-04-22 09:21:16', '', NULL, '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2022-04-22 09:21:16', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', '2022-04-22 09:21:16', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2022-04-22 09:21:16', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', '', 1, 0, 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2022-04-22 09:21:16', 'admin', '2022-05-08 15:00:45', '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, '数据监控', 2, 3, 'druid', 'monitor/druid/index', '', 1, 0, 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin', '2022-04-22 09:21:16', '', NULL, '数据监控菜单');
INSERT INTO `sys_menu` VALUES (112, '服务监控', 2, 4, 'server', 'monitor/server/index', '', 1, 0, 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2022-04-22 09:21:16', '', NULL, '服务监控菜单');
INSERT INTO `sys_menu` VALUES (113, '缓存监控', 2, 5, 'cache', 'monitor/cache/index', '', 1, 0, 'C', '0', '0', 'monitor:cache:list', 'redis', 'admin', '2022-04-22 09:21:16', '', NULL, '缓存监控菜单');
INSERT INTO `sys_menu` VALUES (114, '表单构建', 3, 2, 'build', 'tool/build/index', '', 1, 0, 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2022-04-22 09:21:16', 'admin', '2022-05-08 15:00:58', '表单构建菜单');
INSERT INTO `sys_menu` VALUES (115, '代码生成', 3, 1, 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2022-04-22 09:21:16', 'admin', '2022-05-08 15:00:54', '代码生成菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'monitor/operlog/index', '', 1, 0, 'C', '0', '0', 'monitor:operlog:list', 'form', 'admin', '2022-04-22 09:21:16', '', NULL, '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'monitor/logininfor/index', '', 1, 0, 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2022-04-22 09:21:16', '', NULL, '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, 6, '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, 7, '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1031, '参数查询', 106, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1032, '参数新增', 106, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1033, '参数修改', 106, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1034, '参数删除', 106, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1035, '参数导出', 106, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1036, '公告查询', 107, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1037, '公告新增', 107, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1038, '公告修改', 107, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1039, '公告删除', 107, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1041, '操作删除', 500, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, 5, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1054, '任务导出', 110, 7, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1055, '生成查询', 115, 1, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1056, '生成修改', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1057, '生成删除', 115, 3, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1058, '导入代码', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1059, '预览代码', 115, 4, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1060, '生成代码', 115, 5, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2022-04-22 09:21:16', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2000, '收藏信息', 0, 4, 'fav', NULL, NULL, 1, 0, 'M', '0', '0', '', 'star', 'admin', '2022-05-08 15:04:25', 'admin', '2022-08-31 23:47:30', '');
INSERT INTO `sys_menu` VALUES (2001, '收藏文章', 2000, 2, 'article', 'favorite/article/index', NULL, 1, 0, 'C', '0', '0', 'fav:article:list', 'documentation', 'admin', '2022-05-08 18:22:12', 'admin', '2022-08-31 23:48:01', '文章菜单');
INSERT INTO `sys_menu` VALUES (2002, '文章查询', 2001, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'fav:article:query', '#', 'admin', '2022-05-08 18:22:12', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2003, '文章新增', 2001, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'fav:article:add', '#', 'admin', '2022-05-08 18:22:12', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2004, '文章修改', 2001, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'fav:article:edit', '#', 'admin', '2022-05-08 18:22:12', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2005, '文章删除', 2001, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'fav:article:remove', '#', 'admin', '2022-05-08 18:22:12', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2006, '文章导出', 2001, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'fav:article:export', '#', 'admin', '2022-05-08 18:22:12', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2007, '收藏链接', 2000, 1, 'link', 'favorite/link/index', NULL, 1, 0, 'C', '0', '0', 'fav:link:list', 'guide', 'admin', '2022-05-08 18:44:36', 'admin', '2022-08-31 23:47:56', '主页链接菜单');
INSERT INTO `sys_menu` VALUES (2008, '链接查询', 2007, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'fav:link:query', '#', 'admin', '2022-05-08 18:44:36', 'admin', '2022-05-08 22:58:06', '');
INSERT INTO `sys_menu` VALUES (2009, '链接新增', 2007, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'fav:link:add', '#', 'admin', '2022-05-08 18:44:36', 'admin', '2022-05-08 22:58:12', '');
INSERT INTO `sys_menu` VALUES (2010, '链接修改', 2007, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'fav:link:edit', '#', 'admin', '2022-05-08 18:44:36', 'admin', '2022-05-08 22:58:17', '');
INSERT INTO `sys_menu` VALUES (2011, '链接删除', 2007, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'fav:link:remove', '#', 'admin', '2022-05-08 18:44:36', 'admin', '2022-05-08 22:58:21', '');
INSERT INTO `sys_menu` VALUES (2012, '链接导出', 2007, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'fav:link:export', '#', 'admin', '2022-05-08 18:44:36', 'admin', '2022-05-08 22:58:26', '');
INSERT INTO `sys_menu` VALUES (2013, '笔记目录', 2019, 3, 'catalog', 'notebook/catalog/index', NULL, 1, 0, 'C', '0', '0', 'notebook:catalog:list', 'catalog', 'admin', '2022-05-18 12:42:09', 'admin', '2022-08-12 16:05:19', '笔记目录菜单');
INSERT INTO `sys_menu` VALUES (2014, '笔记目录查询', 2013, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'notebook:catalog:query', '#', 'admin', '2022-05-18 12:42:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2015, '笔记目录新增', 2013, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'notebook:catalog:add', '#', 'admin', '2022-05-18 12:42:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2016, '笔记目录修改', 2013, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'notebook:catalog:edit', '#', 'admin', '2022-05-18 12:42:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2017, '笔记目录删除', 2013, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'notebook:catalog:remove', '#', 'admin', '2022-05-18 12:42:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2018, '笔记目录导出', 2013, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'notebook:catalog:export', '#', 'admin', '2022-05-18 12:42:09', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2019, '我的笔记', 0, 5, 'notebook', NULL, NULL, 1, 0, 'M', '0', '0', '', 'notebook', 'admin', '2022-05-18 12:45:37', 'admin', '2022-08-12 16:22:42', '');
INSERT INTO `sys_menu` VALUES (2020, '笔记列表', 2019, 1, 'content', 'notebook/content/index', NULL, 1, 0, 'C', '0', '0', 'notebook:content:list', 'guide', 'admin', '2022-05-19 12:55:38', 'admin', '2022-08-12 16:22:50', '');
INSERT INTO `sys_menu` VALUES (2021, '分享记录', 2019, 4, 'share', 'notebook/share/index', NULL, 1, 0, 'C', '0', '0', '', 'link', 'admin', '2022-05-20 10:00:24', 'admin', '2022-05-22 23:05:55', '');
INSERT INTO `sys_menu` VALUES (2022, '编辑内容', 2019, 2, 'editor/:id', 'notebook/editor/index', NULL, 1, 0, 'C', '1', '0', 'notebook:editor', 'edit', 'admin', '2022-05-21 19:15:11', 'admin', '2022-08-12 16:10:07', '');
INSERT INTO `sys_menu` VALUES (2023, '笔记内容查询', 2020, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'notebook:content:query', '#', 'admin', '2022-05-22 23:07:51', 'admin', '2022-05-25 20:16:29', '');
INSERT INTO `sys_menu` VALUES (2024, '笔记内容编辑', 2020, 1, '', NULL, NULL, 1, 0, 'F', '0', '0', 'notebook:content:edit', '#', 'admin', '2022-05-22 23:08:11', 'admin', '2022-05-25 20:16:35', '');
INSERT INTO `sys_menu` VALUES (2025, '笔记内容设置', 2020, 2, '', NULL, NULL, 1, 0, 'F', '0', '0', 'notebook:content:setting', '#', 'admin', '2022-05-22 23:08:33', 'admin', '2022-05-25 20:16:42', '');
INSERT INTO `sys_menu` VALUES (2026, '笔记内容导入', 2020, 6, '', NULL, NULL, 1, 0, 'F', '0', '0', 'notebook:content:import', '#', 'admin', '2022-05-22 23:08:56', 'admin', '2022-05-28 22:44:25', '');
INSERT INTO `sys_menu` VALUES (2027, '分享记录查询', 2021, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'notebook:share:query', '#', 'admin', '2022-05-22 23:09:21', 'admin', '2022-05-22 23:15:11', '');
INSERT INTO `sys_menu` VALUES (2028, '分享记录删除', 2021, 1, '', NULL, NULL, 1, 0, 'F', '0', '0', 'notebook:share:remove', '#', 'admin', '2022-05-22 23:09:38', 'admin', '2022-05-22 23:15:20', '');
INSERT INTO `sys_menu` VALUES (2029, '分享记录导出', 2021, 2, '', NULL, NULL, 1, 0, 'F', '0', '0', 'notebook:share:export', '#', 'admin', '2022-05-22 23:14:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2030, '笔记文件下载', 2020, 4, '', NULL, NULL, 1, 0, 'F', '0', '0', 'notebook:content:download', '#', 'admin', '2022-05-25 20:17:14', 'admin', '2022-05-30 14:53:19', '');
INSERT INTO `sys_menu` VALUES (2031, '笔记内容删除', 2020, 3, '', NULL, NULL, 1, 0, 'F', '0', '0', 'notebook:content:remove', '#', 'admin', '2022-05-25 21:09:35', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2032, '笔记内容历史', 2020, 5, '', NULL, NULL, 1, 0, 'F', '0', '0', 'notebook:content:history', '#', 'admin', '2022-05-25 21:10:33', '', NULL, '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '通知公告表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int(1) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '岗位信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, 'mgr', '经理', 1, '0', 'admin', '2022-04-22 09:21:16', 'admin', '2022-04-27 23:23:11', '');
INSERT INTO `sys_post` VALUES (2, 'emp', '员工', 2, '0', 'admin', '2022-04-22 09:21:16', 'admin', '2022-04-27 23:23:51', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '系统管理', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '系统管理');
INSERT INTO `sys_role` VALUES (2, '普通用户', 'common', 2, '2', 1, 1, '0', '0', 'admin', '2022-04-22 09:21:16', 'admin', '2022-04-28 00:11:45', '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和部门关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (2, 100);
INSERT INTO `sys_role_dept` VALUES (2, 101);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 100);
INSERT INTO `sys_role_menu` VALUES (2, 101);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 103);
INSERT INTO `sys_role_menu` VALUES (2, 104);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 111);
INSERT INTO `sys_role_menu` VALUES (2, 112);
INSERT INTO `sys_role_menu` VALUES (2, 113);
INSERT INTO `sys_role_menu` VALUES (2, 114);
INSERT INTO `sys_role_menu` VALUES (2, 115);
INSERT INTO `sys_role_menu` VALUES (2, 500);
INSERT INTO `sys_role_menu` VALUES (2, 501);
INSERT INTO `sys_role_menu` VALUES (2, 1001);
INSERT INTO `sys_role_menu` VALUES (2, 1002);
INSERT INTO `sys_role_menu` VALUES (2, 1003);
INSERT INTO `sys_role_menu` VALUES (2, 1004);
INSERT INTO `sys_role_menu` VALUES (2, 1005);
INSERT INTO `sys_role_menu` VALUES (2, 1006);
INSERT INTO `sys_role_menu` VALUES (2, 1007);
INSERT INTO `sys_role_menu` VALUES (2, 1008);
INSERT INTO `sys_role_menu` VALUES (2, 1009);
INSERT INTO `sys_role_menu` VALUES (2, 1010);
INSERT INTO `sys_role_menu` VALUES (2, 1011);
INSERT INTO `sys_role_menu` VALUES (2, 1012);
INSERT INTO `sys_role_menu` VALUES (2, 1013);
INSERT INTO `sys_role_menu` VALUES (2, 1014);
INSERT INTO `sys_role_menu` VALUES (2, 1015);
INSERT INTO `sys_role_menu` VALUES (2, 1016);
INSERT INTO `sys_role_menu` VALUES (2, 1017);
INSERT INTO `sys_role_menu` VALUES (2, 1018);
INSERT INTO `sys_role_menu` VALUES (2, 1019);
INSERT INTO `sys_role_menu` VALUES (2, 1020);
INSERT INTO `sys_role_menu` VALUES (2, 1021);
INSERT INTO `sys_role_menu` VALUES (2, 1022);
INSERT INTO `sys_role_menu` VALUES (2, 1023);
INSERT INTO `sys_role_menu` VALUES (2, 1024);
INSERT INTO `sys_role_menu` VALUES (2, 1025);
INSERT INTO `sys_role_menu` VALUES (2, 1026);
INSERT INTO `sys_role_menu` VALUES (2, 1027);
INSERT INTO `sys_role_menu` VALUES (2, 1028);
INSERT INTO `sys_role_menu` VALUES (2, 1029);
INSERT INTO `sys_role_menu` VALUES (2, 1030);
INSERT INTO `sys_role_menu` VALUES (2, 1031);
INSERT INTO `sys_role_menu` VALUES (2, 1032);
INSERT INTO `sys_role_menu` VALUES (2, 1033);
INSERT INTO `sys_role_menu` VALUES (2, 1034);
INSERT INTO `sys_role_menu` VALUES (2, 1035);
INSERT INTO `sys_role_menu` VALUES (2, 1036);
INSERT INTO `sys_role_menu` VALUES (2, 1037);
INSERT INTO `sys_role_menu` VALUES (2, 1038);
INSERT INTO `sys_role_menu` VALUES (2, 1039);
INSERT INTO `sys_role_menu` VALUES (2, 1040);
INSERT INTO `sys_role_menu` VALUES (2, 1041);
INSERT INTO `sys_role_menu` VALUES (2, 1042);
INSERT INTO `sys_role_menu` VALUES (2, 1043);
INSERT INTO `sys_role_menu` VALUES (2, 1044);
INSERT INTO `sys_role_menu` VALUES (2, 1045);
INSERT INTO `sys_role_menu` VALUES (2, 1046);
INSERT INTO `sys_role_menu` VALUES (2, 1047);
INSERT INTO `sys_role_menu` VALUES (2, 1048);
INSERT INTO `sys_role_menu` VALUES (2, 1049);
INSERT INTO `sys_role_menu` VALUES (2, 1050);
INSERT INTO `sys_role_menu` VALUES (2, 1051);
INSERT INTO `sys_role_menu` VALUES (2, 1052);
INSERT INTO `sys_role_menu` VALUES (2, 1053);
INSERT INTO `sys_role_menu` VALUES (2, 1054);
INSERT INTO `sys_role_menu` VALUES (2, 1055);
INSERT INTO `sys_role_menu` VALUES (2, 1056);
INSERT INTO `sys_role_menu` VALUES (2, 1057);
INSERT INTO `sys_role_menu` VALUES (2, 1058);
INSERT INTO `sys_role_menu` VALUES (2, 1059);
INSERT INTO `sys_role_menu` VALUES (2, 1060);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 101, 'admin', 'ADMIN', '00', 'devzyh@foxmail.com', '18888888888', '0', '/file/avatar/2022/04/27/blob_20220427184129A001.jpeg', '$2a$10$uXTC6to4QjEFCFmXAQcEpOPzoyrlrmOiKfE.thQx3qqYb6ETggb7G', '0', '0', '127.0.0.1', '2022-09-02 14:30:49', 'admin', '2022-04-22 09:21:16', '', '2022-09-02 14:30:49', '系统管理');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES (1, 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);

SET FOREIGN_KEY_CHECKS = 1;
