package gr.codelearn.showcase.restaurant.system.controller;

import gr.codelearn.showcase.restaurant.system.domain.Customer;
import gr.codelearn.showcase.restaurant.system.domain.Reservation;
import gr.codelearn.showcase.restaurant.system.service.CustomerService;
import gr.codelearn.showcase.restaurant.system.service.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	private final ReservationService reservations;
	private final CustomerService customers;

	public ReservationController(ReservationService reservations, CustomerService customers) {
		this.reservations = reservations;
		this.customers = customers;
	}

	@GetMapping
	public List<Reservation> all() {
		return reservations.allReservations();
	}

	@PostMapping
	public Reservation create(@RequestParam String name, @RequestParam String phone, @RequestParam int tableNumber) {
		// TODO
		Customer c = customers.createCustomer(name, phone);
		return reservations.createReservation(c, tableNumber);
	}
}