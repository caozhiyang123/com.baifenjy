package cn.itcast.job;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAutoConfiguration
@EnableBatchProcessing(modular = true)
@ComponentScan(basePackages={"cn.itcast.job"})
@EnableJpaRepositories(basePackages={"cn.itcast.job.pojo"})
@EnableEurekaClient
@SpringBootApplication
public class BatchApplication
{
    private static ConfigurableApplicationContext context;
    
    public static void main(String[] args) throws Exception {
        context = SpringApplication.run(BatchApplication.class, args);
    }
    
    public static ConfigurableApplicationContext getContext(){
        return context;
    }
}
