package gr.codelearn.showcase.restaurant.system.api.client;

import gr.codelearn.showcase.restaurant.commons.api.resource.NotificationResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification-service", url = "http://localhost:10000")
public interface NotificationServiceClient {
	@PostMapping("/api/notifications")
	void sendNotification(NotificationResource notificationResource);
}
