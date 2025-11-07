package gr.codelearn.showcase.restaurant.system.api.controller;

import gr.codelearn.showcase.restaurant.system.api.mapper.ReservationMapper;
import gr.codelearn.showcase.restaurant.system.api.resource.ReservationResource;
import gr.codelearn.showcase.restaurant.system.service.CustomerServiceImpl;
import gr.codelearn.showcase.restaurant.system.service.ReservationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
	private final ReservationServiceImpl reservationService;
	private final CustomerServiceImpl customerService;
	private final ReservationMapper reservationMapper;

	@GetMapping
	public List<ReservationResource> all() {
		return reservationMapper.toResources(reservationService.findAll());
	}

	@PostMapping
	public ReservationResource create(@RequestBody ReservationResource reservationResource) {
		//TODO Business-wise & validation
		customerService.findById(reservationResource.customerId());

		return reservationMapper.toResource(reservationService.createReservation(reservationMapper.toDomain(reservationResource)));
	}
}