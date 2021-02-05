package schedulertasks.scheduler.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling	
public class SchedulerTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerTasksApplication.class, args);
	}

}
