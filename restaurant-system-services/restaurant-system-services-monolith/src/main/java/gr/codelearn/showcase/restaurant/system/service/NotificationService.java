package gr.codelearn.showcase.restaurant.system.service;

public interface NotificationService {
	void sendReservationConfirmation(String recipient, String message);
}
