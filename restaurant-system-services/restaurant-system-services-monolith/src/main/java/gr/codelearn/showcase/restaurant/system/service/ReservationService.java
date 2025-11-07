package gr.codelearn.showcase.restaurant.system.service;

import gr.codelearn.showcase.restaurant.system.domain.Reservation;

public interface ReservationService extends BaseService<Reservation, Long> {
	Reservation createReservation(Reservation reservation);
}
