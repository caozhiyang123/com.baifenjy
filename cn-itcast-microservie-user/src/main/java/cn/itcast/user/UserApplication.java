package cn.itcast.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//
@EnableAutoConfiguration(exclude={    
        JpaRepositoriesAutoConfiguration.class //禁止springboot自动加载持久化bean  
          })
@EnableJpaRepositories(basePackages={"cn.itcast.user.repository"})
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages={"cn.itcast.user"})
public class UserApplication
{
    private static final Logger log = LoggerFactory.getLogger(UserApplication.class);
    
    public static  void main(String[] args){
        SpringApplication.run(UserApplication.class,args);
    }
}
