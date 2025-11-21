package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.system.domain.Notification;
import gr.codelearn.showcase.restaurant.system.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl extends BaseServiceImpl<Notification, Long> implements NotificationService {
	private final NotificationRepository notificationRepository;

	@Override
	public JpaRepository<Notification, Long> getRepository() {
		return notificationRepository;
	}

	@Async
	public void sendReservationConfirmation(String recipient, String message) {
		logger.info("Sending reservation confirmation to {}: {}", recipient, message);
		notificationRepository.save(new Notification(recipient, message));
	}
}
