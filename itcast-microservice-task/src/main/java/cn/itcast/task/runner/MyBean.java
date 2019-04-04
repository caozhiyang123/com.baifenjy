package cn.itcast.task.runner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

	@BeforeTask
	public void methodA(TaskExecution taskExecution) {
	    System.out.println(taskExecution.getExecutionId());
	    taskExecution.setStartTime(new Date());
	    taskExecution.setTaskName("test");
	}

	@AfterTask
	public void methodB(TaskExecution taskExecution) {
	    taskExecution.setExitMessage("AFTER EXIT MESSAGE");
	    taskExecution.setExitCode(123456);
	    taskExecution.setEndTime(new Date());
	    List<String> params = new ArrayList<String>();
	    params.add("a");
	    params.add("b");
	    params.add("c");
	    taskExecution.setArguments(params);
	}

	@FailedTask
	public void methodC(TaskExecution taskExecution, Throwable throwable) {
	    taskExecution.setErrorMessage("task stoped");
	}
}