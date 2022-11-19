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
  `digest` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容摘要',
  `source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '来源平台',
  `release_date` date NULL DEFAULT NULL COMMENT '发布日期',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fav_article
-- ----------------------------
INSERT INTO `fav_article` VALUES (1, '一文带你入门 JMeter 性能测试！\n', 'https://mp.weixin.qq.com/s/RczbJW_1gX_0s1fNs4K1dw', NULL, 'wxmp', '2021-10-26', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (2, '读懂Redis源码，我总结了这7点心得', 'https://mp.weixin.qq.com/s/h-OEbiUUmKvUZqxmjfmgtg', NULL, 'wxmp', '2021-09-27', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (3, '七步制作精简镜像', 'https://mp.weixin.qq.com/s/cSWHvIntrebJHzC53SM2lg', NULL, 'wxmp', '2021-10-27', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (4, 'Spring中涉及的设计模式总结', 'https://mp.weixin.qq.com/s/m1V_FtlwP4cttcqy7sILMw', NULL, 'wxmp', '2021-09-02', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (5, '阿里技术人看什么书？这个春节和你共享书单！', 'https://mp.weixin.qq.com/s/mDLZ7luWknk7TvQIQjZbBg', NULL, 'wxmp', '2021-02-12', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (6, '武汉有哪些不错的互联网公司？', 'https://mp.weixin.qq.com/s/fhMkMMqTrAe-8Af6Jk4XAg', NULL, 'wxmp', '2021-10-21', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (7, '聊聊订单系统的设计？', 'https://mp.weixin.qq.com/s/k8EXOaqjNIvWMgNzI4fJ3g', NULL, 'wxmp', '2021-09-10', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (8, '【Gradle教程】Gradle 基础入门', 'https://www.cnblogs.com/hellxz/p/helloworld-gradle.html', NULL, 'cnblogs', '2020-05-30', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (9, '算法执行过程可视化网站', 'https://www.cs.usfca.edu/~galles/visualization/Algorithms.html', NULL, 'direct', '2021-11-02', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (10, '经典面试题：在浏览器地址栏输入一个 URL 后回车，背后发生了什么', 'https://www.cnblogs.com/cswiki/p/14429730.html', NULL, 'cnblogs', '2021-02-22', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (11, '关于 TCP 三次握手和四次挥手，满分回答在此', 'https://mp.weixin.qq.com/s/u56NcMs68sgi6uDpzJ61yw', NULL, 'wxmp', '2021-01-07', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (12, '别再恐惧 IP 协议（万字长文 | 多图预警）\n', 'https://mp.weixin.qq.com/s/NO9RDt1A3T1rz-Q4_Y0gPw', NULL, 'wxmp', '2021-01-15', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (13, '48 张图 | 手摸手教你微服务的性能监控、压测和调优\n', 'https://www.cnblogs.com/jackson0714/p/performance.html', NULL, 'cnblogs', '2021-03-17', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (14, 'Dubbo 与 Spring Cloud 完美结合\n', 'https://www.cnblogs.com/babycomeon/p/11546737.html', NULL, 'cnblogs', '2019-09-19', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (15, '在Git的PR(Pull Request)提示冲突无法merge合并的解决方案', 'https://www.cnblogs.com/xxcanghai/p/12160556.html', NULL, 'cnblogs', '2020-01-07', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (16, 'Java：CAS(乐观锁)', 'https://www.jianshu.com/p/ae25eb3cfb5d', NULL, 'jianshu', '2018-07-16', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (17, 'java多线程高并发', 'https://www.cnblogs.com/sx66/p/12623437.html', NULL, 'cnblogs', '2020-04-02', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (18, '2020年最新78道JVM面试题总结（含答案解析和思维导图）', 'https://www.cnblogs.com/zhuifeng523/p/13172080.html', NULL, 'cnblogs', '2020-06-21', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (19, 'Ubuntu20.04 apt方式安装MySQL', 'https://blog.csdn.net/lianghecai52171314/article/details/113807099', NULL, 'csdn', '2021-02-14', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (20, 'AOP面试造火箭始末', 'https://www.cnblogs.com/xiekun/p/14471595.html', NULL, 'cnblogs', '2021-03-02', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (21, 'MySQL Explain详解', 'https://www.cnblogs.com/tufujie/p/9413852.html', NULL, 'cnblogs', '2018-08-03', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (22, 'BigDecimal操作', 'https://blog.csdn.net/javaNiuLei12/article/details/54091258', NULL, 'csdn', '2017-01-05', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (23, '5分钟让你掌握Vuex，深入浅出', 'https://www.cnblogs.com/maoqian/p/15428820.html', NULL, 'cnblogs', '2021-10-20', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (24, '被敖丙用烂的「数据库调优」连招？真香，淦！', 'https://mp.weixin.qq.com/s?__biz=MzAwNDA2OTM1Ng==&mid=2453143331&idx=1&sn=e387e1b1beb4cd516ee2d67ce934115e&scene=21#wechat_redirect', NULL, 'wxmp', '2020-11-17', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (25, '为什么IDEA不推荐你使用@Autowired ？', 'https://mp.weixin.qq.com/s/Nu25_5mMtD8nboPj8m7lyA', NULL, 'wxmp', '2021-11-05', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (26, 'LocalDateTime, LocalDate, Instant, Long 相互转换', 'https://blog.csdn.net/qq_19266669/article/details/106743102', NULL, 'csdn', '2020-06-14', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (27, '英语零基础，有什么自学方法？', 'https://www.zhihu.com/question/36449108/answer/756802719', NULL, 'zhihu', '2019-07-21', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (28, 'BBC减肥十律', 'https://zhuanlan.zhihu.com/p/412545357', NULL, 'zhihu', '2019-09-21', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (29, '蓝绿部署、金丝雀发布（灰度发布）、AB测试都是啥？', 'https://mp.weixin.qq.com/s/3ux2NTgtnXG34NjT2HNW-A', NULL, 'wxmp', '2021-11-13', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (30, 'Spring Boot 2.6之后，动态权限控制终于可以用起来了！', 'https://mp.weixin.qq.com/s/Tki0SWTq37EYXVNtlgYszQ', NULL, 'wxmp', '2021-11-22', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (31, '详细介绍mysql索引类型：FULLTEXT、NORMAL、SPATIAL、UNIQUE', 'https://blog.csdn.net/guo_qiangqiang/article/details/88794971', NULL, 'csdn', '2019-03-25', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (32, 'MySQL存储引擎', 'https://www.cnblogs.com/birdy-silhouette/p/15066260.html', NULL, 'cnblogs', '2021-07-27', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (33, '妙用Java 8中的 Function接口 消灭if...else（非常新颖的写法）', 'https://mp.weixin.qq.com/s/5FmD0PtPsQFPiImMiLC_eg', NULL, 'wxmp', '2021-12-05', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (34, 'MySQL慢查询，一口从天而降的锅！', 'https://blog.csdn.net/qq_39390545/article/details/116139445', NULL, 'csdn', '2021-04-25', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (35, 'Redis 实现限流的三种方式', 'https://blog.csdn.net/lmx125254/article/details/90700118', NULL, 'csdn', '2019-05-30', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (36, '并发模拟的四种方式 + 工具，超级实用！', 'https://mp.weixin.qq.com/s/B5Kx6fKAj_B78mLPMaFZtw', NULL, 'wxmp', '2021-12-17', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (37, 'SQL 优化极简法则，还有谁不会？', 'https://mp.weixin.qq.com/s/NS2trUx9nVN5gNquVVbruw', NULL, 'wxmp', '2021-12-14', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (38, 'Java位运算符：Java移位运算符、复合位赋值运算符及位逻辑运算符', 'http://c.biancheng.net/view/784.html', NULL, 'direct', '2021-12-25', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (39, '作为技术负责人，如何从0搭建公司后端技术栈', 'https://mp.weixin.qq.com/s/v8E4FKu6fIhXb1v_WtlYZw', NULL, 'wxmp', '2022-01-12', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (40, 'Spring MVC中处理Request和Response的策略', 'https://mp.weixin.qq.com/s/DQEI0ZTrJuVjjONOzmnLYg', NULL, 'wxmp', '2022-01-12', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (41, '一文教会你领域建模', 'https://mp.weixin.qq.com/s/3x4fK7rtA2US9fxoKpoAiA', NULL, 'wxmp', '2021-12-30', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (42, '生成订单30分钟未支付，则自动取消，该怎么实现？', 'https://mp.weixin.qq.com/s/QOQhsXWQDqXsWngQUGOk5w', NULL, 'wxmp', '2022-01-25', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (43, '几种常见的JVM调优场景（建议收藏）', 'https://mp.weixin.qq.com/s/35uO5VQnDZGVZXWnaUbaqg', NULL, 'wxmp', '2022-01-24', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (44, 'git-stash用法小结', 'https://www.cnblogs.com/tocy/p/git-stash-reference.html', NULL, 'cnblogs', '2016-10-31', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (45, 'RabbitMQ 如何保证消息不丢失？', 'https://www.cnblogs.com/cnndevelop/p/12091348.html', NULL, 'cnblogs', '2019-12-24', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (46, 'Spring OAuth2 开发指南（一）：体系架构和开发概览', 'https://www.jianshu.com/p/45f6d4d0574a', NULL, 'jianshu', '2021-08-09', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (47, 'SQL优化万能公式：5 大步骤 + 10 个案例', 'https://mp.weixin.qq.com/s/YAu_DG1YN_7pEizlZCqhew', NULL, 'wxmp', '2022-03-31', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (48, '判断时间是否有重叠', 'https://www.cnblogs.com/luyuqiang/p/14990941.html', NULL, 'cnblogs', '2021-07-09', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (49, 'MongoDB 4.x 的权限管理说明', 'https://www.jianshu.com/p/e95c22c4ed43', NULL, 'jianshu', '2020-05-23', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (50, '秒懂 23 种设计模式！有点污，但真得秒啊...', 'https://mp.weixin.qq.com/s/U3LWho3pGw6PdLdsO51kjg', '', 'wxmp', '2022-04-29', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (52, 'IntelliJ IDEA 卡成球了？', 'https://mp.weixin.qq.com/s/p2kMAelK43k_u0lygBmTKg', NULL, 'wxmp', '2022-05-10', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (53, 'Spring Boot + Redis 搞定搜索栏热搜、不雅文字过滤功能', 'https://mp.weixin.qq.com/s/ibb3tgJ-Dzu4QXMpH44fbA', NULL, 'wxmp', '2022-05-12', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (54, 'Spring的@ControllerAdvice注解', 'https://www.cnblogs.com/yanggb/p/10859907.html', NULL, 'cnblogs', '2019-05-15', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (55, 'Socket 粘包和分包问题', 'https://www.apifox.cn/help/reference/socket-stick/', NULL, 'direct', '2022-05-17', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (56, 'Vditor 一款浏览器端的 Markdown 编辑器，支持所见即所得（富文本）、即时渲染（类似 Typora）和分屏预览模式', 'https://ld246.com/article/1549638745630', NULL, 'direct', '2022-05-21', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (57, 'ssh StrictHostKeyChecking', 'https://www.jianshu.com/p/ebcf41c75786', NULL, 'jianshu', '2018-06-29', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (58, '提问的艺术', 'http://spring4all.com/forum-post/694', NULL, 'direct', '2022-04-07', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (59, '面试官：String长度有限制吗？是多少？', 'https://mp.weixin.qq.com/s/Z4sxQ_Bc3uudAX0ugI3ujw', NULL, 'wxmp', '2022-05-31', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (60, 'Linux中几个你不常用，但却很有用的命令', 'https://mp.weixin.qq.com/s/Ic8ltNlEpteFdnnwPSc5kQ', NULL, 'wxmp', '2022-06-07', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (61, '用分布式锁来防止库存超卖，但是是每秒上千订单的高并发场景，如何对分布式锁进行高并发优化来应对这个场景？', 'https://blog.csdn.net/u010391342/article/details/84372342', NULL, 'csdn', '2018-11-23', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (62, '论微服务架构的核心概念', 'https://github.com/JoeCao/JoeCao.github.io/issues/3', NULL, 'direct', '2017-09-12', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (63, 'int(1) 和 int(10) 有什么区别？', 'https://mp.weixin.qq.com/s/7lhleHM74xQyQ--xZZfyMg', NULL, 'wxmp', '2022-06-09', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (64, '谈下新手程序员怎样写好复杂业务代码', 'https://blog.csdn.net/icai888/article/details/106159861', NULL, 'csdn', '2020-05-16', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (65, '3000 帧动画图解 MySQL 为什么需要 binlog、redo log 和 undo log', 'https://my.oschina.net/u/4893843/blog/5533822', NULL, 'oschina', '2022-05-31', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (66, '如何优雅的写 Controller 层代码？', 'https://mp.weixin.qq.com/s/eZS9dQ8I2FWEP6ykeDAHUg', NULL, 'wxmp', '2022-06-23', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (67, 'HTTP协议一知半解？这篇帮你全面了解！', 'https://mp.weixin.qq.com/s/Rh5BMzZxIYKsHzt-hliKMw', NULL, 'wxmp', '2022-06-23', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (68, 'Redis 如何实现库存扣减操作？', 'https://mp.weixin.qq.com/s/DCP76xENsGzJF7mo1U8tCQ', NULL, 'wxmp', '2022-07-13', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (69, '学会 Arthas，让你 3 年经验掌握 5 年功力！', 'https://mp.weixin.qq.com/s/3lJb4vs3pnlyJoVSrl8BhQ', NULL, 'wxmp', '2022-08-02', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (70, '使用 DataX 实现 MySQL 数据的高效同步', 'https://mp.weixin.qq.com/s/8lhWKhMk5uczQzudUEt-Xg', NULL, 'wxmp', '2022-07-14', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (71, '产品太多了，如何实现一次登录多产品互通？', 'https://mp.weixin.qq.com/s/TBVtYPrbLMJyaUulLSVx9g', NULL, 'wxmp', '2022-08-04', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (72, 'Redis为什么这么快？', 'https://mp.weixin.qq.com/s/eSWnwgOF8urqONIbtvxs_Q', NULL, 'wxmp', '2022-08-25', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (73, '从 JDK 8 到 JDK 18，Java 垃圾回收的十次进化', 'https://mp.weixin.qq.com/s/0IqNbhcmnOKrNe0gIK7qlQ', NULL, 'wxmp', '2022-08-26', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (74, '踩坑了！0作为除数，不一定会抛出异常！', 'https://www.cnblogs.com/thisiswhy/p/16635585.html', '', 'cnblogs', '2022-08-29', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (75, '分布式和微服务的区别', 'https://www.cnblogs.com/wq-9/p/15183778.html', NULL, 'cnblogs', '2021-08-25', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (76, '构建 Java 镜像的 10 个最佳实践', 'https://mp.weixin.qq.com/s/u4bsD_xgQ72BdcKNyU3xmw', '在下面的速查表中，我将为你提供构建生产级 Java 容器的最佳实践，旨在优化和保护要投入生产环境中的 Docker 镜像。', 'wxmp', '2022-09-07', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (77, '简单几步，实现 Redis 查询 “附近的人”', 'https://mp.weixin.qq.com/s/1DzUZ7UskewntdygOksz5A', 'Redis结合其有序队列zset以及geohash编码，实现了空间搜索功能，且拥有极高的运行效率。', 'wxmp', '2022-09-15', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (78, '接手了一座年收入 2000 万美元的“屎山”，我到底该重写还是跳槽？', 'https://mp.weixin.qq.com/s/q7tRnbnHVr3mM951ayny7A', '近日 Hacker News 上有一则帖子热度非常高，其主题是：我接手了一份极其糟糕的代码和一支技术团队，接下来该怎么办？', 'wxmp', '2022-09-26', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (79, 'ByteMD开源编辑器', 'https://github.com/bytedance/bytemd', 'ByteMD是使用Svelte构建的标记编辑器组件。它也可以用于其他库/框架，如 React、Vue 和 Angular。', 'direct', '2022-09-27', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (80, '理解和处理Cannot assign requested address错误', 'https://www.cnblogs.com/thatsit/p/cannot-assign-requested-address.html', '“Cannot assign requested address.”是由于linux分配的客户端连接端口用尽，无法建立socket连接所致，虽然socket正常关闭，但是端口不是立即释放，而是处于TIME_WAIT状态，默认等待60s后才释放。', 'cnblogs', '2020-07-21', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (81, '淘宝开放平台应用技术规范', 'https://open.taobao.com/doc.htm?docId=109298&docType=1', '平台经过多年双11考验的技术架构经验向所有的生态伙伴输出，平台鼓励开放平台所有应用开发者依据此规范进行应用架构设计和优化，从而推动整个生态体系更加健康地发展。', 'direct', '2019-08-08', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (82, 'MySQL分页延迟关联查询', 'https://www.cnblogs.com/pufeng/p/11750495.html', '下面的介绍均是在选用MySQL数据库和Innodb引擎的基础开展。我们先来学习索引的几个概念，帮助我们理解延迟关联优化的加快分页查询速度的原因。', 'cnblogs', '2019-10-28', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (83, 'Java 动态代理的两种方式及其优缺点', 'https://mp.weixin.qq.com/s/kgB03P7Ocqj8EUTv55-zNw', '动态代理应用非常的广泛，在各种开源的框架中都能看到他们的身影，动态代理主要有JDK和CGLIB两种方式，今天来学习下这两种方式的实现，以及它们的优缺点。', 'wxmp', '2022-10-09', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (84, 'NetHogs监控Linux的每个进程流量 ', 'http://bash.lutixia.cn/c/nethogs.html#nethogs', '有很多适用于Linux系统的开源网络监视工具。比如说，你可以用命令iftop来检查带宽使用情况。netstat用来查看接口统计报告，还有top监控系统当前运行进程。但是如果你想要找一个能够按进程实时统计网络带宽利用率的工具，那么NetHogs值得一看。', 'direct', '2022-10-09', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (87, 'JAVA 程序突然挂掉排查记录', 'https://blog.csdn.net/yangwy012210/article/details/107378079', '1.程序运行一段时间后，突然挂掉,程序日志无任何异常记录\n2.查看系统日志（/var/log/message）会发现是被系统杀死', 'csdn', '2020-07-16', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_article` VALUES (89, '这么多年你还在怕正则吗？', 'https://juejin.cn/post/7153800580077453326', '不会吧不会吧，这么多年你还在怕正则？这就对了，相信你用不了几分钟看完本文，从此正则算个球。', 'juejin', '2022-10-13', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for fav_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `fav_article_tag`;
CREATE TABLE `fav_article_tag`  (
  `article_id` int(11) NOT NULL COMMENT '文章ID',
  `tag_id` int(11) NOT NULL COMMENT '标签ID',
  PRIMARY KEY (`article_id`, `tag_id`) USING BTREE,
  INDEX `idx_article_id`(`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章标签关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fav_article_tag
-- ----------------------------
INSERT INTO `fav_article_tag` VALUES (1, 22);
INSERT INTO `fav_article_tag` VALUES (2, 19);
INSERT INTO `fav_article_tag` VALUES (3, 4);
INSERT INTO `fav_article_tag` VALUES (4, 3);
INSERT INTO `fav_article_tag` VALUES (4, 20);
INSERT INTO `fav_article_tag` VALUES (5, 2);
INSERT INTO `fav_article_tag` VALUES (5, 9);
INSERT INTO `fav_article_tag` VALUES (6, 8);
INSERT INTO `fav_article_tag` VALUES (7, 6);
INSERT INTO `fav_article_tag` VALUES (8, 23);
INSERT INTO `fav_article_tag` VALUES (9, 1);
INSERT INTO `fav_article_tag` VALUES (10, 16);
INSERT INTO `fav_article_tag` VALUES (11, 16);
INSERT INTO `fav_article_tag` VALUES (12, 16);
INSERT INTO `fav_article_tag` VALUES (13, 12);
INSERT INTO `fav_article_tag` VALUES (13, 22);
INSERT INTO `fav_article_tag` VALUES (14, 5);
INSERT INTO `fav_article_tag` VALUES (14, 12);
INSERT INTO `fav_article_tag` VALUES (15, 7);
INSERT INTO `fav_article_tag` VALUES (15, 23);
INSERT INTO `fav_article_tag` VALUES (16, 9);
INSERT INTO `fav_article_tag` VALUES (17, 8);
INSERT INTO `fav_article_tag` VALUES (17, 9);
INSERT INTO `fav_article_tag` VALUES (18, 8);
INSERT INTO `fav_article_tag` VALUES (18, 9);
INSERT INTO `fav_article_tag` VALUES (18, 10);
INSERT INTO `fav_article_tag` VALUES (19, 11);
INSERT INTO `fav_article_tag` VALUES (19, 15);
INSERT INTO `fav_article_tag` VALUES (20, 9);
INSERT INTO `fav_article_tag` VALUES (20, 20);
INSERT INTO `fav_article_tag` VALUES (21, 15);
INSERT INTO `fav_article_tag` VALUES (22, 9);
INSERT INTO `fav_article_tag` VALUES (23, 24);
INSERT INTO `fav_article_tag` VALUES (24, 15);
INSERT INTO `fav_article_tag` VALUES (25, 9);
INSERT INTO `fav_article_tag` VALUES (25, 20);
INSERT INTO `fav_article_tag` VALUES (26, 9);
INSERT INTO `fav_article_tag` VALUES (27, 21);
INSERT INTO `fav_article_tag` VALUES (28, 21);
INSERT INTO `fav_article_tag` VALUES (29, 22);
INSERT INTO `fav_article_tag` VALUES (30, 9);
INSERT INTO `fav_article_tag` VALUES (30, 20);
INSERT INTO `fav_article_tag` VALUES (31, 15);
INSERT INTO `fav_article_tag` VALUES (32, 15);
INSERT INTO `fav_article_tag` VALUES (33, 9);
INSERT INTO `fav_article_tag` VALUES (34, 15);
INSERT INTO `fav_article_tag` VALUES (35, 6);
INSERT INTO `fav_article_tag` VALUES (35, 9);
INSERT INTO `fav_article_tag` VALUES (35, 19);
INSERT INTO `fav_article_tag` VALUES (36, 22);
INSERT INTO `fav_article_tag` VALUES (37, 15);
INSERT INTO `fav_article_tag` VALUES (38, 9);
INSERT INTO `fav_article_tag` VALUES (39, 17);
INSERT INTO `fav_article_tag` VALUES (40, 9);
INSERT INTO `fav_article_tag` VALUES (40, 20);
INSERT INTO `fav_article_tag` VALUES (41, 17);
INSERT INTO `fav_article_tag` VALUES (42, 6);
INSERT INTO `fav_article_tag` VALUES (43, 9);
INSERT INTO `fav_article_tag` VALUES (43, 10);
INSERT INTO `fav_article_tag` VALUES (44, 7);
INSERT INTO `fav_article_tag` VALUES (44, 23);
INSERT INTO `fav_article_tag` VALUES (45, 14);
INSERT INTO `fav_article_tag` VALUES (45, 18);
INSERT INTO `fav_article_tag` VALUES (46, 9);
INSERT INTO `fav_article_tag` VALUES (46, 20);
INSERT INTO `fav_article_tag` VALUES (47, 15);
INSERT INTO `fav_article_tag` VALUES (48, 6);
INSERT INTO `fav_article_tag` VALUES (48, 15);
INSERT INTO `fav_article_tag` VALUES (49, 13);
INSERT INTO `fav_article_tag` VALUES (50, 3);
INSERT INTO `fav_article_tag` VALUES (52, 23);
INSERT INTO `fav_article_tag` VALUES (53, 9);
INSERT INTO `fav_article_tag` VALUES (53, 19);
INSERT INTO `fav_article_tag` VALUES (53, 20);
INSERT INTO `fav_article_tag` VALUES (54, 9);
INSERT INTO `fav_article_tag` VALUES (54, 20);
INSERT INTO `fav_article_tag` VALUES (55, 16);
INSERT INTO `fav_article_tag` VALUES (56, 25);
INSERT INTO `fav_article_tag` VALUES (57, 11);
INSERT INTO `fav_article_tag` VALUES (58, 21);
INSERT INTO `fav_article_tag` VALUES (59, 9);
INSERT INTO `fav_article_tag` VALUES (60, 11);
INSERT INTO `fav_article_tag` VALUES (61, 6);
INSERT INTO `fav_article_tag` VALUES (61, 19);
INSERT INTO `fav_article_tag` VALUES (62, 12);
INSERT INTO `fav_article_tag` VALUES (63, 15);
INSERT INTO `fav_article_tag` VALUES (64, 6);
INSERT INTO `fav_article_tag` VALUES (65, 15);
INSERT INTO `fav_article_tag` VALUES (66, 6);
INSERT INTO `fav_article_tag` VALUES (66, 20);
INSERT INTO `fav_article_tag` VALUES (67, 16);
INSERT INTO `fav_article_tag` VALUES (68, 6);
INSERT INTO `fav_article_tag` VALUES (68, 19);
INSERT INTO `fav_article_tag` VALUES (69, 10);
INSERT INTO `fav_article_tag` VALUES (69, 23);
INSERT INTO `fav_article_tag` VALUES (70, 15);
INSERT INTO `fav_article_tag` VALUES (70, 23);
INSERT INTO `fav_article_tag` VALUES (71, 6);
INSERT INTO `fav_article_tag` VALUES (71, 9);
INSERT INTO `fav_article_tag` VALUES (72, 19);
INSERT INTO `fav_article_tag` VALUES (73, 9);
INSERT INTO `fav_article_tag` VALUES (73, 10);
INSERT INTO `fav_article_tag` VALUES (74, 9);
INSERT INTO `fav_article_tag` VALUES (75, 26);
INSERT INTO `fav_article_tag` VALUES (76, 4);
INSERT INTO `fav_article_tag` VALUES (76, 9);
INSERT INTO `fav_article_tag` VALUES (77, 6);
INSERT INTO `fav_article_tag` VALUES (77, 19);
INSERT INTO `fav_article_tag` VALUES (78, 17);
INSERT INTO `fav_article_tag` VALUES (79, 23);
INSERT INTO `fav_article_tag` VALUES (79, 27);
INSERT INTO `fav_article_tag` VALUES (80, 11);
INSERT INTO `fav_article_tag` VALUES (81, 26);
INSERT INTO `fav_article_tag` VALUES (82, 15);
INSERT INTO `fav_article_tag` VALUES (83, 9);
INSERT INTO `fav_article_tag` VALUES (84, 11);
INSERT INTO `fav_article_tag` VALUES (87, 9);
INSERT INTO `fav_article_tag` VALUES (87, 11);
INSERT INTO `fav_article_tag` VALUES (89, 9);
INSERT INTO `fav_article_tag` VALUES (93, 3);
INSERT INTO `fav_article_tag` VALUES (93, 4);
INSERT INTO `fav_article_tag` VALUES (93, 6);

-- ----------------------------
-- Table structure for fav_link
-- ----------------------------
DROP TABLE IF EXISTS `fav_link`;
CREATE TABLE `fav_link`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `item` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分组',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `href` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '地址',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图像',
  `seq` int(11) NOT NULL DEFAULT 0 COMMENT '顺序',
  `target` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '_self' COMMENT '打开方式',
  `visits` bigint(255) NULL DEFAULT 0 COMMENT '访问次数',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '链接地址' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fav_link
-- ----------------------------
INSERT INTO `fav_link` VALUES (1, 'editor', 'JSON编辑器', '/json', NULL, 1, '_self', 25, NULL, NULL, NULL, NULL, '简单的JSON文本编辑工具，可以对数据进行格式化和反格式化');
INSERT INTO `fav_link` VALUES (2, 'editor', 'XML编辑器', '/xml', NULL, 2, '_self', 1, NULL, NULL, NULL, NULL, '简单的XML美化压缩工具');
INSERT INTO `fav_link` VALUES (3, 'editor', '文本差异对比', '/diff', NULL, 3, '_self', 11, NULL, NULL, NULL, NULL, '对比两个文本的内容并高亮显示');
INSERT INTO `fav_link` VALUES (4, 'editor', 'XSLT测试', '/xslt', NULL, 4, '_self', 1, NULL, NULL, NULL, NULL, 'XML数据样式表功能测试');
INSERT INTO `fav_link` VALUES (5, 'editor', '加密解密', '/code', NULL, 5, '_self', 2, NULL, NULL, NULL, NULL, '支持常见的加密与解密技术');
INSERT INTO `fav_link` VALUES (6, 'helper', '腾讯翻译君', 'https://fanyi.qq.com/', NULL, 1, '_blank', 3, NULL, NULL, NULL, NULL, '全新人工智能翻译， 句子、文章、论文、资料翻译首选');
INSERT INTO `fav_link` VALUES (7, 'helper', '变量命名', 'https://unbug.github.io/codelf/', NULL, 2, '_blank', 2, NULL, NULL, NULL, NULL, 'Codelf,变量命名,函数命名,方法命名,变量命名神器,GitHub 分组');
INSERT INTO `fav_link` VALUES (8, 'helper', 'Github代下载', 'https://ghproxy.com/', NULL, 3, '_blank', 1, NULL, NULL, NULL, NULL, 'GitHub 文件 , Releases , archive , gist , raw.githubusercontent.com 文件代理加速下载服务');
INSERT INTO `fav_link` VALUES (9, 'helper', '项目文档工具', 'https://docsify.js.org/#/zh-cn/', NULL, 4, '_blank', 1, NULL, NULL, NULL, NULL, '一个神奇的文档网站生成器');
INSERT INTO `fav_link` VALUES (10, 'helper', 'IDEA试用', 'https://gitee.com/pengzhile/ide-eval-resetter', NULL, 5, '_blank', 2, NULL, NULL, NULL, NULL, 'Jetbrains系列产品重置试用方法');
INSERT INTO `fav_link` VALUES (11, 'helper', 'Git大全', 'https://gitee.com/all-about-git', NULL, 6, '_blank', 0, NULL, NULL, NULL, NULL, '最全面的 Git 资源索引以及常用命令教程');
INSERT INTO `fav_link` VALUES (12, 'helper', 'httpbin.org', 'https://httpbin.org', NULL, 7, '_blank', 1, NULL, NULL, NULL, NULL, '一个简单的HTPP请求响应网站');
INSERT INTO `fav_link` VALUES (13, 'document', 'Apache项目', 'https://www.apache.org/index.html#projects-list', NULL, 1, '_blank', 6, NULL, NULL, NULL, NULL, 'Apache基金会官方项目列表');
INSERT INTO `fav_link` VALUES (14, 'document', 'Java8文档', 'https://docs.oracle.com/javase/8/docs/api/', NULL, 2, '_blank', 1, NULL, NULL, NULL, NULL, 'Java8官方文档');
INSERT INTO `fav_link` VALUES (15, 'document', 'Spring文档', 'https://spring.io/projects', NULL, 3, '_blank', 1, NULL, NULL, NULL, NULL, 'Spring项目官方文档');
INSERT INTO `fav_link` VALUES (16, 'document', 'Mybatis文档', 'https://mybatis.org/mybatis-3/zh/index.html', NULL, 4, '_blank', 1, NULL, NULL, NULL, NULL, 'Mybatis官方中文文档');
INSERT INTO `fav_link` VALUES (17, 'document', 'Java开发手册', 'https://github.com/alibaba/p3c', NULL, 5, '_blank', 1, NULL, NULL, NULL, NULL, '阿里巴巴Java开发手册');
INSERT INTO `fav_link` VALUES (18, 'document', 'On Java8', 'https://gitee.com/lingcoder/OnJava8/tree/1ef7ec48e492862300e667e24c245e9b3a5ccd98', NULL, 6, '_blank', 1, NULL, NULL, NULL, NULL, '《On Java 8》中文版');
INSERT INTO `fav_link` VALUES (19, 'document', 'Java8特性', 'https://github.com/biezhi/learn-java8', NULL, 7, '_blank', 1, NULL, NULL, NULL, NULL, '在这里你可以学习到 Java8 中的核心特性以及使用场景');
INSERT INTO `fav_link` VALUES (20, 'document', 'Docs4dev', 'https://www.docs4dev.com/docs/zh', NULL, 8, '_blank', 2, NULL, NULL, NULL, NULL, '开发文档中文版汇总');
INSERT INTO `fav_link` VALUES (21, 'blog', '菜鸟教程', 'https://www.runoob.com', NULL, 1, '_blank', 1, NULL, NULL, NULL, NULL, '提供了编程的基础技术教程, 介绍了各种编程语言的基础知识');
INSERT INTO `fav_link` VALUES (22, 'blog', '阿里云藏经阁', 'https://developer.aliyun.com/ebook', NULL, 2, '_blank', 2, NULL, NULL, NULL, NULL, '汇聚阿里巴巴技术实践精华，深度分享阿里工程师实战经验');
INSERT INTO `fav_link` VALUES (23, 'blog', '程序员DD', 'https://blog.didispace.com/', NULL, 5, '_blank', 1, NULL, NULL, NULL, NULL, '内容涵盖Java后端技术、微服务架构、运维开发等相关的研究与知识分享');
INSERT INTO `fav_link` VALUES (24, 'blog', '酷壳博客', 'https://coolshell.cn/', NULL, 7, '_blank', 2, NULL, NULL, NULL, NULL, '享受编程和技术所带来的快乐 – https://coolshell.cn');
INSERT INTO `fav_link` VALUES (25, 'blog', '虫洞栈', 'https://bugstack.cn/', NULL, 3, '_blank', 4, NULL, NULL, NULL, NULL, '重学Java设计模式, 字节码编程, 中间件, Spring, Java基础, 面经手册');
INSERT INTO `fav_link` VALUES (26, 'blog', '三太子敖丙', 'https://mp.weixin.qq.com/s/2l8iZeTRfMaUOcgtad1wIQ', NULL, 13, '_blank', 0, NULL, NULL, NULL, NULL, '渣男两年文章汇总（附硬核面试点脑图）');
INSERT INTO `fav_link` VALUES (29, 'friend', 'HMISTER', 'https://blog.hmister.net/', NULL, 2, '_blank', 0, NULL, NULL, NULL, NULL, '不想你惊艳我年少时光 只愿你暖我今后岁月');
INSERT INTO `fav_link` VALUES (30, 'editor', 'Cron表达式', '/cron', NULL, 6, '_self', 7, NULL, NULL, NULL, NULL, 'Crontab计划任务表达式在线生成');
INSERT INTO `fav_link` VALUES (34, 'helper', 'CrxDL', 'https://crxdl.com/', NULL, 11, '_blank', 0, NULL, NULL, NULL, NULL, '下载Chrome扩展插件Crx离线安装包');
INSERT INTO `fav_link` VALUES (35, 'helper', 'SSL/TLS安全评估', 'https://myssl.com/', NULL, 9, '_blank', 0, NULL, NULL, NULL, NULL, '您部署的HTTPS网站安全吗');
INSERT INTO `fav_link` VALUES (36, 'blog', 'Javadoop', 'https://javadoop.com/', NULL, 11, '_blank', 0, NULL, NULL, NULL, NULL, '来自魔都的程序员，在互联网摸爬滚打了很多年');
INSERT INTO `fav_link` VALUES (38, 'blog', '凤凰架构', 'http://icyfenix.cn/', NULL, 8, '_blank', 0, NULL, NULL, NULL, NULL, '构建可靠的大型分布式系统');
INSERT INTO `fav_link` VALUES (39, 'editor', 'Diagram', 'https://app.diagrams.net/', NULL, 8, '_blank', 1, NULL, NULL, NULL, NULL, '图表软件和流程图制作工具');
INSERT INTO `fav_link` VALUES (41, 'helper', '程序员做饭指南', 'https://cook.aiurs.co/', NULL, 10, '_blank', 4, NULL, NULL, NULL, NULL, '程序员在家做饭方法指南');
INSERT INTO `fav_link` VALUES (42, 'blog', 'SpringForAll社区', 'http://spring4all.com/', NULL, 12, '_blank', 0, NULL, NULL, NULL, NULL, '专注服务Java和Spring开发者的技术社区');
INSERT INTO `fav_link` VALUES (43, 'blog', 'JavaGuide', 'https://javaguide.cn/', NULL, 9, '_blank', 0, NULL, NULL, NULL, NULL, '一份涵盖大部分 Java 程序员所需要掌握的核心知识');
INSERT INTO `fav_link` VALUES (46, 'document', 'Java规范', 'https://docs.oracle.com/javase/specs/index.html', '', 0, '_blank', 0, NULL, NULL, NULL, NULL, 'Java语言和虚拟机规范');
INSERT INTO `fav_link` VALUES (47, 'document', 'Arthas文档', 'https://arthas.aliyun.com/doc/quick-start.html', NULL, 10, '_blank', 0, NULL, NULL, NULL, NULL, 'Arthas 是Alibaba开源的Java诊断工具，深受开发者喜爱');
INSERT INTO `fav_link` VALUES (48, 'blog', '并发编程网', 'http://ifeve.com/', NULL, 6, '_blank', 3, NULL, NULL, NULL, NULL, '让天下没有难学的技术');
INSERT INTO `fav_link` VALUES (49, 'blog', 'Java进阶知识', 'https://doocs.github.io/advanced-java/#/', '', 10, '_blank', 0, NULL, NULL, NULL, NULL, '内容涵盖高并发、分布式、高可用、微服务、海量数据处理等');
INSERT INTO `fav_link` VALUES (50, 'editor', 'Unix时间戳', '/unix', NULL, 7, '_self', 2, NULL, NULL, NULL, NULL, 'Unix时间戳在线转换工具');
INSERT INTO `fav_link` VALUES (51, 'helper', 'Unicode字符百科', 'https://unicode-table.com/cn/', NULL, 8, '_blank', 0, NULL, NULL, NULL, NULL, 'Unicode(万国码、国际码、统一码) 字符搜索Web服务 ');
INSERT INTO `fav_link` VALUES (52, 'helper', 'SVG文件处理', 'https://svgtopng.com/zh/', NULL, 12, '_blank', 0, NULL, NULL, NULL, NULL, '软件允许您将SVG文档转换成PNG文档。');
INSERT INTO `fav_link` VALUES (53, 'document', 'OI Wiki', 'https://oi-wiki.org/', NULL, 9, '_blank', 1, NULL, NULL, NULL, NULL, '一个免费开放且持续更新的编程竞赛知识整合站点');
INSERT INTO `fav_link` VALUES (54, 'helper', 'Respeed Download', 'https://respeed.chromiumer.com/', NULL, 13, '_blank', 0, NULL, NULL, NULL, NULL, '主要用于文件下载加速（国内资源下载可能会更慢）');
INSERT INTO `fav_link` VALUES (55, 'blog', 'Java全栈知识体系', 'https://pdai.tech/', NULL, 4, '_blank', 2, NULL, NULL, NULL, NULL, '包含: Java, Spring, 数据库原理, 分布式, 中间件, 开发工具等');
INSERT INTO `fav_link` VALUES (56, 'blog', 'Java项目《谷粒商城》', 'https://www.bilibili.com/video/BV1np4y1C7Yf', NULL, 14, '_blank', 0, NULL, NULL, NULL, NULL, '微服务+分布式+全栈+集群+部署+自动化运维+可视化CICD');
INSERT INTO `fav_link` VALUES (57, 'blog', '编程帮', 'http://www.biancheng.net/', NULL, 15, '_blank', 0, NULL, NULL, NULL, NULL, '一个在线学习编程的网站，专注于分享优质编程教程');
INSERT INTO `fav_link` VALUES (58, 'document', 'Redis 命令参考', 'http://doc.redisfans.com/', NULL, 11, '_blank', 0, NULL, NULL, NULL, NULL, '本文档是 Redis Command Reference 和 Redis Documentation 的中文翻译版');
INSERT INTO `fav_link` VALUES (59, 'helper', '代码在线高亮工具', 'https://highlightcode.com/', NULL, 14, '_blank', 0, NULL, NULL, NULL, NULL, '将高亮美化的代码一键粘贴到Word或OneNote中。');
INSERT INTO `fav_link` VALUES (60, 'helper', '高清应用图标下载', 'https://icon.jiejingku.net/', NULL, 15, '_blank', 0, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for fav_tag
-- ----------------------------
DROP TABLE IF EXISTS `fav_tag`;
CREATE TABLE `fav_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名称',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_article_id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章标签表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fav_tag
-- ----------------------------
INSERT INTO `fav_tag` VALUES (1, '数据结构与算法', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (2, '书籍推荐', NULL, NULL, 'admin', '2022-11-19 17:00:49', NULL);
INSERT INTO `fav_tag` VALUES (3, '设计模式', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (4, 'Docker', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (5, 'Dubbo', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (6, '功能设计', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (7, 'Git', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (8, '面试资料\r\n', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (9, 'Java', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (10, 'Java虚拟机', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (11, 'Linux', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (12, '微服务治理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (13, 'MongoDB', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (14, '消息队列', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (15, 'MySQL', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (16, '计算机网络', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (17, '项目管理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (18, 'RabbitMQ', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (19, 'Redis', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (20, 'Spring', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (21, '学习方法', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (22, '测试技术', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (23, '工具使用', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (24, 'Vue.js', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (25, '前端组件', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (26, '架构知识', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `fav_tag` VALUES (27, '开源项目', NULL, NULL, NULL, NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of gen_table
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------

-- ----------------------------
-- Table structure for note_catalog
-- ----------------------------
DROP TABLE IF EXISTS `note_catalog`;
CREATE TABLE `note_catalog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父级ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `rank` int(11) NULL DEFAULT NULL COMMENT '排序',
  `delete_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记目录表' ROW_FORMAT = Dynamic;

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
  `delete_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_catalog_idx`(`catalog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记内容表' ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 235 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '笔记历史表' ROW_FORMAT = DYNAMIC;

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
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2022-04-22 09:21:16', 'admin', '2022-11-19 16:50:32', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2022-04-22 09:21:16', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2022-04-22 09:21:16', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES (4, '账号自助-验证码开关', 'sys.account.captchaOnOff', 'true', 'Y', 'admin', '2022-04-22 09:21:16', '', NULL, '是否开启验证码功能（true开启，false关闭）');
INSERT INTO `sys_config` VALUES (5, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2022-04-22 09:21:16', 'admin', '2022-10-30 20:39:39', '是否开启注册用户功能（true开启，false关闭）');

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
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, 0, '0', 'X-Hub', 0, '', '', '', '0', '0', 'admin', '2022-04-22 09:21:16', 'admin', '2022-04-27 23:27:01', NULL);
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '技术部门', 1, NULL, NULL, NULL, '0', '0', 'admin', '2022-04-27 23:29:21', 'admin', '2022-11-19 16:49:39', NULL);
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '市场部门', 2, NULL, NULL, NULL, '0', '0', 'admin', '2022-04-27 23:29:29', '', NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 156 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典数据表' ROW_FORMAT = DYNAMIC;

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
INSERT INTO `sys_dict_data` VALUES (131, 0, '博客园', 'cnblogs', 'fav_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:29:45', 'https://www.devzyh.cn/file/icon/cnblogs.png');
INSERT INTO `sys_dict_data` VALUES (132, 0, 'CSDN博客', 'csdn', 'fav_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:29:57', 'https://www.devzyh.cn/file/icon/csdn.png');
INSERT INTO `sys_dict_data` VALUES (133, 0, '直接链接', 'direct', 'fav_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:30:05', 'https://www.devzyh.cn/file/icon/link.png');
INSERT INTO `sys_dict_data` VALUES (134, 0, '简书', 'jianshu', 'fav_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:30:12', 'https://www.devzyh.cn/file/icon/jianshu.png');
INSERT INTO `sys_dict_data` VALUES (135, 0, '开源中国', 'oschina', 'fav_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:30:20', 'https://www.devzyh.cn/file/icon/oschina.png');
INSERT INTO `sys_dict_data` VALUES (136, 0, '微信公众号', 'wxmp', 'fav_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:30:27', 'https://www.devzyh.cn/file/icon/weixin.png');
INSERT INTO `sys_dict_data` VALUES (137, 0, '知乎', 'zhihu', 'fav_article_source', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:30:33', 'https://www.devzyh.cn/file/icon/zhihu.png');
INSERT INTO `sys_dict_data` VALUES (145, 3, '技术博客', 'blog', 'fav_link_item', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:21:17', 'https://cdn.icon-icons.com/icons2/1945/PNG/512/iconfinder-blog-4661578_122455.png');
INSERT INTO `sys_dict_data` VALUES (146, 2, '文档连接', 'document', 'fav_link_item', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:21:03', 'https://cdn.icon-icons.com/icons2/827/PNG/512/document_icon-icons.com_66534.png');
INSERT INTO `sys_dict_data` VALUES (147, 0, '数据编辑', 'editor', 'fav_link_item', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:20:25', 'https://cdn.icon-icons.com/icons2/841/PNG/512/circle-edit-line_icon-icons.com_66940.png');
INSERT INTO `sys_dict_data` VALUES (148, 4, '友情链接', 'friend', 'fav_link_item', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:21:39', 'https://cdn.icon-icons.com/icons2/70/PNG/512/social_fb_facebook_14206.png');
INSERT INTO `sys_dict_data` VALUES (149, 1, '辅助工具', 'helper', 'fav_link_item', NULL, 'default', 'N', '0', 'admin', '2022-04-26 14:43:14', 'admin', '2022-10-10 12:20:29', 'https://cdn.icon-icons.com/icons2/812/PNG/512/social_facebook_messenger_icon-icons.com_66150.png');
INSERT INTO `sys_dict_data` VALUES (150, 0, '当前页面', '_self', 'web_open_type', NULL, 'default', 'N', '0', 'admin', '2022-05-08 22:50:40', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (151, 1, '新标签页', '_blank', 'web_open_type', NULL, 'default', 'N', '0', 'admin', '2022-05-08 22:50:53', 'admin', '2022-05-08 22:54:22', NULL);
INSERT INTO `sys_dict_data` VALUES (155, 0, '稀土掘金', 'juejin', 'fav_article_source', NULL, 'default', 'N', '0', 'admin', '2022-10-12 11:11:30', 'admin', '2022-10-12 11:11:46', 'https://www.devzyh.cn/file/icon/juejin.png');

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
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2022-04-22 09:21:16', 'admin', '2022-10-30 20:39:26', '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2022-04-22 09:21:16', 'admin', '2022-11-19 16:50:10', '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '登录状态列表');
INSERT INTO `sys_dict_type` VALUES (100, '站点基本信息', 'web_site_info', '0', 'admin', '2022-04-26 14:41:01', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (102, '文章来源平台', 'fav_article_source', '0', 'admin', '2022-04-26 14:41:45', 'admin', '2022-10-10 12:00:55', NULL);
INSERT INTO `sys_dict_type` VALUES (104, '链接分组信息', 'fav_link_item', '0', 'admin', '2022-04-26 14:42:23', 'admin', '2022-10-10 12:23:32', NULL);
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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, '测试系统默认（无参）', 'DEFAULT', 'testTask.testNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2022-04-22 09:21:16', 'admin', '2022-09-02 17:26:23', '');
INSERT INTO `sys_job` VALUES (2, '测试系统默认（有参）', 'DEFAULT', 'testTask.testParams(\'test\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2022-04-22 09:21:16', 'admin', '2022-09-02 17:26:43', '');
INSERT INTO `sys_job` VALUES (3, '测试系统默认（多参）', 'DEFAULT', 'testTask.testMultipleParams(\'test\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2022-04-22 09:21:16', 'admin', '2022-11-19 16:57:59', '');
INSERT INTO `sys_job` VALUES (4, '首页链接访问量落库', 'DEFAULT', 'webTask.linkVisitsToDb', '0 0 3 * * ?', '1', '1', '0', 'admin', '2022-09-02 17:23:38', 'admin', '2022-10-30 20:40:43', '');

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
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log`  (
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
-- Records of sys_login_log
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
) ENGINE = InnoDB AUTO_INCREMENT = 2041 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = DYNAMIC;

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
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2022-04-22 09:21:16', 'admin', '2022-10-30 20:38:46', '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2022-04-22 09:21:16', '', NULL, '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2022-04-22 09:21:16', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', '2022-04-22 09:21:16', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2022-04-22 09:21:16', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', '', 1, 0, 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2022-04-22 09:21:16', 'admin', '2022-05-08 15:00:45', '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, '数据监控', 2, 3, 'druid', 'monitor/druid/index', '', 1, 0, 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin', '2022-04-22 09:21:16', '', NULL, '数据监控菜单');
INSERT INTO `sys_menu` VALUES (112, '服务监控', 2, 4, 'server', 'monitor/server/index', '', 1, 0, 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2022-04-22 09:21:16', '', NULL, '服务监控菜单');
INSERT INTO `sys_menu` VALUES (113, '缓存监控', 2, 5, 'cache', 'monitor/cache/index', '', 1, 0, 'C', '0', '0', 'monitor:cache:list', 'redis', 'admin', '2022-04-22 09:21:16', '', NULL, '缓存监控菜单');
INSERT INTO `sys_menu` VALUES (115, '代码生成', 3, 1, 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2022-04-22 09:21:16', 'admin', '2022-05-08 15:00:54', '代码生成菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'oper', 'system/log/oper', '', 1, 0, 'C', '0', '0', 'system:log:oper:list', 'form', 'admin', '2022-04-22 09:21:16', 'admin', '2022-11-19 16:28:31', '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'login', 'system/log/login', '', 1, 0, 'C', '0', '0', 'system:log:login:list', 'logininfor', 'admin', '2022-04-22 09:21:16', 'admin', '2022-10-30 20:54:12', '登录日志菜单');
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
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:log:oper:query', '#', 'admin', '2022-04-22 09:21:16', 'admin', '2022-11-19 16:28:48', '');
INSERT INTO `sys_menu` VALUES (1041, '操作删除', 500, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:log:oper:remove', '#', 'admin', '2022-04-22 09:21:16', 'admin', '2022-11-19 16:28:54', '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:log:oper:export', '#', 'admin', '2022-04-22 09:21:16', 'admin', '2022-11-19 16:28:59', '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:log:login:query', '#', 'admin', '2022-04-22 09:21:16', 'admin', '2022-10-30 20:54:24', '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:log:login:remove', '#', 'admin', '2022-04-22 09:21:16', 'admin', '2022-10-30 20:54:32', '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:log:login:export', '#', 'admin', '2022-04-22 09:21:16', 'admin', '2022-10-30 20:54:46', '');
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
INSERT INTO `sys_menu` VALUES (2022, '编辑内容', 2019, 2, 'editor/:id', 'notebook/bytemd/index', NULL, 1, 0, 'C', '1', '0', 'notebook:editor', 'edit', 'admin', '2022-05-21 19:15:11', 'admin', '2022-10-09 09:47:54', '');
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
INSERT INTO `sys_menu` VALUES (2040, '文章标签', 2000, 3, 'tag', 'favorite/tag/index', NULL, 1, 0, 'C', '0', '0', 'fav:tag:list', 'example', 'admin', '2022-10-08 22:24:20', 'admin', '2022-10-09 12:05:31', '');

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
INSERT INTO `sys_post` VALUES (1, 'mgr', '经理', 1, '0', 'admin', '2022-04-22 09:21:16', 'admin', '2022-11-19 16:49:48', '');
INSERT INTO `sys_post` VALUES (2, 'emp', '员工', 2, '0', 'admin', '2022-04-22 09:21:16', 'admin', '2022-10-30 20:38:59', '');

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '系统管理', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2022-04-22 09:21:16', '', NULL, '系统管理');
INSERT INTO `sys_role` VALUES (2, '普通用户', 'common', 2, '2', 1, 1, '0', '0', 'admin', '2022-04-22 09:21:16', 'admin', '2022-10-30 23:29:09', '普通角色');

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
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 101, 'admin', 'ADMIN', '00', 'devzyh@foxmail.com', '18888888888', '0', 'https://www.devzyh.cn/file/avatar/2022/11/08/20221108224430A003.jpeg', '$2a$10$3ah3lFMFkLOThQbzdQbx7.DVukZvITR9aG9OPA4Qv.k3OfmAfkTkG', '0', '0', '171.83.116.110', '2022-11-19 19:13:43', 'admin', '2022-04-22 09:21:16', 'system', '2022-11-19 19:13:43', '系统管理');

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
