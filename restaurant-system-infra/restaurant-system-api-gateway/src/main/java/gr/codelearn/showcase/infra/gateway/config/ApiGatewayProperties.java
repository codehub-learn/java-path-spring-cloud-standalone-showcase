package gr.codelearn.showcase.infra.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Getter
@Setter
@RefreshScope
@ConfigurationProperties(prefix = "api.gateway.rate-limit")
public class ApiGatewayProperties {
	private Integer replenishRate;
	private Integer burstCapacity;

}