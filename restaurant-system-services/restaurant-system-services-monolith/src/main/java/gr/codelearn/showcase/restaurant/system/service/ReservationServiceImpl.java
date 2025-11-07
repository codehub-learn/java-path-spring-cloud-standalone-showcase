package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.system.domain.Reservation;
import gr.codelearn.showcase.restaurant.system.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl extends BaseServiceImpl<Reservation, Long> implements ReservationService {
	private final ReservationRepository reservationRepository;

	@Override
	public JpaRepository<Reservation, Long> getRepository() {
		return reservationRepository;
	}

	@Override
	public Reservation createReservation(final Reservation reservation) {
		//TODO Service integration
		return reservationRepository.save(reservation);
	}
}