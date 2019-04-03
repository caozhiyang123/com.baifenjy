package cn.itcast.task.runner;

import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

	@BeforeTask
	public void methodA(TaskExecution taskExecution) {
	}

	@AfterTask
	public void methodB(TaskExecution taskExecution) {
	    taskExecution.setExitMessage("AFTER EXIT MESSAGE");
	}

	@FailedTask
	public void methodC(TaskExecution taskExecution, Throwable throwable) {
	}
}