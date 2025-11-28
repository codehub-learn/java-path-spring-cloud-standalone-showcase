package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.commons.api.resource.NotificationResource;
import gr.codelearn.showcase.restaurant.commons.component.BaseComponent;
import gr.codelearn.showcase.restaurant.system.api.client.NotificationServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl extends BaseComponent implements NotificationService {
	private final NotificationServiceClient notificationServiceClient;

	@Async
	public void sendReservationConfirmation(String recipient, String message) {
		logger.info("Sending reservation confirmation to {}: {}", recipient, message);
		notificationServiceClient.sendNotification(new NotificationResource(recipient, message));
	}
}
