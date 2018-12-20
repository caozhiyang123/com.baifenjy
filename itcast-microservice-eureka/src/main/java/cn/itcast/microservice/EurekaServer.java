package cn.itcast.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by czy on 2018-03-19.
 */

@EnableEurekaServer //申明这是一个Eureka服务
@SpringBootApplication
public class EurekaServer {
    public static void main(String[] args){
        SpringApplication.run(EurekaServer.class,args);
    }
}
