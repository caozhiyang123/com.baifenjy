package cn.itcast.microservice.item;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by czy on 2018-03-22.
 */
@ImportResource("classpath:applicationContext.xml")
@MapperScan(basePackages={"cn.itcast.microservice.item.mapper"})
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"cn.itcast.microservice.item"})
public class ItemApplication {
    public static void main(String[] args){
        SpringApplication.run(ItemApplication.class,args);
    }
}
