package gr.codelearn.showcase.restaurant.system.listener;

import gr.codelearn.showcase.restaurant.system.domain.Reservation;
import gr.codelearn.showcase.restaurant.system.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceEventListener {
	private final NotificationService notificationService;

	@Async
	@EventListener
	public void sendReservationConfirmation(Reservation reservation) {
		notificationService.sendReservationConfirmation(reservation.getCustomer().getEmail(), "Your reservation has been confirmed!");
	}
}
