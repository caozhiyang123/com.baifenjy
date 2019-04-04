package cn.itcast.task.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class HelloWorldTaskConfigurer extends DefaultTaskConfigurer{
    
    public HelloWorldTaskConfigurer(DataSource dataSource){
        super(dataSource);
    }
    
    @Autowired
    private DataSource dataSource;
    
    @Bean
    public HelloWorldTaskConfigurer getTaskConfigurer() {
        return new HelloWorldTaskConfigurer(dataSource);
    }
}