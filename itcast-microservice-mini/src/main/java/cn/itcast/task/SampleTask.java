package cn.itcast.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@EnableTask
@ImportResource("classpath:applicationContext.xml")
@SpringBootApplication
public class SampleTask {

	@Bean
	public CommandLineRunner commandLineRunner() {
		return new HelloWorldCommandLineRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleTask.class, args);
	}

	public static class HelloWorldCommandLineRunner implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			System.out.println("Hello World!");
		}
	}
}