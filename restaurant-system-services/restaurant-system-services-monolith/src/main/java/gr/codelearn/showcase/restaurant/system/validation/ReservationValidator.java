package gr.codelearn.showcase.restaurant.system.validation;

import gr.codelearn.showcase.restaurant.system.domain.Reservation;
import gr.codelearn.showcase.restaurant.system.exception.RejectedOperationException;
import gr.codelearn.showcase.restaurant.system.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationValidator {
	private final CustomerService customerService;

	public void ensureCustomerExists(final Reservation reservation) {
		if (reservation == null || reservation.getCustomer() == null) {
			throw new RejectedOperationException(
					"You cannot perform this operation as either reservation or reservation customer is empty.");
		}

		if (reservation.getCustomer().getId() != null) {
			customerService.findById(reservation.getCustomer().getId());
			return;
		}
		if (reservation.getCustomer().getEmail() != null) {
			customerService.findByEmail(reservation.getCustomer().getEmail());
			return;
		}
		if (reservation.getCustomer().getPhone() != null) {
			customerService.findByPhone(reservation.getCustomer().getPhone());
		}
	}
}
