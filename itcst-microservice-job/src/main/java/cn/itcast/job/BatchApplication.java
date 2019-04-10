package cn.itcast.job;

import java.util.Date;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
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
        String jobName = "messageMigrationJob";

        JobRegistry jobRegistry = context.getBean(JobRegistry.class);
        Job job = jobRegistry.getJob(jobName);
        if(job == null){ return;}
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        JobExecution jobExecution = jobLauncher.run(job, createJobParams());
        if (!jobExecution.getExitStatus().equals(ExitStatus.COMPLETED)) {
            throw new RuntimeException(format("%s Job execution failed.", jobName));
        }
    }
    
    public static ConfigurableApplicationContext getContext(){
        return context;
    }

    private static String format(String string, Object jobName)
    {
        return string.replace("%s", jobName.toString());
    }

    private static JobParameters createJobParams() {
        return new JobParametersBuilder().addDate("date", new Date()).toJobParameters();
    }
}
