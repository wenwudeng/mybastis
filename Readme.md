# mybatis使用笔记
## 1.基础
- 入门：  
   1.创建数据库  
   2.创建表并插入数据  
   3.在src目录下新建mybatis-config.xml文件并编写相关配置  
   4.新建并配置Category.xml  
   5.运行测试类

- CRUD  
   1.在Category.xml文件中编写crud数据库查询语句  
   2.运行测试类
   
- 更多查询  
   1.模糊查询  
   2.多条件查询
- 一对多 
- 多对一
- 多对多

## 2.动态SQL
- if
- where
- set-在使用update的时候用  
- trim-用于自定义标签
- when-otherwise
- foreach
- bind
## 3.注解  
- 注意：使用注解时，在mybatis-config.xml中声明Mapper类的位置时用*class*；声明路径用.而不是/
   非注解时使用*resource*进行声明，路径用/
- CRUD
- 一对多
- 多对一
- 多对多
- 动态SQL语句
## 4.相关概念
- 日志
- 事务管理
- 延迟加载
- 分页
- PageHelper
- 一级缓存
- 二级缓存
- c3p0连接池
- 查询总数
- 逆向工程
