package cn.itcast.task.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JobConfiguration
{
    private final static Logger LOGGER = LoggerFactory.getLogger(JobConfiguration.class);
    
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    
    @Bean
    public Job job2() {
    	return jobBuilderFactory.get("job2").start(stepBuilderFactory.get("job2step1").tasklet(new Tasklet() {
    		@Override
    		public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
    			LOGGER.info("This job is from PeterWanghao");
    			return RepeatStatus.FINISHED;
    		}
    	}).build()).build();
    }
    
    
}

