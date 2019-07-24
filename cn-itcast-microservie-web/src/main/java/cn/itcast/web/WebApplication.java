package cn.itcast.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude={    
        JpaRepositoriesAutoConfiguration.class ,HibernateJpaAutoConfiguration.class//禁止springboot自动加载持久化bean  
          })
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages={"cn.itcast.web"})
public class WebApplication extends SpringBootServletInitializer
{
    private static final Logger log = LoggerFactory.getLogger(WebApplication.class);
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }
        
    public static  void main(String[] args){
        SpringApplication.run(WebApplication.class,args);
    }
}
