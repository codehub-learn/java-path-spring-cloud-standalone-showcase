package gr.codelearn.showcase.restaurant.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"gr.codelearn.showcase.restaurant"})
public class NotificationService {
	static void main(String[] args) {
		SpringApplication.run(NotificationService.class, args);
	}
}
