package gr.codelearn.showcase.restaurant.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {
	@Bean
	public CommonsRequestLoggingFilter logFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludeHeaders(true);
		filter.setHeaderPredicate(header -> header.startsWith("t-"));
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(8192);
		return filter;
	}
}