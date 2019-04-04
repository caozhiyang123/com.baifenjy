package cn.itcast.task.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

public class TaskListener implements TaskExecutionListener
{
    Logger logger = LoggerFactory.getLogger(TaskListener.class);

    @Override
    public void onTaskEnd(TaskExecution arg0)
    {
        logger.info("on task end");
    }

    @Override
    public void onTaskFailed(TaskExecution arg0, Throwable arg1)
    {
        logger.info("on task faild");
    }

    @Override
    public void onTaskStartup(TaskExecution arg0)
    {
        logger.info("on task start");
    }

}
