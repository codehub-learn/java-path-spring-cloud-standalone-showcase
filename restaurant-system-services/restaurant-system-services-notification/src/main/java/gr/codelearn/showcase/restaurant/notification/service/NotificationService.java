package gr.codelearn.showcase.restaurant.notification.service;

import gr.codelearn.showcase.restaurant.commons.service.BaseService;
import gr.codelearn.showcase.restaurant.notification.domain.Notification;

public interface NotificationService extends BaseService<Notification, Long> {
	void sendReservationConfirmation(Notification notification);
}
