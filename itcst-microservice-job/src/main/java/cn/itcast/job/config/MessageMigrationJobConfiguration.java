package cn.itcast.job.config;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.Writer;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

import com.fasterxml.jackson.core.JsonParseException;

import cn.itcast.job.mapper.MessageLineMapper;
import cn.itcast.job.pojo.Message;


public class MessageMigrationJobConfiguration {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	private static final int CHUNK_SIZE = 50; 
	private static final int SKIP_LIMIT = 20;
	private static final int RETRY_LIMIT = 10;
	
	private static final String MESSAGE_FILE = "D://tools3/workSpace/itcast-microservice2-master/itcast-microservice2-master"
	        + "/itcst-microservice-job/src/main/resources/config/readme.txt";
	
	@Bean
	public Job messageMigrationJob(@Qualifier("messageMigrationStep") Step messageMigrationStep) {
		return jobBuilderFactory.get("messageMigrationJob")
				.start(messageMigrationStep)
				.build();
	}
	
	@Bean
	public Step messageMigrationStep(@Qualifier("jsonMessageReader") FlatFileItemReader<Message> jsonMessageReader,
	                                 @Qualifier("messageItemWriter") JpaItemWriter<Message> messageItemWriter,
	                                 @Qualifier("errorWriter") Writer errorWriter) {
	    return stepBuilderFactory.get("messageMigrationStep")
	            .<Message, Message>chunk(CHUNK_SIZE)
	            .reader(jsonMessageReader).faultTolerant().skip(JsonParseException.class).skipLimit(SKIP_LIMIT)
	            .retry(JsonParseException.class).retryLimit(RETRY_LIMIT)
	            .listener(new MessageItemReadListener(errorWriter))
	            .writer(messageItemWriter).faultTolerant().skip(Exception.class).skipLimit(SKIP_LIMIT)
	            .retry(Exception.class).retryLimit(RETRY_LIMIT)
	            .listener(new MessageWriteListener())
	            .build();
	}
	
	@Bean
	public FlatFileItemReader<Message> jsonMessageReader() {
	    FlatFileItemReader<Message> reader = new FlatFileItemReader<Message>();
	    reader.setResource(new FileSystemResource(new File(MESSAGE_FILE)));
	    reader.setLineMapper(new MessageLineMapper());
	    return reader;
	}
	
	@Autowired
	private EntityManagerFactory entityManager;

	@Bean
	public JpaItemWriter<Message> messageItemWriter() {
	    JpaItemWriter<Message> writer = new JpaItemWriter<Message>();
	    writer.setEntityManagerFactory(entityManager);
	    return writer;
	}
	
	@Bean
	public Writer errorWriter(){
	    return new CharArrayWriter();
	}
}