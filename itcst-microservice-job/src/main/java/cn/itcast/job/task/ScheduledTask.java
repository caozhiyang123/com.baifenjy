package cn.itcast.job.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask
{
    private final ThreadLocal<AtomicInteger> local = new ThreadLocal<AtomicInteger>(){
        @Override
        protected AtomicInteger initialValue() {
            return new AtomicInteger(0);
        };
    };
    
    @Scheduled(fixedRate = 5000)
    public void testFixRate() {
        int count = local.get().addAndGet(1);
        if(count == 10){ System.exit(0);}
        System.out.println("每隔5秒执行一次：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
    
    public void executeTask(){
        
    }
}
