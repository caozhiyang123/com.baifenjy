package cn.itcast.microservice.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by czy on 2018-03-22.
 */

//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class ItemApplication {
    public static void main(String[] args){
        SpringApplication.run(ItemApplication.class,args);
    }
}
