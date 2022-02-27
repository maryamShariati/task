package ir.chica.task;

import ir.chica.task.config.AspectConfig.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TaskApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	}

}
