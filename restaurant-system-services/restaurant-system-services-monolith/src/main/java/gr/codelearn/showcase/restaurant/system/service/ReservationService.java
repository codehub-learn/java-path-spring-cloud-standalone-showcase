package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.system.domain.Reservation;
import gr.codelearn.showcase.restaurant.system.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//TODO
public class ReservationService {
	private final ReservationRepository reservations;

	public List<Reservation> allReservations() {
		return reservations.findAll();
	}

	public Reservation createReservation(Reservation reservation) {
		//TODO Service integration
		return reservations.save(reservation);
	}
}