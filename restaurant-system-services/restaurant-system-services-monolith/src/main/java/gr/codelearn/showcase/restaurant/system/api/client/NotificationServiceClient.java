package gr.codelearn.showcase.restaurant.system.api.client;

import gr.codelearn.showcase.restaurant.commons.api.resource.NotificationResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification-service", path = "/api")
public interface NotificationServiceClient {
	@PostMapping("/notifications")
	void sendNotification(NotificationResource notificationResource);
}
