package gr.codelearn.showcase.restaurant.notification.config;

import gr.codelearn.showcase.restaurant.notification.component.BaseComponent;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"gr.codelearn.showcase.restaurant.notification.repository"},
					   namedQueriesLocation = "classpath:jpa-named-queries.properties")
@EntityScan("gr.codelearn.showcase.restaurant.notification.domain")
@EnableTransactionManagement
public class DatabaseConfig extends BaseComponent {
}