package gr.codelearn.showcase.restaurant.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"gr.codelearn.showcase.restaurant"})
public class RestaurantApplication {
	static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}
}
