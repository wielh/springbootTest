## SpringBoot 語法學習日誌

1. 簡介: 這是用來了解 spring boot 與 java 語法的練習的範例程式

2. spring boot Helloworld

    1. 訪問 Spring Initializr 网站：选择 Maven 或 Gradle 项目。添加依赖项：Spring Web。下载项目并解压到本地。

    2. 在 src/main/java/com/example/helloworld/HelloWorldApplication.java 編寫以下程式範例 :

    ```
        package com.example.helloworld;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        @SpringBootApplication
        public class HelloWorldApplication {

            public static void main(String[] args) {
                SpringApplication.run(HelloWorldApplication.class, args);
            }
        }

        @RestController
        @RequestMapping("/api")
        class HelloWorldController {

            @GetMapping("/hello")
            public String sayHello() {
                return "Hello, World!";
            }
        }

    ```

    3. 執行 : ./gradlew bootRun

3. 此專案用到的 SpringBoot 組件

    1. Spring Boot Starter
        + spring-boot-starter-web：用于构建 Web 应用，包括 RESTful API 和 MVC。
        + spring-boot-starter-data-jpa：用于整合 JPA（Java Persistence API）和 Hibernate。
        + spring-boot-starter-security：提供安全认证和授权功能。

    2. Spring Boot Auto-Configuration
        + 功能：自动配置，根据类路径下的依赖和 Bean 配置自动启用功能。
        + 自动注册 DataSource 配置。
        + 自动扫描 @Entity 和 JPA Repository。

    3. Spring Web MVC: 用于构建基于 Servlet 的 Web 应用。提供 @Controller 和 @RestController 支持。

    4. Spring Data
        提供数据访问的统一抽象。子模块包括：
        + Spring Data JPA：支持 ORM 框架。
        + Spring Data MongoDB：支持 MongoDB。
        + Spring Data Redis：支持 Redis。

    5. Spring JDBC: 传统 JDBC 数据访问的封装。

    6. 消息队列支持
       + Spring AMQP：支持 RabbitMQ。
       + Spring Kafka：支持 Kafka 消息队列。

    7. 安全
        + Spring Security：提供身份认证和授权功能。
        + Spring OAuth2：支持 OAuth2 协议。


4. 記得在作業系統裡安裝 protoc 與 protoc-gen-grpc-java



4. Reference

   1. https://medium.com/@heather_programming/spring-security-%E5%B8%B3%E8%99%9F%E5%AF%86%E7%A2%BC%E9%A9%97%E8%AD%89-98a4bfd03abe