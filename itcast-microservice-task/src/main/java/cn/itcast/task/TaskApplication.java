package cn.itcast.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import cn.itcast.task.listener.TaskListener;

@EnableTask
@EnableBatchProcessing
@EnableScheduling
@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
public class TaskApplication
{
    private final static Logger LOGGER = LoggerFactory.getLogger(TaskApplication.class);
    public static void main(String[] args){
        SpringApplication.run(TaskApplication.class,args);
    }
    
    @Bean
    public TaskListener taskListener() {
        return new TaskListener();
    }
    
    @Bean
    public CommandLineRunner commandLineRunner() {
        return new HelloWorldCommandLineRunner();
    }
    public static class HelloWorldCommandLineRunner implements CommandLineRunner {

        @Override
        public void run(String... strings) throws Exception {
            LOGGER.info("Hello, World!");
        }
    }
}
