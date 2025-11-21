package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.system.domain.Reservation;
import gr.codelearn.showcase.restaurant.system.repository.ReservationRepository;
import gr.codelearn.showcase.restaurant.system.validation.ReservationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl extends BaseServiceImpl<Reservation, Long> implements ReservationService {
	private final ReservationRepository reservationRepository;
	private final ReservationValidator reservationValidator;
	private final ApplicationEventPublisher publisher;
	private final CustomerService customerService;

	@Override
	public JpaRepository<Reservation, Long> getRepository() {
		return reservationRepository;
	}

	@Override
	public Reservation createReservation(final Reservation reservation) {
		reservationValidator.ensureCustomerExists(reservation);
		if (reservation.getCustomer().getEmail() != null && reservation.getCustomer().getId() == null) {
			reservation.setCustomer(customerService.findByEmail(reservation.getCustomer().getEmail()));
		} else if (reservation.getCustomer().getPhone() != null && reservation.getCustomer().getId() == null) {
			reservation.setCustomer(customerService.findByPhone(reservation.getCustomer().getPhone()));
		}
		var savedReservation = reservationRepository.save(reservation);

		publisher.publishEvent(savedReservation);

		return savedReservation;
	}
}