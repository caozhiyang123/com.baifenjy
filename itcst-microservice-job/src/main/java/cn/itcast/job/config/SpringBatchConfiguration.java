package cn.itcast.job.config;

import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBatchConfiguration {
    
    @Bean
    public ApplicationContextFactory messageMigrationJobContext() {
        return new GenericApplicationContextFactory(MessageMigrationJobConfiguration.class);
    }
    
}