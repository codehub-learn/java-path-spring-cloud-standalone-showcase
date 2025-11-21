package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.system.domain.Notification;

public interface NotificationService extends BaseService<Notification, Long> {
	void sendReservationConfirmation(String recipient, String message);
}
