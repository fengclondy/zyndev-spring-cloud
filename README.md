#zyndev-spring-cloud
学习 spring-cloud

### 主要内容：

1. Spring Boot 初体验
    1. Spring 基础知识回顾
    1. Spring bean的配置
    1. 使用 Idea 创建Spring Boot 项目

1. 服务治理：Spring Cloud Eureka

1. 负载均衡：Spring Cloud Ribbon

1. 容错机制：Spring Cloud Hystrix

1. 服务调用：Spring Cloud Feign

1. API网管：Spring Cloud Zuul

1. 配置中心：Spring Cloud Config


### 端口占用

以下配置中，为了测试和开发方便，提供了单机配置 `singleton`,当使用 `singleton` 不需要在开启同项目下的其他配置

> 采用高可用模式，使用两个 Eureka Server 相互注册`spring-boot-eureka-server`

- server1 : 8081
- server2 : 8082
— singleton : 8081

> 服务提供者 `spring-boot-eureka-client`

- 8083
- 8084
- singleton : 8083


> 服务消费者 

- 8085
- 8086
- singleton : 8085




