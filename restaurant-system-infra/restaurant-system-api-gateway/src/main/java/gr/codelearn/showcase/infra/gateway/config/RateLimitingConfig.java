package gr.codelearn.showcase.infra.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

import java.security.Principal;

@Configuration
public class RateLimitingConfig {
	@Primary
	@Bean
	public KeyResolver ipKeyResolver() {
		/*
		 * - Good for public APIs
		 * - Simple
		 * - NAT / proxies can skew results
		 */
		return exchange ->
				Mono.just(exchange.getRequest()
								  .getRemoteAddress()
								  .getAddress()
								  .getHostAddress()
						 );
	}

	@Bean
	public KeyResolver userKeyResolver() {
		/*
		 * - Best for authenticated APIs
		 * - Fair usage
		 * - Works perfectly with JWT
		 */
		return exchange ->
				exchange.getPrincipal()
						.map(Principal::getName)
						.defaultIfEmpty("anonymous");
	}

	@Bean
	public KeyResolver apiKeyResolver() {
		/*
		 * - Best for partners / SaaS APIs
		 * - Industry standard
		 */
		return exchange ->
				Mono.justOrEmpty(exchange.getRequest()
										 .getHeaders()
										 .getFirst("X-API-KEY"))
					.defaultIfEmpty("no-key");
	}

	@Bean
	public KeyResolver globalKeyResolver() {
		/*
		 *- Absolute traffic cap
		 * - Protects backend from overload
		 * - Ideal as a safety valve
		 */
		return exchange -> Mono.just("GLOBAL");
	}
}
