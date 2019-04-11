package cn.itcast.job.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.itcast.job.BatchApplication;

@Component
public class ScheduledTask
{
    private final ThreadLocal<AtomicInteger> local = new ThreadLocal<AtomicInteger>(){
        @Override
        protected AtomicInteger initialValue() {
            return new AtomicInteger(0);
        };
    };
    
    @Scheduled(initialDelay=3000,fixedRate = 5000)
    public void testFixRate() {
        int count = local.get().addAndGet(1);
        executeTask();
        if(count == 10){ System.exit(0);}
        System.out.println("每隔5秒执行一次：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
    
    public void executeTask() {
        try
        {
            ConfigurableApplicationContext context = BatchApplication.getContext();
            String jobName = "messageMigrationJob";
            JobRegistry jobRegistry = context.getBean(JobRegistry.class);
            Job job = jobRegistry.getJob(jobName);
            if(job == null){ return;}
            JobLauncher jobLauncher = context.getBean(JobLauncher.class);
            JobExecution jobExecution = jobLauncher.run(job, createJobParams());
            if (!jobExecution.getExitStatus().equals(ExitStatus.COMPLETED)) {
                throw new RuntimeException(format("%s Job execution failed.", jobName));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private static String format(String string, Object jobName)
    {
        return string.replace("%s", jobName.toString());
    }

    private static JobParameters createJobParams() {
        return new JobParametersBuilder().addDate("date", new Date()).toJobParameters();
    }
}
