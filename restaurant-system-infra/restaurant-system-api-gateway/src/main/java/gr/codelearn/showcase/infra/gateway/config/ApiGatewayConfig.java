package gr.codelearn.showcase.infra.gateway.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:api-gateway.properties")
@EnableConfigurationProperties(ApiGatewayProperties.class)
public class ApiGatewayConfig {
}