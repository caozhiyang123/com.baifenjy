package cn.itcast.microservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * 链接Mysql数据库,通过JpaRepository编写数据库访问。
 * Created by czy on 2018-03-31.
 */

@EnableAutoConfiguration(exclude={    
        JpaRepositoriesAutoConfiguration.class //禁止springboot自动加载持久化bean  
          })
@EnableJpaRepositories(basePackages={"cn.itcast.microservice.repository"})
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages={"cn.itcast.microservice"})
public class JdbcApplication {
    private static final Logger log = LoggerFactory.getLogger(JdbcApplication.class);
    
    public static  void main(String[] args){
        SpringApplication.run(JdbcApplication.class,args);
    }
}
