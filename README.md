# Ssm
搭建Jakarta EE集合框架：Spring+SpringMVC+Mybatis框架

# 项目结构
Java Resources源码包：
- src
	- com.mazaiting
		- controller 控制器包
		- mapper     数据库dao包，存放Mapper接口文件及Mapper.xml文件
		- pojo		 存放Java Bean文件
		- service    存放Service接口文件
			- imple  存放Service接口的实现类文件
- config
	- mybaits
		SqlMapConfig.xml 在这个xml文件里面对Java Bean文件配置别名
	- spring
		applicationContext-dao.xml DAO层数据库配置
		applicationContext-service.xml Service层服务配置
		applicationContext-trans.xml DAO层事务配置
		springmvc.xml 	SpringMVC的web配置
	db.properties       数据库信息配置，自己的数据库配置在这里更改
	log4j.properties    日志信息配置
- test
	- com.mazaiting
		- mapper    测试数据库包
		- service   测试服务包

- WebContent包
	- css	CSS3样式文件
	- image 图片资源文件
	- js    JavaScript文件
	- jsp   Jsp文件
	- lib   第三方jar包
	web.xml Web工程的配置文件

