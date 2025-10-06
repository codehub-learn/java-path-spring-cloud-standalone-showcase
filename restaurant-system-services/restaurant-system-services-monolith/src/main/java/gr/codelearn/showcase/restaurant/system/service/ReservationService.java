package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.system.domain.Customer;
import gr.codelearn.showcase.restaurant.system.domain.Reservation;
import gr.codelearn.showcase.restaurant.system.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
	//ΝΟΤΕ
	private final ReservationRepository reservations;

	public ReservationService(ReservationRepository reservations) {
		this.reservations = reservations;
	}

	public List<Reservation> allReservations() {
		return reservations.findAll();
	}

	public Reservation createReservation(Customer customer, int tableNumber) {
		//ΝΟΤΕ
		Reservation res = new Reservation();
		res.setCustomer(customer);
		res.setTableNumber(tableNumber);
		res.setReservationTime(LocalDateTime.now().plusDays(1));
		return reservations.save(res);
	}
}