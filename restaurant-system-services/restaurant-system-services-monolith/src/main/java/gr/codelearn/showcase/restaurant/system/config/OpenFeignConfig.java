package gr.codelearn.showcase.restaurant.system.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"gr.codelearn.showcase.restaurant.system.api.client"})
public class OpenFeignConfig {
}
