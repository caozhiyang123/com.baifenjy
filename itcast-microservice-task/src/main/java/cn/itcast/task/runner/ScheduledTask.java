package cn.itcast.task.runner;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask
{

    @Scheduled(fixedRate = 5000)
    public void testFixRate() {
        System.out.println("每隔5秒执行一次：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
