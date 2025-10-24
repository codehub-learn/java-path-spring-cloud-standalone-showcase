package gr.codelearn.showcase.restaurant.system.api.controller;

import gr.codelearn.showcase.restaurant.system.api.mapper.ReservationMapper;
import gr.codelearn.showcase.restaurant.system.api.resource.ReservationResource;
import gr.codelearn.showcase.restaurant.system.service.CustomerService;
import gr.codelearn.showcase.restaurant.system.service.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	private final ReservationService reservationService;
	private final CustomerService customerService;
	private final ReservationMapper reservationMapper;

	public ReservationController(ReservationService reservationService, CustomerService customerService,
								 ReservationMapper reservationMapper) {
		this.reservationService = reservationService;
		this.customerService = customerService;
		this.reservationMapper = reservationMapper;
	}

	@GetMapping
	public List<ReservationResource> all() {
		return reservationMapper.toResources(reservationService.allReservations());
	}

	@PostMapping
	public ReservationResource create(@RequestBody ReservationResource reservationResource) {
		//TODO Business-wise & validation
		customerService.findById(reservationResource.customerId());

		return reservationMapper.toResource(reservationService.createReservation(reservationMapper.toDomain(reservationResource)));
	}
}