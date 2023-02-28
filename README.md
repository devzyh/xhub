## 平台简介

* 基于 [RuoYi-Vue](https://doc.ruoyi.vip/ruoyi-vue) 框架开发的软件工具箱。
* 前端采用Vue3、Element Plus、Vite。
* 后端采用Spring Boot、Spring Security、MyBatis Plus、Redis、MySQL。
* 权限认证使用JWT，支持多终端认证系统。
* 支持加载动态权限菜单，多方式轻松权限控制。
* 高效率开发，使用代码生成器可以一键生成前后端代码。

## 代码运行

1. xhub-app模块为代码运行的入口，主要配置文件均放置在xhub-app项目下。
2. Maven完成依赖的刷新后，复制app下的配置`application-example.yml`建立自己的配置文件，并在运行时指定`profile`参数。
3. 后端默认运行端口8888，前端默认运行端口80。
4. 数据库初始文件在app模块下的db资源文件夹内。
5. xhub-admin文件夹下为前端代码。
6. xhub-web为系统前端界面的模板渲染模块。
7. xhub-scheduler为定时任务执行系统功能的入口。

## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10.  登录日志：系统登录日志记录查询包含登录异常。
11.  在线用户：当前系统中活跃用户状态监控。
12.  定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13.  代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14.  服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
15.  缓存监控：对系统的缓存信息查询，命令统计等。
16.  连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

## 默认账号

* 前端登录：admin/123456
* 数据库连接池：druid/druid

## 系统功能
* 前台模块
![home.png](https://file.devzyh.cn/upload/2023/01/17/20230117193317A008.png "home.png")

* 云笔记模块
![note.png](https://file.devzyh.cn/upload/2023/01/17/20230117193223A006.png "note.png")

* 收藏夹模块
![fav.png](https://file.devzyh.cn/upload/2023/01/17/20230117193223A004.png "fav.png")