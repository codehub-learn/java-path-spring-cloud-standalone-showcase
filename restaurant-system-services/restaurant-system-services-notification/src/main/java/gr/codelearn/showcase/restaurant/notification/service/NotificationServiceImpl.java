package gr.codelearn.showcase.restaurant.notification.service;

import gr.codelearn.showcase.restaurant.commons.service.BaseServiceImpl;
import gr.codelearn.showcase.restaurant.notification.domain.Notification;
import gr.codelearn.showcase.restaurant.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl extends BaseServiceImpl<Notification, Long> implements NotificationService {
	private final NotificationRepository notificationRepository;

	@Override
	public JpaRepository<Notification, Long> getRepository() {
		return notificationRepository;
	}

	@Async
	public void sendReservationConfirmation(final Notification notification) {
		logger.info("Sending reservation confirmation to {}: {}", notification.getRecipient(), notification.getMessage());
		notification.setSentAt(ZonedDateTime.now());
		
		notificationRepository.save(notification);
	}
}
