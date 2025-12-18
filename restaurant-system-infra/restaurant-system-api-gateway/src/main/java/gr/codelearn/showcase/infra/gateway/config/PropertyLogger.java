package gr.codelearn.showcase.infra.gateway.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PropertyLogger {
	private final Environment environment;
	private final ApiGatewayProperties apiGatewayProperties;

	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		log.info("ContextRefreshedEvent, replenish-rate: {}, burst-capacity: {}",
				 apiGatewayProperties.getReplenishRate(),
				 apiGatewayProperties.getBurstCapacity());
	}

	@EventListener
	public void handleRefreshScope(RefreshScopeRefreshedEvent event) {
		log.info("RefreshScopeRefreshedEvent, replenish-rate: {}, burst-capacity: {}",
				 apiGatewayProperties.getReplenishRate(),
				 apiGatewayProperties.getBurstCapacity());
	}

	@EventListener
	public void handleEnvChange(EnvironmentChangeEvent event) {
		log.info("EnvironmentChangeEvent, replenish-rate: {}, burst-capacity: {}",
				 environment.getProperty("api.gateway.rate-limit.replenish-rate"),
				 environment.getProperty("api.gateway.rate-limit.burst-capacity"));
	}
}