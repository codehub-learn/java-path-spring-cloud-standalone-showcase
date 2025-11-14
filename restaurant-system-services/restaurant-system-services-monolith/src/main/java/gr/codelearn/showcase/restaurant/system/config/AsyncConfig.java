package gr.codelearn.showcase.restaurant.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Configuration
@EnableAsync
public class AsyncConfig {
	@Bean(name = "taskExecutor")
	public Executor virtualThreadExecutor() {
		// Each task runs on a virtual thread — lightweight & scalable
		// Each task gets its own virtual thread, managed by the JVM (fibers).
		// Extremely lightweight (stack grows on demand, thousands of tasks → fine).
		// Blocking code is no longer expensive — when you block, the carrier thread is released.
		// No thread-pool tuning needed — you can fire thousands of concurrent operations safely.
		// Slight overhead when scheduling millions of very short tasks.
		// You lose explicit back-pressure (you can easily overwhelm an external system).
		//
		// Alternate approach
		//		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		//		executor.setCorePoolSize(1);
		//		executor.setMaxPoolSize(4);
		//		executor.setThreadNamePrefix("taskexec-");
		//		executor.initialize();
		//		return executor;
		ThreadFactory factory = Thread.ofVirtual().name("vthread-", 0).factory();
		return Executors.newThreadPerTaskExecutor(factory);
	}
}
